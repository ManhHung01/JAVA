/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.AttandanceDAO;
import dal.StudentDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Account;
import model.Attandance;
import model.Student;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class TakeAttandanceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TakeAttandanceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeAttandanceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account user = (Account) request.getSession().getAttribute("user");

        if (user != null) {

            StudentDAO studentDB = new StudentDAO();
            SubjectDAO subjectDB = new SubjectDAO();

            ArrayList<Student> students = studentDB.list();
            ArrayList<Subject> subjects = subjectDB.list();

            request.setAttribute("students", students);
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("../AttandanceTake.jsp").forward(request, response);
        } else {
            response.sendRedirect("../login");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("student") != null
                && request.getParameter("subject") != null
                && request.getParameter("date") != null
                && request.getParameter("session") != null) {

            StudentDAO studentDB = new StudentDAO();
            SubjectDAO subjectDB = new SubjectDAO();
            AccountDAO accDB = new AccountDAO();
            AttandanceDAO AttandanceDB = new AttandanceDAO();
            
            int student = Integer.parseInt(request.getParameter("student"));
            int subject = Integer.parseInt(request.getParameter("subject"));
            Date date = Date.valueOf(request.getParameter("date"));
            String session = request.getParameter("session");

            Attandance at = new Attandance();
            at.setDate(date);
            at.setSession(session);

            Student s = new Student();
            s.setSid(student);
            at.setStudent(s);

            Subject su = new Subject();
            su.setSuid(subject);
            at.setSubject(su);

            Account a = (Account) request.getSession().getAttribute("user");
            at.setAccount(a);
            
            AttandanceDB.insert(at);
            
            response.sendRedirect("list");
            

        } else {
            response.sendRedirect("take");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

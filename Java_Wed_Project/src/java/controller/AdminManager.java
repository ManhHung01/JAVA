/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Admin;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDao;
import model.DBConnection;
import model.ProductDao;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AdminManager", urlPatterns = {"/AdminManager"})
public class AdminManager extends HttpServlet {

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
        DBConnection dbconn = new DBConnection();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // DAOCategory daoCate = new DAOCategory(dbconn); 
            AdminDao dao = new AdminDao(dbconn);
            String action = request.getParameter("action");
            // get action from view
            if (action == null) {
                action = "list";
            }

            if (action.equals("list")) {
                // model
                String sql = "Select * from admin";
                ResultSet rs = dbconn.getData(sql);
                // send data to view, select view
                request.setAttribute("rs", rs);
                request.setAttribute("title", "List of Admin");
                //....
                //select jsp
                RequestDispatcher dispth
                        = request.getRequestDispatcher("/Adminview.jsp");
                // run
                dispth.forward(request, response);
                    
            }

            if (action.equals("insert")) {
                String name = request.getParameter("userName");
                String pass = request.getParameter("password");

                dao.add(name, pass);
                response.sendRedirect("AdminManager?action=list");
            }
            if (action.equals("predelete")) {
                String name = request.getParameter("name");
                dao.delete(name);
                response.sendRedirect("AdminManager?action=list");
            }

            if (action.equals("preupdate")) {
                String name = request.getParameter("name");
                String sql1 = "select * from admin where username='" + name + "'";
                ResultSet rs1 = dbconn.getData(sql1);
                request.setAttribute("rs1", rs1);
                RequestDispatcher dispth = request.getRequestDispatcher("/updateAdmin.jsp");
                dispth.forward(request, response);

            }
            if (action.equals("updateAd")) {
                String name = request.getParameter("username").trim();
                String pass = request.getParameter("password").trim();
                Admin ad = new Admin(name, pass);
                dao.update(ad);
                response.sendRedirect("AdminManager?action=list");
                
            }

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ProductManager</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProductManager at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

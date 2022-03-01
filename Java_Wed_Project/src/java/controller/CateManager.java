/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryDao;
import model.DBConnection;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CateManager", urlPatterns = {"/CateManager"})
public class CateManager extends HttpServlet {

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
            CategoryDao dao = new CategoryDao(dbconn);
            String action = request.getParameter("action");
            // get action from view
            if (action == null) {
                action = "list";
            }

            if (action.equals("list")) {
                // model
                String sql = "Select * from category";
                ResultSet rs0 = dbconn.getData(sql);
                // send data to view, select view
                request.setAttribute("rs", rs0);
                request.setAttribute("title", "List of Category");
                //....
                //select jsp
                RequestDispatcher dispth
                        = request.getRequestDispatcher("/Cateview.jsp");
                // run
                dispth.forward(request, response);
            }
            if (action.equals("insert")) {
                String id = request.getParameter("cateID");
                String name = request.getParameter("cateName");
                String image = request.getParameter("image");
                //check contrains

                dao.add(id, name, image);
                response.sendRedirect("CateManager?action=list");

            }
            if (action.equals("predelete")) {
                String id = request.getParameter("id");
                dao.delete(id);
                response.sendRedirect("CateManager?action=list");
            }
            if (action.equals("preUpdate")) {
                String id = request.getParameter("id");
                String sql1 = "select * from category where cateId='" + id + "'";
                ResultSet rs1 = dbconn.getData(sql1);
                request.setAttribute("rs1", rs1);
                RequestDispatcher dispth = request.getRequestDispatcher("/updateCate.jsp");
                dispth.forward(request, response);

            }
            if (action.equals("updateCate")) {
                String id = request.getParameter("cateID");
                String name = request.getParameter("cateName");
                String image = request.getParameter("image");
                Category cate = new Category(id, name, image);
                dao.update(cate);
                response.sendRedirect("CateManager?action=list");

            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CateManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CateManager at " + request.getContextPath() + "</h1>");
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

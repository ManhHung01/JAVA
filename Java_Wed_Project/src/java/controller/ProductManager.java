/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.DBConnection;
import model.ProductDao;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ProductManager", urlPatterns = {"/ProductManager"})
public class ProductManager extends HttpServlet {

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
            ProductDao dao = new ProductDao(dbconn);
            String action = request.getParameter("action");
            // get action from view
            if (action == null) {
                action = "listProduct";
            }

            if (action.equals("listProduct")) {
                // model
                String sql = "Select * from Product";
                ResultSet rs0 = dbconn.getData(sql);
                // send data to view, select view
                request.setAttribute("rs", rs0);
                request.setAttribute("title", "List of Product");
                //....
                //select jsp
                RequestDispatcher dispth
                        = request.getRequestDispatcher("/ProductView.jsp");
                // run
                dispth.forward(request, response);

            }
            if (action.equals("insert")) {
                String id = request.getParameter("proId");
                String name = request.getParameter("proName");
                String quantity = request.getParameter("quantity");
                String price = request.getParameter("price");
                String image = request.getParameter("image");
                String description = request.getParameter("descriptions");
                String cateId = request.getParameter("cateId");
                dao.add(id, name, Integer.parseInt(quantity), Double.parseDouble(price), image, description, cateId);
                response.sendRedirect("ProductManager?action=listProduct");
            }

            if (action.equals("predelete")) {
                String id = request.getParameter("pid");
                dao.delete(id);
                response.sendRedirect("ProductManager?action=listProduct");
            }
            if (action.equals("preUpdate")) {
                String pid = request.getParameter("pid").trim();
                String sql = "select * from Product where pid='" + pid + "'";
                ResultSet rs = dbconn.getData(sql);
                request.setAttribute("rs1", rs);
                RequestDispatcher dispth = request.getRequestDispatcher("/update.jsp");
                dispth.forward(request, response);

            }
            if (action.equals("updatepro")) {
                String id = request.getParameter("proId");
                String name = request.getParameter("proName");
                int quantity = Integer.parseInt(request.getParameter("quantity").trim());
                double price = Double.parseDouble(request.getParameter("price").trim());
                String image = request.getParameter("image");
                String description = request.getParameter("descriptions");

                String cateId = request.getParameter("cateId");

                Product pro = new Product(id, name, quantity, price, image, description, cateId);
                dao.update(pro);
                response.sendRedirect("ProductManager?action=listProduct");
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

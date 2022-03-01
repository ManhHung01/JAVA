/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Customer;
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
import model.CustomerDao;
import model.DBConnection;
import model.ProductDao;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CustomerManager", urlPatterns = {"/CustomerManager"})
public class CustomerManager extends HttpServlet {

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
            CustomerDao dao = new CustomerDao(dbconn);
            String action = request.getParameter("action");
            // get action from view
            if (action == null) {
                action = "list";
            }

            if (action.equals("list")) {
                // model
                String sql = "Select * from Customer";
                ResultSet rs0 = dbconn.getData(sql);
                // send data to view, select view
                request.setAttribute("rs", rs0);
                request.setAttribute("title", "List of Customer");
                //....
                //select jsp
                RequestDispatcher dispth
                        = request.getRequestDispatcher("/Customerview.jsp");
                // run
                dispth.forward(request, response);

            }
            if (action.equals("insert")) {
                String name = request.getParameter("fullName");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String username = request.getParameter("username");
                String pass = request.getParameter("password");

                Customer c = new Customer(name, address, phone, username, pass);
                int n = dao.addCustomer(c);
                response.sendRedirect("CustomerManager?action=list");

            }
            if (action.equals("predelete")) {
                int id1 = Integer.parseInt(request.getParameter("cid1"));
                dao.delete(id1);

                response.sendRedirect("CustomerManager?action=list");
            }
            if (action.equals("preUpdate")) {
                String cid = request.getParameter("cid1");
                String sql1 = "select * from Customer where cid='" + cid + "'";
                ResultSet rs1 = dbconn.getData(sql1);
                request.setAttribute("rs1", rs1);
                RequestDispatcher dispth = request.getRequestDispatcher("/updateCus.jsp");
                dispth.forward(request, response);

            }
            if (action.equals("updatecu")) {
                int cid1 = Integer.parseInt(request.getParameter("cid").trim());
                String name1 = request.getParameter("fullName");
                String address1 = request.getParameter("address");
                String phone1 = request.getParameter("phone");
                String username1 = request.getParameter("username");
                String pass1 = request.getParameter("password");
                Customer cu = new Customer(cid1, name1, address1, phone1, username1, pass1);
                dao.update(cu);
                response.sendRedirect("CustomerManager?action=list");
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerManager at " + request.getContextPath() + "</h1>");
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

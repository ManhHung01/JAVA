/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.BillDetail;
import Entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BillDetailDao;
import model.DBConnection;

/**
 *
 * @author DELL
 */
@WebServlet(name = "BillDetailManager", urlPatterns = {"/BillDetailManager"})
public class BillDetailManager extends HttpServlet {

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
             BillDetailDao dao = new BillDetailDao(dbconn);
            String action = request.getParameter("action");
            // get action from view
            if (action == null) {
                action = "list";
            }
            if (action.equals("list")) {
                // model
                String sql = "Select * from BillDetail";
                ResultSet rs = dbconn.getData(sql);
                // send data to view, select view
                request.setAttribute("rs", rs);
                request.setAttribute("title", "List of billDetail");
                //....
                //select jsp
                RequestDispatcher dispth
                        = request.getRequestDispatcher("/BillDetailview.jsp");
                // run
                dispth.forward(request, response);
                    
            }
            if (action.equals("insert")) {
                int bid = Integer.parseInt(request.getParameter("bid"));
                String pid = request.getParameter("pid");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                BillDetail bb =new BillDetail(bid, pid, quantity, price);
                int n = dao.addBill(bb);
                
                response.sendRedirect("BillDetailManager?action=list");
            }
            if (action.equals("predelete")) {
                int id1 = Integer.parseInt(request.getParameter("bid"));
                dao.delete(id1);

                response.sendRedirect("BillDetailManager?action=list");
            }
            if (action.equals("preUpdate")) {
                String cid = request.getParameter("bid");
                String sql1 = "select * from BillDetail where bid='" + cid + "'";
                ResultSet rs1 = dbconn.getData(sql1);
                request.setAttribute("rs1", rs1);
                RequestDispatcher dispth = request.getRequestDispatcher("/updateBillDetail.jsp");
                dispth.forward(request, response);

            }
            if (action.equals("update")) {
                int bid = Integer.parseInt(request.getParameter("bid"));
                String pid = request.getParameter("pid");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                BillDetail bb =new BillDetail(bid, pid, quantity, price);
                dao.update(bb);
                response.sendRedirect("BillDetailManager?action=list");
            }
            
            
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BillDetailManager</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BillDetailManager at " + request.getContextPath() + "</h1>");
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

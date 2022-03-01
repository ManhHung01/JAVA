/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Admin;
import model.BillDao;
import Entity.Bill;
import model.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

/**
 *
 * @author DELL
 */
@WebServlet(name = "BillManager", urlPatterns = {"/BillManager"})
public class BillManager extends HttpServlet {

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
            BillDao dao = new BillDao(dbconn);
            String action = request.getParameter("action");
            // get action from view
            if (action == null) {
                action = "list";
            }

            if (action.equals("list")) {
                // model
                String sql = "Select * from bill";
                ResultSet rs = dbconn.getData(sql);
                // send data to view, select view
                request.setAttribute("rs", rs);
                request.setAttribute("title", "List of Bill");
                //....
                //select jsp
                RequestDispatcher dispth
                        = request.getRequestDispatcher("/Billview.jsp");
                // run
                dispth.forward(request, response);

            }

            if (action.equals("insert")) {
                //int bID = Integer.parseInt(request.getParameter("bID"));
                String dateCreate = request.getParameter("dateCreate");
                double total = Double.parseDouble(request.getParameter("total"));
                String recName = request.getParameter("recName");
                String recAddress = request.getParameter("address");
                String recPhone = request.getParameter("recPhone");
                //int status = Integer.parseInt(request.getParameter("status"));
                int cID = Integer.parseInt(request.getParameter("cID"));

                Bill bill = new Bill(dateCreate,total,recName,recAddress,recPhone,cID);
                int n = dao.addBill(bill);
                //dao.addBill(bID,dateCreate,total,recName,recAddress,recPhone,status,cID);
                response.sendRedirect("BillManager?action=list");
            }
            if (action.equals("predelete")) {
                int bID = Integer.parseInt(request.getParameter("bID"));
                int cID = Integer.parseInt(request.getParameter("cID"));
                dao.delete(bID, cID);
                response.sendRedirect("BillManager?action=list");
            }

            if (action.equals("preupdate")) {
                int bID = Integer.parseInt(request.getParameter("bID"));
                int cID = Integer.parseInt(request.getParameter("cID"));
                String sql1 = "select * from bill where bID='" + bID + "'and cID='"+cID+"'";
                ResultSet rs1 = dbconn.getData(sql1);
                request.setAttribute("rs1", rs1);
                RequestDispatcher dispth = request.getRequestDispatcher("/updateBill.jsp");
                dispth.forward(request, response);

            }
            if (action.equals("updatebill")) {
                int bID = Integer.parseInt(request.getParameter("bID"));
                String dateCreate = request.getParameter("dateCreate");
                double total = Double.parseDouble(request.getParameter("total"));
                String recName = request.getParameter("recName");
                String recAddress = request.getParameter("address");
                String recPhone = request.getParameter("recPhone");
                int status = Integer.parseInt(request.getParameter("status"));
                int cID = Integer.parseInt(request.getParameter("cID"));

                Bill bill = new Bill(bID,dateCreate,total,recName,recAddress,recPhone,status,cID);
                dao.update(bill);
                response.sendRedirect("BillManager?action=list");
                
            }
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

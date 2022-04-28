/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;
import model.Status;

/**
 *
 * @author ADMIN
 */
public class RequestDAO extends DBContext<Request> {
    
    public static void main(String[] args) {
                RequestDAO requestDB = new RequestDAO();
                Request r = new Request();
        r.setContent("content");
        r.getCategory().setCid(1);
        r.getStatus().setSid(2);
requestDB.insert(r);
    }
    
    @Override
    public ArrayList<Request> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Request model) {

        try {
            String sql = "insert into [Request]\n"
                    + "(\n"
                    + "[content],\n"
                    + "[createdDate],\n"
                    + "[categotyid],\n"
                    + "[statusID]\n"
                    + ")\n"
                    + "values(?, getdate(),?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getContent());
            stm.setInt(2, model.getCategory().getCid());
            stm.setInt(3, model.getStatus().getSid());
            stm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Request model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Request model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

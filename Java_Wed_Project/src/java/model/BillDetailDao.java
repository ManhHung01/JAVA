/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import Entity.BillDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBConnection;

/**
 *
 * @author DELL
 */
public class BillDetailDao {
    DBConnection dbcom;
    Connection conn;

    public BillDetailDao(DBConnection dbcom) {
        this.dbcom = dbcom;
        this.conn = dbcom.getConn();
    }
    public int addBill(BillDetail bd){
        int n=0;
        String sql="insert into BillDetail values(?,?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,bd.getBid());
            pre.setString(2,bd.getPid());
            pre.setInt(3,bd.getQuantity());
            pre.setDouble(4,bd.getPrice());          
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return n;
        
    }
    public void add( String pId, int quantity, double price) {
        String sql = "inset into BillDetail values(?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, pId);
            st.setInt(2, quantity);
            st.setDouble(3, price);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void update(BillDetail bd) {
        String sql = "update BillDetail set quantity = ?, price = ? where bId = ? and pId = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, bd.getQuantity());
            st.setDouble(2, bd.getPrice());
            st.setInt(3, bd.getBid());
            st.setString(4, bd.getPid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void delete(int bid){
        String sql="delete from BillDetail where bid=?";
        try{
            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1, bid);
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}

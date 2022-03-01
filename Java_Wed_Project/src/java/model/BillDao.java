/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Bill;
import model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class BillDao {

    DBConnection dbcom;
    Connection conn;


    public BillDao(DBConnection dbcom) {
        this.dbcom = dbcom;
        this.conn = dbcom.getConn();
    }
    public int addBill(Bill bill){
        int n=0;
        String sql="insert into Bill(dateCreate,total,recName,recAddress,recPhone,cid) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,bill.getDateCreate());
            pre.setDouble(2,bill.getTotal());
            pre.setString(3,bill.getRecName());
            pre.setString(4,bill.getAddress());
            pre.setString(5,bill.getRecPhone());
            pre.setInt(6,bill.getCid());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return n;
        
    }
    //public 
    public void add(int bID, String dateCreate, double total, String recName, String recAddress, String recPhone, int status, int cID) {
        String sql = "inset into Bill values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, bID);
            st.setString(2, dateCreate);
            st.setDouble(3, total);
            st.setString(4, recName);
            st.setString(5, recAddress);
            st.setString(6, recPhone);
            st.setInt(7, status);
            st.setInt(8, cID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Bill b) {
        String sql = "update Bill set dateCreate = ?, total = ?, recName = ?, recAddress = ?, recPhone = ?, status = ? where bId = ? and cId = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, b.getDateCreate());
            st.setDouble(2, b.getTotal());
            st.setString(3, b.getRecName());
            st.setString(4, b.getAddress());
            st.setString(5, b.getRecPhone());
            st.setInt(6, b.getStatus());
            st.setInt(7, b.getBid());
            st.setInt(8, b.getCid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int bid, int cid) {
        String sql = "delete from bill where bid=? and cid = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, bid);
            st.setInt(2, cid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Admin;
import Entity.Customer;
import model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AdminDao {

    DBConnection db;
    Connection con;

    public AdminDao() {
        try {
            db = new DBConnection();
            con = db.getConn();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public AdminDao(DBConnection dbcom) {
        this.db = dbcom;
        this.con = dbcom.getConn();
    }

    public int addAdmin(Admin ad) {
        int n = 0;
        String sql = "insert into admin values(?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, ad.getUserName());
            pre.setString(2, ad.getPassword());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void add(String username, String password) {
        String sql = "insert into admin values(?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Admin a) {
        String sql = "update admin set password=? where username=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getUserName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(String username) {
        String sql = "delete from admin where username=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public boolean login(String userName, String pass) {
         // không sử dụng câu lệnh này vì dễ bị tấn công( injection sql)
//        String sql = "select * from admin admin username'"+userName+"', "+ " and password='"+pass+"'";
        String preSql = "select * from admin where username=? and password=?"; // sử dụng câu lệnh này.
        try {
            PreparedStatement pre = con.prepareStatement(preSql);
            pre.setString(1, userName);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

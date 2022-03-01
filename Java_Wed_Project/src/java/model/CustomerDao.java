/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Customer;
import model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class CustomerDao {

    DBConnection db;
    Connection con;

    public CustomerDao() {
        try {
            db = new DBConnection();
            con = db.getConn();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CustomerDao(DBConnection dbcom) {
        this.db = dbcom;
        this.con = dbcom.getConn();
    }

    public int addCustomer(Customer cus) {
        int n = 0;
        String sql = "insert into Customer(fullname,address,phone,username,password) values(?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, cus.getFullName());
            pre.setString(2, cus.getAddress());
            pre.setString(3, cus.getPhone());
            pre.setString(4, cus.getUserName());
            pre.setString(5, cus.getPassword());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void add(int cId, String fullname, String address, String phone, String username, String password) {
        String sql = "inset into Customer values(?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cId);
            st.setString(2, fullname);
            st.setString(3, address);
            st.setString(4, phone);
            st.setString(5, username);
            st.setString(6, password);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Customer c) {
        String sql = "update Customer set fullname = ?, address = ?, phone = ?, username = ?, password = ? where cid = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getFullName());
            st.setString(2, c.getAddress());
            st.setString(3, c.getPhone());
            st.setString(4, c.getUserName());
            st.setString(5, c.getPassword());
            st.setInt(6, c.getCid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int cid) {
        String sql = "delete from Customer where cId=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void changeStatus(int cid) {
        String sql = "update Customer set status = (case when status = 1 then 0 else 1 end) where cId = '" + cid + "' ";
        try {
            Statement state = con.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Customer> login(String userName, String pass) {
        // không sử dụng câu lệnh này vì dễ bị tấn công( injection sql)
//        String sql = "select * from admin admin username'"+userName+"', "+ " and password='"+pass+"'";
        String preSql = "select * from Customer where username=? and password=?"; // sử dụng câu lệnh này.
        ArrayList<Customer> list = new ArrayList<>();
        try {
            PreparedStatement pre = con.prepareStatement(preSql);
            pre.setString(1, userName);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setCid(rs.getInt(1));
                cus.setFullName(rs.getString(2));
                cus.setAddress(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setStatus(1);
                list.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

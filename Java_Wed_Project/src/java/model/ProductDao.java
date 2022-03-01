/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Product;
import model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ProductDao {
    
    DBConnection db;
    Connection con;

    public ProductDao(DBConnection db) {
        this.db = db;
        this.con = db.getConn();
    }

    public ProductDao() {
        try {
            db = new DBConnection();
            con = db.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public int addProduct(Product pro) {
        int n = 0;
        String sql = "insert into Product(pid,pname,quantity,price,image,description,cateID) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, pro.getPid());
            pre.setString(2, pro.getpName());
            pre.setInt(3, pro.getQuantity());
            pre.setDouble(4, pro.getPrice());
            pre.setString(5, pro.getImage());
            pre.setString(6, pro.getDesciption());
            pre.setString(7, pro.getCateId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

     public void add(String pId, String pname, int quantity, double price, String image, String description, String cateId) {
        String sql = "insert into Product values(?,?,?,?,?,?,1,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pId);
            st.setString(2, pname);
            st.setInt(3, quantity);
            st.setDouble(4, price);
            st.setString(5, image);
            st.setString(6, description);
          
            st.setString(7, cateId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    

    public void update(Product p) {
        String sql = "update product set pname = ?, quantity = ?, price = ?, image = ?, description= ?, cateId = ? where pId = ? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getpName());
            st.setInt(2, p.getQuantity());
            st.setDouble(3, p.getPrice());
            st.setString(4, p.getImage());
            st.setString(5, p.getDesciption());
            st.setString(7, p.getPid());
            st.setString(6, p.getCateId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(String pid) {
        String sql = "delete from Product where pId = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    public void changeStatus(String id) {
        String sql = "update Product set status = (case when status = 1 then 0 else 1 end) where pid = '" + id + "'";
        try {
            Statement state = con.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

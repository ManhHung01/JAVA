/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Category;
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
public class CategoryDao {
    DBConnection dbcom;
    Connection conn;

    public CategoryDao(DBConnection dbcom) {
        this.dbcom = dbcom;
        this.conn = dbcom.getConn();
    }
    public int addCategory(Category cate){
        int n=0;
        String sql="insert into Category(cateid,cateName,image) values(?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,cate.getCateID());
            pre.setString(2,cate.getCateName());
            pre.setString(3,cate.getImage());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
        
    }
    public void add(String id,String name,String image){
        String sql = "insert into Category values(?,?,?,1)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, image);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<String> getCateId(){
        List<String> list = new ArrayList<>();
        String sql="select cateId from product";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String p = rs.getString("cateId");
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    public void delete(String cateid) {
        String sql = "delete from category where cateId=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cateid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void update(Category c) {
        String sql = "update Category set cateName = ?, image = ? where cateId = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, c.getCateName());
            st.setString(2, c.getImage());
            st.setString(3, c.getCateID());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void changeStatus(String cateid){
        String sql = "update Category set status = (case when status = 1 then 0 else 1 end) where cateId = '"+cateid+"' ";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

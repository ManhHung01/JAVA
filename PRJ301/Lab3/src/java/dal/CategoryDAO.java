/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext{
    
    public static void main(String[] args) {
                CategoryDAO categoryDB = new CategoryDAO();
                System.out.println(""+ categoryDB.getCategorys().get(0).getName());
    }
    
    public ArrayList<Category> getCategorys() {
        ArrayList<Category> categorys = new ArrayList<>();
        try {

            String sql = "select * from Category c ";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setCid(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                
                categorys.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categorys;
    }
    
    public Category getCategory(String id) {
        try {

            String sql = "select * from Category c where c.cid =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setCid(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                
                return c;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

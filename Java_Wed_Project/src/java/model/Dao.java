/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Admin;
import Entity.Bill;
import Entity.Category;
import Entity.Customer;
import Entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBConnection dbcom;
    Connection cnn;
    PreparedStatement stm;

    /**
     *
     * @return
     */
    public Dao(DBConnection dbcom) {
        this.dbcom = dbcom;
        this.conn = dbcom.getConn();
        this.cnn = dbcom.getConn();
    }
    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            //mo ket noi voi sql server
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString(1),
                        rs.getString(2),rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int checkId(String id, List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPid().equals(id)) {
                return i;
            }
        }

        return -1;
    }
 
 

    public Product add(String id) {
        String sql = "select * from Product where pid=?";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), 1, rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }

        } catch (Exception e) {
        }
        return null;
    }
    

    /**
     *
     * @return
     */
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product order by price";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     *
     * @param user
     * @param pass
     * @return
     */
//    public Customer checkLoginC(String user, String pass) {
//        String query = "select username,password from Customer WHERE username =? AND password =?";
//        try {
//            conn = new context.DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, user);
//            ps.setString(2, pass);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Customer(user, pass);
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }
    public Admin checkLogin(String user, String pass) {
        String query = "select * from Admin WHERE username =? AND password =?";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Admin(user, pass);
            }
        } catch (Exception e) {
        }
        return null;
    }
    public Customer checkcus(String user, String pass) {
        String query = "select username,password from Customer WHERE username =? AND password =?";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(user, pass);
            }
        } catch (Exception e) {
        }
        return null;
    }
    public Admin checkAccEx(String user) {
        String query = "select * from Admin WHERE username =?";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Admin(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void Signup(String user, String pass){
        String sql = "insert into admin values(?,?)";
        try{
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeQuery();
        }catch(Exception e){
            
        }
    }
    public int addBill(Bill bill ){
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
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }    
                return n;

    }
    

    /**
     *
     * @param cid
     * @return
     */
    public List<Product> getProductByCate(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product where cateid=?";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Product getProduct(String txt) {
        String query = "select * from Product where pid = ?";
        List<Product> list = new ArrayList<>();
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void deleteP(String pid){
        String query="delete from Product where pid=?";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void insertPro(String id, String name, String quantity, String price, String image, String des, int cateid){
        String sql = "insert into Product(pid,pname,quantity,price,image,description,cateID) values(?,?,?,?,?,?,?)";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, quantity);
            ps.setString(4, price);
            ps.setString(5, image);
            ps.setString(6, des);
            ps.setInt(7, cateid);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }
    public void editProduct(String pid, String name, String quantity, String price, String image, String des, int cateid) {
        String sql = "update product set pname = ?, quantity = ?, price = ?, image = ?, description= ?, cateId = ? where pId = ? ";

        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, quantity);
            ps.setString(3, price);
            ps.setString(4, image);
            ps.setString(5, des);
            ps.setString(7, pid);
            ps.setInt(6, cateid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Product getProductByID(String id) {
        String query = "select * from Product\n"
                + "where pid = ?";
        try {
            conn = new context.DBContext().getConnection();
             ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Customer> getAllCus() {
        List<Customer> list = new ArrayList<>();
        String query = "select * from Customer order by cid";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void insertBill(String dateCreate, double total, String recName, String address, String recPhone, int cid) {
        String query = "insert into Bill(dateCreate,total,recName,recAddress,recPhone,cid) values(?,?,?,?,?,?)";
        try {
            conn = new context.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, dateCreate);
            ps.setDouble(2, total);
            ps.setString(3, recName);
            ps.setString(4, address);
            ps.setString(5, recPhone);
            ps.setInt(6, cid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        DBConnection dbconn = new DBConnection();
        Dao dao = new Dao(dbconn);
        List<Customer> list = dao.getAllCus();
        System.out.println(list);
    }
}

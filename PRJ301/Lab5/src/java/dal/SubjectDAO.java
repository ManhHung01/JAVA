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
import model.Student;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class SubjectDAO extends DBContext<Subject>{

    @Override
    public ArrayList<Subject> list() {
        ArrayList<Subject> subjects = new ArrayList<>();
        try {
            String sql = "SELECT * from Subject";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject su = new Subject();
                su.setSuid(rs.getInt("suid"));
                su.setSuname(rs.getString("suname"));

                subjects.add(su);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
        
    }

    @Override
    public Subject get(Subject model) {
        try {
            String sql = "SELECT * from Subject su where su.suid = ? ;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getSuid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject su = new Subject();
                su.setSuid(rs.getInt("suid"));
                su.setSuname(rs.getString("suname"));

                return su;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public Subject getById(int id) {
        try {
            String sql = "SELECT * from Subject su where su.suid = ? ;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject su = new Subject();
                su.setSuid(rs.getInt("suid"));
                su.setSuname(rs.getString("suname"));

                return su;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @Override
    public void insert(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

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
import model.Account;
import model.Attandance;
import model.Student;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class AttandanceDAO extends DBContext<Attandance> {

    StudentDAO studentDB = new StudentDAO();
    SubjectDAO subjectDB = new SubjectDAO();
    AccountDAO accDB = new AccountDAO();

    @Override
    public ArrayList<Attandance> list() {

        ArrayList<Attandance> Attandances = new ArrayList<>();
        try {
            String sql = "SELECT * from Attandance";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attandance at = new Attandance();
                at.setAid(rs.getInt("aid"));
                at.setDate(rs.getDate("date"));
                at.setSession(rs.getString("session"));

                Student s = studentDB.getByID(rs.getInt("sid"));
                at.setStudent(s);

                Subject su = subjectDB.getById(rs.getInt("suid"));
                at.setSubject(su);

                Account a = accDB.getById(rs.getString("userid"));
                at.setAccount(a);

                Attandances.add(at);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Attandances;

    }

    public ArrayList<Attandance> listByUser(String userid) {

        ArrayList<Attandance> Attandances = new ArrayList<>();
        try {
            String sql = "SELECT * from Attandance at where at.userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userid);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attandance at = new Attandance();
                at.setAid(rs.getInt("aid"));
                at.setDate(rs.getDate("date"));
                at.setSession(rs.getString("session"));

                Student s = studentDB.getByID(rs.getInt("sid"));
                at.setStudent(s);

                Subject su = subjectDB.getById(rs.getInt("suid"));
                at.setSubject(su);

                Account a = accDB.getById(rs.getString("userid"));
                at.setAccount(a);

                Attandances.add(at);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Attandances;

    }

    @Override
    public Attandance get(Attandance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attandance model) {

        try {
            String sql = "insert into Attandance\n"
                    + "([date],\n"
                    + "[session],\n"
                    + "[sid],\n"
                    + "[suid],\n"
                    + "[userid])\n"
                    + "values(?, ?,?,?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, model.getDate());
            stm.setString(2, model.getSession());
            stm.setInt(3, model.getStudent().getSid());
            stm.setInt(4, model.getSubject().getSuid());
            stm.setString(5, model.getAccount().getUserId());
            stm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AttandanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Attandance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attandance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

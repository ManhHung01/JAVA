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

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    public Account getAccount(String user, String pass) {

        try {

            String sql = "select * from Account a where a.username = ? and a.password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                return a;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Account> getAccounts(String username) {
        ArrayList<Account> accounts = new ArrayList<>();
        try {

            String sql = "select * from Account a where a.username != ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setUsername(rs.getString("username"));

                accounts.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }

}

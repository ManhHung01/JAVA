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
import model.Request;

/**
 *
 * @author Admin
 */
public class RequestDAO extends DBContext {

    public static void main(String[] args) {
        RequestDAO db = new RequestDAO();
        System.out.println(""+ db.getRequests("admin"));
    }
    
    public void createRequest(String content, String categotyid, String toUser, String username) {

        try {

            String sql = "insert into [Request]\n"
                    + "(\n"
                    + "[content],\n"
                    + "[createdDate],\n"
                    + "[categotyid],\n"
                    + "[toUser],\n"
                    + "[username]\n"
                    + ")\n"
                    + "values(?, getdate(),?,?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, content);
            stm.setString(2, categotyid);
            stm.setString(3, toUser);
            stm.setString(4, username);
            stm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    CategoryDAO categoryDB = new CategoryDAO();

    public ArrayList<Request> getRequests(String username) {
        ArrayList<Request> requests = new ArrayList<>();
        try {
    String sql = "select * from [Request] r ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setContent(rs.getString("content"));
                r.setCreatedDate(rs.getDate("createdDate"));
                r.setRid(rs.getInt("rid"));

                Category c = categoryDB.getCategory(rs.getString("categotyid"));
                r.setCategory(c);
                Account a = new Account();
                a.setUsername(rs.getString("toUser"));
                r.setUsername(a);

                Account a1 = new Account();
                a1.setUsername(username);
                r.setToUser(a1);

                requests.add(r);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return requests;
    }
}

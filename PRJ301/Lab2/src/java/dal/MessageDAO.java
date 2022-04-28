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
import model.Message;

/**
 *
 * @author Admin
 */
public class MessageDAO extends DBContext {
    
    public static void main(String[] args) {
                MessageDAO messDB = new MessageDAO();
        System.out.println(""+ messDB.getMessages("admin").get(0).getFrom().getUsername());
        System.out.println(""+ messDB.getMessages("admin"));
    }
    
    public void createMessage(Message m) {

        try {

            String sql = "insert into [Message]\n"
                    + "(\n"
                    + "[content],\n"
                    + "[createdDate],\n"
                    + "[from],\n"
                    + "[to]\n"
                    + ")\n"
                    + "values(?, getdate(),?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, m.getContent());
            stm.setString(2, m.getFrom().getUsername());
            stm.setString(3, m.getTo().getUsername());
            stm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Message> getMessages(String username) {
        ArrayList<Message> messages = new ArrayList<>();
        try {

            String sql = "select * from [Message] m where m.[to] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Message m = new Message();
                m.setContent(rs.getString("content"));
                m.setCreatedDate(rs.getDate("createdDate"));
                m.setId(rs.getInt("id"));
                
                Account a = new Account();
                a.setUsername(rs.getString("from"));
                m.setFrom(a);
                
                Account a1 = new Account();
                a1.setUsername(username);
                m.setTo(a1);


                messages.add(m);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return messages;
    }
}

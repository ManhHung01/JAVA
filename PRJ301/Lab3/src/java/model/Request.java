/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Request {

    private int rid;
    private String content;
    private Date createdDate;
    private Category category;
    private Account toUser;
    private Account username;

    public Request() {
    }

    public Request(int rid, String content, Date createdDate, Category category, Account toUser, Account username) {
        this.rid = rid;
        this.content = content;
        this.createdDate = createdDate;
        this.category = category;
        this.toUser = toUser;
        this.username = username;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getToUser() {
        return toUser;
    }

    public void setToUser(Account toUser) {
        this.toUser = toUser;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }
    
    

}

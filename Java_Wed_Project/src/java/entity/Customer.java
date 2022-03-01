/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author DELL
 */
public class Customer {
    
    private int cid;
    private String fullName;
    private String address;
    private String phone;
    private String userName;
    private String password;
    private int status = 1;

    public Customer() {
    }

    public Customer(String fullName, String address, String phone, String userName, String password) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
    }
    
    public Customer(int cid, String fullName, String address, String phone, String userName, String password) {
        this.cid = cid;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}

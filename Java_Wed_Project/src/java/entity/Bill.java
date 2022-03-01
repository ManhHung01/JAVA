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
public class Bill {
    
    private int bid;
    private String dateCreate;
    private double total;
    private String recName;
    private String address;
    private String recPhone;
    private int status = 1;
    private int cid;

    public Bill() {
    }

    public Bill(String dateCreate, double total, String recName, String address, String recPhone, int cid) {
        this.dateCreate = dateCreate;
        this.total = total;
        this.recName = recName;
        this.address = address;
        this.recPhone = recPhone;
        this.cid = cid;
    }
    
    public Bill(int bid, String dateCreate, double total, String recName, String address, String recPhone, int status, int cid) {
        this.bid = bid;
        this.dateCreate = dateCreate;
        this.total = total;
        this.recName = recName;
        this.address = address;
        this.recPhone = recPhone;
        this.status = status;
        this.cid = cid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    
}

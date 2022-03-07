/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class BillDetail {
    
    private int bid;
    private String pid;
    private int quantity;
    private double price;

    /**
     *
     */
    public BillDetail() {
    }

    /**
     *
     * @param bid
     * @param pid
     * @param quantity
     * @param price
     */
    public BillDetail(int bid, String pid, int quantity, double price) {
        this.bid = bid;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getBid() {
        return bid;
    }

    /**
     *
     * @param bid
     */
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     *
     * @return
     */
    public String getPid() {
        return pid;
    }

    /**
     *
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    
}

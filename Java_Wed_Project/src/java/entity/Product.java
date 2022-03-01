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
public class Product {
    
    private String pid;
    private String pName;
    private int quantity;
    private double price;
    private String image;
    private String desciption;
    private int status = 1;
    private  String cateId;

    public Product() {
    }

    public Product(String pid, String pName, int quantity, double price, String image, String desciption, String cateId) {
        this.pid = pid;
        this.pName = pName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.desciption = desciption;
        this.cateId = cateId;
    }
    
    public Product(String pid, String pName, int quantity, double price, String image, String desciption, int status, String cateId) {
        this.pid = pid;
        this.pName = pName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.desciption = desciption;
        this.status = status;
        this.cateId = cateId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }
    
    
}

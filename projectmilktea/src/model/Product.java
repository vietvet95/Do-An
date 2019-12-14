/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Product {

    private String productID;
    private String productName;
    private String productType;
    private int productPrice;
    private int amountInCombo;

    public Product(String productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }

    public Product(String productID, String productName, String productType, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    //product by combo
    public Product(String productID, String productName, int productPrice, int amountInCombo) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.amountInCombo = amountInCombo;
    }

    public int getAmountInCombo() {
        return amountInCombo;
    }

    public void setAmountInCombo(int amountInCombo) {
        this.amountInCombo = amountInCombo;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productDiscount) {
        this.productPrice = productDiscount;
    }

}

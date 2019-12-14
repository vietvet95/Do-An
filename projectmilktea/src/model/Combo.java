/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author HoangViet
 */
public class Combo {

    private String comboID;
    private String comboName;
    private int comboPrice;
    private float comboDiscount;
    private String productID;
    private int amountProduct;
    private List<Product> listProduct;

    public Combo(String comboID, String comboName, float comboDiscount, String productID, int amountProduct) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.comboDiscount = comboDiscount;
        this.productID = productID;
        this.amountProduct = amountProduct;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    
    
    public Combo(String comboID, String comboName, int comboPrice, float comboDiscount) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.comboPrice = comboPrice;
        this.comboDiscount = comboDiscount;
    }

    public Combo(String comboID, String comboName, int comboPrice, float comboDiscount, List<Product> listProduct) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.comboPrice = comboPrice;
        this.comboDiscount = comboDiscount;
        this.listProduct = listProduct;
    }
    
    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getComboID() {
        return comboID;
    }

    public void setComboID(String comboID) {
        this.comboID = comboID;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public int getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(int comboPrice) {
        this.comboPrice = comboPrice;
    }

    public float getComboDiscount() {
        return comboDiscount;
    }

    public void setComboDiscount(float comboDiscount) {
        this.comboDiscount = comboDiscount;
    }

}

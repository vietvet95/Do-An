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
public class Recipe {

    private String materialID;
    private String productID;
    private int amountMaterial;

    public Recipe(String productID, String materialID, int amountMaterial) {
        this.materialID = materialID;
        this.productID = productID;
        this.amountMaterial = amountMaterial;
    }

    public int getAmountMaterial() {
        return amountMaterial;
    }

    public void setAmountMaterial(int amountMaterial) {
        this.amountMaterial = amountMaterial;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
}

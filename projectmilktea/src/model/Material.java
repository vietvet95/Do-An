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
public class Material {

    private String materialID;
    private String materialName;
    private String materialDateAdd;
    private int materialPrice;
    private int materialAmount;
    private String unit;
    private int amountInRecipe;

    public int getAmountInRecipe() {
        return amountInRecipe;
    }

    public void setAmountInRecipe(int amountInRecipe) {
        this.amountInRecipe = amountInRecipe;
    }

    public Material(String materialID, String materialName, String unit, int amountInRecipe) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.unit = unit;
        this.amountInRecipe = amountInRecipe;
    }

    public Material(String materialID, String materialName, String materialDateAdd, int materialPrice, int materialAmount, String unit) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialDateAdd = materialDateAdd;
        this.materialPrice = materialPrice;
        this.materialAmount = materialAmount;
        this.unit = unit;
    }

    public Material(String materialID, String materialName, int materialPrice, int materialAmount, String unit) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialPrice = materialPrice;
        this.materialAmount = materialAmount;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialDateAdd() {
        return materialDateAdd;
    }

    public void setMaterialDateAdd(String materialDateAdd) {
        this.materialDateAdd = materialDateAdd;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(int materialPrice) {
        this.materialPrice = materialPrice;
    }

    public int getMaterialAmount() {
        return materialAmount;
    }

    public void setMaterialAmount(int materialAmount) {
        this.materialAmount = materialAmount;
    }

}

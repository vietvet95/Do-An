/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hoangviet
 */
public class Promotion {

    private String promotionID;
    private String promotionDiscount;
    private String dateStart;
    private String dateEnd;
    private String promotionType;

    public Promotion(String promotionID, String promotionDiscount, String dateStart, String dateEnd) {
        this.promotionID = promotionID;
        this.promotionDiscount = promotionDiscount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Promotion(String promotionID, String promotionDiscount, String dateStart, String dateEnd, String promotionType) {
        this.promotionID = promotionID;
        this.promotionDiscount = promotionDiscount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.promotionType = promotionType;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(String promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

}

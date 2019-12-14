/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FOP;
import model.Promotion;
import view.JPanelEmployee;

/**
 *
 * @author Admin
 */
public class PromotionController {

    public static List<Promotion> listPromotion() throws SQLException {
        List<Promotion> listPromotion = new ArrayList<>();
        String sql = "select ProductPromotionID,discount,datePromotionStart,datePromotionStart from ProductPromotion";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String id = rs.getString("ProductPromotionID");
            String discount = rs.getString("discount");
            String dateStart = rs.getString("datePromotionStart");
            String dateEnd = rs.getString("datePromotionStart");
            Promotion promotion = new Promotion(id, discount, dateStart, dateEnd);
            listPromotion.add(promotion);
        }
        rs.close();
        statement.close();
        connection.close();
        return listPromotion;
    }

    public static String getFOPByPromotionId(String promotionID) throws SQLException {
        String productPromotionID = null;
        String sql = "select FOPID from ProductPromotion WHERE ProductPromotionID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, promotionID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            productPromotionID = rs.getString("FOPID");
        }
        rs.close();
        ps.close();
        connection.close();
        return productPromotionID;
    }

    public static void insertPromotion(Promotion promotion, FOP fop) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "INSERT INTO ProductPromotion(ProductPromotionID,FOPID,discount,datePromotionStart,datePromotionEnd)"
                + "VALUES(?,?,?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, promotion.getPromotionID());
        ps.setString(2, fop.getFOPID());
        ps.setString(3, promotion.getPromotionDiscount());
        ps.setString(4, promotion.getDateStart());
        ps.setString(5, promotion.getDateEnd());
        ps.executeUpdate();
        ConnectionDB.closeConnection(cnn);
    }

    public static List<Promotion> searchPromotion(String FOPID) throws SQLException {
        List<Promotion> listPromotion = new ArrayList<>();
        String sql = "select ProductPromotionID,discount,datePromotionStart,datePromotionEnd from ProductPromotion where FOPID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, FOPID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String ProductPromotionID = rs.getString("ProductPromotionID");
            String discount = rs.getString("discount");
            String datePromotionStart = rs.getString("datePromotionStart");
            String datePromotionEnd = rs.getString("datePromotionEnd");
            listPromotion.add(new Promotion(ProductPromotionID, discount, datePromotionStart, datePromotionEnd));
        }
        rs.close();
        ps.close();
        connection.close();
        return listPromotion;
    }

    public static boolean checkPromotionID(String promotionID) {
        try {
            Connection cnn = ConnectionDB.getConnection();
            String query = "select ProductPromotionID,discount,datePromotionStart,datePromotionEnd from ProductPromotion where ProductPromotionID = ?";
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setString(1, promotionID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            ConnectionDB.closeConnection(cnn);
        } catch (SQLException ex) {
            Logger.getLogger(JPanelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void updatePromotion(Promotion promotion, FOP fop) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "UPDATE ProductPromotion SET FOPID =?,discount = ?, datePromotionStart = ?, datePromotionEnd = ? WHERE ProductPromotionID=?";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, fop.getFOPID());
        ps.setString(2, promotion.getPromotionDiscount());
        ps.setString(3, promotion.getDateStart());
        ps.setString(4, promotion.getDateEnd());
        ps.setString(5, promotion.getPromotionID());
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(cnn);
    }

    public static void deletePromotionByID(String promotionId) throws SQLException {
        String query = "DELETE FROM ProductPromotion WHERE ProductPromotionID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, promotionId);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(connection);
    }

    public static void deletePromotionByFOPID(String FOPid) throws SQLException {
        String query = "DELETE FROM ProductPromotion WHERE FOPid = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, FOPid);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(connection);
    }
}

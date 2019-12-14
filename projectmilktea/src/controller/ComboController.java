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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Combo;
import model.Product;

/**
 *
 * @author Admin
 */
public class ComboController {

    public static List<Combo> listAllCombo() throws SQLException {
        List<Combo> listAllCombo = new ArrayList<>();
        String query = "select ComboID,ComboName,sum(priceCombo)as'pricecombo' ,discountCombo  from (\n"
                + "select ComboID,ComboName,(cb.amountProduct * p.price * (1 - cb.discountCombo)) as 'priceCombo',discountCombo from Combo cb \n"
                + "join products p ON p.productID=cb.productID) as temp\n"
                + "group by ComboName,ComboID,discountCombo";
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("ComboID");
                String name = rs.getString("ComboName");
                int price = rs.getInt("pricecombo");
                float discount = rs.getFloat("discountCombo");
                listAllCombo.add(new Combo(id, name, price, discount));
            }
        }
        return listAllCombo;
    } 
    
    public static List<Product> listProductByComboID(String valueSelected) throws SQLException {
        List<Product> listProductByComboID = new ArrayList<>();
        String query = "select p.productID,P.productName,cb.amountProduct,p.price from products p \n"
                + "JOIN Combo cb ON p.productID=cb.productID WHERE Cb.ComboID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, valueSelected);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("productID");
            String name = rs.getString("productName");
            int amount = rs.getInt("amountProduct");
            int price = rs.getInt("price");
            listProductByComboID.add(new Product(id, name, price, amount));
        }
        rs.close();
        ps.close();
        connection.close();
        return listProductByComboID;
    }

    public static void deleteCombo(String comboID) throws SQLException {
        String query = "DELETE FROM combo WHERE comboid = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, comboID);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(connection);
    }

    public static void insertCombo(Combo combo) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "INSERT INTO combo (comboID,productID,ComboName,amountProduct,discountCombo)"
                + "VALUES(?,?,?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, combo.getComboID());
        ps.setString(2, combo.getProductID());
        ps.setString(3, combo.getComboName());
        ps.setInt(4, combo.getAmountProduct());
        ps.setString(5, String.valueOf(combo.getComboDiscount()));
        ps.executeUpdate();
    }
}

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
import model.FOP;
import model.Material;
import model.Product;
import model.Recipe;

/**
 *
 * @author Admin
 */
public class RecipeController {

    public static List<Material> listMaterialByProductID(String productID) throws SQLException {
        List<Material> listMaterial = new ArrayList<>();
        String query = "select rm.RMaterialID,rm.RMaterialName,r.amountMaterial,rm.unit from Recipe r join RawMaterial rm on r.RMaterialID = rm.RMaterialID where r.productID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, productID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listMaterial.add(new Material(rs.getString("RMaterialID"),rs.getString("RMaterialName"),rs.getString("unit"),rs.getInt("amountMaterial")));
        }
        rs.close();
        ps.close();
        connection.close();
        return listMaterial;
    }

    public static List<Product> listAllProductInRecipe() throws SQLException {
        List<Product> listAllProduct = new ArrayList<>();
        String query = "select distinct r.productID,p.productName from Recipe r join products p ON r.productID = p.productID";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("productID");
            String name = rs.getString("productName");
            listAllProduct.add(new Product(id, name));
        }
        rs.close();
        ps.close();
        connection.close();
        return listAllProduct;
    }

    public static void insertRecipe(Recipe recipe) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "insert into Recipe(productID,RMaterialID,amountMaterial)"
                + "VALUES(?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, recipe.getProductID());
        ps.setString(2, recipe.getMaterialID());
        ps.setInt(3, recipe.getAmountMaterial());
        ps.executeUpdate();
        ConnectionDB.closeConnection(cnn);
    }
    public static void deleteRecipe(String productID) throws SQLException{
         String query = "DELETE FROM Recipe WHERE productID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, productID);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(connection);
    }
}

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
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductController {

    public static List<Product> listAllProduct() throws SQLException {
        List<Product> listAllProduct = new ArrayList<>();
        String query = "select p.productID,p.productName,t.productTypeName,p.price from products p INNER JOIN productType t ON p.productTypeID=t.productTypeID";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("productID");
            String name = rs.getString("productName");
            String type = rs.getString("productTypeName");
            int price = rs.getInt("price");
            listAllProduct.add(new Product(id, name, type, price));
        }
        rs.close();
        ps.close();
        connection.close();
        return listAllProduct;
    }

}

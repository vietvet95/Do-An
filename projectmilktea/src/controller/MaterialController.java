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

/**
 *
 * @author Admin
 */
public class MaterialController {

    public static List<Material> listMaterialAll() throws SQLException {
        List<Material> listMaterial = new ArrayList<>();
        String query = "select RMaterialID,RMaterialName,amountAdd,RMaterialPrice,DateAdded,unit from RawMaterial";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listMaterial.add(new Material(rs.getString("RMaterialID"), rs.getString("RMaterialName"), rs.getString("DateAdded"), rs.getInt("RMaterialPrice"), rs.getInt("amountAdd"), rs.getString("unit")));
        }
        rs.close();
        ps.close();
        connection.close();
        return listMaterial;
    }

    public static List<Material> listMaterialByDateAdded(String dateAdded) throws SQLException {
        List<Material> listMaterial = new ArrayList<>();
        String query = "select RMaterialID,RMaterialName,amountAdd,RMaterialPrice,DateAdded,unit from RawMaterial WHERE DateAdded = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, dateAdded);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listMaterial.add(new Material(rs.getString("RMaterialID"), rs.getString("RMaterialName"), rs.getString("DateAdded"), rs.getInt("RMaterialPrice"), rs.getInt("amountAdd"), rs.getString("unit")));
        }
        rs.close();
        ps.close();
        connection.close();
        return listMaterial;
    }

    public static List<String> listDateAdded() throws SQLException {
        List<String> listDateAdded = new ArrayList<>();
        String query = "select distinct DateAdded from RawMaterial";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listDateAdded.add(rs.getString("DateAdded"));
        }
        rs.close();
        ps.close();
        connection.close();
        return listDateAdded;
    }

    public static void insertMaterial(Material material) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "insert into RawMaterial (RMaterialID,RMaterialName,amountAdd,RMaterialPrice,DateAdded,unit)"
                + "VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, material.getMaterialID());
        ps.setString(2, material.getMaterialName());
        ps.setInt(3, material.getMaterialAmount());
        ps.setInt(4, material.getMaterialPrice());
        ps.setString(5, material.getMaterialDateAdd());
        ps.setString(6, material.getUnit());
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(cnn);
    }

    public static void deleteMaterial(String id, String date) throws SQLException {
        String query = "DELETE FROM RawMaterial WHERE RMaterialID = ? and DateAdded = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, id);
        ps.setString(2, date);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(connection);
    }

    public static void updateMaterial(Material material) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "UPDATE RawMaterial SET RMaterialName = ?,amountAdd = ?,RMaterialPrice = ?,unit = ? WHERE RMaterialID = ? and DateAdded = ?";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, material.getMaterialName());
        ps.setInt(2, material.getMaterialAmount());
        ps.setInt(3, material.getMaterialPrice());
        ps.setString(4, material.getUnit());
        ps.setString(5, material.getMaterialID());
        ps.setString(6, material.getMaterialDateAdd());
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(cnn);
    }
}

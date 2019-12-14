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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FOP;
import view.JPanelEmployee;

/**
 *
 * @author Admin
 */
public class FOPController {

    public static List<FOP> listFOP() throws SQLException {
        List<FOP> listFOP = new ArrayList<>();
        FOP fop = null;
        String query = "select FOPID,FOPName from FOP ";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            fop = new FOP(rs.getString("FOPID"), rs.getString("FOPName"));
            listFOP.add(fop);
        }
        rs.close();
        ps.close();
        connection.close();
        return listFOP;
    }

    public static void insertFOP(FOP fop) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "insert into FOP (FOPID, FOPName)"
                + "VALUES(?,?)";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, fop.getFOPID());
        ps.setString(2, fop.getFOPName());
        ps.executeUpdate();
        ConnectionDB.closeConnection(cnn);
    }

    public static boolean checkFOPID(String FOPID) {
        try {
            Connection cnn = ConnectionDB.getConnection();
            String query = "select FOPID,FOPName from FOP  WHERE FOPID = ?";
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setString(1, FOPID);
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

    public static void updateFOP(String editName,String id) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "UPDATE FOP SET FOPName =? WHERE FOPID=?";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, editName);
        ps.setString(2,id);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(cnn);
    }

    public static void deleteFOP(String FOPID) throws SQLException {
        String query = "DELETE FROM FOP WHERE FOPID = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, FOPID);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(connection);
    }
    
}

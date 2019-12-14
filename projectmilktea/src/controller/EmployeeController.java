/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import view.JPanelEmployee;

/**
 *
 * @author Admin
 */
public class EmployeeController {
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //Hàm tìm kiếm theo từ khóa bất kỳ
   
    public static void findNhanVien(JTable table, String valueToSearch){
        try {
            Connection con = ConnectionDB.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select empID,empName,PositionName, EmpBirthday,"
                    + "EmpGender,EmpPhoneNumber,EmpAddress,EmpEmail,EmpDayAtWork "
                    + "from Position a inner join employee b on a.positionid=b.positionid"
                    + " where b.EmpID like ? or b.EmpName like ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ps.setString(2, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
            row = new Object[9];
            row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getDate(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(6);
            row[6] = rs.getString(7);
            row[7] = rs.getString(8);
            row[8] = rs.getDate(9);
            
            model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPanelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static List<Employee> layDanhSachTatCaNhanVien() throws SQLException{
        List<Employee>employeesList = new ArrayList<>();
        String sql = "select empID,EmpName,EmpPass,PositionID,EmpBirthday,EmpGender,EmpPhoneNumber,EmpAddress,EmpEmail,EmpDayAtWork from Employee";
        Connection connection = controller.ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            String id = rs.getString("empID");
            String name = rs.getString("EmpName");
            String pass = rs.getString("EmpPass");
            String position = rs.getString("PositionID");
            Date dateBirthday = rs.getDate("EmpBirthday");
            String gender = rs.getString("EmpGender");
            String phone = rs.getString("EmpPhoneNumber");
            String address = rs.getString("EmpAddress");
            String email =rs.getString("EmpEmail");
            Date dauAtWork = rs.getDate("EmpDayAtWork");
            Employee employee = new Employee(id, name, pass, position, dateBirthday,gender, phone, address,email, dauAtWork);
            employeesList.add(employee);
            
        }
        rs.close();
        statement.close();
        connection.close();
        return employeesList;
    }
     public static void updatePassEmp(String pass,String id) throws SQLException {
        Connection cnn = ConnectionDB.getConnection();
        String query = "UPDATE Employee SET EmpPass =? WHERE EmpID = ?";
        PreparedStatement ps = cnn.prepareStatement(query);
        ps.setString(1, pass);
        ps.setString(2,id);
        ps.executeUpdate();
        ps.close();
        ConnectionDB.closeConnection(cnn);
    }
}

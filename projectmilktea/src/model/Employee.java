/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Admin empID,EmpName,EmpPass,PositionID,EmpBirthday,EmpGender,EmpPhoneNumber,EmpAddress,EmpEmail,EmpDayAtWork
 */
public class Employee {
    private String empID;
    private String empName;
    private String empPass;
    private String empPosition;
    private Date empBirthday;
    private String empGander;
    private String empPhoneNumber;
    private String empAddress;
    private String empEmail;
    private Date empDayAtWork;

    public Employee(String empID, String empName, String empPass, String empPosition, Date empBirthday, String empGander, String empPhoneNumber, String empAddress, String empEmail, Date empDayAtWork) {
        this.empID = empID;
        this.empName = empName;
        this.empPass = empPass;
        this.empPosition = empPosition;
        this.empBirthday = empBirthday;
        this.empGander = empGander;
        this.empPhoneNumber = empPhoneNumber;
        this.empAddress = empAddress;
        this.empEmail = empEmail;
        this.empDayAtWork = empDayAtWork;
    }


    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPass() {
        return empPass;
    }

    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

   
    public String getEmpGander() {
        return empGander;
    }

    public void setEmpGander(String empGander) {
        this.empGander = empGander;
    }

    public String getEmpPhoneNumber() {
        return empPhoneNumber;
    }

    public void setEmpPhoneNumber(String empPhoneNumber) {
        this.empPhoneNumber = empPhoneNumber;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Date getEmpDayAtWork() {
        return empDayAtWork;
    }

    public void setEmpDayAtWork(Date empDayAtWork) {
        this.empDayAtWork = empDayAtWork;
    }
    
}

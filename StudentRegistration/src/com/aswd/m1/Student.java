package com.aswd.m1;

import java.util.Scanner;
import java.sql.*;

/**
 * This program is to validate the inputs in the registration form that the student fill up.
 *
 * Author: Nasrullah.
 * person: 01.
 * since: 25/04/2019.
 */

public class Student {

    public String firstName;
    public String lastName;
    public String gender;
    private String tel;
    private String address;
    public String course;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * This is to connect and give query to mySql database to be executed
     * @return -true if it is connected to mySql and the details are inserted into the database table.
     * @throws Exception -Tells the error if it does not connect or insert
     */

    public boolean insert() throws Exception{
        boolean result = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration", "root", "Nastoi95.");
            String sql = "INSERT INTO Student (firstName,lastName,gender,address,tel,course)VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, gender);
            pstmt.setString(4, address);
            pstmt.setString(5, tel);
            pstmt.setString(6, course);
            int rowInserted = pstmt.executeUpdate();
            result = true;

            return result;
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    /**
     * Validating the firstname
     * @return -boolean true/false;
     */

    public boolean ValidFname() {
        boolean result = true;
        //Check if name if valid
        if (this.firstName.length() == 0) {
            result = false;
        }
        else if(this.firstName.matches(".*\\d.*")){
            result = false;
        }
        return result;
    }

    /**
     * Validating the lastname
     * @return -boolean true/false;
     */

    public boolean ValidLname() {
        boolean result = true;
        //Check if name if valid
        if (this.lastName.length() == 0) {
            result = false;
        }
        else if (this.lastName.matches(".*\\d.*")){
            result = false;
        }
        return result;
    }

    /**
     * Validating the gender
     * @return -boolean true/false;
     */

    public boolean ValidGender() {
        boolean result = true;
        //Check if name if valid
        if (this.gender.length() == 0) {
            result = false;
        }
        else if(!(this.gender.equals("Male") || this.gender.equals("Female")) ){
            result = false;
        }
        return result;
    }

    /**
     * Validating the Address
     * @return -boolean true/false;
     */
    public boolean ValidAddress() {

        return true;
    }

   /* public static String ValidTel(String Tel) {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        //Check if name if valid
        while (Tel.length() == 0) {
            System.out.println("Please enter ur Phone.no");
            System.out.print("Phone.no : ");
            String ReTel = input.nextLine();
            Tel = ReTel;
        }
        while (!Tel.matches("[0-9]+")){
            System.out.println("Only numbers is allowed");
            System.out.print("Phone.no : ");
            String ReTel = input.nextLine();
            Tel = ReTel;
        }
        return Tel;
    }*/


    /**
     * Validating the telephone number
     * @return -boolean true/false;
     */
    public boolean ValidTel() {

        boolean result = true;
        //Check if name if valid
        if (this.tel.length() == 0) {
           result = false;
        }else if(!this.tel.matches("[0-9]+")){
            result = false;
        }
        return result;
    }

}
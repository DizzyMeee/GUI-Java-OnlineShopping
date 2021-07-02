/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshop;

import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    Connection conn = null;
    
    // register a customer
    public String add_user(String fName, String lName, String email, String bdate, String address, String phoneNum, String pass){
        String result = "";
        conn = new ConnectionSQL().getConSQL();
        String query = "INSERT INTO CUSTOMER(FNAME, LNAME, EMAIL, BDATE, ADDRESS, PHONE, PASSWORD) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, email);
            ps.setString(4, bdate);
            ps.setString(5, address);
            ps.setString(6, phoneNum);
            ps.setString(7, pass);
            
            int i = ps.executeUpdate();
            if(i!=0){
                result = "Success";
            }else{
                result = "Failed";
            }
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return result;
    }
    
    // checking email if taken
    public boolean check_email(String email){
        conn = new ConnectionSQL().getConSQL();
        boolean checkEmail = false; // jika email belum ada
        String query = "SELECT * FROM CUSTOMER WHERE EMAIL =?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs;
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkEmail = true; // jika email ada maka tidak boleh dipakai lagi
            }
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return checkEmail;
    }
    
    // login admin
    public String login_adm(String email, String pass){
        String result = "";
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM ADMIN WHERE EMAIL_ADM =? AND PASS_ADM =?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;   
            
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                result = "Success";
            }else{
                result = "Failed";
            }
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return result;
    }
    
    // login customer
    public String login_customer(String email, String pass){
        String result = "";
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM CUSTOMER WHERE EMAIL =? AND PASSWORD =?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;   
            
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
//                fullName = rs.getString("fName")+ " " + rs.getString("lName");
                result ="Success";
            }else{
                result = "Failed";
            }
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return result;
    }
    
    public String get_fullName(String email, String pass){
        String fullName = "";
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM CUSTOMER WHERE EMAIL =? AND PASSWORD =?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;   
            
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                fullName = rs.getString("fName")+ " " + rs.getString("lName");
            }
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return fullName;
    }
}

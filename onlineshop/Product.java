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

public class Product {
    Connection conn = null;
    
    public String update_data(String name, int quantity){
        String result = "";
        conn = new ConnectionSQL().getConSQL();
        String query1 = "SELECT * FROM PRODUCT WHERE PROD_NAME=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query1);
            ps.setString(1, name);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int instock = rs.getInt("STOCK");
                instock -= quantity;
                String query2 = "UPDATE PRODUCT SET STOCK='"+instock+"' WHERE PROD_NAME='"+name+"'";
                
                ps = conn.prepareStatement(query2);
                ps.execute();
            }
            int i = ps.executeUpdate();
            if(i!=0){
                result = "Success";
            }
            else{
                result = "Failed";
            }
            
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }
        
    public List get_data(String str){
        List<String> assetList = new ArrayList<String>();
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM PRODUCT WHERE CATEGORY=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,str + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("PROD_NAME").trim();
                String category = rs.getString("CATEGORY").trim();
                String stock = rs.getString("STOCK").trim();
                String price = rs.getString("PRICE").trim();
                
                String[] df = {name, category, stock, price};
                Collections.addAll(assetList, df);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return assetList;
    }
    
    // show data for customer
    public List show_dataAvailable(){
        List<String> assetList = new ArrayList<String>();
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM PRODUCT WHERE STOCK > 0";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("PROD_NAME").trim();
                String category = rs.getString("CATEGORY").trim();
                String stock = rs.getString("STOCK").trim();
                String price = rs.getString("PRICE").trim();
                
                String df[] = {name, category, stock, price};
                Collections.addAll(assetList, df);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return assetList;
    }
    
    // show data for admin
    public List show_data(){
        List<String> assetList = new ArrayList<String>();
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM PRODUCT";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("PROD_NAME").trim();
                String category = rs.getString("CATEGORY").trim();
                String stock = rs.getString("STOCK").trim();
                String price = rs.getString("PRICE").trim();
                
                String df[] = {name, category, stock, price};
                Collections.addAll(assetList, df);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return assetList;
    }
    
    public List find_data(String str){
        List<String> assetList = new ArrayList<String>();
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM PRODUCT WHERE PROD_NAME LIKE ? AND STOCK > 0 ORDER BY PROD_NAME ASC";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,str + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("PROD_NAME").trim();
                String category = rs.getString("CATEGORY").trim();
                String stock = rs.getString("STOCK").trim();
                String price = rs.getString("PRICE").trim();
                
                String[] df = {name, category, stock, price};
                Collections.addAll(assetList, df);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return assetList;
    }
    
    public String add_data(String name, String category, String stock, String price){
        String result = "";
        conn = new ConnectionSQL().getConSQL();
        String query = "INSERT INTO PRODUCT(PROD_NAME, CATEGORY, STOCK, PRICE) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1,name);
            ps.setString(2,category);
            ps.setString(3,stock);
            ps.setString(4,price);
            
            int i = ps.executeUpdate();
            if(i!=0){
                result = "Success";
            }
            else{
                result = "Failed";
            }
            
            conn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Product: "+name+" can't duplicate");
        }
        return result;
    }
    
    public String edit_data(String name, String category, String stock, String price){
        String result = "";
        int IntStock = Integer.valueOf(stock);
        conn = new ConnectionSQL().getConSQL();
        String query = "UPDATE PRODUCT SET CATEGORY=?, STOCK=?, PRICE=? WHERE PROD_NAME=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1,category);
            ps.setInt(2,IntStock);
            ps.setString(3,price);
            ps.setString(4,name);
            
            int i = ps.executeUpdate();
            if(i!=0){
                result = "Success Update";
            }
            else{
                result = "Failed Update";
            }
            conn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return result;
    }
    
    public String delete_data(String name, String category, String stock, String price){
        int IntStock = Integer.valueOf(stock);
        String result  ="";
        conn = new ConnectionSQL().getConSQL();
        String query = "DELETE PRODUCT WHERE PROD_NAME=? AND CATEGORY=? AND STOCK=? AND PRICE=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setInt(3, IntStock);
            ps.setString(4, price);
            
            int i = ps.executeUpdate();
            if(i!=0){
                result = "Success to delete";
            }else{
                result = "Failed to delete";
            }
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }
    
    public List filter_data(String str){
        List<String> assetList = new ArrayList<String>();
        conn = new ConnectionSQL().getConSQL();
        String query = "SELECT * FROM PRODUCT WHERE CATEGORY LIKE ? AND STOCK > 0 ORDER BY PROD_NAME ASC";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,str + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("PROD_NAME").trim();
                String category = rs.getString("CATEGORY").trim();
                String stock = rs.getString("STOCK").trim();
                String price = rs.getString("PRICE").trim();
                
                String[] df = {name, category, stock, price};
                Collections.addAll(assetList, df);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return assetList;
    }
}

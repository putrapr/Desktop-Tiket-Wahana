/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */

public class Koneksi {
    public static Connection con;
    public static Statement stm; 
    
//    public static void main(String args[]){
//        try{
//            String url = "jdbc:mysql://localhost:3307/data_pegawai";
//            String user = "root";
//            String pass = "";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, user, pass);
//            stm = con.createStatement();
//            System.out.println("Koneksi Berhasil"); 
//        }
//        catch (ClassNotFoundException | SQLException e){
//            System.err.println("Koneksi Gagal" + e.getMessage());
//        }
//    }

    public void config(){
        try{
            String url = "jdbc:mysql://localhost/db_leuwi";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
}

package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by ACER on 6/19/2018.
 */
public class Laundary {
    Connection con;

    Laundary() throws SQLException, ClassNotFoundException {
        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();
    }
//    public void laundaryService() throws IOException, IOException, SQLException, ClassNotFoundException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        LaundaryLogin e = new LaundaryLogin();
//        System.out.println("Enter Userid: ");
//        String user = br.readLine();
//        System.out.println("Enter Password: ");
//        String pass = br.readLine();
//        e.login(user, pass);
//    }
//
//    public void laundary1Service() throws SQLException {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from laundary");
//        String s1 = "Update laundary set status=1 where userid=?";
//        while (rs.next()) {
//            String user = rs.getString(1);
//            int stat = rs.getInt(5);
//            if (stat == 0) {
//                PreparedStatement ps = con.prepareStatement(s1);
//                ps.setString(1,user);
//                int i = ps.executeUpdate();
//                System.out.println(i);
//
//                break;
//                //}
//            }
//            else {
//                System.out.println(user+"  is busy");
//            }
//        }
//
//    }
//
//
//
//
//
//    public void lworkDone(String i) throws SQLException {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from laundary");
//        String s1 = "Update Cleaner set status=0 where userid=?";
//        while (rs.next()) {
//            String user = rs.getString(1);
//            int stat = rs.getInt(4);
//            if (stat == 1) {
//
//                PreparedStatement ps = con.prepareStatement(s1);
//                ps.setString(1,user);
//                int j = ps.executeUpdate();
//                System.out.println(j);
//
//                break;
//
//            }
//        }
//
//    }

    public void laundaryService() throws IOException, SQLException, ClassNotFoundException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        LaundaryLogin l=new LaundaryLogin();
        System.out.println("Enter Username");
        String user=br.readLine();
        System.out.println("Enter Password");
        String pass=br.readLine();
        l.login(user,pass);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Laundary l=new Laundary();
        l.laundaryService();

    }
}

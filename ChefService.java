package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by ACER on 6/20/2018.
 */
public class ChefService {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Connection con=DBConnect.connection();

    public ChefService() throws SQLException, ClassNotFoundException {
    }

    public void startchefService(String useridt) throws IOException, SQLException, ClassNotFoundException {

        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. See your tasks.");
            System.out.println("2. Order Done.");

            System.out.println("Any 0 for exit.");

            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    seeYourTask();
                    break;
                case 2:
                   done();
                    break;
                case 3:

            }
        } while (choice != 0);
    }

    private void seeYourTask() throws SQLException {
        Statement statement=con.createStatement();
        ResultSet rs=statement.executeQuery("select * from fooddept");
      //  System.out.println("HIIIIII");
//        rs.next();
//        String s=rs.getString(1);
//        System.out.println(s);
        rs.next();

            System.out.println("Inside RS");
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }

//    private void statusUpdate() throws SQLException {
//        Statement statement=con.createStatement();
//        ResultSet rs=statement.executeQuery("select * from fooddept");
//        String s1 = "Update fooddept set status="+0+", roomno="+0+"where userid=?";
//        rs.next();
//        String user = rs.getString(1);
//        int stat = rs.getInt(4);
//
//        PreparedStatement ps = con.prepareStatement(s1);
//        ps.setString(1, user);
//        int i = ps.executeUpdate();
//        System.out.println(i);
//        System.out.println(user+":"+stat);
//    }
    private void done() throws SQLException {
        Statement statement=con.createStatement();
        ResultSet rs=statement.executeQuery("select * from fooddept");
        String sql="delete from fooddept where foodtype=?";
        rs.next();
            String rno = rs.getString(2);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rno);
            int i = ps.executeUpdate();
            System.out.println(i);
        }
    }


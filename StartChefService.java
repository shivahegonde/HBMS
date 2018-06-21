package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by ACER on 6/20/2018.
 */
public class StartChefService {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Connection con=DBConnect.connection();
    StartChefService() throws SQLException, ClassNotFoundException {

    }

    public void startChefService(int rno) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from chef where status="+0);
        String s1 = "Update chef set status="+1+", roomno="+rno+"where userid=?";
        rs.next();
        String user = rs.getString(1);
        int stat = rs.getInt(5);

        PreparedStatement ps = con.prepareStatement(s1);
        ps.setString(1, user);
        int i = ps.executeUpdate();
        System.out.println(i);
        System.out.println(user+":"+stat);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StartChefService sc=new StartChefService();
        Scanner s=new Scanner(System.in);
        System.out.println("Enter room no");
        int rno=s.nextInt();
        sc.startChefService(rno);
    }
}

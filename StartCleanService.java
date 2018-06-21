package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by ACER on 6/20/2018.
 */
//Receptonist Employee...
public class StartCleanService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Connection con = DBConnect.connection();

    StartCleanService() throws SQLException, ClassNotFoundException {

    }

    public void startCleanService(int rno) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from cleaner where status=" + 0);
            String s1 = "Update Cleaner set status=" + 1 + ", roomno=" + rno + "where userid=?";
            rs.next();
            String user = rs.getString(1);
            int stat = rs.getInt(5);

            PreparedStatement ps = con.prepareStatement(s1);
            ps.setString(1, user);
            int i = ps.executeUpdate();
            System.out.println(i);
            System.out.println(user + ":" + stat);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

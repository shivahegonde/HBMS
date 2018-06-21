package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by ACER on 6/20/2018.
 */
public class StartLaundaryService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Connection con = DBConnect.connection();

    StartLaundaryService() throws SQLException, ClassNotFoundException {

    }

    public void startLaundaryService(int rno) {
        try {
            Statement stmt = null;
            try {
                stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from laundary where status=" + 0);
            String s1 = "Update laundary set status=" + 1 + ", roomno=" + rno + "where userid=?";
            rs.next();

            String user = rs.getString(1);
            System.out.println(user);

            int stat = rs.getInt(5);

            PreparedStatement ps = con.prepareStatement(s1);
            ps.setString(1, user);
            int i = ps.executeUpdate();
            System.out.println(i);
            System.out.println(user + ":" + stat);
            throw new MyException("Invalid");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (MyException ex) {
            System.out.println(ex);
        }

    }
}

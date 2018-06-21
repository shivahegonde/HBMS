package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by ACER on 6/20/2018.
 */
public class CleanerService {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Connection con=DBConnect.connection();

    public CleanerService() throws SQLException, ClassNotFoundException {
    }

    public void startcleanService(String useridt) throws IOException, SQLException, ClassNotFoundException {

        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. See your tasks.");
            System.out.println("2. update your Status.");

            System.out.println("Any 0 for exit.");

            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    seeYourTask();
                    break;
                case 2:
                    statusUpdate();
                    break;
                case 3:

            }
        } while (choice != 0);
    }

    private void seeYourTask() throws SQLException {
        Statement statement=con.createStatement();
        ResultSet rs=statement.executeQuery("select * from Cleaner");
//        System.out.println("HIIIIII");
//        rs.next();
//        String s=rs.getString(1);
//        System.out.println(s);
        rs.next();

//            System.out.println("Inside RS");
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getInt(5));
        }

    private void statusUpdate() throws SQLException {
        Statement statement=con.createStatement();
        ResultSet rs=statement.executeQuery("select * from Cleaner");
        String s1 = "Update Cleaner set status="+0+", roomno="+0+"where userid=?";
        rs.next();
        String user = rs.getString(1);
        int stat = rs.getInt(5);

        PreparedStatement ps = con.prepareStatement(s1);
        ps.setString(1, user);
        int i = ps.executeUpdate();
        System.out.println(i);
        System.out.println(user+":"+stat);
    }
}

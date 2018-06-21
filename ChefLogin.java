package com.java.Zensar.HBMS;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ACER on 6/20/2018.
 */
public class ChefLogin extends Login{
    Connection con;

    ChefLogin() throws SQLException, ClassNotFoundException {
        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();
    }


    @Override
    void login(String userid, String password) throws IOException, SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from chef where status= "+1);
        while (rs.next()) {
            System.out.print(" , "+ rs.getString(3));

        }
        System.out.println("Are able to Login.");
        loginprocees(userid,password);
    }

    private void loginprocees(String userid, String password) throws SQLException, IOException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from chef where status= "+1);
        while (rs.next()) {
            String user = rs.getString(1);
            String pass = rs.getString(2);
            String fname = rs.getString(3);
            System.out.println(user);
            if (user.equals(userid) && pass.equals(password)) {
                System.out.println("Successfully Login....");
                System.out.println("\n\n\t\tWelcome " + fname);
                ChefService cfs = new ChefService();
                cfs.startchefService(userid);
            }
        }
    }

}

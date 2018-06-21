package com.java.Zensar.HBMS;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by ACER on 6/19/2018.
 */
public class LaundaryLogin extends Login {
    Connection con;

    LaundaryLogin() throws SQLException, ClassNotFoundException {

        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();

    }

    @Override
    void login(String userid, String password) throws IOException, SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from laundaryman where status=" + 0);

        rs.next();

        String useridt = rs.getString(1);
        String passwordt = rs.getString(2);
        String fname = rs.getString(3);
        if (useridt.equals(userid) && passwordt.equals(password)) {
            System.out.println("Successfully Login....");
            System.out.println("\n\n\t\tWelcome " + fname);
            LaundaryService ls = new LaundaryService();
            ls.startLaundaryService();

        }

    }
}






package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerLogin extends Login {
    Connection con;

    CustomerLogin() throws SQLException, ClassNotFoundException {

        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();
    }

    @Override
    void login(String userid, String password) throws IOException, SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers");
        while (rs.next()) {
            String useridt = rs.getString(1);
            String passwordt = rs.getString(2);
            String fname = rs.getString(3);
//            String lname = rs.getString(4);
//            String mobno = rs.getString(5);
            if (useridt.equals(userid) && passwordt.equals(password)) {
                System.out.println("Successfully Login....");
                System.out.println("\n\n\t\tWelcome " + fname);
                CustomerService r = new CustomerService();
                r.cstartService();
            }


        }
    }
}

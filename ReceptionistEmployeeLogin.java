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

class ReceptionistEmployeeLogin extends Login {
    Connection con;

    ReceptionistEmployeeLogin() throws SQLException, ClassNotFoundException {

        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();

    }

    @Override
    void login(String userid, String password) throws IOException, SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from receptionist");
        while (rs.next()) {
            String useridt = rs.getString(1);
            String passwordt = rs.getString(2);
            String fname = rs.getString(3);
//            System.out.println(userid);
            if (useridt.equals(userid) && passwordt.equals(password)) {
                System.out.println("Successfully Login....");
                System.out.println("\n\n\t\tWelcome " + fname);
                ReceptionistService r = new ReceptionistService();
                r.estartService();
            }

        }
    }
}
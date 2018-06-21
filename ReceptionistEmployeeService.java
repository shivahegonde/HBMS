package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class ReceptionistEmployeeService {
    Connection con;

    ReceptionistEmployeeService() throws SQLException, ClassNotFoundException {

        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();

    }

    public void recemployeeService() throws IOException, IOException, SQLException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ReceptionistEmployeeLogin e=new ReceptionistEmployeeLogin();
        System.out.println("Enter Userid: ");
        String user = br.readLine();
        System.out.println("Enter Password: ");
        String pass = br.readLine();
        e.login(user, pass);
    }
}

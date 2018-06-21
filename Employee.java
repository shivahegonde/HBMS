package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Employee {

    public void employeeService() throws IOException, IOException, SQLException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EmployeeLogin e = new EmployeeLogin();
        System.out.println("Enter Userid: ");
        String user = br.readLine();
        System.out.println("Enter Password: ");
        String pass = br.readLine();
        e.login(user, pass);
    }
}

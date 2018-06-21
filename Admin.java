package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

public class Admin {
    public void adminService() throws IOException, IOException, SQLException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdminLogin a = new AdminLogin();
        System.out.println("Enter Userid: ");
        String user = br.readLine();
        System.out.println("Enter Password: ");
        String pass = br.readLine();
        a.login(user, pass);
    }
}

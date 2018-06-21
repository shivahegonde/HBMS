package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import com.java.Zensar.Task.Register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Customer {
    public void customerService() throws IOException, IOException, SQLException, ClassNotFoundException {
        int choice;
        System.out.println("Enter your Choice: ");
        System.out.println("\t1. Login.\n\t2. Register");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                CustomerLogin l = new CustomerLogin();
                System.out.println("Enter Userid: ");
                String user = br.readLine();
                System.out.println("Enter Password: ");
                String pass = br.readLine();
                l.login(user, pass);
                break;
            case 2:
                Register r=new Register();
                r.startRegister();
                break;

        }
    }


}

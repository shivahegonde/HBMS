package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by ACER on 6/18/2018.
 */
public class AllEmployee {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public void aestartService() throws SQLException, ClassNotFoundException, IOException {
        int choice;
        do {
            System.out.println("1.Receptionist");
            System.out.println("2.Cleaner");
            System.out.println("3.Chef");
            System.out.println("4.Laundary man");


            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                  ReceptionistEmployeeService res=new ReceptionistEmployeeService();
                  res.recemployeeService();
                    break;

                case 2:
                    Cleaner c=new Cleaner();
                    c.cleanService();
                    break;
                case 3:
                    Chef chef=new Chef();
                    chef.chefService();
                    break;
                case 4:
                    Laundary l=new Laundary();
                    l.laundaryService();
                    break;
            }

        }while(choice!=5);
    }

}


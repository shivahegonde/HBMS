package com.java.Zensar.HBMS;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by ACER on 6/20/2018.
 */
public class WashService {

        Connection con=DBConnect.connection();
        Scanner scanner=new Scanner(System.in);
        int choice;


        public WashService() throws SQLException, ClassNotFoundException {
        }

        public void startWashService() throws SQLException, IOException, ClassNotFoundException {
            do {
                System.out.println("which service you wants:\n1.clean room \n 2.Laundry Service");
                choice=scanner.nextInt();
                switch (choice)
                {
                    case 1:

                        cleanService();
                        break;
                    case 2:
                       laundryService();
                        break;

                }
            }while (choice!=3);


        }
        public void cleanService() throws SQLException, IOException, ClassNotFoundException {
            StartCleanService cl= new StartCleanService();
            System.out.println("Enter your room no:");
            int rno=scanner.nextInt();
            cl.startCleanService(rno);
        }
        public void laundryService() throws SQLException, ClassNotFoundException, IOException {
            StartLaundaryService cl= new StartLaundaryService();
            System.out.println("Enter your room no:");
            int rno=scanner.nextInt();
            cl.startLaundaryService(rno);
        }
    }



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

public class ReceptionistService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int totalRooms;
    private static int totalAvailableRooms = 10;
    private boolean roomStatus;

    public void cstartService() throws IOException, SQLException, ClassNotFoundException {
        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Delux");
            System.out.println("2. Luxury.");
            System.out.println("Any other key for exit.");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    DeluxRoom deluxRoom = new DeluxRoom();
                    deluxRoom.startService();
                    break;
                case 2:
                    LuxaryRoom luxaryRoom = new LuxaryRoom();
                    luxaryRoom.startService();
                    break;
            }
        } while (choice == 1 || choice == 2);
    }

    private void viewBookedStatus() {
        if (roomStatus == true) {
            System.out.println("Your Room is Booked....");
        }
    }

    public void estartService() throws IOException, SQLException, ClassNotFoundException {
        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Room");
            System.out.println("2. Service.");
            System.out.println("3. Rate us.");
            System.out.println("4. Send Report to Admin");

            System.out.println("Any 0 for exit.");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                   Rooms rooms=new Rooms();
                   rooms.cstartService();
                    break;
                case 2:
                    AllServices as=new AllServices();
                    as.startAllService();
                    break;
                case 3:

            }
        } while (choice != 0);
    }
}

package com.java.Zensar.HBMS;

/**
 * Created by ACER on 6/19/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Rooms{
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
              System.out.println("3. Party Hall.");
//            System.out.println("4. Conference Hall.");
//            System.out.println("5. Terece Garden.");
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
                case 3 :
                    PartyHall partyHall = new PartyHall();
                    partyHall.startService();
                    break;
            }
        } while (choice == 1 || choice == 2);
    }

    private void viewBookedStatus() {
        if (roomStatus == true) {
            System.out.println("Your Room is Booked....");
        }
    }

}

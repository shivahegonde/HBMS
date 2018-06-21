package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class LuxaryRoom extends Room {
    //    int count = 0;
    Connection con = DBConnect.connection();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    LuxaryRoom() throws SQLException, ClassNotFoundException {
        totalAvailableRooms = 10;
        rate = 1000;
        wifi = true;
        roomStatus = true;
    }

    private void bookRoom() throws IOException, SQLException {
        int count = 0;
        System.out.println("Enter how many Rooms you want to Book? ");
        int rooms = Integer.parseInt(br.readLine());
        System.out.println("Enter how many days you want to live? ");
        int days = Integer.parseInt(br.readLine());

        String sql = "select * from luxaryroom where status=0";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(rooms);
        for (int j = 0; j < rooms; j++) {
//            System.out.println(j+1);
            String str = "update luxaryroom set status = 1,days=" + days + " where roomno = " + "(select min(roomno) from luxaryroom where status in(0))";
            PreparedStatement prepare = con.prepareStatement(str);
            prepare.executeUpdate();

        }
    }

//}


    @Override
    public void startService() throws IOException, SQLException {

        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Book Room.");
            System.out.println("2. View Status.");
            System.out.println("Any other key for exit.");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    bookRoom();
                    System.out.println("Do you Want To Continue: ");
                    String s = br.readLine();
                    if (s != "n" || s != "N") {
                        break;
                    }
                case 2:
                    viewBookedStatus();
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


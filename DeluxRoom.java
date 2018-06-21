package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

class DeluxRoom extends Room {
    //int count=0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Connection con=DBConnect.connection();
    Scanner scanner=new Scanner(System.in);

    DeluxRoom() throws SQLException, ClassNotFoundException {
        totalAvailableRooms = 10;
        rate = 1000;
        wifi = true;
        roomStatus = true;
    }
    private void bookRoom() throws IOException, SQLException {
        int count=0;
        System.out.println("Enter how many Rooms you want to Book? ");
        int rooms = Integer.parseInt(br.readLine());
        System.out.println("Enter how many days you want to live? ");
        int days = Integer.parseInt(br.readLine());

        String sql = "select * from deluxroom where status=0";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


            System.out.println(rooms);
            for (int j = 0; j < rooms; j++) {
                //System.out.println("in for");
//            System.out.println(j+1);
                String str = "update deluxroom set status = 1,days=" + days + " where roomno = " + "(select min(roomno) from deluxroom where status in(0))";
                PreparedStatement prepare = con.prepareStatement(str);
                prepare.executeUpdate();

            }
        }

//        }


//        if (rooms <= totalAvailableRooms) {
//            Fare fare = new Fare();
//
//            int totalAmount = fare.calculateDeluxFare(days,rooms);
//            totalAvailableRooms = totalAvailableRooms - rooms;
//            System.out.println("Your Room is Booked and You have to pay: " + totalAmount);
//            roomStatus = true;
//
//        }



    @Override
    public void startService() throws IOException, SQLException {

        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Book Room.");
            System.out.println("2. Unbook Room.");
            System.out.println("3. View Status.");
            System.out.println("Enter n for exit. ");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    bookRoom();
                    System.out.println("Do you Want To Continue: ");
                    String s = br.readLine();
                    if (s != "n" || s != "N") {
                        break;
                    }
                case 2:unbook();
                    break;
                case 3:
                    viewBookedStatus();
                    break;
            }

        } while (choice == 1 || choice == 2);
    }



    private void unbook() throws SQLException {
        int ch;
        do {
            System.out.println("Enter type of room, you want to unbook.");
            System.out.println("1.Delux Room \n 2.Luxuary Room ");
            ch= scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter Room no");
                    int rno = scanner.nextInt();
                    int status1 = 0;
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select status from deluxroom where roomno=" + rno);
                    while (rs.next())
                        status1 = rs.getInt(1);

                    if (status1 == 1) {
                        Statement st1 = con.createStatement();
                        int j = st1.executeUpdate("update deluxroom set days=0 where roomno=" + rno);

                        Statement st2 = con.createStatement();
                        int k = st2.executeUpdate("update deluxroom set status=0 where roomno=" + rno);

                        System.out.println("Thank You...! \n Room - " + rno + " has been unbooked.");
                        System.out.println();
                    } else {
                        System.out.println("Room " + rno + " is already unbooked...!");
                        System.out.println();
                    }

                    break;

                case 2:

                    System.out.println("Enter Room no");
                    int rno2 = scanner.nextInt();
                    int status2 = 0;
                    Statement st3 = con.createStatement();
                    ResultSet rs3 = st3.executeQuery("select status from luxaryroom where roomno=" + rno2);
                    while (rs3.next())
                        status1 = rs3.getInt(1);

                    if (status2 == 1) {
                        Statement st1 = con.createStatement();
                        int j = st1.executeUpdate("update luxaryroom set days=0 where roomno=" + rno2);

                        Statement st2 = con.createStatement();
                        int k = st2.executeUpdate("update luxaryroom set status=0 where roomno=" + rno2);

                        System.out.println("Thank You...! \n Room - " + rno2 + " has been unbooked.");
                        System.out.println();
                    } else {
                        System.out.println("Room " + rno2 + " is already unbooked...!");
                        System.out.println();
                    }
                    break;
            }
        }while (ch!=3);
    }
    private void viewBookedStatus() {
        if (roomStatus == true) {
            System.out.println("Your Room is Booked....");
        }
    }
}




package com.java.Zensar.HBMS;


import java.sql.*;
import java.util.Scanner;

public class AdminService {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminService a=new AdminService();
        a.asstartService();
    }
    Connection con;
    Scanner scanner = new Scanner(System.in);
    AdminService() throws SQLException, ClassNotFoundException {
        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();
    }

    public void asstartService() throws SQLException, ClassNotFoundException {
        int choice;
        Statement stmt = con.createStatement();
        do {
            System.out.println("1.Manage Employees.\n2.Manage Rooms.\n3.Manage Discounts and Offers\n4.Exit.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageEmployees();
                    break;
                case 2:
                    manageRooms();
                    break;
//                case 3 :
//                    manageDiscounts();
//                    break;
            }
        } while (choice != 4);
    }

    private void manageRooms() throws SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();
        int ch = 0;
        do {
            System.out.println("1. Add Rooms.");
            System.out.println("2. Remove Room.");
            System.out.println("3. Total Rooms.");
            System.out.println("4. Exit.");
            System.out.print("Enter Your Choice: ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addRooms();
                    break;
                case 3:
                    displayRooms();
                    break;
            }
        } while (ch != 4);
    }

    private void displayRooms() throws SQLException {
//        Statement stmt = con.createStatement();
//        int totalRooms = 0;
//        ResultSet rs = stmt.executeQuery("select * from staffs");
//        while (rs.next()) {
//            totalRooms = totalRooms + 1;
//        }
//
//        System.out.println("Total Rooms: " + totalRooms);

        System.out.println("\n1.DeluxRoom \n2.LuxsaryRoom");
        System.out.println("Enter Room type:");
        int type = scanner.nextInt();
        switch (type) {
            case 1:

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("select * from deluxroom");
                while (rs.next()) {
                    String roomno = rs.getString(1);
                    String ac = rs.getString(2);
                    String days = rs.getString(3);
                    String status = rs.getString(4);

                    System.out.println(" Room no of Delux room: \t\t\t" + roomno);
                    System.out.println(" Ac is provided or not: \t\t\t\t" + ac);
                    System.out.println(" Book for no of days: \t\t" + days);
                    System.out.println(" Status of Room: \t\t\t" + status);
                    System.out.println("********************************************");
                }
                break;
            case 2:
                Statement stmt1 = con.createStatement();

                ResultSet rs1 = stmt1.executeQuery("select * from luxaryroom");
                while (rs1.next()) {
                    String roomno = rs1.getString(1);
                    String ac = rs1.getString(2);
                    String wifi =rs1.getString(3);
                    String days = rs1.getString(4);
                    String status = rs1.getString(4);

                    System.out.println(" Room no of Luxary room: \t\t\t" + roomno);
                    System.out.println(" Ac is present or not: \t\t\t\t" + ac);
                    System.out.println(" Status  of WIFI: \t\t\t\t" + wifi);
                    System.out.println(" Book for no of days: \t\t" + days);
                    System.out.println(" Status of Room: \t\t\t" + status);
                    System.out.println("********************************************");
                }
                break;

        }
        }

    private void addRooms() throws SQLException {
//        System.out.println("Enter Room No. of Employee: ");
//        int roomno = scanner.nextInt();
//        String query = "insert into rooms values (" + "'" + roomno + "'" + ")";
//
////        String query="insert into staffs values ("+"'seema',"+"'seemap',"+"'Seema',"+"'Kale',"+"'Manager',+"+"'80000',"+"'9879879879'"+")";
//        PreparedStatement stmt = con.prepareStatement(query);
//
//        stmt.execute();
//        System.out.println("Query Executed.....");




        System.out.println("1.DeluxRoom \n2.LaxaryRoom ");
        System.out.println("Enter Room type:");
        int type=scanner.nextInt();
        switch (type) {
            case 1:
                System.out.println("Enter room no of room: ");
                String roomno = scanner.next();
                System.out.println("Provide Ac to room ");
                String ac = scanner.next();
                System.out.println("No od days ");
                String days = scanner.next();
                System.out.println("Status of room ");
                String status = scanner.next();

                String query = "insert into deluxroom values (" + "'" + roomno + "'" + "," + "'" + ac + "'" + "," + "'" + days + "'" + "," + "'" + status + "'" + ")";
                PreparedStatement stmt = con.prepareStatement(query);

                stmt.execute();
                break;
            case 2:
                System.out.println("Enter room no of room: ");
                roomno = scanner.next();
                System.out.println("Provide Ac to room");
                 ac = scanner.next();
                System.out.println("Provide Wifi to room: ");
                String wifi= scanner.next();

                System.out.println("No od days ");
                 days = scanner.next();
                System.out.println("Status of room ");
                 status = scanner.next();

                String query1 = "insert into luxaryroom values (" + "'" + roomno + "'" + "," + "'" + ac + "'" + "," + "'" + wifi + "'" + "," + "'" + days + "'" + "," + "'" + status + "'" + ")";
                PreparedStatement stmt1 = con.prepareStatement(query1);

                stmt1.execute();
                break;
        }
        }

    private void manageEmployees() throws SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();
        DBConnect dbConnect = new DBConnect();
        con = dbConnect.connection();
        int ch = 0;
        do {
            System.out.println("1. Add Employees.");
            System.out.println("2. Remove Employees.");
            System.out.println("3. Display All Employee Details.");
            System.out.println("4. Exit.");
            System.out.print("Enter Your Choice: ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addEmployee();
                    break;
                case 3:
                    displayEmployees();
                    break;
            }

        } while (ch != 4);
    }

    private void displayEmployees() throws SQLException {
        System.out.println("1.RECEPTIONIST \n2.CHEF \n3.CLEANER n4.LAUNDRYMAN");
        System.out.println("Enter Employee type:");
        int type = scanner.nextInt();
        switch (type) {
            case 1:

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("select * from receptionist");
                while (rs.next()) {
                    String useridt = rs.getString(1);
                    String passwordt = rs.getString(2);
                    String fname = rs.getString(3);
                    String lname = rs.getString(4);
                    String status = rs.getString(5);
                    String salary = rs.getString(6);
                    String mobno = rs.getString(7);

                    System.out.println(" Userid of Employee: \t\t\t" + useridt);
                    System.out.println(" Name of Employee: \t\t\t\t" + fname + " " + lname);
                    System.out.println(" Status of Employee: \t\t" + status);
                    System.out.println(" Salary of Employee: \t\t\t" + salary);
                    System.out.println(" Mobile No. of Employee: \t\t" + mobno);
                    System.out.println("********************************************");
                }
                break;
            case 2:

                Statement stmt1 = con.createStatement();

                ResultSet rs1 = stmt1.executeQuery("select * from chef");
                while (rs1.next()) {
                    String useridt = rs1.getString(1);
                    String passwordt = rs1.getString(2);
                    String fname = rs1.getString(3);
                    String lname = rs1.getString(4);
                    String status = rs1.getString(5);
                    String roomno = rs1.getString(6);
                    String salary = rs1.getString(7);
                    String mobno = rs1.getString(8);

                    System.out.println(" Userid of Employee: \t\t\t" + useridt);
                    System.out.println(" Name of Employee: \t\t\t\t" + fname + " " + lname);
                    System.out.println(" Status of Employee: \t\t" + status);
                    System.out.println(" Roomno of Employee: \t\t" + roomno);
                    System.out.println(" Salary of Employee: \t\t\t" + salary);
                    System.out.println(" Mobile No. of Employee: \t\t" + mobno);
                    System.out.println("********************************************");

                }
                break;
            case 3:

                Statement stmt2 = con.createStatement();

                ResultSet rs2 = stmt2.executeQuery("select * from cleaner");
                while (rs2.next()) {
                    String useridt = rs2.getString(1);
                    String passwordt = rs2.getString(2);
                    String fname = rs2.getString(3);
                    String lname = rs2.getString(4);
                    String status = rs2.getString(5);
                    String roomno = rs2.getString(6);
                     String salary = rs2.getString(7);
                    String mobno = rs2.getString(8);

                    System.out.println(" Userid of Employee: \t\t\t" + useridt);
                    System.out.println(" Name of Employee: \t\t\t\t" + fname + " " + lname);
                    System.out.println(" Status of Employee: \t\t" + status);
                    System.out.println(" Roomno of Employee: \t\t" + roomno);

                    System.out.println(" Salary of Employee: \t\t\t" + salary);
                    System.out.println(" Mobile No. of Employee: \t\t" + mobno);
                    System.out.println("********************************************");


                }
                break;
            case 4:

                Statement stmt3 = con.createStatement();

                ResultSet rs3 = stmt3.executeQuery("select * from laundaryman");
                while (rs3.next()) {
                    String useridt = rs3.getString(1);
                    String passwordt = rs3.getString(2);
                    String fname = rs3.getString(3);
                    String lname = rs3.getString(4);
                    String status = rs3.getString(5);
                    String roomno = rs3.getString(6);
                    String salary = rs3.getString(7);
                    String mobno = rs3.getString(8);

                    System.out.println(" Userid of Employee: \t\t\t" + useridt);
                    System.out.println(" Name of Employee: \t\t\t\t" + fname + " " + lname);
                    System.out.println(" Status of Employee: \t\t\t" + status);
                    System.out.println(" Salary of Employee: \t\t\t" + salary);
                    System.out.println(" Mobile No. of Employee: \t\t" + rs3.getString(8));
                    System.out.println("********************************************");

                }
                break;
        }
    }
                    private void addEmployee() throws SQLException {
        System.out.println("Enter userid of Employee: ");
        String userid = scanner.next();
        System.out.println("Enter password of Employee: ");
        String password = scanner.next();
        System.out.println("Enter First Name of Employee: ");
        String fname = scanner.next();
        System.out.println("Enter Last Name of Employee: ");
        String lname = scanner.next();

        System.out.println("Enter Salary of Employee: ");
        int salary = scanner.nextInt();
        System.out.println("Enter Mobile No. of Employee: ");
        String mobno = scanner.next();

        System.out.println("1.RECEPTIONIST \n2.CHEF \n3.CLEANER n4.LAUNDRYMAN");
        System.out.println("Enter employee type:");
        int type=scanner.nextInt();
        switch (type)
        {
            case 1:
                String query = "insert into receptionist values (" + "'" + userid + "'" + "," + "'" + password + "'" + "," + "'" + fname + "'" + "," + "'" + lname + "'" + "," + 0 + ","  + "'" + salary + "'" + "," + "'" + mobno
                    + "'" + ")";
                PreparedStatement stmt = con.prepareStatement(query);

                stmt.execute();
                System.out.println("\tReceptionist Added Successfully....");

                break;
            case 2:
                String query1 = "insert into chef values (" + "'" + userid + "'" + "," + "'" + password + "'" + "," + "'" + fname + "'" + "," + "'" + lname + "'" + ","   + 0 + "," + salary  + "," + "'" + mobno
                        + "'" + ")";
                PreparedStatement stmt1 = con.prepareStatement(query1);

                stmt1.execute();
                System.out.println("Chef Added Successfully....");

                break;
            case 3:
                String query2 = "insert into cleaner values (" + "'" + userid + "'" + "," + "'" + password + "'" + "," + "'" + fname + "'" + "," + "'" + lname + "'" + ","   + 0 +","  + 0 +"," + salary + "," + "'" + mobno
                        + "'" + ")";
                PreparedStatement stmt2 = con.prepareStatement(query2);

                stmt2.execute();
                System.out.println("Cleaner Added Successfully....");

                break;
            case 4:
                String query3 = "insert into laundaryman values (" + "'" + userid + "'" + "," + "'" + password + "'" + "," + "'" + fname + "'" + "," + "'" + lname + "'" + ","   + 0 +","  + 0 +"," + salary + "," + "'" + mobno
                        + "'" + ")";
                PreparedStatement stmt3 = con.prepareStatement(query3);

                stmt3.execute();
                System.out.println("Laundrymen Added Successfully....");

                break;
        }


//        String query="insert into staffs values ("+"'seema',"+"'seemap',"+"'Seema',"+"'Kale',"+"'Manager',+"+"'80000',"+"'9879879879'"+")";

    }

}


package com.java.Zensar.HBMS;

import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class FoodService {
Connection con=DBConnect.connection();

    Scanner scanner=new Scanner(System.in);
int choice,quantity,total;
int price;
String type;

    public FoodService() throws SQLException, ClassNotFoundException {
    }

    public void startFoodService() throws SQLException {

                System.out.println("********Welcome to the Foody Section************");
                do {
                    {
                        System.out.println("Place your order:\n1.BREAKFAST. \n2.LUNCH. \n3.DINNER \n4.LAST DRINK \n5 EXIT");
                        choice=scanner.nextInt();
                        switch (choice)
                        {
                            case 1:
                            Breakfast();
                        break;
                            case 2:
                                Lunch();
                                break;
                            case 3:
                                Dinner();
                                break;
                            case 4:
                                Drink();
                                break;
                                default:
                                    System.out.println("NOT AVAILABLE.");
                        }
                    }
                    }while (choice!=5);


    }
    public void Breakfast() throws SQLException {
        Statement stmt=con.createStatement();
        ResultSet rs1;
        System.out.println("***Good Morning***");
        do {


            System.out.println("\n1. PARATHA. \n2. IDALI. \n3. MAGGI");
            choice = scanner.nextInt();
            System.out.println("Enter Quantity:");
            quantity=scanner.nextInt();
            switch (choice) {
                case 1:
                     type="PARATHA";
                    ResultSet rs = stmt.executeQuery("select * from breakfast where food_id=1");

                    while (rs.next())
                    {
                         price = Integer.parseInt(rs.getString(3));
                    }

                    FoodDept.request(quantity,type);

                    System.out.println("Bill: "+(price*quantity));
                  //  System.out.println("  Bill "+(price*quantity));



                    break;
                case 2:
                    type="IDALI";
                     rs1= stmt.executeQuery("select * from breakfast where food_id=2");
//                    System.out.println(price);
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));

                    }
                    FoodDept.request(quantity,type);
                    Fare f=new Fare();
                    int total=f.calculateFood(quantity,price);
                        System.out.println("  Bill "+total);
                    break;
                case 3:
                    type="MAGGI";
                    rs1 = stmt.executeQuery("select * from breakfast where food_id=3");
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f1=new Fare();
                     total=f1.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
                    default:
                        System.out.println("NOT AVAILABLE . PLEASE ORDER ANOTHER DISH");

            }
        }   while (choice!=4);
    }

    public void Lunch() throws SQLException {
        Statement stmt=con.createStatement();
        ResultSet rs1;

        System.out.println("Good Afternoon");
        do {
            System.out.println("\n1. ROTI \n2. NAN-ROTI \n3. PARATHA \n4.VEG MARATHA \n5. DAL TADKA");
            choice = scanner.nextInt();
            System.out.println("Enter Quantity:");
            quantity=scanner.nextInt();
            switch (choice)
            {

                case 1:
                     type="ROTI";
                    ResultSet rs = stmt.executeQuery("select * from lunch where food_id=3");
                    while (rs.next()){
                        price = Integer.parseInt(rs.getString(3));
                        System.out.println(price);
                    }
                    FoodDept.request(quantity,type);
                    Fare fare=new Fare();
                    price=fare.calculateFood(quantity,price);
//                    FoodDept.request(quantity,type);
                    System.out.println("  Bill "+(price*quantity));
                    break;
                case 2:
                     type="NAN ROTI";
                    rs1= stmt.executeQuery("select * from Lunch where food_id=4");
//                    System.out.println(price);
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                        System.out.println(price);

                    }
                    FoodDept.request(quantity,type);
                    Fare f=new Fare();
                    int total=f.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
                case 3:
                     type = "PARATHA";
                    rs1 = stmt.executeQuery("select * from Lunch where food_id=5");
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f1=new Fare();
                    total=f1.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
//                case 4:
//                    type = "VEG MARATHA";
//                    rs1 = stmt.executeQuery("select * from Lunch where food_id=4");
//                    while (rs1.next()) {
//                        price = Integer.parseInt(rs1.getString(3));
//                    }
//                    FoodDept.request(quantity,type);
//                    Fare f2=new Fare();
//                    total=f2.calculateFood(quantity,price);
//                    System.out.println("  Bill "+total);
//                    break;
//                case 5:
//                    type="DAL TADKA";
//                    rs1 = stmt.executeQuery("select * from Lunch where food_id=4");
//                    while (rs1.next()) {
//                        price = Integer.parseInt(rs1.getString(3));
//                    }
//                    FoodDept.request(quantity,type);
//                    Fare f3=new Fare();
//                    total=f3.calculateFood(quantity,price);
//                    System.out.println("  Bill "+total);
//                    break;

                default:
                    System.out.println("NOT AVAILABLE . PLEASE ORDER ANOTHER DISH");

            }

        }while (choice!=6);
    }

    public void Dinner() throws SQLException {
        Statement stmt=con.createStatement();
        ResultSet rs1;

        System.out.println("Good Night");
        do {
            System.out.println("\n1. ROTI \n2. NAN-ROTI \n3. PARATHA \n4.VEG MARATHA \n5. DAL TADKA");
            choice = scanner.nextInt();
            System.out.println("Enter Quantity:");
            quantity=scanner.nextInt();
            switch (choice)
            {

                case 1:
                    type="ROTI";
                    ResultSet rs = stmt.executeQuery("select * from Dinner where food_id=1");
                    while (rs.next()){
                        price = Integer.parseInt(rs.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f3=new Fare();
                    total=f3.calculateFood(quantity,price);


                    System.out.println("  Bill "+total);
                    break;
                case 2:
                    type="NAN ROTI";
                    rs1= stmt.executeQuery("select * from Dinner where food_id=2");
//                    System.out.println(price);
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));

                    }
                    FoodDept.request(quantity,type);
                    Fare f=new Fare();
                    int total=f.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
                case 3:
                    type="PARATHA";
                    rs1 = stmt.executeQuery("select * from Dinner where food_id=3");
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f1=new Fare();
                    total=f1.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
                case 4:
                    type="VAG MARATHA";
                    rs1 = stmt.executeQuery("select * from Dinner where food_id=4");
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f2=new Fare();
                    total=f2.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
                case 5:
                    type="DAL TADKA";
                    rs1 = stmt.executeQuery("select * from Dinner where food_id=4");
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f4=new Fare();
                    total=f4.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;

                default:
                    System.out.println("NOT AVAILABLE . PLEASE ORDER ANOTHER DISH");

            }

        }while (choice!=6);
    }

    public void Drink() throws SQLException {
        Statement stmt=con.createStatement();
        ResultSet rs1;

        do {
            System.out.println("\n" +
                    "1. COLD COFFEE \n" +
                    "2. JUICE \n" +
                    "3. MILK SHAKE");
            choice = scanner.nextInt();
            System.out.println("Enter Quantity:");
            quantity=scanner.nextInt();
            switch (choice)
            {

                case 1:
                    type="COLD COFFEE";
                    ResultSet rs = stmt.executeQuery("select * from Drinks where food_id=1");
                    while (rs.next()){
                        price = Integer.parseInt(rs.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f=new Fare();
                    total=f.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;
                case 2:
                    type="JUICE";
                    rs1= stmt.executeQuery("select * from Drinks where food_id=2");
//                    System.out.println(price);
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));

                    }

                    FoodDept.request(quantity,type);
                    Fare f1=new Fare();
                    total=f1.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);                    break;
                case 3:
                    type="MILK SHAKE";
                    rs1 = stmt.executeQuery("select * from Lunch where food_id=3");
                    while (rs1.next()) {
                        price = Integer.parseInt(rs1.getString(3));
                    }
                    FoodDept.request(quantity,type);
                    Fare f2=new Fare();
                    total=f2.calculateFood(quantity,price);
                    System.out.println("  Bill "+total);
                    break;


            }

        }while (choice!=6);
    }

}

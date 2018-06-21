package com.java.Zensar.HBMS;
//Author: Sneha Dhondugade.

import java.util.*;
import java.sql.*;

public class TransportService
{
    Scanner sc=new Scanner(System.in);



    public void startTransportService() throws ClassNotFoundException, SQLException
    {
        Connection con=DBConnect.connection();
        Statement stmt=con.createStatement();
        ResultSet rs;

        int t;
        String ans;

        do{
            System.out.println("\n*_____ Wel-come to Transport Service_____*");
            System.out.println("Enter location from where you want Transport Service.");
            System.out.println("1.Airport - Hotel");
            System.out.println("2.Railway Station - Hotel");
            System.out.println("3.Bus Terminal - Hotel");
            System.out.println("4.India Gate - Hotel");
            System.out.println("5.Exit");

            t=sc.nextInt();

            switch(t)
            {
                case 1 : ResultSet rs1=stmt.executeQuery("select * from vehicle where vtype='Car'");
                    while(rs1.next())
                        System.out.println("Your Car Id : "+rs1.getString(1)+", Car No. : "+rs1.getString(2)+".");
                        break;

                case 2 :rs=stmt.executeQuery("select * from vehicle where vtype='Van'");
                    while(rs.next())
                        System.out.println("Your Van Id : "+rs.getString(1)+", Van No. : "+rs.getString(2)+".");
                    break;

                case 3 : rs=stmt.executeQuery("select * from vehicle where vtype='Bus'");
                    while(rs.next())
                        System.out.println("Your Bus Id : "+rs.getString(1)+", Bus No. : "+rs.getString(2)+".");
                    break;

                case 4 : rs=stmt.executeQuery("select * from vehicle where vtype='Auto'");
                    while(rs.next())
                        System.out.println("Your Auto Id : "+rs.getString(1)+", Auto No. : "+rs.getString(2)+".");
                    break;
            }
            
        }while(t!=5);
        System.out.println("Thank You...!");
//        ans=sc.next();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TransportService t1=new TransportService();
        t1.startTransportService();
    }
}
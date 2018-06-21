package com.java.Zensar.HBMS;

import java.io.*;
import java.sql.*;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
// Author: Sneha Dhondugade.

public class PartyHall extends Hall
{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	  PartyHall()
	  {   
	        rate = 400;
	        wifi = true;
	        hallStatus = false;
	  }
	 	 
	@Override
	public void startService() throws IOException
	{
		 int choice;
	        do {
	            System.out.println("Enter your choice: ");
	            System.out.println("1. Book Hall.");
	            System.out.println("2. View Status.");
	            System.out.println("Enter n for exit. ");
	            choice = Integer.parseInt(br.readLine());
	            switch (choice) {
	                case 1:
					try {
						bookPartyHall();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	 
	private void bookPartyHall() throws IOException, ClassNotFoundException, SQLException
	{   
		
		 	System.out.println("Enter date on which you want hall");
		 	String dd,  mmm, yyyy;
		 	System.out.println("Enter Date");
		 	dd=br.readLine();
		 	System.out.println("Enter month");
		 	mmm=br.readLine();
		 	System.out.println("Enter Year");
		 	yyyy=br.readLine();
		 	
		 	  Connection con=DBConnect.connection();
		        PreparedStatement ps=con.prepareStatement("insert into d1 values(?)");
		        ps.setString(1,dd+mmm+yyyy);
		        ps.executeUpdate();
		        
	        System.out.println("Enter for how many hours you want hall? ");
	        int hours = Integer.parseInt(br.readLine());
	        
	        if(hallStatus==false)
	        {
	        	Fare fare=new Fare();
	        	 int totalAmount = fare.calculatePartyHallFare(hours);
	             System.out.println("Hall is Booked and You have to pay: " + totalAmount);
	             hallStatus = true;
	        }
	        else
	        {
	        	System.out.println("Sorry..! \n Hall is not available on "+dd+"-"+mmm+"-"+yyyy);
	        } 
	    }
      	 
	 private void viewBookedStatus() {
	        if (hallStatus == true) {
	            System.out.println("Hall is Booked....");
	        }
	}

	 public static void main(String[] args) throws IOException
	 {
		PartyHall p1=new PartyHall();
		p1.startService();
	 }
}
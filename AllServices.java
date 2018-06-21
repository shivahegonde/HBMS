package com.java.Zensar.HBMS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AllServices {
    public void startAllService() throws SQLException, ClassNotFoundException, IOException {
        int choice;
    Scanner scanner=new Scanner(System.in);
    FoodService food=new FoodService();
    WashService wash=new WashService();
    //CabService cap=new CabService();
        TransportService transport=new TransportService();
   // ComplaintService complaint=new ComplaintService();




    do {

            System.out.println("Enter your choice : \n1.FOOD SERVICE. \n2. WASH SERVICE. \n3.TRANSPORT SERVICE. \n4. COMPLAINT SERVICE");
            choice = scanner.nextByte();
            switch (choice)
            {
                case 1:
                   food.startFoodService();
                    break;
                case 2:
                    wash.startWashService();
                    break;
                case 3:

                    transport.startTransportService();
                    break;
//                case 4:
//                    complaint.startComplaintService();
//                    break;
                    default:
                        System.out.println("no service available.");


            }

        } while (choice!=5);
    }
}
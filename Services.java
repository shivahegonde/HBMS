package com.java.Zensar.HBMS;

/*
Author:     ShivKumar Hegonde.
MailId:     shivkumarhegonde@gmail.com
MobileNo:   9405462511
*/

import java.util.Scanner;

public class Services {
    String[] foodType = {"Fast food", "Lunch", "Dinner", "Drinks"};
    int[] rates = {50, 400, 700, 100};
    int quantity = 1;
    static int totalAmount = 0;
    Scanner scanner = new Scanner(System.in);

    public void startService() {
        int choice = 0;
        do {
            System.out.println("1. Fast food");
            System.out.println("2. Lunch");
            System.out.println("3. Dinner");
            System.out.println("4. Drinks");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    totalAmount = totalAmount + rates[0] * quantity;
                    break;
                case 2:
                    System.out.println("Enter lunch quantity: ");
                    quantity = scanner.nextInt();
                    totalAmount = totalAmount + rates[1] * quantity;
                    break;
                case 3:
                    System.out.println("Enter Dinner quantity: ");
                    quantity = scanner.nextInt();
                    totalAmount = totalAmount + rates[2] * quantity;
                    break;
                case 4:
                    System.out.println("Enter Drinks quantity: ");
                    quantity = scanner.nextInt();
                    totalAmount = totalAmount + rates[3] * quantity;
                    break;


            }
        } while (choice != 5);
    }

    public void washService() {

    }
}

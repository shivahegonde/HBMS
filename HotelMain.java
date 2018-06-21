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
import java.util.InputMismatchException;

public class HotelMain {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int userChoice;
            System.out.println("\t\t\t..Welcome TO HBMS..");
            System.out.println("\t1. Customer.\n\t2. Employee. \n\t3. Admin. ");
            System.out.print("\tEnter User Mode:  ");
            userChoice = Integer.parseInt(br.readLine());
            switch (userChoice) {
                case 1:
                    Customer c = new Customer();
                    c.customerService();
                    break;
                case 2:
                    AllEmployee e = new AllEmployee();
                    e.aestartService();
                    break;
                case 3:
                    Admin a = new Admin();
                    a.adminService();
                    break;
            }
        } catch (IOException i) {
            System.out.println("You dont know how to handle ioexception the learn first.");
        } catch (SQLException i) {
            System.out.println("Database is not properly connected. Or\nTable doesn't Exist.");
        } catch (ClassNotFoundException i) {
            System.out.println("Not found the Oracle Class");
        }
        catch (InputMismatchException i) {
            System.out.println("Given input is mismatched...");
        }

        catch (NumberFormatException i) {
            System.out.println("Number Format is not valid....");
        }
    }
}
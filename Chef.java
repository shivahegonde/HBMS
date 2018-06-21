package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Created by ACER on 6/20/2018.
 */
public class Chef {
    public void chefService() throws IOException, SQLException, ClassNotFoundException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ChefLogin cf=new ChefLogin();
        System.out.println("Enter Username");
        String user=br.readLine();
        System.out.println("Enter Password");
        String pass=br.readLine();
        cf.login(user,pass);

    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Chef c=new Chef();
        c.chefService();
    }
}

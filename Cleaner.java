package com.java.Zensar.HBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by ACER on 6/19/2018.
 */
public class Cleaner {

    Connection con;
        Cleaner() throws SQLException, ClassNotFoundException {
            DBConnect dbConnect = new DBConnect();
            con = dbConnect.connection();
        }

        public void cleanService() throws IOException, IOException, SQLException, ClassNotFoundException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            CleanerLogin e=new CleanerLogin();
            System.out.println("Enter Userid: ");
            String user = br.readLine();
            System.out.println("Enter Password: ");
            String pass = br.readLine();
            e.login(user, pass);
        }
        public void clean() throws SQLException {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cleaner");
            String s1="Update Cleaner set status=1 where userid= ?";
            System.out.println("hellooooo");
            rs.next();
                String user=rs.getString(1);
                int stat=rs.getInt(5);

                    PreparedStatement ps=con.prepareStatement(s1);
                    int i =ps.executeUpdate();
                    ps.setString(1,user );


            }
        }







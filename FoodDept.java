package com.java.Zensar.HBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodDept {
    static Connection con;

    static {
        try {
            con = DBConnect.connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public FoodDept() throws SQLException, ClassNotFoundException {
    }

    public static void request(int quantity,String type) throws SQLException {
        String query="insert into fooddept values (" +"fooddeptsr.nextval,"+ quantity+","+"'"+ type +"'"+" )";

        PreparedStatement statement=con.prepareStatement(query);
//        statement.setString(quantity,type);
        statement.executeUpdate();


    }

}

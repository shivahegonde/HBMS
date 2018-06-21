package com.java.Zensar.HBMS;
// Author : Sneha Dhondugade.

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendReport
{

	public SendReport() throws SQLException, ClassNotFoundException {
	}

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
			Connection con=DBConnect.connection();

			FileWriter fw=new FileWriter("C:\\Users\\Shivkumar Hegonde\\IdeaProjects\\Mutex\\src\\com\\java\\Zensar\\HBMS\\EmpRecords.txt");
			fw.append("\n");
			
			String s1="select * from vehicle";

//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			Connection conn = DriverManager.getConnection(url, "system", "system");
				
			PreparedStatement ps=con.prepareStatement(s1);
						
			ResultSet rs1=ps.executeQuery();
			int cnt=0;
			while(rs1.next())
			{
				fw.append("\n"+rs1.getString(1)+" : "+rs1.getString(2)+" : "+rs1.getString(3));
				cnt++;
			}
			fw.append("\n\n Total Number of Entries : "+cnt);
			fw.close();
		}
}


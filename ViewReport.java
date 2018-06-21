package com.java.Zensar.HBMS;
// Author : Sneha Dhondugade.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class ViewReport
{
	public static void main(String[] args) throws IOException {
		
	String str;
	FileReader fr=new FileReader("F:\\Myjavaprograms\\ZenSar3\\src\\IOAssignments\\EmpRecords.txt");
	BufferedReader br=new BufferedReader(fr);
	LineNumberReader lr=new LineNumberReader(br);
	
	while((str=lr.readLine())!=null)
	{
		System.out.println(str);
	}
	}
}
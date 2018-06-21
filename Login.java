package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

public abstract class Login {


    abstract void login(String userid,String password) throws IOException, SQLException, ClassNotFoundException;
}

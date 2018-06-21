package com.java.Zensar.HBMS;
/*
Author: ShivKumar Hegonde
MailId: shivkumarhegonde@gmail.com
MobileNo: 9405462511
*/

import java.io.IOException;
import java.sql.SQLException;

public abstract class Room {
    int totalAvailableRooms;
    int rate;
    boolean wifi;
    boolean roomStatus;
    public abstract void startService() throws IOException, SQLException;
}

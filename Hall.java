
package com.java.Zensar.HBMS;

import java.io.IOException;
// Author : Sneha Dhondugade.

public abstract class Hall
{
	 int rate;
	 boolean wifi;
	 boolean hallStatus;
	 public abstract void startService() throws IOException;
}

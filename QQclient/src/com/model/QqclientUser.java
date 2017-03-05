package com.model;

import com.common.User;

public class QqclientUser {

	
	public boolean CheckUser(User u)
	{
	Myqqclient mq1=new Myqqclient();
	
		return mq1.Sendinfotoserver(u);
		
	}
	
}

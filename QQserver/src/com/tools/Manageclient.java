package com.tools;

import java.util.HashMap;

public class Manageclient {

	public static HashMap hm1=new HashMap<String,SerThred>();
	
	
	//向hm1中添加一个客户端通讯线程
	public static void addClientThread(String uid,SerThred st)
	{
		hm1.put(uid, st);
	}
	
	public static SerThred geThred(String uid)
	{
		return (SerThred)hm1.get(uid);
	}
	
}

package com.tools;

import java.util.HashMap;

public class Manageclient {

	public static HashMap hm1=new HashMap<String,SerThred>();
	
	
	//��hm1�����һ���ͻ���ͨѶ�߳�
	public static void addClientThread(String uid,SerThred st)
	{
		hm1.put(uid, st);
	}
	
	public static SerThred geThred(String uid)
	{
		return (SerThred)hm1.get(uid);
	}
	
}

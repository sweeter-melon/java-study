package com.tools;

import java.util.HashMap;

import com.view.Qchat;

public class Manageqqchat {

	private static HashMap hm1=new HashMap<String,Qchat>();
	
	//����
	
	public static void addQchat(String LoginId,Qchat qq)
	{
		hm1.put(LoginId, qq);
	}
	
	//ȡ��
	public static Qchat getQchat(String loginId)
	{
		return (Qchat)hm1.get(loginId);
	}
}

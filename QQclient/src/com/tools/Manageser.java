
//����ͻ��˺ͷ�����ͨѶ���߳�

package com.tools;

import java.util.HashMap;

public class Manageser {

	private static HashMap hm=new HashMap<String,ClientThred>();
	
	//�Ѵ�����ClientThred����hm
	
	public static void addconServerThred(String qqId,ClientThred cl)
	{
		hm.put(qqId, cl);
	}
	
	//����ͨ��qqIdȡ���߳�
	public static ClientThred getconserverThred(String qqId)
	{
		return (ClientThred)hm.get(qqId);
	}
}

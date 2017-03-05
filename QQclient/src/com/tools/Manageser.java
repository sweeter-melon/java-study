
//管理客户端和服务器通讯的线程

package com.tools;

import java.util.HashMap;

public class Manageser {

	private static HashMap hm=new HashMap<String,ClientThred>();
	
	//把创建的ClientThred放入hm
	
	public static void addconServerThred(String qqId,ClientThred cl)
	{
		hm.put(qqId, cl);
	}
	
	//可以通过qqId取得线程
	public static ClientThred getconserverThred(String qqId)
	{
		return (ClientThred)hm.get(qqId);
	}
}

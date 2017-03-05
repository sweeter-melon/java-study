//客户端连接服务器的后台

package com.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;
import com.common.User;
import com.tools.ClientThred;
import com.tools.Manageser;

public class Myqqclient {

	public  Socket s1;
	
	//发送第一次消息
	public boolean Sendinfotoserver(Object o)
	{
		boolean b=false;
		try {
			 s1=new Socket("127.0.0.1", 9999);
			
			ObjectOutputStream oos1=new ObjectOutputStream(s1.getOutputStream());
			oos1.writeObject(o);
			
			ObjectInputStream ois1=new ObjectInputStream(s1.getInputStream());
			Message ms=(Message)ois1.readObject();
			//验证用户登录
			if(ms.getMesType().equals("1"))
			{
				
				//创建一个该qq号和服务器保持通信的线程
				ClientThred cl1=new ClientThred(s1);
				//启动线程
				cl1.start();
				Manageser.addconServerThred(((User)o).getUseId(),cl1);
				b=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return b;
		
	}
	
	
	
}

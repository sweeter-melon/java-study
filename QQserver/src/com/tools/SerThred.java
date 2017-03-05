
//服务器和某个客户通信线程

package com.tools;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;

public class SerThred extends Thread{

	Socket s;
	
	public SerThred(Socket s)
	{
		//把服务器和客户端的连接赋给s
		this.s=s;
		
		
	}
	
	public void run()
	{
		while(true)
		{
			//这里该线程接收客户端信息
			try {
				
				ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
				Message m1=(Message)ois1.readObject();
				
				System.out.println(m1.getSender()+"给"+m1.getGetter()+"说："+m1.getCon());
				
				//完成转发
				//取得接收人的通信线程
				SerThred st1=Manageclient.geThred(m1.getGetter());
				ObjectOutputStream oos1=new ObjectOutputStream(st1.s.getOutputStream());
				oos1.writeObject(m1);
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
			
		}
		
	}
	
}

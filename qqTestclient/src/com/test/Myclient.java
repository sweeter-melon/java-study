package com.test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.User;

public class Myclient {

	
	public static void main(String []args)
	{
		Myclient my1=new Myclient();
	}
	
	
	public Myclient()
	{
		
		try {
			
			Socket s=new Socket("127.0.0.1", 3456);
			
			//以对象流方式读取（假设客户端发送的一个对象）
			ObjectOutputStream oos1=new ObjectOutputStream(s.getOutputStream());
			User u=new User();
			u.setName("zhangwenzhe");
			u.setPass("123456");
		oos1.writeObject(u);
		s.close();
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
	}
}

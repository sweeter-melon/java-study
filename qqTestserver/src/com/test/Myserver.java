package com.test;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.w3c.dom.UserDataHandler;

import com.common.User;

public class Myserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Myserver myserver=new Myserver();
		
		
	}

	public Myserver()
	{
		
		try {
			
			ServerSocket ss=new ServerSocket(3456);
			System.out.println("监听..........");
			Socket s=ss.accept();
			//以对象流方式读取（假设客户端发送的一个对象）
			ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
			User u=(User)ois1.readObject();
			
			//输出
			System.out.println("从客户端接收："+u.getName()+u.getPass());
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}

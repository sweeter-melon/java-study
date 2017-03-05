

//功能：是一个服务器，在9999端口监听
//可以通过控制台输入消息
package com.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA_2_3.portable.InputStream;

public class MyServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyServer2 myServer2=new MyServer2();
	}

	public MyServer2()
	{
		
		
		try {
			
			//在9999端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("服务器正在监听.....");
			//等待连接
			Socket s=ss.accept();
			
			//先接收客户端发来的消息
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br1=new BufferedReader(isr1);
			
			PrintWriter pw1=new PrintWriter(s.getOutputStream(),true);
			
			//接收从控制台输入的信息
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			while(true)
			{
				
				
				String info=br1.readLine();
				System.out.println("客户端发来:"+info);
			
				if(info.equals("bye bye"))
				{
					s.close();
					break;
				}
				
				System.out.println("输入你想对客户端说的话：");
				String response =br2.readLine();
				
				//把消息回送给客户端
				pw1.println(response);
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
}



//这是第一个服务器端程序，让它在9999端口接收
//可以接收从客户端发来的消息

package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA_2_3.portable.InputStream;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server test1=new Server();
	}

	
	public Server()
	{
		
		try {
			//在9999端口监听
			ServerSocket ss1=new ServerSocket(9999);
			System.out.println("我是服务器，在9999端口监听");
			//等待某个客户端来连接，该函数会返回一个Socker连接
			Socket s=ss1.accept();
			System.out.println("11");
			
			//要读取s中传递的数据
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr1);
			
			String info1=br.readLine();
			System.out.println("服务器接收到了消息1："+info1);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("我是服务器，你也好");
			
			
			String info2=br.readLine();
			System.out.println("服务器接收到了消息2："+info2);
			
			PrintWriter pw2=new PrintWriter(s.getOutputStream(),true);
			pw2.println("你也好帅");
			
			String info3=br.readLine();
			System.out.println("服务器接收到了消息3："+info3);
			
			PrintWriter pw3=new PrintWriter(s.getOutputStream(),true);
			pw2.println("client byebye");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

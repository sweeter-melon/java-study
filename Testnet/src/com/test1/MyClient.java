package com.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

	
	public static void main(String []args)
	{
		MyClient my1=new MyClient();
		
	}
	
	
	public MyClient()
	{
		try {
		//连接某个服务器，127.0.0.1表示ip地址
			//9999表示端口
			Socket s=new Socket("127.0.0.1", 9999);
			
			//如果s连接成功，就可以发送数据给服务器
			
			//我们通过pw向s写数据。true表示及时刷新
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("你好吗,我是客户端");
			
			
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr1);
			
			String response=br.readLine();
			System.out.println("客户端收到消息1:"+response);
		
			PrintWriter pw1=new PrintWriter(s.getOutputStream(),true);
			pw.println("服务器你真帅啊");
			
			String response2=br.readLine();
			System.out.println("客户端收到消息2:"+response2);
			
			
			PrintWriter pw3=new PrintWriter(s.getOutputStream(),true);
			pw3.println("server byebye");
			

			String response3=br.readLine();
			System.out.println("客户端收到消息3:"+response3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

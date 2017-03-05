package com.tools;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;
import com.view.Qchat;

public class ClientThred extends Thread{

	private Socket s;
	
	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	//构造函数
	public ClientThred(Socket s)
	{
		
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			//不停读取从服务器发来的消息
try {
				
				ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
				Message m1=(Message)ois1.readObject();
				
				System.out.println(m1.getSender()+"对"+m1.getGetter()+"说："+m1.getCon());
				
				//把从服务器获得消息显示到聊天界面
				Qchat qchat=Manageqqchat.getQchat(m1.getGetter()+""+m1.getSender());
				//显示
				qchat.showMessage(m1);
				
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		
	}
	
}

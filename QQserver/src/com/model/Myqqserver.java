  
//qq���������ȴ�ĳ��qq�ͻ���������

package com.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.annotation.processing.Messager;
import javax.xml.ws.handler.MessageContext;

import com.common.Message;
import com.common.User;
import com.tools.Manageclient;
import com.tools.SerThred;
import com.view.Myserverfram;

public class Myqqserver {

	
	public Myqqserver()
	{
		
		try {
			
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("����......");
			
			while(true)
			{
			Socket s=ss.accept();
			//���տͻ��˷�������Ϣ
			ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
			
			User u=(User)ois1.readObject();
		Message m1=new Message();
		ObjectOutputStream oos1=new ObjectOutputStream(s.getOutputStream());
			if(u.getPasswd().equals("123456"))
			{
				//���سɹ�
				m1.setMesType("1");
				oos1.writeObject(m1);
				
				//����һ���̣߳��ø��̺߳Ϳͻ��˱���ͨ��
				SerThred scct=new SerThred(s);
				Manageclient.addClientThread(u.getUseId(),scct);
				scct.start();
			}
			
			else
			{
				m1.setMesType("2");
				oos1.writeObject(m1);
				s.close();
			}
			
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}

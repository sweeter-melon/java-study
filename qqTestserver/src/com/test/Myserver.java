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
			System.out.println("����..........");
			Socket s=ss.accept();
			//�Զ�������ʽ��ȡ������ͻ��˷��͵�һ������
			ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
			User u=(User)ois1.readObject();
			
			//���
			System.out.println("�ӿͻ��˽��գ�"+u.getName()+u.getPass());
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}

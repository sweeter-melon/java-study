

//���ܣ���һ������������9999�˿ڼ���
//����ͨ������̨������Ϣ
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
			
			//��9999�˿ڼ���
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���������ڼ���.....");
			//�ȴ�����
			Socket s=ss.accept();
			
			//�Ƚ��տͻ��˷�������Ϣ
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br1=new BufferedReader(isr1);
			
			PrintWriter pw1=new PrintWriter(s.getOutputStream(),true);
			
			//���մӿ���̨�������Ϣ
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			while(true)
			{
				
				
				String info=br1.readLine();
				System.out.println("�ͻ��˷���:"+info);
			
				if(info.equals("bye bye"))
				{
					s.close();
					break;
				}
				
				System.out.println("��������Կͻ���˵�Ļ���");
				String response =br2.readLine();
				
				//����Ϣ���͸��ͻ���
				pw1.println(response);
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
}

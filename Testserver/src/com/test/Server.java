

//���ǵ�һ���������˳���������9999�˿ڽ���
//���Խ��մӿͻ��˷�������Ϣ

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
			//��9999�˿ڼ���
			ServerSocket ss1=new ServerSocket(9999);
			System.out.println("���Ƿ���������9999�˿ڼ���");
			//�ȴ�ĳ���ͻ��������ӣ��ú����᷵��һ��Socker����
			Socket s=ss1.accept();
			System.out.println("11");
			
			//Ҫ��ȡs�д��ݵ�����
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr1);
			
			String info1=br.readLine();
			System.out.println("���������յ�����Ϣ1��"+info1);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("���Ƿ���������Ҳ��");
			
			
			String info2=br.readLine();
			System.out.println("���������յ�����Ϣ2��"+info2);
			
			PrintWriter pw2=new PrintWriter(s.getOutputStream(),true);
			pw2.println("��Ҳ��˧");
			
			String info3=br.readLine();
			System.out.println("���������յ�����Ϣ3��"+info3);
			
			PrintWriter pw3=new PrintWriter(s.getOutputStream(),true);
			pw2.println("client byebye");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

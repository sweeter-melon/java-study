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
		//����ĳ����������127.0.0.1��ʾip��ַ
			//9999��ʾ�˿�
			Socket s=new Socket("127.0.0.1", 9999);
			
			//���s���ӳɹ����Ϳ��Է������ݸ�������
			
			//����ͨ��pw��sд���ݡ�true��ʾ��ʱˢ��
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("�����,���ǿͻ���");
			
			
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr1);
			
			String response=br.readLine();
			System.out.println("�ͻ����յ���Ϣ1:"+response);
		
			PrintWriter pw1=new PrintWriter(s.getOutputStream(),true);
			pw.println("����������˧��");
			
			String response2=br.readLine();
			System.out.println("�ͻ����յ���Ϣ2:"+response2);
			
			
			PrintWriter pw3=new PrintWriter(s.getOutputStream(),true);
			pw3.println("server byebye");
			

			String response3=br.readLine();
			System.out.println("�ͻ����յ���Ϣ3:"+response3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

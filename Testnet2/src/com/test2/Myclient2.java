package com.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Myclient2 {

	public static void main(String []args)
	{
		Myclient2 myclient2=new Myclient2();
	}
	
	public Myclient2()
	{
		
		
		
		//���ӷ�����
		try {
			Socket s=new Socket("127.0.0.1", 9999);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			InputStreamReader isr1=new InputStreamReader(System.in);
			BufferedReader br1=new BufferedReader(isr1);
			
			InputStreamReader isr2=new InputStreamReader(s.getInputStream());
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				System.out.println("����������˵�Ļ���");
				String info=br1.readLine();
				pw.println(info);
				
				//���մӷ����������Ļ�
				
				String res1=br2.readLine();
				System.out.println("������˵��"+res1);
				
				if(res1.equals("bye bye"))
				{
					s.close();
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
		
		
		
	}
}

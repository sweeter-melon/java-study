
//��������ĳ���ͻ�ͨ���߳�

package com.tools;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;

public class SerThred extends Thread{

	Socket s;
	
	public SerThred(Socket s)
	{
		//�ѷ������Ϳͻ��˵����Ӹ���s
		this.s=s;
		
		
	}
	
	public void run()
	{
		while(true)
		{
			//������߳̽��տͻ�����Ϣ
			try {
				
				ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
				Message m1=(Message)ois1.readObject();
				
				System.out.println(m1.getSender()+"��"+m1.getGetter()+"˵��"+m1.getCon());
				
				//���ת��
				//ȡ�ý����˵�ͨ���߳�
				SerThred st1=Manageclient.geThred(m1.getGetter());
				ObjectOutputStream oos1=new ObjectOutputStream(st1.s.getOutputStream());
				oos1.writeObject(m1);
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
			
		}
		
	}
	
}

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

	//���캯��
	public ClientThred(Socket s)
	{
		
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			//��ͣ��ȡ�ӷ�������������Ϣ
try {
				
				ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
				Message m1=(Message)ois1.readObject();
				
				System.out.println(m1.getSender()+"��"+m1.getGetter()+"˵��"+m1.getCon());
				
				//�Ѵӷ����������Ϣ��ʾ���������
				Qchat qchat=Manageqqchat.getQchat(m1.getGetter()+""+m1.getSender());
				//��ʾ
				qchat.showMessage(m1);
				
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		
	}
	
}

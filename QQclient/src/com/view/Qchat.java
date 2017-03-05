
//���������Ľ���
//��Ϊ�ͻ��������촦�ڶ�ȡ״̬�������߳�
package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.common.Message;
import com.model.Myqqclient;
import com.tools.ClientThred;
import com.tools.Manageser;


public class Qchat extends JFrame implements ActionListener{

	JTextArea jta1;
	JTextField jtf1;
	JButton jb1;
	JPanel jp1;
	String ownId;
	String friend;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Qchat Qchat=new Qchat("1");
//		
//	}
public Qchat(String friend,String ownId)
{
	this.ownId=ownId;
	this.friend=friend;
	
	jta1=new JTextArea();
	jtf1=new JTextField(15);
	jb1=new JButton("����");
	
	jb1.addActionListener(this);
	jp1=new JPanel();
	
	
	jp1.add(jtf1);
	jp1.add(jb1);
	
	this.add(jta1,"Center");
	this.add(jp1, "South");
	this.setIconImage((new ImageIcon("image\\qq2.jpg").getImage()));
	
	
	this.setTitle(ownId+"���ں� "+friend+" ���� ");
	this.setSize(300, 200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
}

//дһ��������ʾ��Ϣ
public void showMessage(Message m)
{
	String info1=m.getGetter()+"�� "+m.getSender()+"˵��"+m.getCon()+"\r\n";
	this.jta1.append(info1);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource()==jb1)
	{
		//����û��������
		Message m=new Message();
		m.setSender(ownId);
		m.setGetter(friend);
		m.setCon(jtf1.getText());
		m.setSendtime(new Date().toString());
		
		//���͸�������
		
		try {
			//���ת��
			ClientThred cl1=Manageser.getconserverThred(ownId);
			ObjectOutputStream oos1=new ObjectOutputStream(cl1.getS().getOutputStream());
		oos1.writeObject(m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


	
	
}

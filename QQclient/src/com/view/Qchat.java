
//与好友聊天的界面
//因为客户端与聊天处于读取状态，做成线程
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
	jb1=new JButton("发送");
	
	jb1.addActionListener(this);
	jp1=new JPanel();
	
	
	jp1.add(jtf1);
	jp1.add(jb1);
	
	this.add(jta1,"Center");
	this.add(jp1, "South");
	this.setIconImage((new ImageIcon("image\\qq2.jpg").getImage()));
	
	
	this.setTitle(ownId+"正在和 "+friend+" 聊天 ");
	this.setSize(300, 200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
}

//写一个方法显示消息
public void showMessage(Message m)
{
	String info1=m.getGetter()+"对 "+m.getSender()+"说："+m.getCon()+"\r\n";
	this.jta1.append(info1);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource()==jb1)
	{
		//如果用户点击发送
		Message m=new Message();
		m.setSender(ownId);
		m.setGetter(friend);
		m.setCon(jtf1.getText());
		m.setSendtime(new Date().toString());
		
		//发送给服务器
		
		try {
			//完成转发
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

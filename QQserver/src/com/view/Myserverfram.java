


package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.model.Myqqserver;

public class Myserverfram extends JFrame implements ActionListener {
   JPanel jp1;
   JButton jb1,jb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Myserverfram my1=new Myserverfram();
	}

	public Myserverfram()
	{
		
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb2=new JButton("关闭服务器");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1.add(jb1);
		jp1.add(jb2);
		this.add(jp1);
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			new Myqqserver();
		}
		if(arg0.getSource()==jb2)
		{
			System.exit(0);
		}
	}
	
}

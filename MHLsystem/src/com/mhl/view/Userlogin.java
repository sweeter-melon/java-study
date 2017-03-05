package com.mhl.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mhl.model.Usermodel;
import com.mhl.tool.Mytool;

public class Userlogin extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3;
	JTextField jtf1;
	JPasswordField jpf1;
	JButton jb1,jb2;
	
	
	public static void main(String []args)
	{
	Userlogin us1=new Userlogin();
	}
	
	public Userlogin()
	{
		jl1=new JLabel("请输入用户名");
		jl1.setFont(Mytool.f1);
		jl1.setBounds(60,190,150,30);
		this.add(jl1);
		
		jtf1=new JTextField(20);
		jtf1.setFont(Mytool.f1);
		jtf1.setBounds(180,190,120,30);
		//设置下陷
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(jtf1);
		
		jl2=new JLabel("(员工号)");
				jl2.setFont(Mytool.f2);
		//设置前景色
		jl2.setForeground(Color.red);
		jl2.setBounds(100,210,100,30);
		this.add(jl2);
		
		jl3=new JLabel("请输入密码");
		jl3.setFont(Mytool.f1);
		jl3.setBounds(60,240,150,30);
		this.add(jl3);
		
		jpf1=new JPasswordField(20);
		jpf1.setBounds(180,240,120,30);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(jpf1);
		
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setFont(Mytool.f1);
		jb2.setBounds(220,300,70,30);
		this.add(jb2);
		
		jb1=new JButton("确定");
		//jb1.setActionCommand("ok");
		jb1.addActionListener(this);
		jb1.setFont(Mytool.f1);
		jb1.setBounds(110,300,70,30);
		this.add(jb1);
		
		
		this.setLayout(null);
		
		Backimage b1=new Backimage();
		//不使用上下框
		
		//把位置确定  ,空布局必须确定位置
		b1.setBounds(0, 0,360, 362);
		
		this.add(b1);
		this.setUndecorated(true);
		
		this.setSize(360,362);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//if(arg0.getActionCommand().equals("ok"))
		if(arg0.getSource()==jb1)
		{
			
//			//System.out.println("确定");
//			//取出员工号，密码
//			String u=this.jtf1.getText().trim();
//			String p=new String(this.jpf1.getPassword());
//			Usermodel um1=new Usermodel();
//		String res=um1.checkUser(u, p);//返回职位
//			
//		if(res.equals("经理")||res.equals("主管"));
//		{
//			new Windows();
//			//同时关闭登录界面
//			this.dispose();
//		}
			//因为不能连接数据库，暂时先这样写
			new Windows();
			this.dispose();
		}
		
		if(arg0.getSource()==jb2)
		{
			System.exit(0);
		}
	}
	
	
}


//内部类
	class Backimage extends JPanel
	{
		
		Image im;
		
		public void paint(Graphics g)
		{
			super.paint(g);
//			Image im=Toolkit.getDefaultToolkit().getImage(("image2\\3.jpg"));
//			
		try {
				im=ImageIO.read(new File("image2\\login.gif"));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		
		
			g.drawImage(im, 0, 0, 360,362,this);
		
	}
	}
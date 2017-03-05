//这是系统管理员，经理，主管可以进入的界面


package com.mhl.view;

import com.mhl.model.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.tools.JavaCompiler;

import com.mhl.tool.ImagePanel;
import com.mhl.tool.Mytool;

public class Windows extends JFrame implements ActionListener ,MouseListener{
//定义组件
	ImageIcon title;
	JMenuBar jmb1;
	//一级菜单
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//二级菜单
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6;
	
	//图标
	ImageIcon icon1,icon2,icon3,icon4,icon5;
	
	//工具栏
	JToolBar jtb1;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	//定义需要的5个面板
	JPanel jp1,jp2,jp3,jp4,jp5;
	//显示时间
	JLabel nowtime;
	Image Timebg;
	//javax.swing包中的timer可以定时触发action事件
	javax.swing.Timer t;
	
	ImagePanel p1_impanel;
	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	Image p1_bg=null;
	
	//给jp2面板定义需要的jlabel
	JLabel p2_jl1;
	JLabel p2_jl2;
	
	Image zhu_image;
	JSplitPane jsp1;
	CardLayout cardp2;
	CardLayout cardp3;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Windows win=new Windows();
//	}

	//初始化菜单
	public void initmenu()
	{
title=new ImageIcon("image2\\title.jpg");
		
		//创建图标
		icon1=new ImageIcon("image2//jm1_icon1.jpg");
		icon2=new ImageIcon("image2//jm1_icon2.jpg");
		icon3=new ImageIcon("image2//jm1_icon3.jpg");
		icon4=new ImageIcon("image2//jm1_icon4.jpg");
		icon5=new ImageIcon("image2//jm1_icon5.jpg");
		
		//创建一级菜单
		jm1=new JMenu("系统管理");
		jm1.setFont(Mytool.f1);
		//它的二级菜单
		jmi1=new JMenuItem("切换用户",icon1);
		jmi1.setFont(Mytool.f2);
		jmi2=new JMenuItem("切换到收款界面",icon2);
		jmi2.setFont(Mytool.f2);
		jmi3=new JMenuItem("登录管理",icon3);
		jmi3.setFont(Mytool.f2);
		jmi4=new JMenuItem("万年历",icon4);
		jmi4.setFont(Mytool.f2);
		jmi5=new JMenuItem("退出",icon5);
		jmi5.setFont(Mytool.f2);
		
		//加入
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi5);
		
		
		
		jm2=new JMenu("人事管理");
		jm2.setFont(Mytool.f1);
		jm3=new JMenu("菜单服务");
		jm3.setFont(Mytool.f1);
		jm4=new JMenu("报表统计");
		jm4.setFont(Mytool.f1);
		jm5=new JMenu("成本及库房");
		jm5.setFont(Mytool.f1);
		jm6=new JMenu("帮助");
		jm6.setFont(Mytool.f1);
		
		//把一级菜单加入
		jmb1=new JMenuBar();
				jmb1.add(jm1);
				jmb1.add(jm2);
				jmb1.add(jm3);
				jmb1.add(jm4);
				jmb1.add(jm5);
				jmb1.add(jm6);
				
				this.setJMenuBar(jmb1);
	}
	
	//初始化工具栏
	public void inittoolbar()
	{
		//处理工具栏的组件
		jtb1=new JToolBar();
		//设置工具栏不可以浮动
		jtb1.setFloatable(false);
		
		jb1=new JButton(new ImageIcon("image2\\jb1.jpg"));
		jb2=new JButton(new ImageIcon("image2\\jb2.jpg"));
		jb3=new JButton(new ImageIcon("image2\\jb3.jpg"));
		jb4=new JButton(new ImageIcon("image2\\jb4.jpg"));
		jb5=new JButton(new ImageIcon("image2\\jb5.jpg"));
		jb6=new JButton(new ImageIcon("image2\\jb6.jpg"));
		jb7=new JButton(new ImageIcon("image2\\jb7.jpg"));
		jb8=new JButton(new ImageIcon("image2\\jb8.jpg"));
		jb9=new JButton(new ImageIcon("image2\\jb9.jpg"));
		jb10=new JButton(new ImageIcon("image2\\jb10.jpg"));
		
		jtb1.add(jb1);
		jtb1.add(jb2);
		jtb1.add(jb3);
		jtb1.add(jb4);
		jtb1.add(jb5);
		jtb1.add(jb6);
		jtb1.add(jb7);
		jtb1.add(jb8);
		jtb1.add(jb9);
		jtb1.add(jb10);
		
	}
	
	//初始化中间的panel
	
	public void initpanel()
	{
		//处理p1面板
		jp1=new JPanel(new BorderLayout()); 
		
		 try {
			p1_bg=ImageIO.read(new File("image2\\jp1_bg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
		p1_impanel=new ImagePanel(p1_bg);
		p1_impanel.setLayout(new GridLayout(8,1));
	    
		
	
		jl1=new JLabel(new ImageIcon("image2\\label_1.gif"));
		jl2=new JLabel("人 事 管 理",new ImageIcon("image2\\label_2.jpg"),0);
		jl3=new JLabel("登 录 管 理",new ImageIcon("image2\\label_3.jpg"),0);
		jl4=new JLabel("菜 谱 价 格",new ImageIcon("image2\\label_4.jpg"),0);
		jl5=new JLabel("报 表 统 计",new ImageIcon("image2\\label_5.jpg"),0);
		jl6=new JLabel("成 本 及 库 房",new ImageIcon("image2\\label_6.jpg"),0);
		jl7=new JLabel("系 统 设 置",new ImageIcon("image2\\label_7.jpg"),0);
		jl8=new JLabel("动 画 帮 助",new ImageIcon("image2\\label_8.jpg"),0);
		
		// 注册监听
		jl1.addMouseListener(this);
		jl2.addMouseListener(this);
		jl3.addMouseListener(this);
		jl4.addMouseListener(this);
		jl5.addMouseListener(this);
		jl6.addMouseListener(this);
		jl7.addMouseListener(this);
		jl8.addMouseListener(this);
		
		//设置光标图像
		jl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jl8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jl2.setFont(Mytool.f3);
		jl3.setFont(Mytool.f3);
		jl4.setFont(Mytool.f3);
		jl5.setFont(Mytool.f3);
		jl6.setFont(Mytool.f3);
		jl7.setFont(Mytool.f3);
		jl8.setFont(Mytool.f3);
		
		jl1.setEnabled(false);
		jl2.setEnabled(false);
		jl3.setEnabled(false);
		jl4.setEnabled(false);
		jl5.setEnabled(false);
		jl6.setEnabled(false);
		jl7.setEnabled(false);
		jl8.setEnabled(false);
		
		p1_impanel.add(jl1);
		p1_impanel.add(jl2);
		p1_impanel.add(jl3);
		p1_impanel.add(jl4);
		p1_impanel.add(jl5);
		p1_impanel.add(jl6);
		p1_impanel.add(jl7);
		p1_impanel.add(jl8);
		
		jp1.add(p1_impanel);
		
		//处理p2,p3,p4
		//卡片布局
		//点击哪个按钮就显示哪一个卡片的内容
		jp4=new JPanel(new BorderLayout());
		cardp2=new CardLayout();
		jp2=new JPanel(cardp2);
		
		p2_jl1=new JLabel(new ImageIcon("image2\\jp2_left.jpg"));
		p2_jl2=new JLabel(new ImageIcon("image2\\jp2_right.jpg"));
		
		p2_jl1.addMouseListener(this);
		p2_jl2.addMouseListener(this);
		
		jp2.add(p2_jl1,"0");
		jp2.add(p2_jl2,"1");
		cardp3=new CardLayout();
		jp3=new JPanel(cardp3);
		
		//先给p3加入一个主界面卡片
		try {
			 zhu_image=ImageIO.read(new File("image2\\jp3.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	ImagePanel iPanel=new ImagePanel(zhu_image);
	jp3.add(iPanel,"0");
	
	//jp3.add(new JLabel(new ImageIcon("image2\\jp3_1.jpg")),"1");
	
	EmpInfo empInfo=new EmpInfo();
	jp3.add(empInfo,"1");
	jp3.add(new JLabel(new ImageIcon("image2\\jp3_2.jpg")),"2");
	jp3.add(new JLabel(new ImageIcon("image2\\jp3_3.jpg")),"3");
	jp3.add(new JLabel(new ImageIcon("image2\\jp3_4.jpg")),"4");
	jp3.add(new JLabel(new ImageIcon("image2\\jp3_5.jpg")),"5");
	jp3.add(new JLabel(new ImageIcon("image2\\jp3_6.jpg")),"6");
	jp3.add(new JLabel(new ImageIcon("image2\\jp3_7.jpg")),"7");
		//做一个拆分窗口，分别存放p1和p4
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
	//指定左边面板多大
		//jsp1.setDividerLocation(120);
		//把边界线设为0
		//jsp1.setDividerSize(0);
		//可以移动
		jsp1.setOneTouchExpandable(true);
	}
	
	public Windows()
	{
		
		this.initmenu();
		this.inittoolbar();
		this.initpanel();	
				
				jp4.add(jp2,BorderLayout.WEST);
				jp4.add(jp3, BorderLayout.CENTER);
				
				
				//创建jp5面板
				jp5=new JPanel(new BorderLayout());
				//创建Timer,每隔一秒触发action事件
				
				t=new Timer(1000, this);
				
				//启动定时器
				t.start();
				
				//获取当前时间
			
				
				nowtime=new JLabel(Calendar.getInstance().getTime().toLocaleString());
				nowtime.setFont(Mytool.f2);
				try {
					
					Timebg=ImageIO.read(new File("image2\\jp1_bg.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ImagePanel ip1=new ImagePanel(Timebg);
				ip1.setLayout(new BorderLayout());
				ip1.add(nowtime,BorderLayout.EAST);
				
				jp5.add(ip1);
				
				//从Jframe中取出container
				Container ct1=this.getContentPane();
				
				
				ct1.add(jtb1,BorderLayout.NORTH);
				ct1.add(jp5,BorderLayout.SOUTH);
				ct1.add(jsp1,BorderLayout.CENTER);
				
				
		//设置大小
		 //int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		 //int h=Toolkit.getDefaultToolkit().getScreenSize().height;

				//ct1.setBackground(Color.cyan);
//				 ct1.setFont(Mytool.f1);
//				 ct1.setForeground(Color.red);
//				 
				this.setSize(720,720);
		 this.setIconImage(title.getImage());
		 
		 
		 this.setTitle("满汉楼餐饮管理系统");
		 this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		 this.setResizable(false);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.nowtime.setText("当前时间 "+Calendar.getInstance().getTime().toLocaleString()+"   ");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==p2_jl1)
		{
			//把显示各种操作的界面p1隐藏
			//显示向右的箭头
			cardp2.show(jp2, "1");
			jsp1.setDividerLocation(0);
		}
		
		if(arg0.getSource()==p2_jl2);
		{
			//把显示各种操作的界面p1展开
			//显示向左的箭头
			cardp2.show(jp2, "0");
			jsp1.setDividerLocation(120);
		}
		
		if(arg0.getSource()==jl1)
		{
			cardp3.show(jp3, "0");
		}
		if(arg0.getSource()==jl2)
		{
			cardp3.show(jp3, "1");
		}
		if(arg0.getSource()==jl3)
		{
			cardp3.show(jp3, "2");
		}
		if(arg0.getSource()==jl4)
		{
			cardp3.show(jp3, "3");
		}
		if(arg0.getSource()==jl5)
		{
			cardp3.show(jp3, "4");
		}
		if(arg0.getSource()==jl6)
		{
			cardp3.show(jp3, "5");
		}
		if(arg0.getSource()==jl7)
		{
			cardp3.show(jp3, "6");
		}
		if(arg0.getSource()==jl8)
		{
			cardp3.show(jp3, "7");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户选择了某个jlabel,则 高亮
		if(arg0.getSource()==jl2)
		{
			jl2.setEnabled(true);
		}
		if(arg0.getSource()==jl3)
		{
			jl3.setEnabled(true);
		}
		if(arg0.getSource()==jl4)
		{
			jl4.setEnabled(true);
		}
		if(arg0.getSource()==jl5)
		{
			jl5.setEnabled(true);
		}
		if(arg0.getSource()==jl6)
		{
			jl6.setEnabled(true);
		}
		if(arg0.getSource()==jl7)
		{
			jl7.setEnabled(true);
		}
		if(arg0.getSource()==jl8)
		{
			jl8.setEnabled(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户选择了某个jlabel,则 禁用
				if(arg0.getSource()==jl2)
				{
					jl2.setEnabled(false);
				}
				if(arg0.getSource()==jl3)
				{
					jl3.setEnabled(false);
				}
				if(arg0.getSource()==jl4)
				{
					jl4.setEnabled(false);
				}
				if(arg0.getSource()==jl5)
				{
					jl5.setEnabled(false);
				}
				if(arg0.getSource()==jl6)
				{
					jl6.setEnabled(false);
				}
				if(arg0.getSource()==jl7)
				{
					jl7.setEnabled(false);
				}
				if(arg0.getSource()==jl8)
				{
					jl8.setEnabled(false);
				}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

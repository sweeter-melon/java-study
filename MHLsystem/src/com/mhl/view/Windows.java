//����ϵͳ����Ա���������ܿ��Խ���Ľ���


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
//�������
	ImageIcon title;
	JMenuBar jmb1;
	//һ���˵�
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//�����˵�
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6;
	
	//ͼ��
	ImageIcon icon1,icon2,icon3,icon4,icon5;
	
	//������
	JToolBar jtb1;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	//������Ҫ��5�����
	JPanel jp1,jp2,jp3,jp4,jp5;
	//��ʾʱ��
	JLabel nowtime;
	Image Timebg;
	//javax.swing���е�timer���Զ�ʱ����action�¼�
	javax.swing.Timer t;
	
	ImagePanel p1_impanel;
	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	Image p1_bg=null;
	
	//��jp2��嶨����Ҫ��jlabel
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

	//��ʼ���˵�
	public void initmenu()
	{
title=new ImageIcon("image2\\title.jpg");
		
		//����ͼ��
		icon1=new ImageIcon("image2//jm1_icon1.jpg");
		icon2=new ImageIcon("image2//jm1_icon2.jpg");
		icon3=new ImageIcon("image2//jm1_icon3.jpg");
		icon4=new ImageIcon("image2//jm1_icon4.jpg");
		icon5=new ImageIcon("image2//jm1_icon5.jpg");
		
		//����һ���˵�
		jm1=new JMenu("ϵͳ����");
		jm1.setFont(Mytool.f1);
		//���Ķ����˵�
		jmi1=new JMenuItem("�л��û�",icon1);
		jmi1.setFont(Mytool.f2);
		jmi2=new JMenuItem("�л����տ����",icon2);
		jmi2.setFont(Mytool.f2);
		jmi3=new JMenuItem("��¼����",icon3);
		jmi3.setFont(Mytool.f2);
		jmi4=new JMenuItem("������",icon4);
		jmi4.setFont(Mytool.f2);
		jmi5=new JMenuItem("�˳�",icon5);
		jmi5.setFont(Mytool.f2);
		
		//����
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi5);
		
		
		
		jm2=new JMenu("���¹���");
		jm2.setFont(Mytool.f1);
		jm3=new JMenu("�˵�����");
		jm3.setFont(Mytool.f1);
		jm4=new JMenu("����ͳ��");
		jm4.setFont(Mytool.f1);
		jm5=new JMenu("�ɱ����ⷿ");
		jm5.setFont(Mytool.f1);
		jm6=new JMenu("����");
		jm6.setFont(Mytool.f1);
		
		//��һ���˵�����
		jmb1=new JMenuBar();
				jmb1.add(jm1);
				jmb1.add(jm2);
				jmb1.add(jm3);
				jmb1.add(jm4);
				jmb1.add(jm5);
				jmb1.add(jm6);
				
				this.setJMenuBar(jmb1);
	}
	
	//��ʼ��������
	public void inittoolbar()
	{
		//�������������
		jtb1=new JToolBar();
		//���ù����������Ը���
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
	
	//��ʼ���м��panel
	
	public void initpanel()
	{
		//����p1���
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
		jl2=new JLabel("�� �� �� ��",new ImageIcon("image2\\label_2.jpg"),0);
		jl3=new JLabel("�� ¼ �� ��",new ImageIcon("image2\\label_3.jpg"),0);
		jl4=new JLabel("�� �� �� ��",new ImageIcon("image2\\label_4.jpg"),0);
		jl5=new JLabel("�� �� ͳ ��",new ImageIcon("image2\\label_5.jpg"),0);
		jl6=new JLabel("�� �� �� �� ��",new ImageIcon("image2\\label_6.jpg"),0);
		jl7=new JLabel("ϵ ͳ �� ��",new ImageIcon("image2\\label_7.jpg"),0);
		jl8=new JLabel("�� �� �� ��",new ImageIcon("image2\\label_8.jpg"),0);
		
		// ע�����
		jl1.addMouseListener(this);
		jl2.addMouseListener(this);
		jl3.addMouseListener(this);
		jl4.addMouseListener(this);
		jl5.addMouseListener(this);
		jl6.addMouseListener(this);
		jl7.addMouseListener(this);
		jl8.addMouseListener(this);
		
		//���ù��ͼ��
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
		
		//����p2,p3,p4
		//��Ƭ����
		//����ĸ���ť����ʾ��һ����Ƭ������
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
		
		//�ȸ�p3����һ�������濨Ƭ
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
		//��һ����ִ��ڣ��ֱ���p1��p4
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
	//ָ����������
		//jsp1.setDividerLocation(120);
		//�ѱ߽�����Ϊ0
		//jsp1.setDividerSize(0);
		//�����ƶ�
		jsp1.setOneTouchExpandable(true);
	}
	
	public Windows()
	{
		
		this.initmenu();
		this.inittoolbar();
		this.initpanel();	
				
				jp4.add(jp2,BorderLayout.WEST);
				jp4.add(jp3, BorderLayout.CENTER);
				
				
				//����jp5���
				jp5=new JPanel(new BorderLayout());
				//����Timer,ÿ��һ�봥��action�¼�
				
				t=new Timer(1000, this);
				
				//������ʱ��
				t.start();
				
				//��ȡ��ǰʱ��
			
				
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
				
				//��Jframe��ȡ��container
				Container ct1=this.getContentPane();
				
				
				ct1.add(jtb1,BorderLayout.NORTH);
				ct1.add(jp5,BorderLayout.SOUTH);
				ct1.add(jsp1,BorderLayout.CENTER);
				
				
		//���ô�С
		 //int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		 //int h=Toolkit.getDefaultToolkit().getScreenSize().height;

				//ct1.setBackground(Color.cyan);
//				 ct1.setFont(Mytool.f1);
//				 ct1.setForeground(Color.red);
//				 
				this.setSize(720,720);
		 this.setIconImage(title.getImage());
		 
		 
		 this.setTitle("����¥��������ϵͳ");
		 this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		 this.setResizable(false);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.nowtime.setText("��ǰʱ�� "+Calendar.getInstance().getTime().toLocaleString()+"   ");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==p2_jl1)
		{
			//����ʾ���ֲ����Ľ���p1����
			//��ʾ���ҵļ�ͷ
			cardp2.show(jp2, "1");
			jsp1.setDividerLocation(0);
		}
		
		if(arg0.getSource()==p2_jl2);
		{
			//����ʾ���ֲ����Ľ���p1չ��
			//��ʾ����ļ�ͷ
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
		//����û�ѡ����ĳ��jlabel,�� ����
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
		//����û�ѡ����ĳ��jlabel,�� ����
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

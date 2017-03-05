
//�����б����

package com.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.tools.Manageqqchat;

public class Friendlist extends JFrame implements ActionListener,MouseListener{

	//�����һ�ſ�Ƭ
	JPanel jphy1,jphy2,jphy3;
	JButton jbhy1,jbhy2,jbhy3;
	JScrollPane jsp1;
	
	//����ڶ��ſ�Ƭ
	JPanel jpms1,jpms2,jpms3;
	JButton jbms1,jbms2,jbms3;
	JScrollPane jsp2;
	
	//��������ſ�Ƭ
		JPanel jphmd1,jphmd2,jphmd3;
		JButton jbhmd1,jbhmd2,jbhmd3;
		JScrollPane jsp3;
		
		CardLayout cl;
		String ownId;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Friendlist friendlist=new Friendlist();
//	}

	public Friendlist(String ownId)
	{
		this.ownId=ownId;
		this.Card1();
		this.Card2();
		this.Card3();
	
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpms1,"2");
		this.add(jphmd1,"3");
		
		this.setSize(140,400);
		this.setTitle(ownId);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		
	}
	
	public void Card1()
	{
		//�����һ�ſ�Ƭ����ʾ�����б�
		
				jphy1=new JPanel(new BorderLayout());
				//����50������
				//4 4 �ֱ�Ϊ�м����м��
				jphy2=new JPanel(new GridLayout(50, 1,4,4));
				
				jphy3=new JPanel(new GridLayout(2, 1));
				
				jbhy1=new JButton("�ҵĺ���");
				jbhy2=new JButton("İ����");
				jbhy3=new JButton("������");
				jbhy2.addActionListener(this);
				jbhy3.addActionListener(this);
				//��������ť����hphy3
				jphy3.add(jbhy2);
				jphy3.add(jbhy3);
				
				//��jphy2��ʼ��50������
				JLabel jbs1[]=new JLabel[50];
				
				for(int i=0;i<jbs1.length;i++)
				{
					jbs1[i]=new JLabel(i+1+"",new ImageIcon("image\\mm.jpg"),JLabel.LEFT);
				    jbs1[i].addMouseListener(this);
					jphy2.add(jbs1[i]);
				}
				jsp1=new JScrollPane(jphy2);
				
				jphy1.add(jbhy1,"North");
				jphy1.add(jsp1,"Center");
				jphy1.add(jphy3,"South");
				
				this.add(jphy1);
				
	}
	
	public void Card2()
	{
		//����ڶ��ſ�Ƭ
		
		jpms1=new JPanel(new BorderLayout());
		
		//4 4 �ֱ�Ϊ�м����м��
		jpms2=new JPanel(new GridLayout(20, 1,4,4));
		
		jpms3=new JPanel(new GridLayout(2, 1));
		
		jbms1=new JButton("�ҵĺ���");
		jbms2=new JButton("İ����");
		jbms3=new JButton("������");
		
		jbms1.addActionListener(this);
		jbms3.addActionListener(this);
	
		jpms3.add(jbms1);
		jpms3.add(jbms2);
		
		
		JLabel jbs2[]=new JLabel[20];
		
		for(int i=0;i<jbs2.length;i++)
		{
			jbs2[i]=new JLabel(i+1+"",new ImageIcon("image\\mm.jpg"),JLabel.LEFT);
			jbs2[i].addMouseListener(this);
			jpms2.add(jbs2[i]);
		}
		jsp2=new JScrollPane(jpms2);
		
		jpms1.add(jpms3,"North");
		jpms1.add(jsp2,"Center");
		jpms1.add(jbms3,"South");
	
		this.add(jpms1);
	}
	
	public void Card3()
	{
		
		//��������ſ�Ƭ
		
jphmd1=new JPanel(new BorderLayout());
		
		//4 4 �ֱ�Ϊ�м����м��
		jphmd2=new JPanel(new GridLayout(15, 1,4,4));
		jphmd3=new JPanel(new GridLayout(3, 1));
		
		
		jbhmd1=new JButton("�ҵĺ���");
		jbhmd2=new JButton("İ����");
		jbhmd3=new JButton("������");
		
		jbhmd1.addActionListener(this);
	    jbhmd2.addActionListener(this);
		
		jphmd3.add(jbhmd1);
		jphmd3.add(jbhmd2);
		jphmd3.add(jbhmd3);
		
		JLabel jbs3[]=new JLabel[15];
		for(int i=0;i<jbs3.length;i++)
		{
			jbs3[i]=new JLabel(i+1+"",new ImageIcon("image\\mm.jpg"),JLabel.LEFT);
			jbs3[i].addMouseListener(this);
			jphmd2.add(jbs3[i]);
		}
		
		jsp3=new JScrollPane(jphmd2);
		jphmd1.add(jphmd3,"North");
		jphmd1.add(jsp3,"Center");
		
		this.add(jphmd1);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jbms1||arg0.getSource()==jbhmd1)
		{
			cl.show(this.getContentPane(), "1");
		}
		
		if(arg0.getSource()==jbhy2||arg0.getSource()==jbhmd2)
		{
			cl.show(this.getContentPane(), "2");
		}
		if(arg0.getSource()==jbhy3||arg0.getSource()==jbms3)
		{
			cl.show(this.getContentPane(), "3");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//��Ӧ˫�����¼����õ����ѱ��
		if(arg0.getClickCount()==2) //˫��
		{
			//�õ��ú��ѱ��
			String friendNo=((JLabel)arg0.getSource()).getText();
			System.out.println(friendNo);
			Qchat qchat=new Qchat(friendNo,ownId);
		
			//�����������������
			Manageqqchat.addQchat(ownId+" "+friendNo, qchat);
		
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl1=(JLabel)arg0.getSource();
		jl1.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl1=(JLabel)arg0.getSource();
		jl1.setForeground(Color.black);
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

//�����¼��������
package ��35;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Locale.Category;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class D35 extends JFrame implements ActionListener{

	//Mypanel mp1=null;
	JPanel jp1=null;
	JButton jb1=null;
	JButton jb2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      D35 d35=new D35();
	}

	public D35()
	{
		//mp1=new Mypanel();
		jp1=new JPanel();
		
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		
		jp1.setBackground(Color.BLACK);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jp1);
		this.add(jb2,BorderLayout.SOUTH);

		Cat cat=new Cat();
		//ע�����
		jb1.addActionListener(this); //this��ʾ����D35���
		jb1.addActionListener(cat);
		//ָ��action����
		jb1.setActionCommand("aa"); 
		
		jb2.addActionListener(this); //this��ʾ����D35���
		jb2.setActionCommand("bb");
		this.setSize(200,150);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//���¼�����ķ���
	
	public void actionPerformed(ActionEvent e)
	{
		//�ж����ĸ���ť�����
		if(e.getActionCommand().equals("aa"))
		{
			System.out.println("����˺�ɫ��ť");
			jp1.setBackground(Color.BLACK);
		}
		else if(e.getActionCommand().equals("bb"))
		{
			System.out.println("����˺�ɫ��ť");
			jp1.setBackground(Color.red );
		}
		else
		{
		System.out.println("��֪��");	
		}
	}
}

//һ���¼�Դ���Ա�����������
class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aa"))
		{
			System.out.println("èèҲ֪���㰴�º�ɫ");
		}
	}
	
	/*1.һ����ʵ�ּ����Ĳ���
	 * a.ʵ����Ӧ�Ľӿڣ�actionlistener keylistener��
	 * b.�ѽӿ���Ҫ�ķ���������Ҫ����д
	 * c.���¼�Դ����
	 * 
	 * 
	 * 
	 */
	
}

/*class Mypanel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 200, 150);
	}
	
}*/
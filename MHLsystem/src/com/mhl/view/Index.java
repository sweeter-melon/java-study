

//��������
package com.mhl.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JWindow;

public class Index extends JWindow implements Runnable{

	Paint p;
	//private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Index index=new Index();
		Thread t1=new Thread(index);
		t1.start();
		
	}

	public Index()
	{
		//����p
		p=new Paint();
		Thread t2=new Thread(p);
		t2.start();
		this.add(p);
		this.setSize(400,300);
		//ȷ��jwindow�ĳ�ʼλ��
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		//�ȴ����������;���ת����¼����
		try {
			Thread.sleep(20*500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//��ת����¼
		System.out.println("��������");
		//System.exit(0);
	//this.remove(p);
		
	    
		new Userlogin();
		this.dispose();
	}
	
}


//������
class  Paint extends Panel implements Runnable
{

	int r,h,b;
	public void paint(Graphics g)
	{
		super.paint(g);
	Image im=Toolkit.getDefaultToolkit().getImage(("image2\\index.gif"));
	
	   //��ʾͼƬ
	   
	   g.drawImage(im, 0, 0, 400, 300,this);//���Ͻ������ͼƬ���
		
		// ���ַ�������
			g.setColor(new Color(r, h, b));
			g.setFont(new Font("���Ĳ���",Font.BOLD,20));
			g.drawString("�� �� �� ʳ ", 100, 100);

	      
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			try {
				Thread.sleep(500);
				
			} catch (Exception e) {
				// TODO: handle exception
		e.printStackTrace();
			}
			
			 r=(int)(Math.random()*255);
			 h=(int)(Math.random()*255);
			 b=(int)(Math.random()*255);
			 this.repaint();
		}
	
	}
	
	
	
	
	
}
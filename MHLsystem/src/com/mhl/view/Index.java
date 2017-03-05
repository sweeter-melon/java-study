

//闪屏界面
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
		//创建p
		p=new Paint();
		Thread t2=new Thread(p);
		t2.start();
		this.add(p);
		this.setSize(400,300);
		//确定jwindow的初始位置
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		//等待闪屏结束就就跳转到登录界面
		try {
			Thread.sleep(20*500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//跳转到登录
		System.out.println("闪屏结束");
		//System.exit(0);
	//this.remove(p);
		
	    
		new Userlogin();
		this.dispose();
	}
	
}


//闪屏类
class  Paint extends Panel implements Runnable
{

	int r,h,b;
	public void paint(Graphics g)
	{
		super.paint(g);
	Image im=Toolkit.getDefaultToolkit().getImage(("image2\\index.gif"));
	
	   //显示图片
	   
	   g.drawImage(im, 0, 0, 400, 300,this);//左上角坐标和图片宽高
		
		// 画字符串和字
			g.setColor(new Color(r, h, b));
			g.setFont(new Font("华文彩云",Font.BOLD,20));
			g.drawString("中 华 美 食 ", 100, 100);

	      
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

//����  ������¼�������Ƶ����
//ͨ�����̿���С��

package com.circle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sql.rowset.JdbcRowSet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo1 extends JFrame {

	Mypanle mp1=null;
	public static void main(String []args)
	{
		Demo1 demo1=new Demo1();
	}
	
	public Demo1()
	{
		mp1=new Mypanle();
		
		this.add(mp1);
		
		this.addKeyListener(mp1);
		this.setSize(400,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class Mypanle extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		g.setColor(Color.YELLOW);
		//g.fillOval(x, y, 10, 10);
		this.tanke(g);
	}
	public void tanke(Graphics g)
	{
        g.fill3DRect(x, y, 5, 30,false);
		
		//2.�����ұ߾���
		g.fill3DRect(x+15, y, 5, 30,false);
		//3.�����м����
		g.fill3DRect(x+5, y+5, 10, 20,false);
		
		//4.����Բ��
		g.fillOval(x+4, y+10, 10, 10);
		
		//5.������
		g.drawLine(x+9, y+15, x+9, y-5);
	}

	//������
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("������"+(char)e.getKeyCode());
	
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{
		y++;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP)
	{
		y--;
	}
	
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
		x--;
	}
	
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
		x++;
	}
	//����repaint�����������ػ�
	this.repaint();
	}

	//���ͷ�
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//����һ��ֵ�����
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
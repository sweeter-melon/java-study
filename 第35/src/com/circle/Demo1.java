
//功能  加深对事件处理机制的理解
//通过键盘控制小球

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
		
		//2.画出右边矩形
		g.fill3DRect(x+15, y, 5, 30,false);
		//3.画出中间矩形
		g.fill3DRect(x+5, y+5, 10, 20,false);
		
		//4.画出圆形
		g.fillOval(x+4, y+10, 10, 10);
		
		//5.画出线
		g.drawLine(x+9, y+15, x+9, y-5);
	}

	//键按下
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("被按下"+(char)e.getKeyCode());
	
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
	//调用repaint（）函数来重绘
	this.repaint();
	}

	//键释放
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//键的一个值被输出
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
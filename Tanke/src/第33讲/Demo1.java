   //java绘图原理

//repaint 刷新组件的外观   实现动态

package 第33讲;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo1 extends JFrame {

	Mypanle mp=null;
	
	public static void main(String []args)
	{
		Demo1 demo1=new Demo1();
	}
	
	public Demo1()
	{
		mp=new Mypanle();
		this.add(mp);
		this.setBackground(Color.cyan);
		this.setSize(300,300);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}


//像素是一个密度单位，计算机800*600表示480000个像素
 

//定义一个myplanel(我自己的面板，用于绘图和显示绘图)

class Mypanle extends JPanel
{
	//覆盖Jpanel 里面的一个方法
	//Graphics是一个绘图的重要类，理解成画笔
	public void paint(Graphics g) 
	{
		//1.调用父类函数完成初始化
		//这句话不能少
		
		//1.窗口最小化,paint被调用
		//2.窗口最大化 paint被调用
		//3.repaint函数被调用
//System.out.println("paint被调用");
		super.paint(g);
		//画一个圆
		/*g.drawOval(10, 10, 30, 30);
		
		//画直线
   g.drawLine(10, 10, 40, 40);
		
   //画矩形边框
   g.drawRect(10, 10, 60, 60);
   
   //画填充矩形
   g.setColor(Color.blue);
   g.fillRect(10, 10, 40, 40);*/
		
		//在面板上画出图片
   Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		
   //显示图片
   
   g.drawImage(im, 90, 90, 200, 200,this);//左上角坐标和图片宽高
	
	// 画字符串和字
		g.setColor(Color.red);
		g.setFont(new Font("华文彩云",Font.BOLD,32));
		g.drawString("祖国万岁", 100, 100);
	}
}


	
	


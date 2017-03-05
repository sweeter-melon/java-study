//讲解事件处理机制
package 第35;

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
		
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		jp1.setBackground(Color.BLACK);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jp1);
		this.add(jb2,BorderLayout.SOUTH);

		Cat cat=new Cat();
		//注册监听
		jb1.addActionListener(this); //this表示监听D35这个
		jb1.addActionListener(cat);
		//指定action命令
		jb1.setActionCommand("aa"); 
		
		jb2.addActionListener(this); //this表示监听D35这个
		jb2.setActionCommand("bb");
		this.setSize(200,150);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//对事件处理的方法
	
	public void actionPerformed(ActionEvent e)
	{
		//判断是哪个按钮被点击
		if(e.getActionCommand().equals("aa"))
		{
			System.out.println("点击了黑色按钮");
			jp1.setBackground(Color.BLACK);
		}
		else if(e.getActionCommand().equals("bb"))
		{
			System.out.println("点击了红色按钮");
			jp1.setBackground(Color.red );
		}
		else
		{
		System.out.println("不知道");	
		}
	}
}

//一个事件源可以被多个对象监听
class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aa"))
		{
			System.out.println("猫猫也知道你按下黑色");
		}
	}
	
	/*1.一个类实现监听的步骤
	 * a.实现相应的接口（actionlistener keylistener）
	 * b.把接口需要的方法根据需要重新写
	 * c.在事件源监听
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
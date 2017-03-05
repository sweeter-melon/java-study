//功能   BorderLayout演示
//1.继承JFrame
//2.定义你需要的组件
//3.创建组件（构造函数）
//4.添加组件
//5.对窗体设置

package 第29讲;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo2 extends JFrame{

	//定义组件
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String []args)
	{
		Demo2 demo2=new Demo2();
	}
	
	
	public Demo2()
	{
		//创建组件
		jb1=new JButton("中部");
		jb2=new JButton("东部");
		jb3=new JButton("西部");
		jb4=new JButton("南部");
		jb5=new JButton("北部");
		
		//添加各个组件
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.EAST);
		this.add(jb3,BorderLayout.WEST);
		this.add(jb4,BorderLayout.SOUTH);
		this.add(jb5,BorderLayout.NORTH);
		
		
		
		//设置窗体标题
		 this.setTitle("边界布局案例");
		 this.setSize(300,200);
		 this.setLocation(200,200);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//显示窗体
		 this.setVisible(true);
	}
}

//多种布局管理器组合使用

package 第31讲;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//一个窗口面板只可以有一个JFrame,但可以有多个JPanel

public class Demo1 extends JFrame{
    //定义组件
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Demo1 demo1=new Demo1();
		
	}

	//构造函数
	
	public Demo1()
	{
		//创建组件
		//JPanel布局默认是流式布局
		
		
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		
		jb1=new JButton("西瓜");
		jb2=new JButton("苹果");
		jb3=new JButton("荔枝");
		jb4=new JButton("葡萄");
		jb5=new JButton("橘子");
		jb6=new JButton("香蕉");
		
		//设置布局
		
		jp1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//添加JPanel
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		//把Panel加入JFrame；
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		this.add(jb6, BorderLayout.CENTER);
		

		//设置窗体标题
		 this.setTitle("流式布局案例"); 
		 this.setSize(300,200);
		 this.setLocation(200,200);
		 
		 //禁止用户改变窗体大小
		 this.setResizable(false);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//显示窗体
		 this.setVisible(true);
	}
	
}

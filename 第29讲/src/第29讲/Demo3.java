//流式布局案例

package 第29讲;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo3 extends JFrame{

	//定义需要的组件
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Demo3 demo3=new Demo3();
		
	}

	//构造函数
	public Demo3()
	{
		//创建组件
		jb1=new JButton("关羽");
		jb2=new JButton("张飞");
		jb3=new JButton("马超");
		jb4=new JButton("黄忠");
		jb5=new JButton("赵云");
		jb6=new JButton("魏延");
		
		
	//添加组件
		
		this.add(jb1);
		//jb1.setSize(100,30);//布局管理器不限制管理的组件大小，允许最佳大小，不能更改
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//设置布局管理器
		
		//this.setLayout(null);
		//默认居中对齐
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
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

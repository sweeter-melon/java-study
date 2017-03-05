

//标签  JLable
//密码框  JPasswordFiled
//文本框  JTextFiled
package 第31讲;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Demo2 extends JFrame{

	//定义组件
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JTextField jt1;
	JPasswordField js1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo2 demo2=new Demo2();
	}

	//构造函数
	
	public Demo2()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jl1=new JLabel("用户名");
		jl2=new JLabel(" 密码  ");
		
		jb1=new JButton("登录");
		jb2=new JButton("取消");
				
		jt1=new JTextField(10);
		
		js1=new JPasswordField(10);	
		
		//设置布局管理器
		
		this.setLayout(new GridLayout(3,1));
		
		//加入各个组件
		
		jp1.add(jl1);
		jp1.add(jt1);
		
		jp2.add(jl2);
		jp2.add(js1);
		
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//加入到JFrame
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("用户登录界面");
		
		this.setSize(300, 150);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
	}
	
	
}

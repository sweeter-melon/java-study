package 第31讲;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Demo7 extends JFrame{

	
	//北部区域
	JLabel jl1;
	
	//南部区域
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//中部区域
	JTabbedPane jtp;  //选项卡窗格
	JPanel jp2,jp3,jp4;
	
	JLabel jl2,jl3,jl4,jl5;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb4;
	JCheckBox jcb1,jcb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo7 demo7=new Demo7();
	}

	//构造函数
	public Demo7()
	{
		jl2=new JLabel("QQ号码",JLabel.CENTER);  //把标签放在中间
		jl3=new JLabel("QQ密码",JLabel.CENTER);
		jl4=new JLabel("忘记密码",JLabel.CENTER);
		jl4.setFont(new Font("宋体", Font.PLAIN, 16)); //设置字体样式
	    jl4.setForeground(Color.blue); //设置颜色
	    jl5=new JLabel("<html><a href='www.qq.com'>申请密码保护</a>");
	    jl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
	jtf=new JTextField();
	jpf=new JPasswordField();
	jb4=new JButton("消除号码");
	
	jcb1=new JCheckBox("隐身登录");
	jcb2=new JCheckBox("记住密码");
	
	//北部区域
	
	jl1=new JLabel("QQ2017欢迎你",JLabel.CENTER);
	jl1.setFont(new Font("方正楷体", Font.PLAIN, 32)); //设置字体样式
    jl1.setForeground(new Color(128, 200, 100)); //设置颜色
	
	
	//南部
	jp1=new JPanel();
	jb1=new JButton("登录");
	jb2=new JButton("取消");
	jb3=new JButton("帮助");
	
	//中部
	jtp=new JTabbedPane();
	jp2=new JPanel();
	//jp2.setBackground(new Color(0, 64, 64));
	jp3=new JPanel();
	jp3.setBackground(Color.RED);
	jp4=new JPanel();
	jp4.setBackground(new Color(249,191,100));
	
	//将面板添加到选项卡窗格
	
	jtp.add("QQ号码", jp2); //第一个参数代表选项卡名称
	jtp.add("手机号码", jp3);
	jtp.add("电子邮箱", jp4);
	
	
	//设置布局
	
	jp2.setLayout(new GridLayout(3, 3));
	
	//添加组件
	
	jp1.add(jb1);
	jp1.add(jb2);
	jp1.add(jb3);
	
	jp2.add(jl2);
	jp2.add(jtf);
	jp2.add(jb4);
	jp2.add(jl3);
	jp2.add(jpf);
	jp2.add(jl4);
	jp2.add(jcb1);
	jp2.add(jcb2);
	jp2.add(jl5);
	
	this.add(jp1,BorderLayout.SOUTH);
	this.add(jl1,BorderLayout.NORTH);
	this.add(jtp, BorderLayout.CENTER);
	
	//展现组件
	
	ImageIcon icon=new ImageIcon("images\\qq2.jpg");
	
	this.setIconImage(icon.getImage());
	this.setSize(350, 240);
	this.setResizable(false);
	this.setTitle("腾讯QQ");
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setVisible(true);
	}
	
}

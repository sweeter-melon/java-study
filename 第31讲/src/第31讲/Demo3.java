//复选框和单选框

package 第31讲;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Demo3 extends JFrame{

//定义组件
	
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;  //复选框组件
	JRadioButton jrb1,jrb2;    //单选框组件
	
	ButtonGroup bg ;
	/*同一组单选按钮必须先创建ButtonGroup，
	然后把单选框组件放入到ButtonGroup中*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo3 demo3=new Demo3();
	}
//构造函数
	
	public Demo3()
	{
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jl1=new JLabel("你喜欢的运动");
		jl2=new JLabel("你的性别");
		
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		
		jcb1=new JCheckBox("足球");
		jcb2=new JCheckBox("篮球");
		jcb3=new JCheckBox("网球");		
		
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");	
		
		//一定要把jrb1和jrb2放入ButtonGroup中管理
		
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//设置布局管理器
		
	this.setLayout(new GridLayout(3,1));
	
	//添加组件
	jp1.add(jl1);
	jp1.add(jcb1);
	jp1.add(jcb2);
	jp1.add(jcb3);
	
	jp2.add(jl2);
	jp2.add(jrb1);
	jp2.add(jrb2);
	
	jp3.add(jb1);
	jp3.add(jb2);
	
	//加入到JFrame
	
	this.add(jp1);
	this.add(jp2);
	this.add(jp3);
	
	
	this.setTitle("用户注册界面");
	
	this.setSize(300, 150);
	
	this.setResizable(false);
	
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
   
	this.setLocation(200,200);
	
	this.setVisible(true);
	
	}
	
	
}

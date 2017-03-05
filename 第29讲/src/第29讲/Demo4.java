//网格布局演示

package 第29讲;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo4 extends JFrame{

	static int size=9;
	//定义组件
	JButton jbs[]=new JButton[size];
	
	public static void main(String []args)
	{
		Demo4 demo4=new Demo4();
	}
	
	public Demo4()
	{
		//创建组件
		
		for(int i=0;i<9;i++)
		{
			jbs[i]=new JButton(String.valueOf(i+1));
		}
		
		//设置网格布局
		this.setLayout(new GridLayout(3,3)); //代表三行三列
		
		//添加组件
		//所有组件大小相同
		for(int i=0;i<9;i++)
		{
			this.add(jbs[i]);
		}
		
		//设置窗体属性
		this.setTitle("网格布局案例");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(200, 100);
		this.setVisible(true);
	}
	
}

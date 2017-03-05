//下拉框组件（JComboBox）
//列表框组件（JList）
//滚动窗格组件(JScrollPane)



package 第31讲;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Demo4 extends JFrame{

	//定义
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JComboBox jcb1; //拉框组件
	JList  jList;  //列表框组件
	JScrollPane jsc; //滚动窗格组件(JScrollPane)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo4 demo4=new Demo4();
	}

	//构造函数
	public Demo4()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("你的籍贯");
		jl2=new JLabel("旅游地点");
		
		String jg[]={"北京","上海","天津","火星"};
		
		jcb1=new JComboBox(jg); //下拉框组件
		
		String dd[]={"九寨沟","故宫","长城","天安门"};
		
		jList=new JList(dd);  //列表框组件
		
		//设置你希望显示多少个选项
		jList.setVisibleRowCount(2);
		
		jsc=new JScrollPane(jList);
		
		
		
		
		
		
		//设置布局
		this.setLayout(new GridLayout(3, 1));
		
		//添加组件
		
		jp1.add(jl1);
		jp1.add(jcb1);
		
		jp2.add(jl2);
		jp2.add(jsc);
		
		
		this.add(jp1);
		this.add(jp2);
		
		this.setTitle("用户调查");
		
		this.setSize(300, 300);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
		
	}
	
}

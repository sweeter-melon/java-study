
//拆分窗格  JSplitPane

//词霸
package 第31讲;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;

public class Demo5 extends JFrame{

	//定义组件
	JSplitPane jsp1;
	JList jList;
	JLabel jl1;
	
	public static void main(String []args)
	{
		Demo5 demo5=new Demo5();
	}
	
	public Demo5() {
		// TODO Auto-generated constructor stub
		//创建组件
		String words[]={"boy","girl","bird"};
		jList=new JList(words);
		
		jl1=new JLabel(new ImageIcon("images\\java素材.jpg"));  //插入图片
		
		//拆分窗格
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jList,jl1);
		
		//可以变化
		jsp1.setOneTouchExpandable(true);
		
		//设置布局管理器
		
		//添加组件
		this.add(jsp1);
		
        this.setSize(300, 300);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
		
	}
	
}

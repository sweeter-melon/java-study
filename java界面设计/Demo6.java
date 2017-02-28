//qq聊天界面
// JTextArea jtArea=null; //多行文本框组件

//
//选项卡窗格（页签组件） JTabbedPane

package 第31讲;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo6 extends JFrame {

	JTextArea jtArea=null; //多行文本框组件
	JScrollPane jsp=null;
	JPanel jp1=null;
	JComboBox jcb=null;
	JTextField jtf=null;
	JButton jb=null;
	public static void  main(String []args)
	{
		Demo6 demo6=new Demo6();
	}
	
	//构造函数
	
	public Demo6()
	{
		jtArea=new JTextArea();
		
		jp1=new JPanel();
		
		jsp=new JScrollPane(jtArea);
		
		String chatter[]={"布什","拉登"};
		
		jcb=new JComboBox(chatter);
		jtf=new JTextField(10);
		jb=new JButton("发送");
		
		//设置布局
		
		//添加组件
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jsp);
		
        
		
        this.setSize(300, 200);
		
        this.setTitle("腾讯qq");
        
        this.setIconImage((new ImageIcon("images\\qq1.jpg")).getImage());//插入图片
        
        this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
	}
}

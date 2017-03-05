
//完成一个mini版本的学生管理系统
package 第69讲;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test3 extends JFrame implements ActionListener{
//定义一些控件
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTable jt1;
	JScrollPane jsp1;
	JTextField jtf1;
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Test3 test3=new Test3();
	}

	public Test3 ()
	{
		jp1=new JPanel();
		jtf1=new JTextField(10);
		jb1=new JButton("查询");
		jl1=new JLabel("请输入名字");
		
		//把各个控件加入到jp1
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb3=new JButton("修改");
		jb4=new JButton("删除");
		
		jb1.setActionCommand("jb1");
		jb1.addActionListener(this);
		
		//把按钮加入jp2
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		 //创建一个数据模型对象
		MytableModel mm=new MytableModel();
		 
    		
    		//初始化JTable
    		jt1=new JTable(mm);
	
    		jsp1=new JScrollPane(jt1);
    		
    		this.add(jsp1);
    		this.add(jp1,BorderLayout.NORTH);
    		this.add(jp2,BorderLayout.SOUTH);
    		this.setSize(400,300);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("jb1"))
		{
			//System.out.println("select");
			//因为把对表的数据封装到MytableModel，可以比较简单完成查询
			String name =this.jtf1.getText().trim();
			//写一个sql语句
			String sql="select *from stus where name="+name+"";
		//构建新的数据模型类并更新
			MytableModel mm1=new MytableModel(sql);
			jt1.setModel(mm1);
		}
	}
	
}

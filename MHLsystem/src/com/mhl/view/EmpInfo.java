package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mhl.model.EmpModel;
import com.mhl.tool.Mytool;

public class EmpInfo extends JPanel implements ActionListener{
	
	//定义需要的组件
	JPanel jp1,jp2,jp3,jp4,jp5;
	JLabel p1_jl1,p3_jl1;
	JTextField p1_jtf1;
	JButton p1_jb1,p4_jb1,p4_jb2,p4_jb3,p4_jb4;
	//显示人事信息的Jtable
	JTable jt1;
	JScrollPane jsp1;
	
	EmpModel em1=null;
	//构造函数
	public EmpInfo()
	{
		
		jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_jl1=new JLabel("请输入姓名(员工或职位)");
		p1_jl1.setFont(Mytool.f2);
		
		p1_jtf1=new JTextField(20);
		p1_jb1=new JButton("查询");
		p1_jb1.setFont(Mytool.f3);
		
		jp1.add(p1_jl1);
		jp1.add(p1_jtf1);
		jp1.add(p1_jb1);
		
		//不能连接数据库,这部分处理不好
		
//		//处理中间
//		 em1=new EmpModel();
//		String paras[]={"1"};
//		em1.Query("select 员工号，姓名，性别，职位 from 人事资料 where 1=?", paras);
//		jt1=new JTable(em1);
//		jsp1=new JScrollPane(jt1);
//		jp2=new JPanel(new BorderLayout());
//	jp2.add(jsp1);
		
		//处理南部的
		jp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_jl1=new JLabel("总记录数是**条");
		p3_jl1.setFont(Mytool.f3);
		jp3.add(p3_jl1);
		jp4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1=new JButton("详细信息");
		p4_jb2=new JButton("添加");
		p4_jb3=new JButton("修改");
		p4_jb4=new JButton("删除");
		p4_jb4.addActionListener(this);
		
		p4_jb1.setFont(Mytool.f3);
		p4_jb2.setFont(Mytool.f3);
		p4_jb3.setFont(Mytool.f3);
		p4_jb4.setFont(Mytool.f3);
		
		jp4.add(p4_jb1);
		jp4.add(p4_jb2);
		jp4.add(p4_jb3);
		jp4.add(p4_jb4);
		
		jp5=new JPanel(new BorderLayout());
		jp5.add(jp3,BorderLayout.WEST);
		
		jp5.add(jp4,BorderLayout.EAST);
		//把p1加入总的panel
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		//this.add(jp2, BorderLayout.CENTER);
		this.add(jp5, BorderLayout.SOUTH);
		//this.setBackground(Color.pink);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//如果用户要删除某个员工
		if(arg0.getSource()==p4_jb4)
		{
			System.out.println("delete");
			int selrownum=jt1.getSelectedRow();
		String empNo=(String)em1.getValueAt(selrownum, 0);
		if(em1.delEmpbyid(empNo))
		{
			//弹出消息框
			JOptionPane.showMessageDialog(null, "删除成功");
		
		}
		else
		{
			JOptionPane.showMessageDialog(null, "删除不成功");
		
		}
		String paras[]={"1"};
		//更新数据模型
		em1=new EmpModel();
		em1.Query("select *from 人事资料 where 1=?", paras);
		}
		
	}

}

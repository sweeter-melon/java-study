
//���һ��mini�汾��ѧ������ϵͳ
package ��69��;

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
//����һЩ�ؼ�
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
		jb1=new JButton("��ѯ");
		jl1=new JLabel("����������");
		
		//�Ѹ����ؼ����뵽jp1
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("���");
		jb3=new JButton("�޸�");
		jb4=new JButton("ɾ��");
		
		jb1.setActionCommand("jb1");
		jb1.addActionListener(this);
		
		//�Ѱ�ť����jp2
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		 //����һ������ģ�Ͷ���
		MytableModel mm=new MytableModel();
		 
    		
    		//��ʼ��JTable
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
			//��Ϊ�ѶԱ�����ݷ�װ��MytableModel�����ԱȽϼ���ɲ�ѯ
			String name =this.jtf1.getText().trim();
			//дһ��sql���
			String sql="select *from stus where name="+name+"";
		//�����µ�����ģ���ಢ����
			MytableModel mm1=new MytableModel(sql);
			jt1.setModel(mm1);
		}
	}
	
}

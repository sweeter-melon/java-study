

//��ǩ  JLable
//�����  JPasswordFiled
//�ı���  JTextFiled
package ��31��;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Demo2 extends JFrame{

	//�������
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JTextField jt1;
	JPasswordField js1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo2 demo2=new Demo2();
	}

	//���캯��
	
	public Demo2()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jl1=new JLabel("�û���");
		jl2=new JLabel(" ����  ");
		
		jb1=new JButton("��¼");
		jb2=new JButton("ȡ��");
				
		jt1=new JTextField(10);
		
		js1=new JPasswordField(10);	
		
		//���ò��ֹ�����
		
		this.setLayout(new GridLayout(3,1));
		
		//����������
		
		jp1.add(jl1);
		jp1.add(jt1);
		
		jp2.add(jl2);
		jp2.add(js1);
		
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//���뵽JFrame
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("�û���¼����");
		
		this.setSize(300, 150);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
	}
	
	
}

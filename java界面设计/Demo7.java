package ��31��;

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

	
	//��������
	JLabel jl1;
	
	//�ϲ�����
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//�в�����
	JTabbedPane jtp;  //ѡ�����
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

	//���캯��
	public Demo7()
	{
		jl2=new JLabel("QQ����",JLabel.CENTER);  //�ѱ�ǩ�����м�
		jl3=new JLabel("QQ����",JLabel.CENTER);
		jl4=new JLabel("��������",JLabel.CENTER);
		jl4.setFont(new Font("����", Font.PLAIN, 16)); //����������ʽ
	    jl4.setForeground(Color.blue); //������ɫ
	    jl5=new JLabel("<html><a href='www.qq.com'>�������뱣��</a>");
	    jl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
	jtf=new JTextField();
	jpf=new JPasswordField();
	jb4=new JButton("��������");
	
	jcb1=new JCheckBox("�����¼");
	jcb2=new JCheckBox("��ס����");
	
	//��������
	
	jl1=new JLabel("QQ2017��ӭ��",JLabel.CENTER);
	jl1.setFont(new Font("��������", Font.PLAIN, 32)); //����������ʽ
    jl1.setForeground(new Color(128, 200, 100)); //������ɫ
	
	
	//�ϲ�
	jp1=new JPanel();
	jb1=new JButton("��¼");
	jb2=new JButton("ȡ��");
	jb3=new JButton("����");
	
	//�в�
	jtp=new JTabbedPane();
	jp2=new JPanel();
	//jp2.setBackground(new Color(0, 64, 64));
	jp3=new JPanel();
	jp3.setBackground(Color.RED);
	jp4=new JPanel();
	jp4.setBackground(new Color(249,191,100));
	
	//�������ӵ�ѡ�����
	
	jtp.add("QQ����", jp2); //��һ����������ѡ�����
	jtp.add("�ֻ�����", jp3);
	jtp.add("��������", jp4);
	
	
	//���ò���
	
	jp2.setLayout(new GridLayout(3, 3));
	
	//������
	
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
	
	//չ�����
	
	ImageIcon icon=new ImageIcon("images\\qq2.jpg");
	
	this.setIconImage(icon.getImage());
	this.setSize(350, 240);
	this.setResizable(false);
	this.setTitle("��ѶQQ");
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setVisible(true);
	}
	
}

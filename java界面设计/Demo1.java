//���ֲ��ֹ��������ʹ��

package ��31��;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//һ���������ֻ������һ��JFrame,�������ж��JPanel

public class Demo1 extends JFrame{
    //�������
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Demo1 demo1=new Demo1();
		
	}

	//���캯��
	
	public Demo1()
	{
		//�������
		//JPanel����Ĭ������ʽ����
		
		
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		
		jb1=new JButton("����");
		jb2=new JButton("ƻ��");
		jb3=new JButton("��֦");
		jb4=new JButton("����");
		jb5=new JButton("����");
		jb6=new JButton("�㽶");
		
		//���ò���
		
		jp1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//���JPanel
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		//��Panel����JFrame��
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		this.add(jb6, BorderLayout.CENTER);
		

		//���ô������
		 this.setTitle("��ʽ���ְ���"); 
		 this.setSize(300,200);
		 this.setLocation(200,200);
		 
		 //��ֹ�û��ı䴰���С
		 this.setResizable(false);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//��ʾ����
		 this.setVisible(true);
	}
	
}

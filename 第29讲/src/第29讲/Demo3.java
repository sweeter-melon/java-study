//��ʽ���ְ���

package ��29��;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo3 extends JFrame{

	//������Ҫ�����
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Demo3 demo3=new Demo3();
		
	}

	//���캯��
	public Demo3()
	{
		//�������
		jb1=new JButton("����");
		jb2=new JButton("�ŷ�");
		jb3=new JButton("��");
		jb4=new JButton("����");
		jb5=new JButton("����");
		jb6=new JButton("κ��");
		
		
	//������
		
		this.add(jb1);
		//jb1.setSize(100,30);//���ֹ����������ƹ���������С��������Ѵ�С�����ܸ���
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//���ò��ֹ�����
		
		//this.setLayout(null);
		//Ĭ�Ͼ��ж���
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
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

//���񲼾���ʾ

package ��29��;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo4 extends JFrame{

	static int size=9;
	//�������
	JButton jbs[]=new JButton[size];
	
	public static void main(String []args)
	{
		Demo4 demo4=new Demo4();
	}
	
	public Demo4()
	{
		//�������
		
		for(int i=0;i<9;i++)
		{
			jbs[i]=new JButton(String.valueOf(i+1));
		}
		
		//�������񲼾�
		this.setLayout(new GridLayout(3,3)); //������������
		
		//������
		//���������С��ͬ
		for(int i=0;i<9;i++)
		{
			this.add(jbs[i]);
		}
		
		//���ô�������
		this.setTitle("���񲼾ְ���");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(200, 100);
		this.setVisible(true);
	}
	
}

   //java��ͼԭ��

//repaint ˢ����������   ʵ�ֶ�̬

package ��33��;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo1 extends JFrame {

	Mypanle mp=null;
	
	public static void main(String []args)
	{
		Demo1 demo1=new Demo1();
	}
	
	public Demo1()
	{
		mp=new Mypanle();
		this.add(mp);
		this.setBackground(Color.cyan);
		this.setSize(300,300);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}


//������һ���ܶȵ�λ�������800*600��ʾ480000������
 

//����һ��myplanel(���Լ�����壬���ڻ�ͼ����ʾ��ͼ)

class Mypanle extends JPanel
{
	//����Jpanel �����һ������
	//Graphics��һ����ͼ����Ҫ�࣬���ɻ���
	public void paint(Graphics g) 
	{
		//1.���ø��ຯ����ɳ�ʼ��
		//��仰������
		
		//1.������С��,paint������
		//2.������� paint������
		//3.repaint����������
//System.out.println("paint������");
		super.paint(g);
		//��һ��Բ
		/*g.drawOval(10, 10, 30, 30);
		
		//��ֱ��
   g.drawLine(10, 10, 40, 40);
		
   //�����α߿�
   g.drawRect(10, 10, 60, 60);
   
   //��������
   g.setColor(Color.blue);
   g.fillRect(10, 10, 40, 40);*/
		
		//������ϻ���ͼƬ
   Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		
   //��ʾͼƬ
   
   g.drawImage(im, 90, 90, 200, 200,this);//���Ͻ������ͼƬ���
	
	// ���ַ�������
		g.setColor(Color.red);
		g.setFont(new Font("���Ĳ���",Font.BOLD,32));
		g.drawString("�������", 100, 100);
	}
}


	
	


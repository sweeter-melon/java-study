package com.test1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyServer3 extends JFrame implements ActionListener{

	JTextArea jtArea=null; //�����ı������
	JScrollPane jsp=null;
	JPanel jp1=null;
	JComboBox jcb=null;
	JTextField jtf=null;
	JButton jb=null;
	PrintWriter pw1=null;
	public static void main(String[] args) 
	{
		
     MyServer3 myServer3=new MyServer3();
	}

	public MyServer3()
	{
jtArea=new JTextArea();
		
		jp1=new JPanel();
		
		jsp=new JScrollPane(jtArea);
		
		String chatter[]={"������"};
		
		jcb=new JComboBox(chatter);
		jtf=new JTextField(10);
		jb=new JButton("����");
		jb.addActionListener(this);
		
		//���ò���
		
		//������
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jsp);
		
        
		
        this.setSize(300, 200);
		
        this.setTitle("��ѶQQ");
        
        this.setIconImage((new ImageIcon("image/qq2.jpg")).getImage());//����ͼƬ
        
        this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
		
		
			try {
				
				//��9999�˿ڼ���
				ServerSocket ss=new ServerSocket(9988);
				System.out.println("���������ڼ���.....");
				//�ȴ�����
				Socket s=ss.accept();
				
				//�Ƚ��տͻ��˷�������Ϣ
				InputStreamReader isr1=new InputStreamReader(s.getInputStream());
				BufferedReader br1=new BufferedReader(isr1);
				
				 pw1=new PrintWriter(s.getOutputStream(),true);
				
				
				
				while(true)
				{
					//���մӿ���̨�������Ϣ
					
					String info=br1.readLine();
					jtArea.append("�ͻ��˷���:"+info+"\r\n");
				
				
		} 
			}
			catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb)
		{
			//�ѷ�������jtf��������ݷ��͸��ͻ���
			String res=jtf.getText();
			pw1.println(res);
			jtf.setText("");//���
		}
	}
}

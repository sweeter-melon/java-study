//qq�������
// JTextArea jtArea=null; //�����ı������

//
//ѡ�����ҳǩ����� JTabbedPane

package ��31��;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo6 extends JFrame {

	JTextArea jtArea=null; //�����ı������
	JScrollPane jsp=null;
	JPanel jp1=null;
	JComboBox jcb=null;
	JTextField jtf=null;
	JButton jb=null;
	public static void  main(String []args)
	{
		Demo6 demo6=new Demo6();
	}
	
	//���캯��
	
	public Demo6()
	{
		jtArea=new JTextArea();
		
		jp1=new JPanel();
		
		jsp=new JScrollPane(jtArea);
		
		String chatter[]={"��ʲ","����"};
		
		jcb=new JComboBox(chatter);
		jtf=new JTextField(10);
		jb=new JButton("����");
		
		//���ò���
		
		//������
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jsp);
		
        
		
        this.setSize(300, 200);
		
        this.setTitle("��Ѷqq");
        
        this.setIconImage((new ImageIcon("images\\qq1.jpg")).getImage());//����ͼƬ
        
        this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
	}
}

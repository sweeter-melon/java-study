//�����������JComboBox��
//�б�������JList��
//�����������(JScrollPane)



package ��31��;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Demo4 extends JFrame{

	//����
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JComboBox jcb1; //�������
	JList  jList;  //�б�����
	JScrollPane jsc; //�����������(JScrollPane)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo4 demo4=new Demo4();
	}

	//���캯��
	public Demo4()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("��ļ���");
		jl2=new JLabel("���εص�");
		
		String jg[]={"����","�Ϻ�","���","����"};
		
		jcb1=new JComboBox(jg); //���������
		
		String dd[]={"��կ��","�ʹ�","����","�찲��"};
		
		jList=new JList(dd);  //�б�����
		
		//������ϣ����ʾ���ٸ�ѡ��
		jList.setVisibleRowCount(2);
		
		jsc=new JScrollPane(jList);
		
		
		
		
		
		
		//���ò���
		this.setLayout(new GridLayout(3, 1));
		
		//������
		
		jp1.add(jl1);
		jp1.add(jcb1);
		
		jp2.add(jl2);
		jp2.add(jsc);
		
		
		this.add(jp1);
		this.add(jp2);
		
		this.setTitle("�û�����");
		
		this.setSize(300, 300);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
		
	}
	
}

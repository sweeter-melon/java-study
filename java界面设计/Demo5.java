
//��ִ���  JSplitPane

//�ʰ�
package ��31��;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;

public class Demo5 extends JFrame{

	//�������
	JSplitPane jsp1;
	JList jList;
	JLabel jl1;
	
	public static void main(String []args)
	{
		Demo5 demo5=new Demo5();
	}
	
	public Demo5() {
		// TODO Auto-generated constructor stub
		//�������
		String words[]={"boy","girl","bird"};
		jList=new JList(words);
		
		jl1=new JLabel(new ImageIcon("images\\java�ز�.jpg"));  //����ͼƬ
		
		//��ִ���
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jList,jl1);
		
		//���Ա仯
		jsp1.setOneTouchExpandable(true);
		
		//���ò��ֹ�����
		
		//������
		this.add(jsp1);
		
        this.setSize(300, 300);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   
		this.setLocation(200,200);
		
		this.setVisible(true);
		
	}
	
}

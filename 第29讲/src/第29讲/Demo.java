//���濪����ʾ


package ��29��;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo extends JFrame{

	//����Ҫ��swing������嵽����
	JButton jb1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    Demo demo=new Demo();
		
	}

	
	//���캯��
	
	public Demo()
	{
		//JFrame��һ����������
				//JFrame jfFrame=new JFrame();
				
				jb1=new JButton("��ʼ��Ϸ");
				
				//���������ñ���
			this.setTitle("����vs����");
			
			//���ô�С�������أ�1����=�����ף�
				this.setSize(200, 200);
				
				//���JButton���
				this.add(jb1);
				
				//���ó�ʼλ��
				this.setLocation(100,200);
				
				//���õ��رմ���ʱ����֤jvmҲ�˳�
				this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
				
				//��ʾ
				
				this.setVisible(true);
	}
}

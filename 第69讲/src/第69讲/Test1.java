
//jTable��ʹ��

package ��69��;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test1 extends JFrame {

	Vector rowdata; //���������
	Vector columnNames;//�������
    JTable jt1=null;
    JScrollPane jsp1=null; //������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test1 test1=new Test1();
	}

	public Test1()
	{
		columnNames=new Vector();
		//��������
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("ϵ��");
		
		rowdata=new Vector();
		//rowdata���Դ�Ŷ���
		Vector hang=new Vector();
		hang.add("sp001");
		hang.add("wukong");
		hang.add("��");
		hang.add("500");
		hang.add("����ɽ");
		hang.add("�䵱");
		
		//���뵽rowdata
		rowdata.add(hang);
		
		//��ʼ��JTable
		jt1=new JTable(rowdata, columnNames);
		
		jsp1=new JScrollPane(jt1);
		
		this.add(jsp1);
		this.setSize(400,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}

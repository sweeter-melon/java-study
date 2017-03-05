
//jTable的使用

package 第69讲;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test1 extends JFrame {

	Vector rowdata; //存放行数据
	Vector columnNames;//存放列名
    JTable jt1=null;
    JScrollPane jsp1=null; //滚动条
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test1 test1=new Test1();
	}

	public Test1()
	{
		columnNames=new Vector();
		//设置列名
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowdata=new Vector();
		//rowdata可以存放多行
		Vector hang=new Vector();
		hang.add("sp001");
		hang.add("wukong");
		hang.add("男");
		hang.add("500");
		hang.add("花果山");
		hang.add("武当");
		
		//加入到rowdata
		rowdata.add(hang);
		
		//初始化JTable
		jt1=new JTable(rowdata, columnNames);
		
		jsp1=new JScrollPane(jt1);
		
		this.add(jsp1);
		this.setSize(400,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}

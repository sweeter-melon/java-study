//从数据库提取数据进行操作

package 第69讲;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test2 extends JFrame{

	Vector rowdata; //存放行数据
	Vector columnNames;//存放列名
    JTable jt1=null;
    JScrollPane jsp1=null; //滚动条
    
    //操作数据库的对象
    PreparedStatement ps1=null;
    Connection ct1=null;
    ResultSet rs1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Test2 test2=new Test2();
	}
          public Test2()
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
      		
      		try {
				
      			//1.加载驱动
      			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
      			//2.连接
      			ct1=DriverManager.getConnection
    			("jdbc:microsoft:sqlserver:"
    					+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
    				
      			//3.执行
      			ps1=ct1.prepareStatement("select *from stus");
      			rs1=ps1.executeQuery();
      			
      			while(rs1.next())
      			{
      				Vector hang=new Vector();
      				hang.add(rs1.getString(1));
      				hang.add(rs1.getString(2));
      				hang.add(rs1.getString(3));
      				hang.add(rs1.getString(4));
      				hang.add(rs1.getString(5));
      				hang.add(rs1.getString(6));
      				rowdata.add(hang);
      			}
      			
      			
			} catch (Exception e) {
				// TODO: handle exception
			}
      		
      		finally
      		{
      			try {
    				if(ps1!=null)
    				{
    				ps1.close();
    				}
    				if(ct1!=null)
    				{
    				ct1.close();
    				}
    				} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
      		}
      		
      		//初始化JTable
      		jt1=new JTable(rowdata, columnNames);
      		
      		jsp1=new JScrollPane(jt1);
      		
      		this.add(jsp1);
      		this.setSize(400,300);
      		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      		this.setVisible(true);
	
             }
	
}

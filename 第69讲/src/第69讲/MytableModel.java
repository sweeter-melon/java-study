//学生表模型

package 第69讲;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MytableModel extends AbstractTableModel{

	Vector rowdata; //存放行数据
	Vector columnNames;//存放列名
	
	 //操作数据库的对象
    PreparedStatement ps1=null;
    Connection ct1=null;
    ResultSet rs1=null;
	
    public void init(String sql)
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
 			ps1=ct1.prepareStatement(sql);
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
    }
    
    //通过传递的sql语句来获得数据模型
    public MytableModel(String sql)
    {
    	this.init(sql);
    }
    
    
// 构造一个数据模型函数
  public MytableModel() {
		// TODO Auto-generated constructor stub
	  this.init(" ");
	 
	}
    
    
	//得到多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	//得到多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowdata.size();
	}

	//得到某行某列的数据
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowdata.get(row)).get(column);
	}


	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(arg0);
	}

	

}

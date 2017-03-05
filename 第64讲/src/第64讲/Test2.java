//1.PreparedStatement可以提高执行效率（有预编译功能）
//2.preparedStatement 可以防止sql注入，但是要求用？赋值方式才行
//这种方式不要引三个jar包
//sun.jdbc.odbc

package 第64讲;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		PreparedStatement ps1=null;
		ResultSet rs1=null;
		Connection ct1=null;
		
		try {
			
			//1.加载驱动(把需要的驱动程序加入内存)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.得到连接（指定连接到哪个数据源，用户名和密码）
			//如果你配置数据源时候，选择windows nt 验证，则不需要"sa","2509697407"
			//即Connecttion ct=DriverManager.getConnecttion("jdbc:odbc:mytest")
			 ct1=DriverManager.getConnection("jdbc:odbc:test","sa","2509697407");
		//3.创建ps
//		ps1=ct1.prepareStatement("select *from dept");
//		rs1=ps1.executeQuery();
//		 while(rs1.next())
//		 {
//			 int deptno=rs1.getInt(1);
//			 String dname=rs1.getString(2);
//			 String loc=rs1.getString(3);
//			 System.out.println(deptno+dname+loc);
//		 }
			
			//使用preparedstatement添加一条记录
			 
			 ps1=ct1.prepareStatement("insert into dept values(?,?,?)");
			ps1.setInt(1, 50);
			ps1.setString(2, "安全部");
			ps1.setString(3, "北京");
			
			//执行
			int i=ps1.executeUpdate();
			if(i==1)
			{
				System.out.println("添加ok");
			}
			else {
				{
					System.out.println("error");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
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

}

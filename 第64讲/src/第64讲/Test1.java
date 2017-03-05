//演示使用jdbc-odbc桥连方式操作数据库
//1.配置数据源
//用这种方式不需引入三个jar包，即用sun.jdbc.odbc的方式
package 第64讲;
import java.sql.*;
import java.beans.Statement;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		Statement sm1=null;
		try {
			
			//1.加载驱动(把需要的驱动程序加入内存)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.得到连接（指定连接到哪个数据源，用户名和密码）
			//如果你配置数据源时候，选择windows nt 验证，则不需要"sa","2509697407"
			//即Connecttion ct=DriverManager.getConnecttion("jdbc:odbc:mytest")
			 ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","2509697407");
		//3.创建statement
		 sm1=ct.createStatement();
		//4.执行（crud，创建数据库，备份，删除数据。。。。）
		
//		//1.演示添加一条数据到dept表
//			//exectueUpdate可以执行cud操作（添加，删除，修改）
//			int i=sm1.executeUpdate("insert into dept values(50,'保安部','西永')");
//			//删除
		 //int i=sm1.executeUpdate("delete from dept where sal=5000");
//			
		 //修改
		 //int i=sm1.executeUpdate("update dept set sal=3000 where name='kong'");
//			if(i==1)
//			{
//				System.out.println("添加ok");
//			}
//			else
//			{
//				System.out.println("添加失败");
//			}
		 
		 //查询显示所有部门
		 ResultSet rs=sm1.executeQuery("select *from dept");
		 //因为rs指向结果集的第一行的前一行
		 while(rs.next())
		 {
			 int deptno=rs.getInt(1);
			 String dname=rs.getString(2);
			 String loc=rs.getString(3);
			 System.out.println(deptno+dname+loc);
		 }
//		 //试图取出1行的第一列
//		 rs.next();
//		 int a=rs.getInt(1);
//		 System.out.println(a);
//		 //取出第二列
//		 String b=rs.getString(2);
//		 System.out.println(b);
		
		
		
		
		
		
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(sm1!=null)
				{
				sm1.close();
				}
				if(ct!=null)
				{
				ct.close();
				}
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

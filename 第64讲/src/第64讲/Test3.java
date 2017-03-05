

//jdbc方式操作数据库
//需要引入三个jar包
//这种方式com.microsoft.jdbc要引包
//引包方法在66讲18分钟
package 第64讲;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //PreparedStatement[火箭车]
		
		//定义需要的对象
		PreparedStatement ps1=null;
		Connection ct1=null;
		ResultSet rs1=null;
		
		
		try {
			//初始化我们的对象
			//1.加载驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//2.连接
			//127.0.0.1表示你要连接的数据库的ip地址
			//1433 表示sql server 的默认端口()
			ct1=DriverManager.getConnection
	("jdbc:microsoft:sqlserver:"
			+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
			
//			//3.创建火箭车
//			ps1=ct1.prepareStatement("select *from emp");
//			ps
//			//4.执行
//			rs1=ps1.executeQuery();
//			//如果是增加 删除 修改 就用 executeUpdate
//			//查找就用 executeQuery
//			
//			//循环取出
//			
//			while(rs1.next())
//			{
//				String name=rs1.getString(2);
//				//String name=rs1.getString("name") 也可以
//				float sal=rs1.getFloat(6);
//				//float sal=rs1.getFloat("sal");
//				int deptno=rs1.getInt(8);
//				//int deptno=rs1.getInt("deptno");
//				System.out.println(name+sal+deptno);
//				
//			}
//			
			//插入数据
//			//3.创建火箭车
//			ps1=ct1.prepareStatement("insert into dept values(?,?,?)");
//			//给？赋值
//			ps1.setInt(1, 50);
//			ps1.setString(2, "安全部");
//			ps1.setString(3, "北京");
			
//			//删除数据
//			ps1=ct1.prepareStatement("delete from dept where sal=?");
//			ps1.setInt(1, 5000);
			
			//修改数据
			ps1=ct1.prepareStatement("update dept set sal=? where deptno=?");
			ps1.setInt(1, 3000);
			ps1.setString(2, "3");
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

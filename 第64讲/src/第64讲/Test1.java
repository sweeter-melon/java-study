//��ʾʹ��jdbc-odbc������ʽ�������ݿ�
//1.��������Դ
//�����ַ�ʽ������������jar��������sun.jdbc.odbc�ķ�ʽ
package ��64��;
import java.sql.*;
import java.beans.Statement;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		Statement sm1=null;
		try {
			
			//1.��������(����Ҫ��������������ڴ�)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.�õ����ӣ�ָ�����ӵ��ĸ�����Դ���û��������룩
			//�������������Դʱ��ѡ��windows nt ��֤������Ҫ"sa","2509697407"
			//��Connecttion ct=DriverManager.getConnecttion("jdbc:odbc:mytest")
			 ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","2509697407");
		//3.����statement
		 sm1=ct.createStatement();
		//4.ִ�У�crud���������ݿ⣬���ݣ�ɾ�����ݡ���������
		
//		//1.��ʾ���һ�����ݵ�dept��
//			//exectueUpdate����ִ��cud��������ӣ�ɾ�����޸ģ�
//			int i=sm1.executeUpdate("insert into dept values(50,'������','����')");
//			//ɾ��
		 //int i=sm1.executeUpdate("delete from dept where sal=5000");
//			
		 //�޸�
		 //int i=sm1.executeUpdate("update dept set sal=3000 where name='kong'");
//			if(i==1)
//			{
//				System.out.println("���ok");
//			}
//			else
//			{
//				System.out.println("���ʧ��");
//			}
		 
		 //��ѯ��ʾ���в���
		 ResultSet rs=sm1.executeQuery("select *from dept");
		 //��Ϊrsָ�������ĵ�һ�е�ǰһ��
		 while(rs.next())
		 {
			 int deptno=rs.getInt(1);
			 String dname=rs.getString(2);
			 String loc=rs.getString(3);
			 System.out.println(deptno+dname+loc);
		 }
//		 //��ͼȡ��1�еĵ�һ��
//		 rs.next();
//		 int a=rs.getInt(1);
//		 System.out.println(a);
//		 //ȡ���ڶ���
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

//1.PreparedStatement�������ִ��Ч�ʣ���Ԥ���빦�ܣ�
//2.preparedStatement ���Է�ֹsqlע�룬����Ҫ���ã���ֵ��ʽ����
//���ַ�ʽ��Ҫ������jar��
//sun.jdbc.odbc

package ��64��;

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
			
			//1.��������(����Ҫ��������������ڴ�)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.�õ����ӣ�ָ�����ӵ��ĸ�����Դ���û��������룩
			//�������������Դʱ��ѡ��windows nt ��֤������Ҫ"sa","2509697407"
			//��Connecttion ct=DriverManager.getConnecttion("jdbc:odbc:mytest")
			 ct1=DriverManager.getConnection("jdbc:odbc:test","sa","2509697407");
		//3.����ps
//		ps1=ct1.prepareStatement("select *from dept");
//		rs1=ps1.executeQuery();
//		 while(rs1.next())
//		 {
//			 int deptno=rs1.getInt(1);
//			 String dname=rs1.getString(2);
//			 String loc=rs1.getString(3);
//			 System.out.println(deptno+dname+loc);
//		 }
			
			//ʹ��preparedstatement���һ����¼
			 
			 ps1=ct1.prepareStatement("insert into dept values(?,?,?)");
			ps1.setInt(1, 50);
			ps1.setString(2, "��ȫ��");
			ps1.setString(3, "����");
			
			//ִ��
			int i=ps1.executeUpdate();
			if(i==1)
			{
				System.out.println("���ok");
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

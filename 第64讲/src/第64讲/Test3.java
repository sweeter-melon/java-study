

//jdbc��ʽ�������ݿ�
//��Ҫ��������jar��
//���ַ�ʽcom.microsoft.jdbcҪ����
//����������66��18����
package ��64��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //PreparedStatement[�����]
		
		//������Ҫ�Ķ���
		PreparedStatement ps1=null;
		Connection ct1=null;
		ResultSet rs1=null;
		
		
		try {
			//��ʼ�����ǵĶ���
			//1.��������
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//2.����
			//127.0.0.1��ʾ��Ҫ���ӵ����ݿ��ip��ַ
			//1433 ��ʾsql server ��Ĭ�϶˿�()
			ct1=DriverManager.getConnection
	("jdbc:microsoft:sqlserver:"
			+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
			
//			//3.���������
//			ps1=ct1.prepareStatement("select *from emp");
//			ps
//			//4.ִ��
//			rs1=ps1.executeQuery();
//			//��������� ɾ�� �޸� ���� executeUpdate
//			//���Ҿ��� executeQuery
//			
//			//ѭ��ȡ��
//			
//			while(rs1.next())
//			{
//				String name=rs1.getString(2);
//				//String name=rs1.getString("name") Ҳ����
//				float sal=rs1.getFloat(6);
//				//float sal=rs1.getFloat("sal");
//				int deptno=rs1.getInt(8);
//				//int deptno=rs1.getInt("deptno");
//				System.out.println(name+sal+deptno);
//				
//			}
//			
			//��������
//			//3.���������
//			ps1=ct1.prepareStatement("insert into dept values(?,?,?)");
//			//������ֵ
//			ps1.setInt(1, 50);
//			ps1.setString(2, "��ȫ��");
//			ps1.setString(3, "����");
			
//			//ɾ������
//			ps1=ct1.prepareStatement("delete from dept where sal=?");
//			ps1.setInt(1, 5000);
			
			//�޸�����
			ps1=ct1.prepareStatement("update dept set sal=? where deptno=?");
			ps1.setInt(1, 3000);
			ps1.setString(2, "3");
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

//java��ʹ��ddl��䣨backup create drop��

package ��64��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������Ҫ�Ķ���
				PreparedStatement ps1=null;
				Connection ct1=null;
				ResultSet rs1=null;
				
				
				try {
					//��ʼ�����ǵĶ���
					//1.��������
					Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
					//2.����
					ct1=DriverManager.getConnection
			("jdbc:microsoft:sqlserver:"
					+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
				
					//�������ݿ�
					//ps1=ct1.prepareStatement("create database vvv");
					//������
					ps1=ct1.prepareStatement("create table xxx(age int)");
					//�������ݿ�
					ps1=ct1.prepareStatement("backup database bbb to disk='f:\\ss.bak'");
					boolean b=ps1.execute(); //�ɹ��ͷ���һ��false
					if(!b)
					{
						System.out.println("ok");
					}
					else {
						System.out.println("ok");
					}
	}
				catch (Exception e) 
				{
					// TODO: handle exception
					e.printStackTrace();
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
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				}
}

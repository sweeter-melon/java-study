
//�����ݿ���в�������
//�����ݿ����������crud

package com.mhl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {

	//������Ҫ�Ķ���
	PreparedStatement ps1=null;
	ResultSet rs1=null;
	Connection ct1=null;

	//���캯����ʼ��ct
	public SqlHelper()
	{
		
		try {
			//1.��������
 			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
 			//2.����
 			ct1=DriverManager.getConnection
 		("jdbc:microsoft:sqlserver:"
 				+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
 			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	//�Ѷ����ݿ������ɾ����дһ������
	
	public boolean exeUpdata(String sql,String paras[])
	{
		boolean b=true;
		try {
			ps1=ct1.prepareStatement(sql);
			//��sql������ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps1.setString(i+1, paras[i]);
			}
			//ִ��
			ps1.executeUpdate();
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return b;
		
	}
	
	
	
	
	public ResultSet query(String sql,String []paras)
	{
		//sqlΪ���ݿ�����
		//paras[]Ϊ��ѯ����
		
		try {
			ps1=ct1.prepareStatement(sql);
			//��sql������ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps1.setString(i+1, paras[i]);
			}
			//ִ��
			rs1=ps1.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs1;
		
	}
	
	//�ر���Դ�ķ���
	
	public void close()
	{
		
		try {
			if(rs1!=null)
			{
				rs1.close();
			}
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

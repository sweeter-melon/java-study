
//对数据库进行操作的类
//对数据库操作，就是crud

package com.mhl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {

	//定义需要的对象
	PreparedStatement ps1=null;
	ResultSet rs1=null;
	Connection ct1=null;

	//构造函数初始化ct
	public SqlHelper()
	{
		
		try {
			//1.加载驱动
 			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
 			//2.连接
 			ct1=DriverManager.getConnection
 		("jdbc:microsoft:sqlserver:"
 				+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
 			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	//把对数据库的增，删，改写一个函数
	
	public boolean exeUpdata(String sql,String paras[])
	{
		boolean b=true;
		try {
			ps1=ct1.prepareStatement(sql);
			//对sql参数赋值
			for(int i=0;i<paras.length;i++)
			{
				ps1.setString(i+1, paras[i]);
			}
			//执行
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
		//sql为数据库语言
		//paras[]为查询条件
		
		try {
			ps1=ct1.prepareStatement(sql);
			//对sql参数赋值
			for(int i=0;i<paras.length;i++)
			{
				ps1.setString(i+1, paras[i]);
			}
			//执行
			rs1=ps1.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs1;
		
	}
	
	//关闭资源的方法
	
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


//人事的数据操作

package com.mhl.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.management.Query;
import javax.swing.table.AbstractTableModel;

import com.mhl.db.SqlHelper;

public class EmpModel extends AbstractTableModel{

	Vector colums;
	Vector rows;
	
	//提供一个可以完成增，删，改的方法
	//通过员工号删除员工
	public boolean delEmpbyid(String empid)
	{
		boolean b=true;
		String sql="delete from 人事资料 where 员工号=?";
		String paras[]={empid};
		SqlHelper sh=new SqlHelper();
		
		try {
			b=sh.exeUpdata(sql, paras);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			sh.close();
		}
		
		return b;
	}
	
	
	//写一个方法查询需要显示的人事
	
	public void Query(String sql,String paras[])
	{
		//初始化列
		colums=new Vector();
		colums.add("员工号");
		colums.add("姓名");
		colums.add("性别");
		colums.add("职位");
		
		rows=new Vector();
		//创建sqlhelper对象
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.query(sql, paras);
		
		try
		{
		//从rs对象中得到一个ResultSetMetadata
			//rsmt可以得到结果有多少列，而且可以知道每列的名字
		ResultSetMetaData rsmt1=rs.getMetaData();
		for(int i=0;i<rsmt1.getColumnCount();i++)
		{
			colums.add(rsmt1.getColumnName(i+1));
		}
		
			while(rs.next())
			{
				Vector temp=new Vector();
				for(int i=0;i<rsmt1.getColumnCount();i++)
				{
					temp.add(rs.getString(i+1));
				}
				rows.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			sh.close();
		}
	}
	
	//得到多少列
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return this.colums.size();
		}

		//得到多少行
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return this.rows.size();
		}

		//得到某行某列的数据
		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return ((Vector<String>)this.rows.get(row)).get(column);
		}


		@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return (String)this.colums.get(arg0);
		}
}


//���µ����ݲ���

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
	
	//�ṩһ�������������ɾ���ĵķ���
	//ͨ��Ա����ɾ��Ա��
	public boolean delEmpbyid(String empid)
	{
		boolean b=true;
		String sql="delete from �������� where Ա����=?";
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
	
	
	//дһ��������ѯ��Ҫ��ʾ������
	
	public void Query(String sql,String paras[])
	{
		//��ʼ����
		colums=new Vector();
		colums.add("Ա����");
		colums.add("����");
		colums.add("�Ա�");
		colums.add("ְλ");
		
		rows=new Vector();
		//����sqlhelper����
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.query(sql, paras);
		
		try
		{
		//��rs�����еõ�һ��ResultSetMetadata
			//rsmt���Եõ�����ж����У����ҿ���֪��ÿ�е�����
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
	
	//�õ�������
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return this.colums.size();
		}

		//�õ�������
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return this.rows.size();
		}

		//�õ�ĳ��ĳ�е�����
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

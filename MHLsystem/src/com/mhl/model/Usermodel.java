
//�û�������ģ�ͣ�������ɶ��û��Ĳ���
//uid �û����  p ����
//return �û�ְλ ���û������ڷ���" "

package com.mhl.model;

import java.sql.ResultSet;

import javax.swing.SpinnerDateModel;

import com.mhl.db.SqlHelper;

public class Usermodel {
	
	
	public String checkUser(String uid,String p)
	{
		String zhiwei="";
		SqlHelper sp=null;
		try {
			
			//��֯sql���Ͳ����б�
			String sql="select ��������.ְλ from ��¼,��������where ��¼.Ա����=��������."
					+ "Ա���� and ��¼.Ա����=? and ��¼.����=��";
			String paras[]={uid,p};
			 sp=new SqlHelper();
			ResultSet rs1=sp.query(sql, paras);
			
			if(rs1.next())
			{
				//ȡ��ְλ
				zhiwei=rs1.getString(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			sp.close();
		}
		
		
		return zhiwei;
	}
	

}

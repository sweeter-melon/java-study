
//用户表数据模型，用它完成对用户的操作
//uid 用户编号  p 密码
//return 用户职位 ，用户不存在返回" "

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
			
			//组织sql语句和参数列表
			String sql="select 人事资料.职位 from 登录,人事资料where 登录.员工号=人事资料."
					+ "员工号 and 登录.员工号=? and 登录.密码=？";
			String paras[]={uid,p};
			 sp=new SqlHelper();
			ResultSet rs1=sp.query(sql, paras);
			
			if(rs1.next())
			{
				//取出职位
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

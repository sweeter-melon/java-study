//ѧ����ģ��

package ��69��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MytableModel extends AbstractTableModel{

	Vector rowdata; //���������
	Vector columnNames;//�������
	
	 //�������ݿ�Ķ���
    PreparedStatement ps1=null;
    Connection ct1=null;
    ResultSet rs1=null;
	
    public void init(String sql)
    {
    	 columnNames=new Vector();
 		//��������
 		columnNames.add("ѧ��");
 		columnNames.add("����");
 		columnNames.add("�Ա�");
 		columnNames.add("����");
 		columnNames.add("����");
 		columnNames.add("ϵ��");
 		rowdata=new Vector();
 		
 		try {
 			
 			//1.��������
 			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
 			//2.����
 			ct1=DriverManager.getConnection
 		("jdbc:microsoft:sqlserver:"
 				+ "//127.0.0.1.1433;databasename=spdbl","sa","2509697407");
 			
 			//3.ִ��
 			ps1=ct1.prepareStatement(sql);
 			rs1=ps1.executeQuery();
 			
 			while(rs1.next())
 			{
 				Vector hang=new Vector();
 				hang.add(rs1.getString(1));
 				hang.add(rs1.getString(2));
 				hang.add(rs1.getString(3));
 				hang.add(rs1.getString(4));
 				hang.add(rs1.getString(5));
 				hang.add(rs1.getString(6));
 				rowdata.add(hang);
 			}
 			
 			
 		} catch (Exception e) {
 			// TODO: handle exception
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
 			} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		}
    }
    
    //ͨ�����ݵ�sql������������ģ��
    public MytableModel(String sql)
    {
    	this.init(sql);
    }
    
    
// ����һ������ģ�ͺ���
  public MytableModel() {
		// TODO Auto-generated constructor stub
	  this.init(" ");
	 
	}
    
    
	//�õ�������
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	//�õ�������
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowdata.size();
	}

	//�õ�ĳ��ĳ�е�����
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowdata.get(row)).get(column);
	}


	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(arg0);
	}

	

}

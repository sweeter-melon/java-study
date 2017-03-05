package 第21讲;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Demo2 {
                                           //异常抛出
	public static void main (String[] args)throws Exception {
		// TODO Auto-generated method stub

		/*演示比较的方法
		String a="abc";
		String b="abc";
		if(a.equals(b))
		{
			System.out.println("OK");
		}*/
		
		//创建员工对象
		EmpManage em=new EmpManage();
		
		//作出一个简易菜单
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("请选择你要进行的操作");
			System.out.println("1.表示添加一个雇员");
			System.out.println("2.表示查找一个雇员");
			System.out.println("3.修改一个雇员工资");
			System.out.println("4.删除一个雇员");
			System.out.println("5.退出系统");
			
			String opertype=br.readLine();
			if(opertype.equals("1"))
			{
				System.out.println("请输入编号");
				String number=br.readLine();
				System.out.println("请输入姓名");
				String name=br.readLine();
				System.out.println("请输入薪水");
				float sal=Float.parseFloat(br.readLine());
				Emp emp=new Emp(number, name, sal);
				em.addEmp(emp);
			}
			
			if(opertype.equals("2"))
			{
				System.out.println("请输入编号");
				String number=br.readLine();
				em.shouInfo(number);
			}
			
			if(opertype.equals("3"))
			{
				System.out.println("请输入编号");
				String number=br.readLine();
				
				System.out.println("请输入新的薪水");
				float newsal=Float.parseFloat(br.readLine());
				em.updateSal(number, newsal);
			}
			
			if(opertype.equals("4"))
			{
				System.out.println("请输入编号");
				String number=br.readLine();
				em.delete(number);
			}
			
			if(opertype.equals("5"))
			{
				System.exit(0);
			}
		}
	}

}

//雇员管理类

class EmpManage
{
	private ArrayList al =null;
	
	//构造函数
	public EmpManage()
	{
		al=new ArrayList();
		
	}
	
	//加入员工
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	
	//显示员工信息
	public void shouInfo(String number)
	{
		//遍历整个ArrayList
    for(int i=0;i<al.size();i++)
    {
    	//取出emp对象
    	Emp emp=(Emp)al.get(i);
    	
    	//比较编号
    	if(emp.getNumber().equals(number))
    	{
    		System.out.println("找到该员工，他的信息是：");
    		System.out.println("编号="+number);
    		System.out.println("名字="+emp.getName());
    		System.out.println("工资="+emp.getSal());
    	}
    	
    }
	}
	
	//修改工资
	
	public void updateSal(String number,float newsal)

	
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			if(emp.getNumber().equals(number))
			{
				//修改薪水
				emp.setSal(newsal);
			}
		}
	}

	//删除某个员工
	
	public void delete(String number)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			if(emp.getNumber().equals(number))
			{
				al.remove(i);
				//al.remove(emp) 两种都可以
				
			}
	}
	}
}

//雇员类
class Emp
{
	//学号
	private String number;
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	private String name;
	private float sal;
	
	//构造函数
	public Emp(String number,String name,float sal)
	{
		this.name=name;
		this.number=number;
		this.sal=sal;
	}
	
}


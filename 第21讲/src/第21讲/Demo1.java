//功能  java集合类的演示

package 第21讲;

//先引包
 import java.util.*;
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList al=new ArrayList();
		//显示大小
		System.out.println("al大小："+al.size());
		//向al中加入数据
		//创建一个职员
		Clerk clerk1=new Clerk("宋江",25,1000);
		Clerk clerk2=new Clerk("吴用",23,5000);
		Clerk clerk3=new Clerk("林冲",28,7000);
		//将clerk1加入al中
		al.add(clerk1);
		al.add(clerk2);
		al.add(clerk3);
		al.add(clerk2);
		//可不可以将人重复加入？？？   可以
		//显示大小
				System.out.println("al大小："+al.size());
				
				//访问al中对象
				//Clerk temp=(Clerk)al.get(0);//强制转换
				//System.out.println("第一个人名字:"+temp.getName());
				
				//遍历所有对象
				for(int i=0;i<al.size();i++)
				{
					Clerk temp=(Clerk)al.get(i);
					System.out.println("名字="+temp.getName());
				}
				
				//如何从al中删除对象
				al.remove(3);
				System.out.println("=====删除====");
				
				for(int i=0;i<al.size();i++)
				{
					Clerk temp=(Clerk)al.get(i);
					System.out.println("名字="+temp.getName());
				}
	}

}
//定义一个员工类
class Clerk
{
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	private int age;
	private float sal;
	
	Clerk(String name,int age,float sal)
	{
		this.age=age;
		this.name=name;
		this.sal=sal;
		
	}
}
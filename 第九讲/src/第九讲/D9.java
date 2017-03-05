package 第九讲;

import org.omg.CORBA.PUBLIC_MEMBER;

public class D9 {
	
static int i=1;
	
	static
	{
		//该静态区域块只被执行一次
		System.out.println("chufa");
		i++;
	}
	
	public D9()
	{
		System.out.println("test");
		i++;
	}
	public static void main(String[] args )
	{
		D9 t1=new D9();
		System.out.println(t1.i);
		
		D9 t2=new D9();
		System.out.println(t2.i);
		
		Student stu1=new Student(10, "andy", 5000);
		Student stu2=new Student(15, "baby", 4800);
		System.out.println(stu1.Gettotalfee());
		
		Clerk cl1=new Clerk("xiaohuang",25,586.9f);
	//System.out.println("名字是"+cl1.name+"薪水是"+cl1.salary);
	//私有的只能在类里面才能访问
System.out.println("名字是"+cl1.name+"    薪水是"+cl1.getsalary());
	}
}

class Student
{
	
	int age;
	String name;
	int fee;
	
	static int totalfee;
	
	public Student(int age,String name,int fee)
	{
		//age++;
		//totalfee++;
		this.age=age;
		this.name=name;
		totalfee+=fee;
	}
	
	//加上static的称为静态变量，否则称为实例变量
	public static int Gettotalfee()
	{
		//静态方法只能访问静态变量
		//age++;
		return totalfee;
	}
}

class Clerk
{
	public String name;
	private int age;
	private float salary;
	
	public Clerk(String name,int age,float salary)
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
	//通过一个成员方法去控制和访问私有成员
	
	public float getsalary()
	{
		return this.salary;
	}
}
 
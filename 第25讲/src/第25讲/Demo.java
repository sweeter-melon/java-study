package 第25讲;

import java.lang.reflect.Method; //反射包

public class Demo {

	public static void main(String []args)
	{
		
		//java的反射机制
		Gen<String> gen1=new Gen<String>("aaa");
		gen1.showTypename();
		
		Gen<Integer> gen2=new Gen<Integer>(1);  
		gen2.showTypename();
		
		Gen<Bird> gen3=new Gen<Bird>(new Bird());
		gen3.showTypename();
	}
	
}


//定义一个bird

class Bird
{
	public void test1()
	{
		System.out.println("aa");
	}
	
	public void count(int a,int b)
	{
	System.out.println(a+b);
	}
}

//定义一个类

class Gen<T>
{
	private T o;
	
	//构造函数
	
	public Gen(T a)
	{
		o=a;
	}
	//得到T的类型名称
	public void showTypename()
	{
		System.out.println("类型是："+o.getClass().getName());
	//通过反射机制可以得到T这个类型的很多信息
		//c得到成员函数名
	Method []m=o.getClass().getDeclaredMethods();
		
	//打印
	
	for(int i=0;i<m.length;i++)
	{
		System.out.println(m[i].getName());
	}
	}
}
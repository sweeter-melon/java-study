package ���彲;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.attribute.FileOwnerAttributeView;

public class D5 {
	
	public static void main(String[] args)
	{
/*		//��һֻè
		int cat1age=3;
		String cat1name="С��";----------------------------------------
		String cat1color="��ɫ"��
		
				//�ڶ�ֻè
				int cat1age=4;
				String cat1name="С��";
				String cat1color="��ɫ"��*/
		//����һ��è�Ķ���
		/*Cat cat1=new Cat();
		cat1.age=3;
		cat1.color="��ɫ";
		cat1.name="С��";
		
		Person a=new Person();
		a.age=10;
		a.name="С��";
		Person b;
		b=a;
		System.out.println(b.age);
		
		Person c;
		c=b;
		System.out.println(c.name);
		c.age=9;
		System.out.println("a.age "+a.age);
		System.out.println("b.age "+b.age);
		System.out.println("c.age "+c.age);
		*/
		Person p1=new Person("С��");
		p1.speack();
		p1.jisuan(5);
		p1.add(10, 20);
		int res=p1.add(10,20);
		System.out.println(res);
		System.out.println(p1.add3(2, 3.4f, 2.8f));
	}
		
		

}

class Cat{
	int age;
	String color;
	String name;
	
	Master mymaster;
	
}

class Master{
	
	int age;
	String address;
	String name;
}


class Person{
String name; 
int age;
public Person( String name,int age ) 
//�����������Ĺ��췽��
{ 
	name=name;
    age=age;
    //this.name=name;
    //this.age=age;
}
public Person()
{
	
}
public Person(String name)
{
	name=name;
	System.out.println("���ǹ���1");
}


	public void speack()
	{
		System.out.println("����һ������");
	}
	
	public void jisuan(int n)
	{  
		
		int result=0;
		for(int i=1;i<=n;i++)
		{
			result=result+i;
		}
		System.out.println("�����"+result);
	}
	
	/*public void add(int num1,int num2)
	{
		int num3=num1+num2;
		System.out.println(num3);
		
	}*/
	
	public int add( int num1,int num2)
{
	return num1+num2;
}
	
	public float add3(int num1,float num2,float num3)
	{
		return num1+num2+num3;
	}
	
}
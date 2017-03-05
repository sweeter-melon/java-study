
//说明继承的重要性

package zhangwenzhe;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Demo1 {
	
	public static void main(String []args)
	{
		
		Pupil p1=new Pupil();
		p1.pritname();
	}


}

//小学生类
class Pupil extends Stu
{
	/*
	//成员属性
	private int age;
	private String name;
	private float fee;
	*/
	//成员行为
	public void pay(float fee)
	{
		this.fee=fee;
	}
	
}

class Child extends Pupil
{
	//该类拥有了学生的所有属性和Pupil类的成员方法
	//继承的层次越低，功能越强大
	
}


//继承的层次没有限制
//将学生的共有属性提取出来一个父类来继承

//父类的public和protected的属性和方法被继承，private不能被继承


//编程中，若有某个属性不希望被继承，声明为private

//子类只能继承一个父类
//通过接口来解决不能多重继承的问题
class Stu
{
	//成员属性
	public int age;
	public String name;
	public float fee;
	
	public void pritname()
	{
		
		System.out.println("名字 "+this.name);
	}
	
	
}
//中学生类

class MidStu extends Stu
{
	/*
	//成员属性
		private int age;
		private String name;
		private float fee;
		*/
	
		//成员行为
		public void pay(float fee)
		{
			this.fee=fee*0.8f;
		}
	
}
//大学生类
class ColStu extends Stu
{
	/*
	//成员属性
			private int age;
			private String name;
			private float fee;
			
			*/
			//成员行为
			public void pay(float fee)
			{
				this.fee=fee*0.1f;
			}
	
}


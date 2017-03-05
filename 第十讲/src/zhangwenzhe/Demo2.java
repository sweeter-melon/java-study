package zhangwenzhe;

import javax.swing.*;
public class Demo2  extends JFrame{
	
public static void main(String []args)
{
	Demo2 d1=new Demo2();
	
}

public Demo2() {
	
	this.setVisible(true);
	this.setSize(400,400);
}


//重载

//重载注意事项
/*1.方法名相同
  2.方法的参数，个数，顺序至少有一项不同
  3.方法返回类型不同；
  4.方法修饰符不同



*/
class Abc
{
	//求较大数
	public int getmax(int i,int j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}
	
	public float getmax(float i,float j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}
	
	
	//如果只是返回类型不一样，不能够构成重载
	/*public double getmax(float i,float j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}*/
	
	//如果只是控制访问修饰符号不一样，不能够重载
	/*
	 protected float getmax(float i,float j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}
	*/
	 
	
	
	
}
}


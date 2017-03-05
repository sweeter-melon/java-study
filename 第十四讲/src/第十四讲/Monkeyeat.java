package 第十四讲;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Monkeyeat {
	public static void main(String []args)
	{
		while(true)
			{
			Showpeach ashow=new Showpeach();
		Monkeyeat.shenyu(ashow.total);
		System.out.println();
			}
		//Monkeyeat.scan();
		}
	//静态函数可以直接访问
	public static void scan()
	{
		System.out.println("请输入两个数");
		Scanner sr=new Scanner(System.in);
		int a=sr.nextInt();
		int b=sr.nextInt();
		
	}
	
	public static void shenyu(int shenyu)
	{
		
		
		
		 
		System.out.println("请输入第几天");
		Scanner sr=new Scanner(System.in);
		int n=sr.nextInt();
		for(int i=1;i<n;i++)
		{
			shenyu=(shenyu/2)-1;
		}
		System.out.println("该天还剩余"+shenyu);
		
	}
	
	

}

class Showpeach
{
	
 
 int total=1;
 
	public Showpeach()
	{ 
		
		for(int i=1;i<10;i++)
		{
			total=(total+1)*2;
		}
		
		System.out.println("苹果总数"+total);
	}
		
	
}
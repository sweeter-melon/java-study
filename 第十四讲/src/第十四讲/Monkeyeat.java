package ��ʮ�Ľ�;

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
	//��̬��������ֱ�ӷ���
	public static void scan()
	{
		System.out.println("������������");
		Scanner sr=new Scanner(System.in);
		int a=sr.nextInt();
		int b=sr.nextInt();
		
	}
	
	public static void shenyu(int shenyu)
	{
		
		
		
		 
		System.out.println("������ڼ���");
		Scanner sr=new Scanner(System.in);
		int n=sr.nextInt();
		for(int i=1;i<n;i++)
		{
			shenyu=(shenyu/2)-1;
		}
		System.out.println("���컹ʣ��"+shenyu);
		
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
		
		System.out.println("ƻ������"+total);
	}
		
	
}
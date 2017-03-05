package 第十五讲;

import java.util.Scanner;

public class Supermario {

	public static void main(String []args)
	{
		Scanner sr=new Scanner(System.in);
		System.out.println("输入1——25的数字，你可以移动Mario，输入其他数字退出");
		int i=sr.nextInt();
		Mario m=new Mario();
		for(int a=i;a<=25;a--)
		{
			if(i<=25)
			{
				m.move(i);
				i=sr.nextInt();
		}
			else{
				System.out.println("退出游戏");
				break;
			}
		}
	}
	
}


class Mario
{
	int x;
	int y;
	//构造方法，初始化场景，确定地面mario的位置
	
	public Mario()
	{
		System.out.println("I’m Mario"+"@");
		
	}
	
	public void move(int i)
	{
		for(int k=1;k<=25;k++)
		{
			if(k==i)
			{
				System.out.print("@");
			}
			else
			{
				System.out.print(" ");
			}
		}
	}
}

package ��ʮ�彲;

import java.util.Scanner;

public class Supermario {

	public static void main(String []args)
	{
		Scanner sr=new Scanner(System.in);
		System.out.println("����1����25�����֣�������ƶ�Mario���������������˳�");
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
				System.out.println("�˳���Ϸ");
				break;
			}
		}
	}
	
}


class Mario
{
	int x;
	int y;
	//���췽������ʼ��������ȷ������mario��λ��
	
	public Mario()
	{
		System.out.println("I��m Mario"+"@");
		
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

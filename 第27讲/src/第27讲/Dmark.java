package ��27��;

import java.util.Scanner;

public class Dmark {

	
	public static void main(String []args)
	{
		
		Judge judge=new Judge();
		
		System.out.println("�õ�ƽ����"+judge.lastFen());
		
		
		System.out.println("��˲����ǵ�"+(judge.getworst()+1)+"��");
	}
}


class Judge
{
	//����һ�����Դ��8��С��������
	//float arr[]=new float[8];
	
	float fens[]=null;
	int size=3;
	//���캯��
	public Judge()
	{
		fens=new float[size];
		//��ʼ��
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<fens.length;i++)
		{
			System.out.println("�������"+(i+1)+"�����гɼ�");
			fens[i]=scanner.nextFloat();
		}
	}
	
	
	//�õ������ί
	
	public int getworst()
	{
		float lastfen=this.lastFen();
		//����Ϊ��һ�����
		
		int worstindex=0;
		float ca=Math.abs(fens[0]-lastfen);
		
		float temca=0;
		for(int i=1;i<fens.length;i++)
		{
			if(ca<Math.abs(fens[i]-lastfen))
			{
				temca=Math.abs(fens[i]-lastfen);
				worstindex=i;
				ca=temca;
			}
		}
		
		return worstindex;
	}
	
	//�õ��˶�Ա���÷�
	
	public float lastFen()
	{
		float lastfen=0;
		float allfen=0;
		int minindex=this.getlowfenindex();
		int maxindex=this.gethighfenindex();
		for(int i=0;i<fens.length;i++)
		{
			if(i!=minindex&&i!=maxindex)
			{
				allfen+=fens[i];
			}
		}
		
		return allfen/(fens.length-2);
		
		//3.�õ�ƽ����
	}
	//1.���ҵ���ͷֵ��±꣩
	
	public int getlowfenindex()
	{
		//ѡ��
		//��Ϊ��һ������ͷ�
		
		float minfen=fens[0];
		int minindex=0;
		for(int i=0;i<fens.length;i++)
		{
			if(minfen>fens[i])
			{
				minfen=fens[i];
				minindex=i;
			}
		}
		
		return minindex;
	}
	
	//2.�ҵ���߷��±�
	
	public int gethighfenindex()
	{
		//ѡ��
		//��Ϊ��һ������߷�
		
		float maxfen=fens[size-1];
		int maxindex=size-1;
		for(int i=0;i<fens.length;i++)
		{
			if(maxfen<fens[i])
			{
				maxfen=fens[i];
				maxindex=i;
			}
		}
		
		return maxindex;
	}
	
}
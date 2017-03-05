package 第27讲;

import java.util.Scanner;

public class Dmark {

	
	public static void main(String []args)
	{
		
		Judge judge=new Judge();
		
		System.out.println("得到平均分"+judge.lastFen());
		
		
		System.out.println("最菜裁判是第"+(judge.getworst()+1)+"个");
	}
}


class Judge
{
	//定义一个可以存放8个小数的数组
	//float arr[]=new float[8];
	
	float fens[]=null;
	int size=3;
	//构造函数
	public Judge()
	{
		fens=new float[size];
		//初始化
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<fens.length;i++)
		{
			System.out.println("请输入第"+(i+1)+"个裁判成绩");
			fens[i]=scanner.nextFloat();
		}
	}
	
	
	//得到最菜评委
	
	public int getworst()
	{
		float lastfen=this.lastFen();
		//我认为第一个最菜
		
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
	
	//得到运动员最后得分
	
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
		
		//3.得到平均分
	}
	//1.（找到最低分的下标）
	
	public int getlowfenindex()
	{
		//选择法
		//认为第一个是最低分
		
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
	
	//2.找到最高分下标
	
	public int gethighfenindex()
	{
		//选择法
		//认为第一个是最高分
		
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
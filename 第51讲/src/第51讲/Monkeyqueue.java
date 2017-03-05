//猴子排队

//类的成员变量可以不初始化，但是局部变量要初始化

package 第51讲;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Monkeyqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//定义装5个猴子对象数组
		int size=3;
		
		Monkey monkeys[]=new Monkey[size];
		
		InputStreamReader isr1=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr1);
		
		for(int i=0;i<monkeys.length;i++)
		{
			System.out.println("请输入第"+(i+1)+"只猴子高度：");
			try {
				String height=bReader.readLine();
				float h=Float.parseFloat(height);
				monkeys[i]=new Monkey((i+1)+"",h);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		Monkey oldmonkey=new Monkey("1000", 0.6f);
		
		oldmonkey.sort(monkeys);
		
		oldmonkey.show(monkeys);
	}

}


class Monkey
{
	
	private String monkeyId;
	private float height;
	
	public Monkey(String monkeyId,float height)
	{
		this.monkeyId=monkeyId;
		this.height=height;
		
	}
	
	//排队
	
	public void sort(Monkey monkeys[])
	{
		float tempheight=0.0f;
		String tempNo="";
		
		for(int i=0;i<monkeys.length-1;i++)
		{
			for(int j=0;j<monkeys.length-1-i;j++)
			{
				if(monkeys[j].height>monkeys[j+1].height)
				{
					tempheight=monkeys[j].height;
					monkeys[j].height=monkeys[j+1].height;
					monkeys[j+1].height=tempheight;
					
					tempNo=monkeys[j].monkeyId;
					monkeys[j].monkeyId=monkeys[j+1].monkeyId;
					monkeys[j+1].monkeyId=tempNo;
				}
			}
		}
		
	}
	
	public void show(Monkey monkeys[])
	{
		System.out.println("1");
		for(int i=0;i<monkeys.length;i++)
		{
			System.out.println("猴子编号："+monkeys[i].monkeyId+"猴子体重："+monkeys[i].height);
		}
	}
	
}
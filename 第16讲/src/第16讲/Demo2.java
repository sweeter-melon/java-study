//功能 对象数组使用

package 第16讲;

import java.util.Scanner;

import org.w3c.dom.css.DocumentCSS;

public class Demo2 {

	public static void main(String []args)
	{
		//定义一个可以存放4只狗的对象数组
		Dog dogs[]=new Dog[4];
		//赋初值
		/*dogs[0]=new Dog();
		dogs[0].setName("花花");
		dogs[0].setWeight(4.8f);*/
		
		//从控制台输入各个狗信息
		
		for(int i=0;i<4;i++)
		{
			 dogs[i]=new Dog();
			System.out.println("请输入第"+(i+1)+"狗名");
			Scanner sr=new Scanner(System.in);
			String a1=sr.next();
			dogs[i].setName(a1);
			System.out.println("请输入第"+(i+1)+"狗的体重");
			float  a2=sr.nextFloat();
			dogs[i].setWeight(a2);
		}
		
		//计算体重平均值
		float allweight=0;
		for(int i=0;i<4;i++)
		{
			allweight+=dogs[i].getWeight();
		}
		System.out.println("平均体重"+allweight/dogs.length);
		
		//找出体重最大的一只狗
		float maxweight=0;
		int maxindex=0;
		for(int i=0;i<4;i++)
		{
			if(maxweight<dogs[i].getWeight())
			{
				maxweight=dogs[i].getWeight();
				maxindex=i+1;
			}
		}
		System.out.println("第"+maxindex+"只狗体重最大，为"+maxweight);
	}
}

//比较两个字符串是否相等时候，用equals,别用==
class Dog
{
	private String name;
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private float weight;
	
}
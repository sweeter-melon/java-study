//�����Ŷ�

//��ĳ�Ա�������Բ���ʼ�������Ǿֲ�����Ҫ��ʼ��

package ��51��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Monkeyqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//����װ5�����Ӷ�������
		int size=3;
		
		Monkey monkeys[]=new Monkey[size];
		
		InputStreamReader isr1=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr1);
		
		for(int i=0;i<monkeys.length;i++)
		{
			System.out.println("�������"+(i+1)+"ֻ���Ӹ߶ȣ�");
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
	
	//�Ŷ�
	
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
			System.out.println("���ӱ�ţ�"+monkeys[i].monkeyId+"�������أ�"+monkeys[i].height);
		}
	}
	
}
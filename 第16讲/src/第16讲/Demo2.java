//���� ��������ʹ��

package ��16��;

import java.util.Scanner;

import org.w3c.dom.css.DocumentCSS;

public class Demo2 {

	public static void main(String []args)
	{
		//����һ�����Դ��4ֻ���Ķ�������
		Dog dogs[]=new Dog[4];
		//����ֵ
		/*dogs[0]=new Dog();
		dogs[0].setName("����");
		dogs[0].setWeight(4.8f);*/
		
		//�ӿ���̨�����������Ϣ
		
		for(int i=0;i<4;i++)
		{
			 dogs[i]=new Dog();
			System.out.println("�������"+(i+1)+"����");
			Scanner sr=new Scanner(System.in);
			String a1=sr.next();
			dogs[i].setName(a1);
			System.out.println("�������"+(i+1)+"��������");
			float  a2=sr.nextFloat();
			dogs[i].setWeight(a2);
		}
		
		//��������ƽ��ֵ
		float allweight=0;
		for(int i=0;i<4;i++)
		{
			allweight+=dogs[i].getWeight();
		}
		System.out.println("ƽ������"+allweight/dogs.length);
		
		//�ҳ���������һֻ��
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
		System.out.println("��"+maxindex+"ֻ���������Ϊ"+maxweight);
	}
}

//�Ƚ������ַ����Ƿ����ʱ����equals,����==
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
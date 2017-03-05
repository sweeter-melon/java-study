package ��25��;

import java.lang.reflect.Method; //�����

public class Demo {

	public static void main(String []args)
	{
		
		//java�ķ������
		Gen<String> gen1=new Gen<String>("aaa");
		gen1.showTypename();
		
		Gen<Integer> gen2=new Gen<Integer>(1);  
		gen2.showTypename();
		
		Gen<Bird> gen3=new Gen<Bird>(new Bird());
		gen3.showTypename();
	}
	
}


//����һ��bird

class Bird
{
	public void test1()
	{
		System.out.println("aa");
	}
	
	public void count(int a,int b)
	{
	System.out.println(a+b);
	}
}

//����һ����

class Gen<T>
{
	private T o;
	
	//���캯��
	
	public Gen(T a)
	{
		o=a;
	}
	//�õ�T����������
	public void showTypename()
	{
		System.out.println("�����ǣ�"+o.getClass().getName());
	//ͨ��������ƿ��Եõ�T������͵ĺܶ���Ϣ
		//c�õ���Ա������
	Method []m=o.getClass().getDeclaredMethods();
		
	//��ӡ
	
	for(int i=0;i<m.length;i++)
	{
		System.out.println(m[i].getName());
	}
	}
}
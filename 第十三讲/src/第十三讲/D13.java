package ��ʮ����;

import org.omg.CORBA.PUBLIC_MEMBER;

public class D13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�����಻��ʵ����
    //Animal animal=new Animal();
	}

}

//�����һ��������
   abstract class Animal
{
	String name;
	int age;
	//������
	abstract public void cry();
	//���������û�г��󷽷�
	public void aaa()
	{
		System.out.println("1111");
	}
	
	
}
   
   //��һ����̳еĸ����ǳ����࣬
   // ����Ҫ�ѳ���������з���ʵ��
   class Cat extends Animal
   {
	   public void cry()
	   {
		   System.out.println("èè��");
	   }
   }
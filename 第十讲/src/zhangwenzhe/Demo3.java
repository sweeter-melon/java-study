
//�����̳�
package zhangwenzhe;

public class Demo3 {
	public static void main(String []args)
	{
		Cat cat1=new Cat();
		cat1.cry();
		Dog dog1=new Dog();
		dog1.cry();
	}

}

class Animal
{
	int age;
	String name;
	//������
	public void cry()
	{
		System.out.println("���Ƕ����֪����ô��");
	}
	
	
}


//èè��
class Cat extends Animal
{
	//���Ǹ��෽��
	//protected void cry()
	public void cry()
	{
		System.out.println("èè��");
	}
	
}
//���෽��������С���෽���ķ���Ȩ��

//������
class Dog extends Animal
{
	//���Ǹ��෽��
	public void cry()
	{
		System.out.println("������");
	}
	
}

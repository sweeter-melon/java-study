//����  ��ʾ�߳�ע������

//һ���̶߳�������������

package ��39��;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Cat cat=new Cat();
		cat.start();
		cat.start();
		*/
		Dog dog1=new Dog();
		Thread t1=new Thread(dog1);
		Thread t2=new Thread(dog1);
		t1.start();
		//t1.start();
		t2.start();
	}

}

class Cat extends Thread
{
	
	public void run()
	{
	
		System.out.println("11");
	}

}

class Dog extends Thread
{
	public void run()
	{
		
		System.out.println("22");
	}
	
	
}



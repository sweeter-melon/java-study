//��̬
//ͬһ�������ڲ�ͬ����µĶ���״̬


//��ν��̬������һ�����������ڲ�ͬ����µĶ���״̬
package ��ʮ����;

public class Duotai {

	public static void main(String []args)
	{
		/*
		Cat cat=new Cat();
		cat.cry();
		Dog dog=new Dog();
		dog.cry();
		*/
		//�������඼����ͨ��һ�����������ý��з���
		//java����������ñ����������������ʵ��
		Animal an=new Cat();
		an.cry();
		an=new Dog();
		an.cry();
		
		Master master=new Master();
		master.feed(new Dog(),new Bone());
	}
	
}

//
class Master
{
	//������ιʳ��ʹ�ö�̬������һ������
	public void feed(Animal an,Food f)
	{
		an.eat();
		f.showname();
		
	}
}
//������Animal

class Animal
{
	 String name;
	 int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void cry()
	{
		System.out.println("��֪����ô��");
	}
	
	public void eat()
	{
		
		System.out.println("��֪����ʲô");
	}
	
}


class Food
{
	String name;
	public void showname()
	{
		
	}
	
}

class Fish extends Food
{
	public void showname()
	{
		System.out.println("������");
	}
}

class Bone extends Food
{
	public void showname()
	{
		System.out.println("���ǹ�ͷ");
	}
}
class Cat extends Animal
{
	//è��
	public void cry()
	{
		System.out.println("è��");
	}
	
	public void eat()
	{
		System.out.println("è������");
		
		
	}
	
}

class Dog extends Animal
{
	//����
	public void cry()
	{
		System.out.println("����");
	}
	
	public void eat()
	{
		System.out.println("�����Թ�ͷ");
		
		
	}
	
}


//���͵ı�Ҫ��
package ��25��;

import java.util.ArrayList;

public class Demo1 {

	public  static void main(String []args)
	{
		ArrayList<Dog> al =new ArrayList<Dog>();
		//����һֻ��
		Dog Dog1=new Dog();
		al.add(Dog1);
		
		//ȡ��
		Dog temp=(Dog)al.get(0);
		//Cat temp1=(Cat)al.get(0);//����Ƿ����쳣��������
		Dog temp2=al.get(0);//����ǿ��ת���Ƚϰ�ȫ
	}
}


class Cat
{
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
}

class Dog
{
	private String name;
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
	private int age;
	
}


//泛型的必要性
package 第25讲;

import java.util.ArrayList;

public class Demo1 {

	public  static void main(String []args)
	{
		ArrayList<Dog> al =new ArrayList<Dog>();
		//创建一只狗
		Dog Dog1=new Dog();
		al.add(Dog1);
		
		//取出
		Dog temp=(Dog)al.get(0);
		//Cat temp1=(Cat)al.get(0);//这就是泛型异常，不报错
		Dog temp2=al.get(0);//不用强制转换比较安全
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

//多态
//同一种引用在不同情况下的多种状态


//所谓多态，就是一种引用类型在不同情况下的多种状态
package 第十二讲;

public class Duotai {

	public static void main(String []args)
	{
		/*
		Cat cat=new Cat();
		cat.cry();
		Dog dog=new Dog();
		dog.cry();
		*/
		//所有子类都可以通过一个父类来引用进行访问
		//java允许父类的引用变量引用他的子类的实例
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
	//给动物喂食，使用多态方法用一个就行
	public void feed(Animal an,Food f)
	{
		an.eat();
		f.showname();
		
	}
}
//动物类Animal

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
		System.out.println("不知道怎么叫");
	}
	
	public void eat()
	{
		
		System.out.println("不知道吃什么");
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
		System.out.println("我是鱼");
	}
}

class Bone extends Food
{
	public void showname()
	{
		System.out.println("我是骨头");
	}
}
class Cat extends Animal
{
	//猫叫
	public void cry()
	{
		System.out.println("猫叫");
	}
	
	public void eat()
	{
		System.out.println("猫爱吃鱼");
		
		
	}
	
}

class Dog extends Animal
{
	//狗叫
	public void cry()
	{
		System.out.println("狗叫");
	}
	
	public void eat()
	{
		System.out.println("狗爱吃骨头");
		
		
	}
	
}

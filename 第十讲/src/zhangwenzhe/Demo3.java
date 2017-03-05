
//方法继承
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
	//动物会叫
	public void cry()
	{
		System.out.println("我是动物，不知道怎么叫");
	}
	
	
}


//猫猫类
class Cat extends Animal
{
	//覆盖父类方法
	//protected void cry()
	public void cry()
	{
		System.out.println("猫猫叫");
	}
	
}
//子类方法不能缩小父类方法的访问权限

//狗狗类
class Dog extends Animal
{
	//覆盖父类方法
	public void cry()
	{
		System.out.println("狗狗叫");
	}
	
}

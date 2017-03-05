package 第十三讲;

import org.omg.CORBA.PUBLIC_MEMBER;

public class D13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//抽象类不能实例化
    //Animal animal=new Animal();
	}

}

//这就是一个抽象类
   abstract class Animal
{
	String name;
	int age;
	//动物会叫
	abstract public void cry();
	//抽象类可以没有抽象方法
	public void aaa()
	{
		System.out.println("1111");
	}
	
	
}
   
   //当一个类继承的父类是抽象类，
   // 则需要把抽象类的所有方法实现
   class Cat extends Animal
   {
	   public void cry()
	   {
		   System.out.println("猫猫叫");
	   }
   }
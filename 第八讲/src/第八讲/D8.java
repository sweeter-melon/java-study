package 第八讲;


//this的必要性
public class D8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog dog1=new Dog(4,"huang");
		
		Person p1=new Person(dog1,23,"guodegang");
		Person p2=new Person(dog1,25,"liuqian");
		p1.showInfo();
		p1.dog.showInfo();
		
		//int total=0;
		Children ch1=new Children(5, "xiaohong");
		ch1.joingame();
		//total++;
		
		Children ch2=new Children(6, "xiaohuang");
		ch2.joingame();
		
		
		Children ch3=new Children(9, "xiaoxiao");
		ch3.joingame();
		
		System.out.println("jieguoyou="+ch1.total);
		//total++;
		//封装，继承，多态，抽象
	}

}

class Person{
	int age;
	String name;
	Dog dog; //引用类型
	
	public Person(Dog dog,int age, String name)
	{
		this.age=age;
		this.name=name;
		this.dog=dog;
	}
	public Person()
	{
	
	}
	
	public void showInfo()
	{
		System.out.println("人名是"+this.name);
		
	}
				
	
}

class Dog{
	
	int age;
	String name;
	
	public Dog(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	
	public void showInfo()
	{
		System.out.println("狗名是"+this.name);
		
	}
}

class Children{
	
	int age;
	String name;
	static int total=0;
	public Children(int age,String name)
	{
		this.age=age;
		this.name=name;
		
	}
	
	public void joingame()
	{
		total++;
		System.out.println("have one child join");
	}
}
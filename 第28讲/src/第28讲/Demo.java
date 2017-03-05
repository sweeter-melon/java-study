package 第28讲;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Son son=new Son(1, "dd");
	}

}


class  Base
{
	
	int age;
	String name;
	public Base(int age,String name)
	{
		System.out.println("Base");
		this.age=age;
		this.name=name;
	}
	
	
}


//如果希望在子类中调用父类的构造方法，要求在子类的构造函数中调用
class Son extends Base
{
	public Son(int age,String name)
	{
		super(age,name);
		System.out.println("Son");
		
	}
}

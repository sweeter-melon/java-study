package ��28��;

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


//���ϣ���������е��ø���Ĺ��췽����Ҫ��������Ĺ��캯���е���
class Son extends Base
{
	public Son(int age,String name)
	{
		super(age,name);
		System.out.println("Son");
		
	}
}

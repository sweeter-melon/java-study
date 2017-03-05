package 第十四讲;

public class D14 {
	
	public static void main(String []args)
	{
		
		Carshop ashop=new Carshop();
		ashop.sellCar(new BMW());
		ashop.sellCar(new CherryQQ());
		System.out.println("总售价"+ashop.getMoney());
		Aaa one=new Aaa();
		one.showa();
		Bbb two=new Bbb();
		two.showa();
	}

}

interface Bird
{
	public void Fly();
}

interface Fish
{
	public void swimming();
}
class Monkey
{
	int age;
	//跳
	public void jump()
	{
		System.out.println("猴子会跳");
	}
	
}
//java是单继承
class Littermonkey extends Monkey implements Fish,Bird

{

	@Override
	public void swimming() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Fly() {
		// TODO Auto-generated method stub
		
	}
	
}
//汽车接口
interface Car
{
	//汽车名称
	String getName();
	//获得汽车售价
	int getPrice();
}

//宝马

class BMW implements Car
{
	public String getName()
	{
		return "BMW";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 300000;
	}
	
	
}

//奇瑞qq
class CherryQQ implements Car
{
	public String getName()
	{
		return "CherryQQ";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 20000;
	}
	
	
}
//汽车出售店
 class Carshop
{
	//售车收入
	private int money=0;
	//售车一部车
	public void sellCar(Car car)
	{
		
		
		System.out.println("车型"+car.getName()+"单价"+car.getPrice());
		money+=car.getPrice();
	}
	public int getMoney()
	{
		return money;
	}
	
}

class Aaa
{
	int a;
	//final修饰的变量必须赋初值，并且以后不能再赋值
	final float rate=3.1415926f;
	//给成员方法用final修饰表示不可以被修改
	final public void sendmessage()
	{
		System.out.println("发送消息");
	}
	public void showa()
	{
		//a不赋初值会默认为0；
		System.out.println("a=="+this.a);
	}
	
}
//要想类不被继承，在类前加个final;

//final class A();

class Bbb extends Aaa
{
	
	public Bbb()
	{
		a++;
		//用final修饰不能修改
		//rate++;
	}
	/*public void sendmessage()
	{
		System.out.println("发送消息");
	}*/
	
}


package ��ʮ�Ľ�;

public class D14 {
	
	public static void main(String []args)
	{
		
		Carshop ashop=new Carshop();
		ashop.sellCar(new BMW());
		ashop.sellCar(new CherryQQ());
		System.out.println("���ۼ�"+ashop.getMoney());
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
	//��
	public void jump()
	{
		System.out.println("���ӻ���");
	}
	
}
//java�ǵ��̳�
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
//�����ӿ�
interface Car
{
	//��������
	String getName();
	//��������ۼ�
	int getPrice();
}

//����

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

//����qq
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
//�������۵�
 class Carshop
{
	//�۳�����
	private int money=0;
	//�۳�һ����
	public void sellCar(Car car)
	{
		
		
		System.out.println("����"+car.getName()+"����"+car.getPrice());
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
	//final���εı������븳��ֵ�������Ժ����ٸ�ֵ
	final float rate=3.1415926f;
	//����Ա������final���α�ʾ�����Ա��޸�
	final public void sendmessage()
	{
		System.out.println("������Ϣ");
	}
	public void showa()
	{
		//a������ֵ��Ĭ��Ϊ0��
		System.out.println("a=="+this.a);
	}
	
}
//Ҫ���಻���̳У�����ǰ�Ӹ�final;

//final class A();

class Bbb extends Aaa
{
	
	public Bbb()
	{
		a++;
		//��final���β����޸�
		//rate++;
	}
	/*public void sendmessage()
	{
		System.out.println("������Ϣ");
	}*/
	
}


package 第十三讲;

public class D13_2 {
	
	public static void main(String[] args) 
	{
	
		//接口不能实例化
		//Usb usb=new Usb();
		System.out.print(Usb.a);
		Computer computer=new Computer();
		Camera camera=new Camera();
		Phone phone=new Phone();
		computer.useUsb(camera);
		computer.useUsb(phone);
	}

}

//一个接口
interface Kkk
{
	public void aaa();
}
//接口不能继承类
//接口可以继承其他接口
interface Usb extends Kkk
{
	//接口里面的成员变量都默认为static型
	//必须初始化
	int a=1;
	//接口里面成员方法不能有主体
	public void start();
	public void stop();
	
}

class Computer
{
	//使用usb接口
	public void useUsb(Usb usb)
	{
		usb.start();
		usb.stop();
	}
}

//当一个类实现一个接口，就必须把该接口的所有方法实现
//可以实现多个接口
class Camera implements Usb,Kkk
{
	public void start()
	{
		System.out.println("相机开始工作");
	}
	
	public void stop()
	{
		System.out.println("相机停止工作");
	}
	
	public void aaa()
	{
		System.out.println("1111");
	}
	
}

class Phone implements Usb
{
	public void start()
	{
		System.out.println("手机开始工作");
	}
	
	public void stop()
	{
		System.out.println("手机停止工作");
	}
	
	public void aaa()
	{
		System.out.println("1111");
	}
	
}
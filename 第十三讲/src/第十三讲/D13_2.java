package ��ʮ����;

public class D13_2 {
	
	public static void main(String[] args) 
	{
	
		//�ӿڲ���ʵ����
		//Usb usb=new Usb();
		System.out.print(Usb.a);
		Computer computer=new Computer();
		Camera camera=new Camera();
		Phone phone=new Phone();
		computer.useUsb(camera);
		computer.useUsb(phone);
	}

}

//һ���ӿ�
interface Kkk
{
	public void aaa();
}
//�ӿڲ��ܼ̳���
//�ӿڿ��Լ̳������ӿ�
interface Usb extends Kkk
{
	//�ӿ�����ĳ�Ա������Ĭ��Ϊstatic��
	//�����ʼ��
	int a=1;
	//�ӿ������Ա��������������
	public void start();
	public void stop();
	
}

class Computer
{
	//ʹ��usb�ӿ�
	public void useUsb(Usb usb)
	{
		usb.start();
		usb.stop();
	}
}

//��һ����ʵ��һ���ӿڣ��ͱ���Ѹýӿڵ����з���ʵ��
//����ʵ�ֶ���ӿ�
class Camera implements Usb,Kkk
{
	public void start()
	{
		System.out.println("�����ʼ����");
	}
	
	public void stop()
	{
		System.out.println("���ֹͣ����");
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
		System.out.println("�ֻ���ʼ����");
	}
	
	public void stop()
	{
		System.out.println("�ֻ�ֹͣ����");
	}
	
	public void aaa()
	{
		System.out.println("1111");
	}
	
}
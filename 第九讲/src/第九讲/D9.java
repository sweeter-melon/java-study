package �ھŽ�;

import org.omg.CORBA.PUBLIC_MEMBER;

public class D9 {
	
static int i=1;
	
	static
	{
		//�þ�̬�����ֻ��ִ��һ��
		System.out.println("chufa");
		i++;
	}
	
	public D9()
	{
		System.out.println("test");
		i++;
	}
	public static void main(String[] args )
	{
		D9 t1=new D9();
		System.out.println(t1.i);
		
		D9 t2=new D9();
		System.out.println(t2.i);
		
		Student stu1=new Student(10, "andy", 5000);
		Student stu2=new Student(15, "baby", 4800);
		System.out.println(stu1.Gettotalfee());
		
		Clerk cl1=new Clerk("xiaohuang",25,586.9f);
	//System.out.println("������"+cl1.name+"нˮ��"+cl1.salary);
	//˽�е�ֻ������������ܷ���
System.out.println("������"+cl1.name+"    нˮ��"+cl1.getsalary());
	}
}

class Student
{
	
	int age;
	String name;
	int fee;
	
	static int totalfee;
	
	public Student(int age,String name,int fee)
	{
		//age++;
		//totalfee++;
		this.age=age;
		this.name=name;
		totalfee+=fee;
	}
	
	//����static�ĳ�Ϊ��̬�����������Ϊʵ������
	public static int Gettotalfee()
	{
		//��̬����ֻ�ܷ��ʾ�̬����
		//age++;
		return totalfee;
	}
}

class Clerk
{
	public String name;
	private int age;
	private float salary;
	
	public Clerk(String name,int age,float salary)
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
	//ͨ��һ����Ա����ȥ���ƺͷ���˽�г�Ա
	
	public float getsalary()
	{
		return this.salary;
	}
}
 
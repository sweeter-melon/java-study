
//˵���̳е���Ҫ��

package zhangwenzhe;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Demo1 {
	
	public static void main(String []args)
	{
		
		Pupil p1=new Pupil();
		p1.pritname();
	}


}

//Сѧ����
class Pupil extends Stu
{
	/*
	//��Ա����
	private int age;
	private String name;
	private float fee;
	*/
	//��Ա��Ϊ
	public void pay(float fee)
	{
		this.fee=fee;
	}
	
}

class Child extends Pupil
{
	//����ӵ����ѧ�����������Ժ�Pupil��ĳ�Ա����
	//�̳еĲ��Խ�ͣ�����Խǿ��
	
}


//�̳еĲ��û������
//��ѧ���Ĺ���������ȡ����һ���������̳�

//�����public��protected�����Ժͷ������̳У�private���ܱ��̳�


//����У�����ĳ�����Բ�ϣ�����̳У�����Ϊprivate

//����ֻ�ܼ̳�һ������
//ͨ���ӿ���������ܶ��ؼ̳е�����
class Stu
{
	//��Ա����
	public int age;
	public String name;
	public float fee;
	
	public void pritname()
	{
		
		System.out.println("���� "+this.name);
	}
	
	
}
//��ѧ����

class MidStu extends Stu
{
	/*
	//��Ա����
		private int age;
		private String name;
		private float fee;
		*/
	
		//��Ա��Ϊ
		public void pay(float fee)
		{
			this.fee=fee*0.8f;
		}
	
}
//��ѧ����
class ColStu extends Stu
{
	/*
	//��Ա����
			private int age;
			private String name;
			private float fee;
			
			*/
			//��Ա��Ϊ
			public void pay(float fee)
			{
				this.fee=fee*0.1f;
			}
	
}


package zhangwenzhe;

import javax.swing.*;
public class Demo2  extends JFrame{
	
public static void main(String []args)
{
	Demo2 d1=new Demo2();
	
}

public Demo2() {
	
	this.setVisible(true);
	this.setSize(400,400);
}


//����

//����ע������
/*1.��������ͬ
  2.�����Ĳ�����������˳��������һ�ͬ
  3.�����������Ͳ�ͬ��
  4.�������η���ͬ



*/
class Abc
{
	//��ϴ���
	public int getmax(int i,int j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}
	
	public float getmax(float i,float j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}
	
	
	//���ֻ�Ƿ������Ͳ�һ�������ܹ���������
	/*public double getmax(float i,float j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}*/
	
	//���ֻ�ǿ��Ʒ������η��Ų�һ�������ܹ�����
	/*
	 protected float getmax(float i,float j)
	{
		if(i>j)
		{
			return i;
		}
		else {
			{
				return j;
			}
		}
	}
	*/
	 
	
	
	
}
}


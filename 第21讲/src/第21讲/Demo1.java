//����  java���������ʾ

package ��21��;

//������
 import java.util.*;
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList al=new ArrayList();
		//��ʾ��С
		System.out.println("al��С��"+al.size());
		//��al�м�������
		//����һ��ְԱ
		Clerk clerk1=new Clerk("�ν�",25,1000);
		Clerk clerk2=new Clerk("����",23,5000);
		Clerk clerk3=new Clerk("�ֳ�",28,7000);
		//��clerk1����al��
		al.add(clerk1);
		al.add(clerk2);
		al.add(clerk3);
		al.add(clerk2);
		//�ɲ����Խ����ظ����룿����   ����
		//��ʾ��С
				System.out.println("al��С��"+al.size());
				
				//����al�ж���
				//Clerk temp=(Clerk)al.get(0);//ǿ��ת��
				//System.out.println("��һ��������:"+temp.getName());
				
				//�������ж���
				for(int i=0;i<al.size();i++)
				{
					Clerk temp=(Clerk)al.get(i);
					System.out.println("����="+temp.getName());
				}
				
				//��δ�al��ɾ������
				al.remove(3);
				System.out.println("=====ɾ��====");
				
				for(int i=0;i<al.size();i++)
				{
					Clerk temp=(Clerk)al.get(i);
					System.out.println("����="+temp.getName());
				}
	}

}
//����һ��Ա����
class Clerk
{
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	private int age;
	private float sal;
	
	Clerk(String name,int age,float sal)
	{
		this.age=age;
		this.name=name;
		this.sal=sal;
		
	}
}
package ��21��;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Demo2 {
                                           //�쳣�׳�
	public static void main (String[] args)throws Exception {
		// TODO Auto-generated method stub

		/*��ʾ�Ƚϵķ���
		String a="abc";
		String b="abc";
		if(a.equals(b))
		{
			System.out.println("OK");
		}*/
		
		//����Ա������
		EmpManage em=new EmpManage();
		
		//����һ�����ײ˵�
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("��ѡ����Ҫ���еĲ���");
			System.out.println("1.��ʾ���һ����Ա");
			System.out.println("2.��ʾ����һ����Ա");
			System.out.println("3.�޸�һ����Ա����");
			System.out.println("4.ɾ��һ����Ա");
			System.out.println("5.�˳�ϵͳ");
			
			String opertype=br.readLine();
			if(opertype.equals("1"))
			{
				System.out.println("��������");
				String number=br.readLine();
				System.out.println("����������");
				String name=br.readLine();
				System.out.println("������нˮ");
				float sal=Float.parseFloat(br.readLine());
				Emp emp=new Emp(number, name, sal);
				em.addEmp(emp);
			}
			
			if(opertype.equals("2"))
			{
				System.out.println("��������");
				String number=br.readLine();
				em.shouInfo(number);
			}
			
			if(opertype.equals("3"))
			{
				System.out.println("��������");
				String number=br.readLine();
				
				System.out.println("�������µ�нˮ");
				float newsal=Float.parseFloat(br.readLine());
				em.updateSal(number, newsal);
			}
			
			if(opertype.equals("4"))
			{
				System.out.println("��������");
				String number=br.readLine();
				em.delete(number);
			}
			
			if(opertype.equals("5"))
			{
				System.exit(0);
			}
		}
	}

}

//��Ա������

class EmpManage
{
	private ArrayList al =null;
	
	//���캯��
	public EmpManage()
	{
		al=new ArrayList();
		
	}
	
	//����Ա��
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	
	//��ʾԱ����Ϣ
	public void shouInfo(String number)
	{
		//��������ArrayList
    for(int i=0;i<al.size();i++)
    {
    	//ȡ��emp����
    	Emp emp=(Emp)al.get(i);
    	
    	//�Ƚϱ��
    	if(emp.getNumber().equals(number))
    	{
    		System.out.println("�ҵ���Ա����������Ϣ�ǣ�");
    		System.out.println("���="+number);
    		System.out.println("����="+emp.getName());
    		System.out.println("����="+emp.getSal());
    	}
    	
    }
	}
	
	//�޸Ĺ���
	
	public void updateSal(String number,float newsal)

	
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			if(emp.getNumber().equals(number))
			{
				//�޸�нˮ
				emp.setSal(newsal);
			}
		}
	}

	//ɾ��ĳ��Ա��
	
	public void delete(String number)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			if(emp.getNumber().equals(number))
			{
				al.remove(i);
				//al.remove(emp) ���ֶ�����
				
			}
	}
	}
}

//��Ա��
class Emp
{
	//ѧ��
	private String number;
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	private String name;
	private float sal;
	
	//���캯��
	public Emp(String number,String name,float sal)
	{
		this.name=name;
		this.number=number;
		this.sal=sal;
	}
	
}



//���� zhangwenzhe
//���� �������������

package ����������;

import javax.xml.crypto.Data;

public class D11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cyclink cyclink=new Cyclink();
		cyclink.setlen(5);
		cyclink.setk(2);
		cyclink.setm(2);
		cyclink.creatlink();
		cyclink.show();
		cyclink.play();

	}

}

class Child
{
	int no;
	Child nextChild=null;
	public Child(int no)
	{
		//��һ�����
		this.no=no;
	}
}

//��������
class Cyclink
{
	//�ȶ���һ��ָ������ͷ������
	//ָ���һ��С�������ò��ܶ�;
	Child firstChild=null;
	Child temp=null;
	int len=0; //���ж���С��
	int k=0;
	int m=0;
	
	public void setm(int m)
	{
		this.m=m;
	}
	//���û��������С
	public void setlen(int len)
	{
	this.len=len;
	}
	
	//��ʼ��Ϸ
	public void play()
	{
		Child temp=this.firstChild;
		//1.���ҵ���ʼ������
		for(int i=1;i<k;i++)
		{
			temp=temp.nextChild;
		}
		//2.��m��
		while(this.len!=1)
		{
		for(int j=1;j<m;j++)
		{
			temp=temp.nextChild;
		}
			
		//�ҵ�Ҫ��Ȧ��ǰһ��С��
		Child temp2=temp;
		
		while(temp2.nextChild!=temp)
		{
			temp2=temp2.nextChild;
		}
		//3.������m��С���˳�Ȧ
		
		temp2.nextChild=temp.nextChild;
		//��tempָ����һ��������С��
		temp=temp.nextChild;
		//this.show();
		
		this.len--;
		}
		//���һ��С����ӡ����
		System.out.println("����� "+temp.no);
	}
	//���ôӵڼ����˿�ʼ����
	
	public void setk(int k)
	{
		this.k=k;
	}
	//��ʼ����������
	
	public void creatlink()
	{
		for(int i=1;i<=len;i++)
		{
			if(i==1)
			{
			//������һ��С��
			Child ch=new Child(i);
			this.firstChild=ch;
			this.temp=ch;
			}
			else
			{
				//�������һ��С��
				if(i==len)
				{
					Child ch=new Child(i);
					temp.nextChild=ch;
					temp=ch;
					temp.nextChild=this.firstChild;
				}
				else
				{
				//��������С��
				Child ch=new Child(i);
				temp.nextChild=ch;
				temp=ch;
				}
			}
		}
	}
	
	//��ӡ��������
	public void show()
	{
		//����һ��������
		Child temp=this.firstChild;
 do 
 {
	System.out.print(temp.no+" ");
	temp=temp.nextChild;
 } 
 while (temp!=this.firstChild);

		
	}
	
	
	
}


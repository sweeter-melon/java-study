//����   �������򷽷�

package ��ʮ�߽�;

import java.util.*;

public class D17 {

	public static void main(String []args)
	{
		int len=5;
		int arr[]=new int[len];
		
		for(int i=0;i<len;i++)
		{
			//�ó����������һ���������
			//Math.random���������0~1����
			int t=(int)(Math.random()*10000);
			arr[i]=t;
		}
		
		
		//������ǰ��ӡϵͳʱ��
		
		Calendar cal=Calendar.getInstance();
		System.out.println("����ǰ"+cal.getTime());
		//Select select=new Select();
		//select.sort(arr);
		//Bubble bubble=new Bubble();
		//bubble.sort(arr);//��������Ϊ����ʵ��
		Quicksort qs=new Quicksort();
		qs.sort(0, arr.length-1, arr);
	    cal=Calendar.getInstance();
		System.out.println("�����"+cal.getTime());
		
		
		//Insert insert=new Insert();
		//insert.sort(arr);
	}
}

class Bubble       //ð������
{
	
	//���򷽷�
	public void sort(int arr[])
	{
	 
		int temp;
		for(int i=0;i<arr.length-1;i++)
		{
			//���ѭ��������һ���߼���
			
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		
			
			
		}
		
		/*for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}*/
	}
}

class  Insert
{
	//  ����   ����
	
	public void sort(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int insertval=arr[i];
			//׼����ǰһ�����Ƚ�
			int index=i-1;
			while(index>=0&&insertval<arr[index])
			{
				//��arr[index]����ƶ���
				arr[index+1]=arr[index];
				index--;
			}
			arr[index+1]=insertval;
			
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	}
	
}









class Select
{
	//ѡ������
	public void sort(int arr[])
	{
		
		for(int i=0;i<arr.length-1;i++)
		{
	    int temp;
		int min=arr[i];//����Ϊ��һ����Ϊ��С
		int minindex=i;
		for(int j=i+1;j<arr.length;j++)
		{
			if(min>arr[j])
			{
				//�޸���С
				min=arr[j];
				minindex=j;
				
			}
		}
		//�˳�for���ҵ�������Сֵ
		temp=arr[i];
		arr[i]=arr[minindex];
		arr[minindex]=temp;
		
		
		}
		
		/*for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}*/
	}
	
}

//��������
class Quicksort
{
	public void sort(int left,int right,int array[])
	{
		int l=left;
		int r=right;
		int pivot=array[(left+right)/2];
		int temp=0;
		
		while(l<r)
		{
			while(array[l]<pivot) l++;
			while(array[r]>pivot) r--;
			
			if(l>=r) break;
			
			temp=array[l];
			array[l]=array[r];
			array[r]=temp;
			
			if(array[l]==pivot) --r;
			if(array[r]==pivot) ++l;
		}
		
		for(int i=0;i<array.length;i++)
		{
		System.out.println(array[i]);
		}
		
		if(l==r)
		{
			l++;
			r--;
		}
		
		if(left<r) sort(left,r,array);
		if(right>l) sort(l, right, array);
		
		
	}
	
}

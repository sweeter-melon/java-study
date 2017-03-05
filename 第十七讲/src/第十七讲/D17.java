//功能   各种排序方法

package 第十七讲;

import java.util.*;

public class D17 {

	public static void main(String []args)
	{
		int len=5;
		int arr[]=new int[len];
		
		for(int i=0;i<len;i++)
		{
			//让程序随机产生一个随机的数
			//Math.random会随机产生0~1的数
			int t=(int)(Math.random()*10000);
			arr[i]=t;
		}
		
		
		//在排序前打印系统时间
		
		Calendar cal=Calendar.getInstance();
		System.out.println("排序前"+cal.getTime());
		//Select select=new Select();
		//select.sort(arr);
		//Bubble bubble=new Bubble();
		//bubble.sort(arr);//数组名做为函数实参
		Quicksort qs=new Quicksort();
		qs.sort(0, arr.length-1, arr);
	    cal=Calendar.getInstance();
		System.out.println("排序后"+cal.getTime());
		
		
		//Insert insert=new Insert();
		//insert.sort(arr);
	}
}

class Bubble       //冒泡排序
{
	
	//排序方法
	public void sort(int arr[])
	{
	 
		int temp;
		for(int i=0;i<arr.length-1;i++)
		{
			//外层循环，决定一共走几趟
			
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
	//  插入   排序
	
	public void sort(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int insertval=arr[i];
			//准备和前一个数比较
			int index=i-1;
			while(index>=0&&insertval<arr[index])
			{
				//将arr[index]向后移动；
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
	//选择排序
	public void sort(int arr[])
	{
		
		for(int i=0;i<arr.length-1;i++)
		{
	    int temp;
		int min=arr[i];//我认为第一个数为最小
		int minindex=i;
		for(int j=i+1;j<arr.length;j++)
		{
			if(min>arr[j])
			{
				//修改最小
				min=arr[j];
				minindex=j;
				
			}
		}
		//退出for就找到本次最小值
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

//快速排序法
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

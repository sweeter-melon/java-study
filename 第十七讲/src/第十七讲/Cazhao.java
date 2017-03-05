//功能   二分查找
// 二分查找必须是有序的
package 第十七讲;

import java.util.Scanner;

public class Cazhao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]={2,5,7,12,24} ;
		System.out.println("请输入你要查找的数");
		Scanner scanner=new Scanner(System.in);
		int val=scanner.nextInt();
		Binaryfind binaryfind=new Binaryfind();
		binaryfind.find(0, arr.length, val, arr);
		
	}

}

class Binaryfind
{
	//二分查找
	public void find(int leftindex,int rightindex,int val,int arr[])
	{
	//首先找到中间的数
		int midindex=(rightindex+leftindex)/2;
		int midval=arr[midindex];
		//如果找到数比midval大
		if(rightindex>=leftindex)
		{
		if(midval>val)
		{
			//在arr数组的左边去找
			find(leftindex,midindex-1,val,arr);
		}
		if(midval<val)
		{
			//去右边找
			find(midindex+1,rightindex,val,arr);
		}
		
		if(midval==val)
		{
			System.out.println("找到下标"+midindex);
		}
		}
	}
	
}
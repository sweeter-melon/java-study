//����   ���ֲ���
// ���ֲ��ұ����������
package ��ʮ�߽�;

import java.util.Scanner;

public class Cazhao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]={2,5,7,12,24} ;
		System.out.println("��������Ҫ���ҵ���");
		Scanner scanner=new Scanner(System.in);
		int val=scanner.nextInt();
		Binaryfind binaryfind=new Binaryfind();
		binaryfind.find(0, arr.length, val, arr);
		
	}

}

class Binaryfind
{
	//���ֲ���
	public void find(int leftindex,int rightindex,int val,int arr[])
	{
	//�����ҵ��м����
		int midindex=(rightindex+leftindex)/2;
		int midval=arr[midindex];
		//����ҵ�����midval��
		if(rightindex>=leftindex)
		{
		if(midval>val)
		{
			//��arr��������ȥ��
			find(leftindex,midindex-1,val,arr);
		}
		if(midval<val)
		{
			//ȥ�ұ���
			find(midindex+1,rightindex,val,arr);
		}
		
		if(midval==val)
		{
			System.out.println("�ҵ��±�"+midindex);
		}
		}
	}
	
}
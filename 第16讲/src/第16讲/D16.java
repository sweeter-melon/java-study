package ��16��;

public class D16 {

	public static void main(String []args)
	{
		
		//����һ�����Դ��6��float���͵�����
		
		float arr[]=new float[6];
		
		arr[0]=3;//�;����Զ���߾���ת��
		arr[1]=5;
		arr[2]=1;
		arr[3]=3.4f;
		arr[4]=1;
		arr[5]=20;
		
		//����������
		float all=0;
		for(int i=0;i<6;i++)
		{
			all+=arr[i];
		}
		
		System.out.println(all);
		
		//����һ��sizeΪ5��int����
		int [] arr1;//int arr1[];
		arr1=new int[5];
		
		//�������
		float arr2[]={6,3,3.4f,90,7.1f,5};
		float all2=0;
		for(int i=0;i<arr2.length;i++)
		{
			all2+=arr2[i];
		}
		System.out.println("ƽ���ɼ�"+all2/arr.length);
	}
	

}

package 第16讲;

public class D16 {

	public static void main(String []args)
	{
		
		//定义一个可以存放6个float类型的数组
		
		float arr[]=new float[6];
		
		arr[0]=3;//低精度自动向高精度转换
		arr[1]=5;
		arr[2]=1;
		arr[3]=3.4f;
		arr[4]=1;
		arr[5]=20;
		
		//计算总体重
		float all=0;
		for(int i=0;i<6;i++)
		{
			all+=arr[i];
		}
		
		System.out.println(all);
		
		//定义一个size为5的int数组
		int [] arr1;//int arr1[];
		arr1=new int[5];
		
		//滑板比赛
		float arr2[]={6,3,3.4f,90,7.1f,5};
		float all2=0;
		for(int i=0;i<arr2.length;i++)
		{
			all2+=arr2[i];
		}
		System.out.println("平均成绩"+all2/arr.length);
	}
	

}

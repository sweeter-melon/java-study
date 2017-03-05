package 第19讲;

public class D19 {

	
	public static void main(String []args)
	{
		
		int a[][]=new int[4][5];
		
		
		
		//数组默认值为零
		/*for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				a[i][j]=0;
			}
		}*/
		a[1][2]=1;
		a[2][1]=2;
		a[2][3]=3;
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(" "+a[i][j]+"");
			}
			System.out.println();
		}
	}
}

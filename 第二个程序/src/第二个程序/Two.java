package 第二个程序;

import java.io.*;


public class Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*int a=2;
		int b=4;
		if(b%a==0)
		{
			System.out.println("可以整除");
		}
		else
		{
			System.out.println("不可以整除");
		}
	}
*/
		/*int a=3;
		int b=++((++a)--);
		System.out.println(b);
*/
	
		
			try {
				InputStreamReader isr= new InputStreamReader(System.in);
				
				BufferedReader br= new BufferedReader(isr);
				//从控制台读取一行数据；
				System.out.println("请输入第一个数");
				String a1=br.readLine();
				
				System.out.println("请输入第二个数");
				String a2=br.readLine();
				
				
				float num1=Float.parseFloat(a1);
				float num2=Float.parseFloat(a2);
				
				if(num1>num2)
				{
					System.out.println("第一个大");
					
				}
				
				if(num1==num2)
				{
					System.out.println("一样大");
				}
				
				if(num1<num2)
				{
					System.out.println("第二个大");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//标准输入
}

}

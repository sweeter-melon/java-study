package �ڶ�������;

import java.io.*;


public class Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*int a=2;
		int b=4;
		if(b%a==0)
		{
			System.out.println("��������");
		}
		else
		{
			System.out.println("����������");
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
				//�ӿ���̨��ȡһ�����ݣ�
				System.out.println("�������һ����");
				String a1=br.readLine();
				
				System.out.println("������ڶ�����");
				String a2=br.readLine();
				
				
				float num1=Float.parseFloat(a1);
				float num2=Float.parseFloat(a2);
				
				if(num1>num2)
				{
					System.out.println("��һ����");
					
				}
				
				if(num1==num2)
				{
					System.out.println("һ����");
				}
				
				if(num1<num2)
				{
					System.out.println("�ڶ�����");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//��׼����
}

}

package ���Ľ�;

public class D4 {

	public static void main(String[] args) {
		
		/*char c='a';
		switch(c)
		{
		case 'a':
		{
		System.out.println("����һ");
		int a=1;
		int b=3;
		int d=a+b;
		System.out.println(d);
		break;
		}
		case 'b':
		{
		System.out.println("���ڶ�");
		break;
		}
		case 'c':
		{
		System.out.println("������");
		break;
		}
		default:
			System.out.println("��֪��");
		    break;
		}*/
		// TODO Auto-generated method stub
   //��ȥ����->���߲�//�������
		/*int lay=7;
		for(int i=1;i<=lay;i++)
		{
			for(int k=1;k<=lay-i;k++)
			{
			System.out.print(" ");
			}
			for(int j=1;j<=(i-1)*2+1;j++)
			{
				System.out.print("*");//������
				
			}
			System.out.println();//����
		}*/
			
		//���οս�����
		int lay=7;
		int i;
		for( i=1;i<=lay;i++)
		{
			for(int k=1;k<=lay-i;k++)
			{
			System.out.print(" ");
			}
			for(int j=1;j<=(i-1)*2+1;j++)
			{
				if(i==1||i==lay)
						{
				System.out.print("*");//������
						}
				else 
					{
						if(j==1||j==(i-1)*2+1)
						{
							System.out.print("*");
					}
						else
						{
							System.out.print(" ");
						}
				}
			}
			System.out.println();//����
		}
		
	
		
	}

}

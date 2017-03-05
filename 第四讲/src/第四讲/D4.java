package 第四讲;

public class D4 {

	public static void main(String[] args) {
		
		/*char c='a';
		switch(c)
		{
		case 'a':
		{
		System.out.println("星期一");
		int a=1;
		int b=3;
		int d=a+b;
		System.out.println(d);
		break;
		}
		case 'b':
		{
		System.out.println("星期二");
		break;
		}
		case 'c':
		{
		System.out.println("星期三");
		break;
		}
		default:
			System.out.println("不知道");
		    break;
		}*/
		// TODO Auto-generated method stub
   //死去活来->打七层//打金字塔
		/*int lay=7;
		for(int i=1;i<=lay;i++)
		{
			for(int k=1;k<=lay-i;k++)
			{
			System.out.print(" ");
			}
			for(int j=1;j<=(i-1)*2+1;j++)
			{
				System.out.print("*");//不换行
				
			}
			System.out.println();//换行
		}*/
			
		//打镂空金字塔
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
				System.out.print("*");//不换行
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
			System.out.println();//换行
		}
		
	
		
	}

}

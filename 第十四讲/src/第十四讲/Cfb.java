package µÚÊ®ËÄ½²;

public class Cfb {
	public static void main(String []args)
	{
		Show aShow=new Show(9);
		
		
	}

} 
     class Show
{
    	public Show(int n) 
    	{
    	 for(int i=1;i<=n;i++)
 		{
 			for(int j=1;j<=i;j++)
 			{
 				System.out.print(j+"*"+i+"="+j*i+" ");
 				
 			}
 			System.out.println();
 		}
    	}
}
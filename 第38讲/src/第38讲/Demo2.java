package µÚ38½²;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog dog=new Dog();
		
		Thread t=new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable
{
	public void run() 
	{
		
		int times=0;
		
		while(true)
		{
			//ÐÝÃßÒ»Ãë
			
			try 
			{
				
				Thread.sleep(1000);
			} catch (Exception e) 
			{
				// TODO: handle exception
			}
			times++;
			System.out.println("hello world"+times);
		}
	}
}
package 第39讲;

//同时启动两个线程

public class Demo3 {

	public static void main(String []args)
	{
		Pig pig=new Pig(10);
		Bird bird=new Bird(10);
		Thread t1=new Thread(pig);
		Thread t2=new Thread(bird);
		t1.start();
		t2.start();
	}
}

class Pig implements Runnable
{
int n=0;
int times=0;
	
 public Pig(int n) {
	this.n=n;
	 // TODO Auto-generated constructor stub
}
	@Override
	public void run() {
		
		while(true)
		{// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		times++;
		System.out.println("输出第"+times);
		
		if(times==n)
		{
			break;
		}
	}
	
}
}

class Bird implements Runnable
{

	int n=0;
	int res=0;
	int times=0;
	 public Bird(int n) 
	 {
	
		this.n=n;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			res+=(times++);
			System.out.println("本次结果"+res);
			
			if(times==n)
			{
				System.out.println("最后结果是"+res);
				break;
				
			}
		}
	}
}

	
	

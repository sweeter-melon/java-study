//通过继承thread来开发线程

package 第38讲;

public class Demo1 {

	public static void main()
	{
		Cat cat=new Cat();
		//启动线程，导致run函数运行
		cat.start();
	}
	
}


class Cat extends Thread
{
	int times=0;
	//重写run函数
	public void run()
	{
		while(true)
		{
			//休眠一秒
			//sleep会让线程进入阻塞状态，并释放资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("hello world"+times);
			
			if(times==10)
			{
				break;
			}
		}
		
	}
	
}
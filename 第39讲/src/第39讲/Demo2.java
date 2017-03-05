package 第39讲;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*   
		//定义三个售票窗口
		Ticketwindow tw1=new Ticketwindow();
		Ticketwindow tw2=new Ticketwindow();
		Ticketwindow tw3=new Ticketwindow();
		
		Thread  t1=new Thread(tw1);
		Thread  t2=new Thread(tw2);
		Thread  t3=new Thread(tw3);
		

		t1.start();
		t2.start();
		t3.start();
		*/
		
		//使用三个线程启动
		
		Ticketwindow tw1=new Ticketwindow();
		
		Thread  t1=new Thread(tw1);
		Thread  t2=new Thread(tw1);
		Thread  t3=new Thread(tw1);
		

		t1.start();
		t2.start();
		t3.start();
	}

}


class Ticketwindow implements Runnable
{

	
	private int nums=10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			
			
			//认为if else 要保证原子性
			synchronized (this)  //对象锁
			{	
			if(nums>0)
			{
				
				System.out.println(Thread.currentThread().getName()+" 正在售出第"+nums+"张票");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				nums--;
			}
			
			else
			{
			break;	
			}
		}
		}
		
	}
	//一共2000张票
	
}
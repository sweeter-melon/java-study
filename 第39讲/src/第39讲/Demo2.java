package ��39��;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*   
		//����������Ʊ����
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
		
		//ʹ�������߳�����
		
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
			
			
			//��Ϊif else Ҫ��֤ԭ����
			synchronized (this)  //������
			{	
			if(nums>0)
			{
				
				System.out.println(Thread.currentThread().getName()+" �����۳���"+nums+"��Ʊ");
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
	//һ��2000��Ʊ
	
}
//ͨ���̳�thread�������߳�

package ��38��;

public class Demo1 {

	public static void main()
	{
		Cat cat=new Cat();
		//�����̣߳�����run��������
		cat.start();
	}
	
}


class Cat extends Thread
{
	int times=0;
	//��дrun����
	public void run()
	{
		while(true)
		{
			//����һ��
			//sleep�����߳̽�������״̬�����ͷ���Դ
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
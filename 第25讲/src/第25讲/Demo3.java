package ��25��;

import java.io.FileReader;
import java.net.Socket;

public class Demo3 {

	
	public static void main(String []args)
	{
		FileReader fReader=null;
		//����쳣1 .���ļ�
		try {
			
			System.out.println("sss");
			 fReader=new FileReader("d:\\aa.text");
			
			//���׳��쳣�ĵط�����ִֹ�У�����catch���
			//System.out.println("go on"); ��ִ����仰
		//����ж��catch��䣬�ͽ���ƥ���쳣�Ǹ�catch
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			//���쳣��Ϣ����������ų�bug
			//System.out.println("message="+e.getMessage());Ҳ���Դ�ӡ����
			e.printStackTrace();
		}
		
		//����
		//finally����һ���ᱻִ��
		finally{
			
			//������飬������û���쳣����ִ��
			//һ��˵������Ҫ�رյ���Դ[�ļ������ӣ��ڴ档����]
			
			if(fReader!=null)
			{
				
				try {
					fReader.close();
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}
		
		//ֻ��try ��finally���Ҳ����ִ��
		
		System.out.println("OK1");  
	
		//�����쳣  2.����һ��192.168.12.12 ip�Ķ˿ں�4567
		//Socket socket=new Socket("192.168.1.23",78);
	
		
		//�����쳣 3
		//int a=4/0;   û�д��󣬵��ǲ�������
		
		//int arr[]={1,2,3};
		//����Խ��
		//System.out.println(arr[8]);
	}
}

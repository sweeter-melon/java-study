package 第25讲;

import java.io.FileReader;
import java.net.Socket;

public class Demo3 {

	
	public static void main(String []args)
	{
		FileReader fReader=null;
		//检查异常1 .打开文件
		try {
			
			System.out.println("sss");
			 fReader=new FileReader("d:\\aa.text");
			
			//在抛出异常的地方就终止执行，进入catch语句
			//System.out.println("go on"); 不执行这句话
		//如果有多个catch语句，就进入匹配异常那个catch
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			//把异常信息输出，利于排除bug
			//System.out.println("message="+e.getMessage());也可以打印错误
			e.printStackTrace();
		}
		
		//处理
		//finally代码一定会被执行
		finally{
			
			//这个语句块，不管有没有异常都会执行
			//一般说，把需要关闭的资源[文件，连接，内存。。。]
			
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
		
		//只有try 和finally语句也可以执行
		
		System.out.println("OK1");  
	
		//连接异常  2.连接一个192.168.12.12 ip的端口号4567
		//Socket socket=new Socket("192.168.1.23",78);
	
		
		//运行异常 3
		//int a=4/0;   没有错误，但是不能运行
		
		//int arr[]={1,2,3};
		//数组越界
		//System.out.println(arr[8]);
	}
}

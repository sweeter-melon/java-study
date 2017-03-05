package 第26讲;

import java.io.File;
import java.io.FileReader;

public class D26 {

	public static void main(String []args)
	{
		Father father=new Father();
		father.test1();
	}
}



//可以一层一层往上抛，丢给虚拟机处理
class Father
{
	
	private Son son=null;
	
	public Father()
	{
		son=new Son();
	}
	public void test1()
	{
		System.out.println("1");
		
		try {
			son.test2();//要想调用这个函数，必须捕获，不能抛出
		} 
		catch (Exception e) {
			
			// TODO: handle exception
			System.out.println("father handle");
			e.printStackTrace();
		}
		
	}
}

class Son
{
	public void test2()throws Exception
	{
		FileReader fr=null;
		fr=new FileReader("d:\\dd.txt");
	}
	
}
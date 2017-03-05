//演示FileInputstream类的使用

//从文件读取并显示出来
package 第44讲;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		File file=new File("d:\\aa.txt");
//		
//		//因为File没有读写的能力，要用Inputstream流
//		FileInputStream fis =null;
//		
//		try {
//			 fis =new FileInputStream(file);
//			
//			//定义一个字节数组,相当于缓存
//			byte bytes[]=new byte[1024];
//			int n=0; //得到实际读取到的字节数
//			//循环读取
//			while((n=fis.read(bytes))!=-1)  //-1表示读到末尾文件
//			{
//				//把字节转成string
//				String s=new String(bytes, 0, n);
//				System.out.println(s);
//			}
//		} 
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			//关闭文件流必须放到finally
//			try {
//				fis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		   
//		}
	}

}

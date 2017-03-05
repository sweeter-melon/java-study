
//从键盘写入文件里面

package 第44讲;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file=new File("d:\\mm.txt"); //如果没有mm这个文件，会自己新建一个
		
		//字节输出流
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(file);
			
			String s="hello world\r\n";//\r\n表示回车换行
			String s1="china good";
			//定义字节数组
			//byte bytes[]=new byte[1024];
			//如何把String->bytes数组
			fos.write(s.getBytes());
			fos.write(s1.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

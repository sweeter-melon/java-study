//功能：File类的基本用法

package 第44讲;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		//创建一个文件对象
//		File file= new File("d:\\aa.txt");
//		//File file= new File("d:/aa.txt");
//		//得到文件路径
//		
//		System.out.println("文件路径"+file.getAbsolutePath());
//		//得到文件大小，字节数
//		System.out.println("文件大小"+file.length());
		
		//创建文件
//		File file=new File("d:\\ff\\hsp.txt");
//		
//		if(!file.exists())
//		{
//			//可以创建
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//		System.out.println("有文件，不能创建");	
//		}
		
		//创建文件夹
		
//		File file=new File("d:\\ff");
//		//File file=new File("d:/ff");都可以
//		
//		if(file.isDirectory())
//		{
//			System.out.println("文件夹已存在");
//		}
//		
//		else
//		{
//			//创建文件夹
//			file.mkdir();
//		}
		
		
		//列出一个文件夹下面的所有文件
//		
//		File file=new File("d:\\ff");
//		
//		if(file.isDirectory())
//		{
//		File lists[]=file.listFiles();
//		
//		for(int i=0;i<lists.length;i++)
//		{
//			System.out.println("文件名"+lists[i]);
//		}
//		}
	}

}

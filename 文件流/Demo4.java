
//ͼƬ����

package ��44��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {

	
	public static void main(String []args)
	{
		//˼·  �Ȱ�ͼƬ���뵽�ڴ棬д��ĳ�ļ�
		//�Զ��������
		
		File f1=new File("d:\\a.jpg");
		File f2=new File("d:\\b.jpg");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(f1);
			fos=new FileOutputStream(f2);
			byte bytes[]=new byte[1024];
			//ѭ����ȡ
			int n=0;
		   while((n=fis.read(bytes))!=-1)
		   {
			   //�����ָ���ļ�
			   fos.write(bytes);
		   }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

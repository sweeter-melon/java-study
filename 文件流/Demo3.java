
//�Ӽ���д���ļ�����

package ��44��;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file=new File("d:\\mm.txt"); //���û��mm����ļ������Լ��½�һ��
		
		//�ֽ������
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(file);
			
			String s="hello world\r\n";//\r\n��ʾ�س�����
			String s1="china good";
			//�����ֽ�����
			//byte bytes[]=new byte[1024];
			//��ΰ�String->bytes����
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

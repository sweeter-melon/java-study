
//��ʾ�ļ��ַ���

package ��44��;

import java.io.FileReader;
import java.io.FileWriter;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�ļ���ȡ�ַ���������������
		FileReader fr=null;
		
		//�ļ�д�루�������
		FileWriter fw=null;
		
		try {
			//��������
			fr=new FileReader("d:\\text.txt");
			fw=new FileWriter("d:\\h.txt");
			//���뵽�ڴ�
			char c[]=new char[1024];
			
			int n=0; //��¼ʵ�ʶ�ȡ�����ַ���
			while((n=fr.read(c))!=-1)
			{
//				String s=new String(c, 0, n);
//				System.out.println(s);
				//�����ָ���ļ�
			fw.write(c,0,n);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				fr.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}

//�ļ������ַ���

package ��44��;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			//�ȴ���һ��FileReader����
			FileReader fr=new FileReader("d:\\text.txt");
			br=new BufferedReader(fr);
			
			
			FileWriter fw=new FileWriter("d:\\x.txt");
			bw=new BufferedWriter(fw);
			//ѭ����ȡ
			String s="";
			while((s=br.readLine())!=null)
			{
				//System.out.println(s);
				bw.write(s+"\r\n");  //�����뻻����ֹ��
				//���������
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
			try {
				
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

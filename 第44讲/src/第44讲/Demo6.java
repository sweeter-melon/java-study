//文件缓冲字符流

package 第44讲;

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
			//先创建一个FileReader对象
			FileReader fr=new FileReader("d:\\text.txt");
			br=new BufferedReader(fr);
			
			
			FileWriter fw=new FileWriter("d:\\x.txt");
			bw=new BufferedWriter(fw);
			//循环读取
			String s="";
			while((s=br.readLine())!=null)
			{
				//System.out.println(s);
				bw.write(s+"\r\n");  //不读入换行终止符
				//输出到磁盘
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


//演示文件字符流

package 第44讲;

import java.io.FileReader;
import java.io.FileWriter;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//文件读取字符流对象（输入流）
		FileReader fr=null;
		
		//文件写入（输出流）
		FileWriter fw=null;
		
		try {
			//创建对象
			fr=new FileReader("d:\\text.txt");
			fw=new FileWriter("d:\\h.txt");
			//读入到内存
			char c[]=new char[1024];
			
			int n=0; //记录实际读取到的字符数
			while((n=fr.read(c))!=-1)
			{
//				String s=new String(c, 0, n);
//				System.out.println(s);
				//输出到指定文件
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

//我的记事本（界面+功能）

package 第44讲;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Demo7 extends JFrame implements ActionListener{

	//定义需要的组件
	JTextArea jta=null; //多行文本框
	
	JMenuBar jmb=null; //菜单条
	
	JMenu jm1=null;
	
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo7 demo7=new Demo7();
		
		
	}

	public Demo7()
	{
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("打开(o)");
		
		//设置助记符
		
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("打开",new ImageIcon("new.jpg"));
		jmi2=new JMenuItem("另存为");
		this.setJMenuBar(jmb);
		
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//放入到Jframe
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		this.add(jta);
		this.setSize(400,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断哪个菜单被选中
		
		if(arg0.getActionCommand().equals("open"))
		{
			//System.out.println("open");
			
			//文件选择组件JfileChooser
			
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件...");
			jfc1.showOpenDialog(null); //默认方式
			jfc1.setVisible(true);
			
			//得到用户选择的文件全路径
			
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				String string="";
				String allcon="";
				
				while((string=br.readLine())!=null)
				{
					allcon+=string+"\r\n";
				}
				jta.setText(allcon);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		finally 
		{
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
		if(arg0.getActionCommand().equals("save"))
		{
			//System.out.println("save");
			//出现保存对话框
			
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("另存为...");
			jfc2.showOpenDialog(null); //默认方式
			jfc2.setVisible(true);
			
			//得到用户希望把文件保存到何处
			
			String file=jfc2.getSelectedFile().getAbsolutePath();
			
			//准备写入到指定文件即可
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				
				bw.write(this.jta.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					bw.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	}	
	
}

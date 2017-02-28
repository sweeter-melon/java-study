//�ҵļ��±�������+���ܣ�

package ��44��;

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

	//������Ҫ�����
	JTextArea jta=null; //�����ı���
	
	JMenuBar jmb=null; //�˵���
	
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
		jm1=new JMenu("��(o)");
		
		//�������Ƿ�
		
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("��",new ImageIcon("new.jpg"));
		jmi2=new JMenuItem("���Ϊ");
		this.setJMenuBar(jmb);
		
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//���뵽Jframe
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
		//�ж��ĸ��˵���ѡ��
		
		if(arg0.getActionCommand().equals("open"))
		{
			//System.out.println("open");
			
			//�ļ�ѡ�����JfileChooser
			
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�...");
			jfc1.showOpenDialog(null); //Ĭ�Ϸ�ʽ
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ�ȫ·��
			
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
			//���ֱ���Ի���
			
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("���Ϊ...");
			jfc2.showOpenDialog(null); //Ĭ�Ϸ�ʽ
			jfc2.setVisible(true);
			
			//�õ��û�ϣ�����ļ����浽�δ�
			
			String file=jfc2.getSelectedFile().getAbsolutePath();
			
			//׼��д�뵽ָ���ļ�����
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

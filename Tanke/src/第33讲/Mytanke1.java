
//java��β�������
//����  ̹����Ϸ��1.0
//̹�˿������������ƶ�

//������ͬһ�������涨��һ����ͬ����
package ��33��;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.xml.transform.Templates;

public class Mytanke1 extends JFrame implements ActionListener{

	Mypanel mp=null;
	
	//����һ����ʼ���
	Mystart msp=null;
	
	//��������Ҫ�Ĳ˵�
	JMenuBar jmb1=null;
	JMenu jm1=null;
	JMenu jm2=null;
	JMenu jm3=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	JMenuItem jmi5=null;
	
	JMenuItem jmi7=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		Mytanke1 mytanke1=new Mytanke1();
	}

	//���캯��
	 public Mytanke1 () 
	 {
		// TODO Auto-generated constructor stub

		 jmb1=new JMenuBar();
		 jm1=new JMenu("��Ϸ(G)");
		 jm2=new JMenu("����(H)");
		 jm3=new JMenu("����()");
		 //���ÿ�ݷ�ʽ
		 jm1.setMnemonic('G');
		 jmi1=new JMenuItem("��ʼ����Ϸ(N)");
		 jmi2=new JMenuItem("��ͣ��Ϸ");
		 
		 jmi3=new JMenuItem("��������");
		 jmi4=new JMenuItem("��Ҽ�¼");
		 jmi5=new JMenuItem("�˳���Ϸ");
		
		 jmi7=new JMenuItem("������Ϸ");
		 
		 jmi5.setMnemonic('E');
		 //��jmi1������Ӧ
		 jmi1.addActionListener(this);
		 jmi1.setActionCommand("newgame");
		 
		 jmi5.addActionListener(this);
		 jmi5.setActionCommand("exit");
		 
		
		 
		 jmi7.addActionListener(this);
		 jmi7.setActionCommand("congame");
		 
		 jm1.add(jmi1);
		 jm1.add(jmi7);
		 jm1.add(jmi2);
		 jm1.add(jmi5);
		
		 jm2.add(jmi3);
		 jm2.add(jmi4);
		 jmb1.add(jm1);
		 jmb1.add(jm2);
		 jmb1.add(jm3);
		 
		 this.setJMenuBar(jmb1); //�Ѳ˵����뵽this
		 
		msp=new Mystart();
		Thread t1=new Thread(msp);
		t1.start();
		 this.add(msp);
		 
		 this.setSize(600,500);
		this.setResizable(false);	
		 this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			this.setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("newgame"))
		{
			//����ս��
			 mp=new Mypanel("new game");
			 Thread t =new Thread(mp);
			 t.start();
			 //��ɾ���ɵ����
			 this.remove(msp);
			 this.add(mp);
			 this.addKeyListener(mp);
			 
			 //��ʾˢ��
			 this.setVisible(true);
		}
		
		if(arg0.getActionCommand().equals("exit"))
		{
			
			//���沢
			//�ָ���¼
			Recorder.setEts(mp.ets);
			Recorder.keepandtank();
			//�˳�
			System.exit(0);
			
		}
		
		
		
		if(arg0.getActionCommand().equals("congame"))
		{
			
			///����ս��
			 mp=new Mypanel("continue");
			
			
;			 Thread t =new Thread(mp);
			 t.start();
			 //��ɾ���ɵ����
			 this.remove(msp);
			 this.add(mp);
			 this.addKeyListener(mp);
			 
			 //��ʾˢ��
			 this.setVisible(true);
			
		}
	} 
	
}
//��ʾ����
class Mystart extends JPanel implements Runnable
{
	int times=0;
	
	public void paint (Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		if(times%2==0)
		{
	
		g.setColor(Color.yellow);
	//������Ϣ������
	Font myFont =new Font("������κ", Font.BOLD,30);
	g.setFont(myFont);
	g.drawString("Stage:1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//����
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			times++;
			this.repaint();
		}
		
	}
	
	
}



//�ҵ����

class Mypanel extends JPanel implements KeyListener,Runnable
{
	
	
	//����һ���ҵ�̹��
	Hero hero=null;
	
	//�ж��Ƿ�����Ϸ
	
	
	Vector<Node> nodes=new Vector<Node>();
	//�������̹��
	Vector<Enemytank>ets=new Vector<Enemytank>();
	
	//����ը������
	
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	
	//��������ͼƬ,���һ��ը��
   Image image1=null;
   Image image2=null;
   Image image3=null;
   
	int ensize=4;
	boolean a=true;
	
	public Mypanel(String flag)
	{
		
		hero=new Hero(100, 100);
		
		//��ʼ������̹��
		
		if(flag.equals("new game"))
		{
		for(int i=0;i<ensize;i++)
		{
			Enemytank et=new Enemytank((i+1)*50, 0);
			et.setDirect(2);
			et.setColor(0);
			
			//��mypanel����̹��������������̹��
			et.setEts(ets);
			Thread thread=new Thread(et);
			thread.start();
			//����������ӵ�
			Shot s=new Shot(et.x+9, et.y+37, 2);
			
			//���������
			et.ss.add(s);
			
			Thread t2=new Thread(s);
			t2.start();
			
			ets.add(et);
		}
		}
		
		else
		{
			
			 nodes=new Recorder().getNoderec();
			for(int i=0;i<nodes.size();i++)
			{
				Node node=nodes.get(i);
				
				Enemytank et=new Enemytank(node.x, node.y);
				et.setDirect(2);
				et.setColor(0);
				
				//��mypanel����̹��������������̹��
				et.setEts(ets);
				Thread thread=new Thread(et);
				thread.start();
				//����������ӵ�
				Shot s=new Shot(et.x+9, et.y+37, 2);
				
				//���������
				et.ss.add(s);
				
				Thread t2=new Thread(s);
				t2.start();
				
				ets.add(et);
			}
			
		}
		
		//��ʼ��ͼƬ
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	
//		image1=ImageIO.read(new File("bomb_1.gif"));
//		image2=ImageIO.read(new File("bomb_2.gif"));
//		image3=ImageIO.read(new File("bomb_3.gif"));
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.showinfo(g);  //������ʾ��Ϣ
		
		//�����Լ�̹��
		if(hero.islive==true)
		{
		this.drawtank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		}
		this.drawshot(g);
		
		//��������̹��
		for(int i=0;i<ets.size();i++)
		{
			
			Enemytank temp=ets.get(i);
			if(temp.islive==true)
			{
			this.drawtank(temp.getX(), temp.getY(), g, temp.direct, 1);
			//�������˵��ӵ�
			for(int j=0;j<temp.ss.size();j++)
			{
				Shot eShot=temp.ss.get(j);
				if(eShot.islive)
				{
					g.draw3DRect(eShot.x, eShot.y, 1, 1, false);
				}
				else
				{
					temp.ss.remove(eShot);
				}
				
			}
			
			}
			
			
		}
		//����ը��
		
		for(int i=0;i<bombs.size();i++)
		{
			Bomb b =bombs.get(i);
			
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30,30,this);
			}
			
			else if(b.life>3)
			{
				g.drawImage(image2, b.x, b.y, 30,30,this);
			}
			
		else
			{
				g.drawImage(image1, b.x, b.y, 30,30,this);
			}
			
			b.lifedown();
			
			if(b.life==0)
			{
				bombs.remove(i);
			}
		}
		
	}
	
	//����̹����ʾ��Ϣ
	public void showinfo(Graphics g)
	{
		//������ʾ��Ϣ̹��
				this.drawtank(80, 330, g, 0, 1);
				g.setColor(Color.black);
				g.setFont(new Font("����", Font.BOLD, 20));
				g.drawString(Recorder.getEnNum()+"", 120, 350);
				
				this.drawtank(160, 330, g, 0, 0);
				g.setColor(Color.black);
				g.drawString(Recorder.getMylife()+" ", 195, 350);
				
				//��������ܳɼ�
				g.drawString("�����ܳɼ���", 420, 30);
				
				this.drawtank(420, 60, g, 0, 1);
	         g.setColor(Color.black);
	         g.drawString(Recorder.getAllenNum()+"", 460, 80);
	}
	
	
	
	//�����ӵ�����
	public void drawshot(Graphics g)
	{
		//��ss��ȡ��ÿ���ӵ�������
		for(int i=0;i<this.hero.ss.size();i++)
		{
		Shot myShot=hero.ss.get(i);
		if(hero.s!=null&&hero.s.islive==true)
		{
		
		g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
		}
		
		if(myShot.islive==false)
		{
			hero.ss.remove(myShot);
		} 
	
		}
		
	}
	
	//�ж��ҵ��ӵ��Ƿ���е���̹��
	public void hitenemytank()
	{
		//�ж��Ƿ���е���̹��
		
		for(int i=0;i<hero.ss.size();i++)
		{
			Shot myShot=hero.ss.get(i);
			
			if(myShot.islive)
			{
				//ȡ������̹�ˣ������ж�
				
				for(int j=0;j<ets.size();j++)
				{
					Enemytank et=ets.get(j);
					if(et.islive)
					{
						this.hitTank(myShot, et);
						
					}
					if(this.a==false)
					{
						Recorder.enNum--;
						Recorder.allenNum++;
						a=true;
					}
			}
			}
		}
		
	}
	
	//�ж��ҵ�̹���Ƿ񱻵��˻���
	
	public void hitme()
	{
		
		for(int i=0;i<this.ets.size();i++)
		{
			Enemytank et =ets.get(i);
			
			for(int j=0;j<et.ss.size();j++)
			{
				Shot eShot=et.ss.get(j);
				
				if(hero.islive)
				{
					this.hitTank(eShot, hero);
					
				}
				if(a==false)
				{
					Recorder.mylife--;
					a=true;
				}
				
			}
		}
		
	}
	
	
	//�����ӵ�����̹�˺���
	public void hitTank(Shot s, Tank et)
	{
		//�ж�̹�˷���
		
		switch (et.direct) {
		case 0:
			
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				s.islive=false;  //�ӵ�����
				et.islive=false;  //̹������
				
				//����һ��ը��
				
				Bomb b=new Bomb(et.x,et.y);
				
				bombs.add(b);
				a=false;
			}
			
			break;
			
		case 1:
			
		case 3:
		if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
		{
			s.islive=false; 
			et.islive=false;
			
			
			Bomb b=new Bomb(et.x,et.y);
			
			bombs.add(b);
			a=false;
		}
		
		break;
		
		}
		
		
	}
	
	
	
		
	//����̹�˺���
	public void drawtank(int x,int y,Graphics g,int direct,int type)
	{
		switch(type)
		{
		case 0:
			g.setColor(Color.yellow);
		  break;
		
		case 1:
		g.setColor(Color.cyan);
		break;
		
	}
		switch(direct)
		{
		//����
		case 0:
		
		
		
		//�����ҵ�̹��(�ٷ�װ��һ����)
		//1.������ߵľ���
		g.fill3DRect(x, y, 5, 30,false);
		
		//2.�����ұ߾���
		g.fill3DRect(x+15, y, 5, 30,false);
		//3.�����м����
		g.fill3DRect(x+5, y+5, 10, 20,false);
		
		//4.����Բ��
		g.fillOval(x+4, y+10, 10, 10);
		
		//5.������
		g.drawLine(x+9, y+15, x+9, y-5);
		
		break;
		
		case 1:
			//��Ͳ����
			//1.��������ľ���
			g.fill3DRect(x, y, 30, 5,false);
			
			//2.�����������
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.�����м����
			g.fill3DRect(x+5, y+5, 20, 10,false);
			
			//4.����Բ��
			g.fillOval(x+10, y+4, 10, 10);
			
			//5.������
			g.drawLine(x+15, y+9, x+35, y+9);
			break;
			
		case 2:
			//��Ͳ����
			g.fill3DRect(x, y, 5, 30,false);
			
			//2.�����ұ߾���
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.�����м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			
			//4.����Բ��
			g.fillOval(x+4, y+10, 10, 10);
			
			//5.������
			g.drawLine(x+9, y+15, x+9, y+35);
			break;
			
		case 3:
			//��Ͳ����
g.fill3DRect(x, y, 30, 5,false);
			
			//2.�����������
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.�����м����
			g.fill3DRect(x+5, y+5, 20, 10,false);
			
			//4.����Բ��
			g.fillOval(x+10, y+4, 10, 10);
			
			//5.������
			g.drawLine(x+15, y+9, x-5, y+9);
			break;
		}
	}

	//�����´���  
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_UP)
      {
	  this.hero.setDirect(0);
	  this.hero.moveup();
      }
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			this.hero.setDirect(1);
			this.hero.moveright();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			this.hero.setDirect(2);
			this.hero.movedown();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			this.hero.setDirect(3);
			this.hero.moveleft();
		}
		
		//�ж���Ұ��·����
		if(arg0.getKeyCode()==KeyEvent.VK_1)
		{
			//����
			if(hero.ss.size()<=4)
			{
			this.hero.shotenemy();
			}
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//ÿ��100�����ػ�
		
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			this.hitenemytank();
			this.hitme();
			
			this.repaint();
		}
		
	}
		
}




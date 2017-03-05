package tank5;

import   java.awt.*;

import javax.imageio.ImageIO;
import   javax.swing.*;
import   java.awt.event.*;
import java.io.File;
import   java.util.Vector;
import   java.util.*;

import javax.xml.parsers.FactoryConfigurationError;

import org.omg.CORBA.PUBLIC_MEMBER;
public class Tanke_1 extends  JFrame  implements  ActionListener {
	 MyPanel  mp=null;
	 
	//����һ�� ��ʼ�����
	 MyStartPanel  msp=null;
		
	//����������Ҫ�Ĳ˵�
	 JMenuBar jmb=null;
	 //��ʼ��Ϸ
	 JMenu  jm1=null;
	 JMenuItem  jmi1=null;
	       	 
	 
	 
	public static void main(String[] args) {
		Tanke_1  ta=new  Tanke_1();
  
	}
	public  Tanke_1 ()
	{  
		
		
		//�����˵����˵�ѡ��
		jmb=new JMenuBar();
		jm1=new  JMenu("��Ϸ(G)");
		jm1.setMnemonic('G');
		jmi1=new  JMenuItem("��ʼ��Ϸ(N)");
		
		
		
		//��jmi1ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		
		
		
		
	    jm1.add(jmi1);
	    jmb.add(jm1);
		
		
		msp=new  MyStartPanel();
		this.add(msp);
		
		Thread  t=new  Thread(msp);
		t.start();
		
		this.setJMenuBar(jmb);
		this.setSize(600,500);
		this.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		//���û���ͬ�ĵ��������ͬ�Ĵ���
		if(arg0.getActionCommand().equals("newgame"))
		{    //����ս�����
			 mp=new   MyPanel();
	 	     
			 //�����߳�
	        Thread  t=new  Thread(mp);	
		    t.start();
		    
		    //��ɾ���ɵĿ�ʼ���
		    this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ��ˢ��JFrame
			this.setVisible(true);
			
		}
		
	}

}


//����һ����ʾ����
class   MyStartPanel extends  JPanel     implements  Runnable
{   
	int  times=0;
	
	
	public  void  paint(Graphics  g)
	
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		
		
		
		
		
		
		if(times%2==0)                                                                                                                                                 
		 //��ʾϸϢ
		{
		g.setColor(Color.yellow);
		
		//������Ϣ������
		Font  myFont=new  Font("������κ", Font.BOLD,30);
		g.setFont(myFont);
		g.drawString("stage:1", 150,150 );
		
		}
		
		
	}

	
	public void run() {
	     
		while(true)
		{
			try {
				
				Thread.sleep(100);
				
			} catch (Exception e) {
				
				// TODO: handle exception
				e.printStackTrace();
				
			}
			
			
			times++;
			
			//�ػ�
			this.repaint();
		}
	}


}








class  MyPanel  extends  JPanel  implements  KeyListener,Runnable
{    
	//����һ���ҵ�̹��
	Hero  hero=null;
	
	//������˵�̹��
	Vector<EnemyTank>ets=new Vector<EnemyTank>();
	int ensize=4;
	
	//����ը������
	Vector<Bomb>  bombs=new  Vector<Bomb>();
	
	Image  image1=null;
	Image  image2=null;
	Image  image3=null;
	  
	
	
	//��������ͼƬ������ͼƬ���һ���ӵ�
	
	
	public  MyPanel()
	{
		hero=new Hero(100, 100);
		
		
		
		
		//��ʼ�����˵�̹��
		for(int i=0;i<ensize;i++)
		{   //����һ������̹�˵Ķ���
			EnemyTank  et=new  EnemyTank((i+1)*60,0);
			ets.add(et);
			et.setColor(0);
			et.setDirect(2);
			//�������˵�̹��
			Thread  t=new Thread(et);
			t.start();
			//������̹�����һ�� �ӵ�
			Shot  s=new  Shot(et.x+10,et.y+30,2);
			//���� ����̹��
			et.ss.add(s);
		    Thread  t2=new  Thread(s);
		    t2.start();
			//����
		   ets.add(et);			
			
			
			
			
		}
		
		try {
			image1=ImageIO.read(new File("bomb_1.gif"));
			image2=ImageIO.read(new File("bomb_2.gif"));
			image3=ImageIO.read(new File("bomb_3.gif"));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		              }
		
		
		//��ʼ��ͼƬ
		//image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		//image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		//image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
		
		
		
		
		
		
	}
	
	
	//������ʾϸϢ
	public  void  showInfo(Graphics  g)
	{
		
		//������ʾϸϢ̹�ˣ���������ս
		this.drawTanK(80, 330, g, 0,  0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"", 100, 350);
		//��������̹�ˣ���������ս
		this.drawTanK(150, 330, g, 0,  1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMylife()+"", 180, 350);
		
		
		
		//��������ܳɼ�
	    g.setColor(Color.blue);
	    Font  font=new  Font("����", Font.BOLD, 30);
	    g.setFont(font);
	    g.drawString("�ܳɼ�", 450, 150);
		
	    this.drawTanK(450, 180, g, 0, 1);
	    
	    
	}
	
	
	
	
	
	
	//����paint
	public  void    paint(Graphics  g)
	{
		super.paint(g);
		//�����ҵ�̹��
		g.fillRect(0, 0, 400, 300);
		
		//������ʾϸϸ
		this.showInfo(g);
		
		
		this.drawTanK(hero.getX(), hero.getY(),g,hero.direct,1);
	 
	
		
		//��ss��ȡ��ÿһ���ӵ���������
		for(int  i=0;i<hero.ss.size();i++)
		{
		    Shot   myShot=hero.ss.get(i);
		      
		    //����һ���ӵ�
		    if(myShot!=null&&myShot.isLive)
		    {
		        
		    	g.draw3DRect(myShot.x,myShot.y, 1, 1, false);
		    	
		    }
		    //
		    if(myShot.isLive==false)
		    {
		    	hero.ss.remove(myShot);
		    }
	 
		}
		
		//����ը��
		for(int  i=0;i<bombs.size();i++)
		{   
			//ȡ��ը��
			Bomb  b=bombs.get(i);
			
			System.out.println("bombs.size()="+bombs.size());
			
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30,30,this);
			}else  if(b.life>4)
			{
				
				g.drawImage(image2, b.x, b.y, 30,30,this);
			}else{
				
				
				g.drawImage(image3, b.x, b.y, 30,30,this);
			}
				
			//��b������ֵ��С
			b.lifeDown();
			
			//���ը������ֵΪ0���ͰѸ�ը��bombs����ȥ��
			if(b.life==0)
			{
				bombs.remove(b);
			}
				
				
				
			
		}
		
		
		
		
		
		
		
		
		
		
		//�������˵�̹��
		
		for(int  i=0;i<ets.size();i++)
		{   
			EnemyTank  et=ets.get(i);
			
			if(et.isLive)
			{
			          this.drawTanK(et.getX(),et.getY(), g, et.getDirect(),0);
			           //�������˵��ӵ�
			          for(int  j=0;j<et.ss.size();j++)
			        	  
			          {
			        	  //ȡ���ӵ�
			        	  Shot  enemyShot=et.ss.get(j);
			        	  if(enemyShot.isLive)
			        	  {
			        		  g.draw3DRect(enemyShot.x,enemyShot.y, 1, 1, false);
			        	  }else{
			        		  //������˵�̹��
			        		  et.ss.remove(enemyShot);
			        		  
			        	  }
			      
			        	  
			        	  
			        	  
			          }
			          
			          
			          
			}
		}
		
		
		
	}	
	
	//дһ������ר���ж��ӵ��Ƿ��е���̹��
	public void hitTank(Shot  s,EnemyTank  et)
	{
		//�жϸ�̹�˵ķ���
		switch(et.direct)
		{
		    //������˵�̹�˵ķ������ϻ�������
		    case 0:
		    case 2:
		    	    if(s.x>=et.x&&s.x<=et.x+20&&s.y>=et.y&&s.y<=et.y+30)
		    	    {
		    	    	//����
		    	    	//�ӵ�����
		    	    	s.isLive=false;
		    	    	//̹������
		    	    	et.isLive=false;
		    	    	Recorder.reduceEnNum();
		    	    	//����һ��ը��������Vector
		    	    	Bomb  b=new  Bomb(et.x, et.y);
		    	    	//����Vector
		    	    	bombs.add(b);
		    	    	
		    	    }
		    case  1:
		    case  3: 	
		    	     if(s.x>=et.x&&s.x<=et.x+30&&s.y>=et.y&&s.y<=et.y+20)
		    	     {   
		    	    	 //����
		    	    	//�ӵ�����
			    	    	s.isLive=false;
			    	    	//̹������
			    	    	et.isLive=false;
			    	    	Recorder.reduceEnNum();
			    	    	//����һ��ը��������Vector
			    	    	Bomb  b=new  Bomb(et.x, et.y);
			    	    	//����Vector
			    	    	bombs.add(b);
		    	    	 
		    	     }
		    
		
		
		
		}
	}
	
	
	
	
	
	//����̹�˵ĺ���
	public   void  drawTanK(int  x,int  y,Graphics g,int  direct,int  type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{  
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		//�жϷ���
		switch(direct)
		{//����
		case  0:
	          //�����ҵ�̹��
			  g.fill3DRect(x, y, 5, 30,false);
			  g.fill3DRect(x+15, y, 5, 30,false);
			  g.fill3DRect(x+5, y+5, 10, 20,false);
			  g.fillOval(x+5, y+10, 10,10);
			  g.drawLine(x+10, y+15, x+10,y);
			  break;
		case  1:
	          //����	
			  g.fill3DRect(x, y, 30,5,false);
			  g.fill3DRect(x, y+15,30, 5,false);
			  g.fill3DRect(x+5, y+5, 20, 10,false);
			  g.fillOval(x+10, y+5, 10,10);
			  g.drawLine(x+15, y+10, x+30,y+10);
			  break;
		case  2:
			  //����
			  g.fill3DRect(x, y, 5, 30,false);
			  g.fill3DRect(x+15, y, 5, 30,false);
			  g.fill3DRect(x+5, y+5, 10, 20,false);
			  g.fillOval(x+5, y+10, 10,10);
			  g.drawLine(x+10, y+15, x+10,y+30);
			  break;
		case  3:
			  //����
			  g.fill3DRect(x, y, 30,5,false);
			  g.fill3DRect(x, y+15,30, 5,false);
			  g.fill3DRect(x+5, y+5, 20, 10,false);
			  g.fillOval(x+10, y+5, 10,10);
			  g.drawLine(x+15, y+10, x,y+10);
			  break;
			
			
			
			
			
			
			  
			  
			  
			  
			  
			  
		}
	}

	//�����´���    a��ʾ����   w��ʾ����      d��ʾ����        s��ʾ����
	
	
	public void keyPressed(KeyEvent argo) {
		// TODO Auto-generated method stub
		if(argo.getKeyCode()==KeyEvent.VK_W)
		{
			//�����ҵ�̹�˷���
			this.hero.setDirect(0);
			this.hero.moveUp();
		}else  if(argo.getKeyCode()==KeyEvent.VK_D)
		{
			//����
			this.hero.setDirect(1);
			this.hero.moveRight();
			
		}else  if(argo.getKeyCode()==KeyEvent.VK_S)
		{   //����
			this.hero.setDirect(2);
			this.hero.moveDown();
			
		}else  if(argo.getKeyCode()==KeyEvent.VK_A)
		{   //����
			this.hero.setDirect(3);
			this.hero.moveLeft();
			
		}
		
		if(argo.getKeyCode()==KeyEvent.VK_J)
		{//�ж�����Ƿ���J
			
		      //����
	          if(this.hero.ss.size()<=10)
	          {		
			
		          this.hero.shotEnemy();
	          }    
		}
		
		
		
		
		//�������»���panel
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		while(true)
		{
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}	
			
			//�ж��Ƿ����
			for(int  i=0;i<hero.ss.size();i++)
				
			{    
				//ȡ���ӵ�
				Shot  myShot=hero.ss.get(i);
				//�ж��ӵ��Ƿ���Ч
				if(myShot.isLive)
					
				{
					 
					//ȡ��ÿ��̹�ˣ������ж�
					for(int  j=0;j<ets.size();j++)
					{   
						//ȡ��̹��
						EnemyTank  et=ets.get(j);
						if(et.isLive)
						{
							this.hitTank(myShot, et);
						}
						
						
					}
					
					
					
				}
				
				
				
				
				
			}
			
			//�ж��Ƿ���Ҫ̹�˼����µ��ӵ�
			for(int  i=0;i<ets.size();i++)
			{ 
				 EnemyTank  et=ets.get(i);
				 if(et.isLive)
				 {
					    //�ж��ӵ��Ƿ�û��
		                if(et.ss.size()<1)
		                {
		                	Shot  s=null;
		                	
		                	
		                	switch(et.direct)
		                	{
		                	
		                	case  0:
		            			s=new  Shot(et.x+10,et.y,0);
		            			//���ӵ���������
		            			et.ss.add(s);
		            			break;
		            			
		            		case  1:
		            			s=new  Shot(et.x+30, et.y+10,1);
		            			et.ss.add(s);
		            			break;
		            		case  2:
		            			s=new  Shot(et.x+10, et.y+30,2);
		            			et.ss.add(s);
		            			break;
		            		case  3:
		            			s=new  Shot(et.x, et.y+10,3);
		            			et.ss.add(s);
		            			break;
		                	
		                	
		                	
		                	
		                	
		                	}
		                	//�����ӵ�
		                	Thread  t=new  Thread(s);
		                	t.start();
		                	
		                	
		                	
		                	
		                	
		                	
		                	
		                }
				 }
				  
			}
			
			
			this.repaint();

		}
		
	}
}












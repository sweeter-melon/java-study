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
	 
	//定义一个 开始的面板
	 MyStartPanel  msp=null;
		
	//做出我所需要的菜单
	 JMenuBar jmb=null;
	 //开始游戏
	 JMenu  jm1=null;
	 JMenuItem  jmi1=null;
	       	 
	 
	 
	public static void main(String[] args) {
		Tanke_1  ta=new  Tanke_1();
  
	}
	public  Tanke_1 ()
	{  
		
		
		//创建菜单几菜单选项
		jmb=new JMenuBar();
		jm1=new  JMenu("游戏(G)");
		jm1.setMnemonic('G');
		jmi1=new  JMenuItem("开始游戏(N)");
		
		
		
		//对jmi1注册监听
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
		
		
		
		//对用户不同的点击做出不同的处理
		if(arg0.getActionCommand().equals("newgame"))
		{    //创建战场面板
			 mp=new   MyPanel();
	 	     
			 //启动线程
	        Thread  t=new  Thread(mp);	
		    t.start();
		    
		    //先删除旧的开始面板
		    this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示，刷新JFrame
			this.setVisible(true);
			
		}
		
	}

}


//就是一个提示作用
class   MyStartPanel extends  JPanel     implements  Runnable
{   
	int  times=0;
	
	
	public  void  paint(Graphics  g)
	
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		
		
		
		
		
		
		if(times%2==0)                                                                                                                                                 
		 //提示细息
		{
		g.setColor(Color.yellow);
		
		//开关信息的字体
		Font  myFont=new  Font("华文新魏", Font.BOLD,30);
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
			
			//重画
			this.repaint();
		}
	}


}








class  MyPanel  extends  JPanel  implements  KeyListener,Runnable
{    
	//定义一个我的坦克
	Hero  hero=null;
	
	//定义敌人的坦克
	Vector<EnemyTank>ets=new Vector<EnemyTank>();
	int ensize=4;
	
	//定义炸弹集合
	Vector<Bomb>  bombs=new  Vector<Bomb>();
	
	Image  image1=null;
	Image  image2=null;
	Image  image3=null;
	  
	
	
	//定义三张图片，三张图片组成一个子弹
	
	
	public  MyPanel()
	{
		hero=new Hero(100, 100);
		
		
		
		
		//初始化敌人的坦克
		for(int i=0;i<ensize;i++)
		{   //创建一辆敌人坦克的对象
			EnemyTank  et=new  EnemyTank((i+1)*60,0);
			ets.add(et);
			et.setColor(0);
			et.setDirect(2);
			//启动敌人的坦克
			Thread  t=new Thread(et);
			t.start();
			//给敌人坦克添加一颗 子弹
			Shot  s=new  Shot(et.x+10,et.y+30,2);
			//加入 敌人坦克
			et.ss.add(s);
		    Thread  t2=new  Thread(s);
		    t2.start();
			//加入
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
		
		
		//初始化图片
		//image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		//image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		//image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
		
		
		
		
		
		
	}
	
	
	//画出提示细息
	public  void  showInfo(Graphics  g)
	{
		
		//画出提示细息坦克，不参与作战
		this.drawTanK(80, 330, g, 0,  0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"", 100, 350);
		//画出敌人坦克，不参与作战
		this.drawTanK(150, 330, g, 0,  1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMylife()+"", 180, 350);
		
		
		
		//画出玩家总成绩
	    g.setColor(Color.blue);
	    Font  font=new  Font("宋体", Font.BOLD, 30);
	    g.setFont(font);
	    g.drawString("总成绩", 450, 150);
		
	    this.drawTanK(450, 180, g, 0, 1);
	    
	    
	}
	
	
	
	
	
	
	//重新paint
	public  void    paint(Graphics  g)
	{
		super.paint(g);
		//画出我的坦克
		g.fillRect(0, 0, 400, 300);
		
		//画出提示细细
		this.showInfo(g);
		
		
		this.drawTanK(hero.getX(), hero.getY(),g,hero.direct,1);
	 
	
		
		//从ss中取出每一颗子弹，并画出
		for(int  i=0;i<hero.ss.size();i++)
		{
		    Shot   myShot=hero.ss.get(i);
		      
		    //画出一颗子弹
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
		
		//画出炸弹
		for(int  i=0;i<bombs.size();i++)
		{   
			//取出炸弹
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
				
			//让b的生命值减小
			b.lifeDown();
			
			//如果炸弹生命值为0，就把该炸弹bombs向量去掉
			if(b.life==0)
			{
				bombs.remove(b);
			}
				
				
				
			
		}
		
		
		
		
		
		
		
		
		
		
		//画出敌人的坦克
		
		for(int  i=0;i<ets.size();i++)
		{   
			EnemyTank  et=ets.get(i);
			
			if(et.isLive)
			{
			          this.drawTanK(et.getX(),et.getY(), g, et.getDirect(),0);
			           //画出敌人的子弹
			          for(int  j=0;j<et.ss.size();j++)
			        	  
			          {
			        	  //取出子弹
			        	  Shot  enemyShot=et.ss.get(j);
			        	  if(enemyShot.isLive)
			        	  {
			        		  g.draw3DRect(enemyShot.x,enemyShot.y, 1, 1, false);
			        	  }else{
			        		  //如果敌人的坦克
			        		  et.ss.remove(enemyShot);
			        		  
			        	  }
			      
			        	  
			        	  
			        	  
			          }
			          
			          
			          
			}
		}
		
		
		
	}	
	
	//写一个函数专门判断子弹是否集中敌人坦克
	public void hitTank(Shot  s,EnemyTank  et)
	{
		//判断该坦克的方向
		switch(et.direct)
		{
		    //如果敌人的坦克的方向向上或者向下
		    case 0:
		    case 2:
		    	    if(s.x>=et.x&&s.x<=et.x+20&&s.y>=et.y&&s.y<=et.y+30)
		    	    {
		    	    	//击中
		    	    	//子弹死亡
		    	    	s.isLive=false;
		    	    	//坦克死亡
		    	    	et.isLive=false;
		    	    	Recorder.reduceEnNum();
		    	    	//创建一个炸弹，放入Vector
		    	    	Bomb  b=new  Bomb(et.x, et.y);
		    	    	//放入Vector
		    	    	bombs.add(b);
		    	    	
		    	    }
		    case  1:
		    case  3: 	
		    	     if(s.x>=et.x&&s.x<=et.x+30&&s.y>=et.y&&s.y<=et.y+20)
		    	     {   
		    	    	 //击中
		    	    	//子弹死亡
			    	    	s.isLive=false;
			    	    	//坦克死亡
			    	    	et.isLive=false;
			    	    	Recorder.reduceEnNum();
			    	    	//创建一个炸弹，放入Vector
			    	    	Bomb  b=new  Bomb(et.x, et.y);
			    	    	//放入Vector
			    	    	bombs.add(b);
		    	    	 
		    	     }
		    
		
		
		
		}
	}
	
	
	
	
	
	//画出坦克的函数
	public   void  drawTanK(int  x,int  y,Graphics g,int  direct,int  type)
	{
		//判断是什么类型的坦克
		switch(type)
		{  
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		//判断方向
		switch(direct)
		{//向上
		case  0:
	          //画出我的坦克
			  g.fill3DRect(x, y, 5, 30,false);
			  g.fill3DRect(x+15, y, 5, 30,false);
			  g.fill3DRect(x+5, y+5, 10, 20,false);
			  g.fillOval(x+5, y+10, 10,10);
			  g.drawLine(x+10, y+15, x+10,y);
			  break;
		case  1:
	          //向右	
			  g.fill3DRect(x, y, 30,5,false);
			  g.fill3DRect(x, y+15,30, 5,false);
			  g.fill3DRect(x+5, y+5, 20, 10,false);
			  g.fillOval(x+10, y+5, 10,10);
			  g.drawLine(x+15, y+10, x+30,y+10);
			  break;
		case  2:
			  //向下
			  g.fill3DRect(x, y, 5, 30,false);
			  g.fill3DRect(x+15, y, 5, 30,false);
			  g.fill3DRect(x+5, y+5, 10, 20,false);
			  g.fillOval(x+5, y+10, 10,10);
			  g.drawLine(x+10, y+15, x+10,y+30);
			  break;
		case  3:
			  //向左
			  g.fill3DRect(x, y, 30,5,false);
			  g.fill3DRect(x, y+15,30, 5,false);
			  g.fill3DRect(x+5, y+5, 20, 10,false);
			  g.fillOval(x+10, y+5, 10,10);
			  g.drawLine(x+15, y+10, x,y+10);
			  break;
			
			
			
			
			
			
			  
			  
			  
			  
			  
			  
		}
	}

	//键按下处理    a表示向左   w表示向上      d表示向右        s表示向下
	
	
	public void keyPressed(KeyEvent argo) {
		// TODO Auto-generated method stub
		if(argo.getKeyCode()==KeyEvent.VK_W)
		{
			//设置我的坦克方向
			this.hero.setDirect(0);
			this.hero.moveUp();
		}else  if(argo.getKeyCode()==KeyEvent.VK_D)
		{
			//向右
			this.hero.setDirect(1);
			this.hero.moveRight();
			
		}else  if(argo.getKeyCode()==KeyEvent.VK_S)
		{   //向下
			this.hero.setDirect(2);
			this.hero.moveDown();
			
		}else  if(argo.getKeyCode()==KeyEvent.VK_A)
		{   //向左
			this.hero.setDirect(3);
			this.hero.moveLeft();
			
		}
		
		if(argo.getKeyCode()==KeyEvent.VK_J)
		{//判断玩家是否按下J
			
		      //开火
	          if(this.hero.ss.size()<=10)
	          {		
			
		          this.hero.shotEnemy();
	          }    
		}
		
		
		
		
		//必须重新绘制panel
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
			
			//判断是否击中
			for(int  i=0;i<hero.ss.size();i++)
				
			{    
				//取出子弹
				Shot  myShot=hero.ss.get(i);
				//判断子弹是否有效
				if(myShot.isLive)
					
				{
					 
					//取出每个坦克，与它判断
					for(int  j=0;j<ets.size();j++)
					{   
						//取出坦克
						EnemyTank  et=ets.get(j);
						if(et.isLive)
						{
							this.hitTank(myShot, et);
						}
						
						
					}
					
					
					
				}
				
				
				
				
				
			}
			
			//判断是否需要坦克加入新的子弹
			for(int  i=0;i<ets.size();i++)
			{ 
				 EnemyTank  et=ets.get(i);
				 if(et.isLive)
				 {
					    //判断子弹是否没有
		                if(et.ss.size()<1)
		                {
		                	Shot  s=null;
		                	
		                	
		                	switch(et.direct)
		                	{
		                	
		                	case  0:
		            			s=new  Shot(et.x+10,et.y,0);
		            			//把子弹加入向量
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
		                	//启动子弹
		                	Thread  t=new  Thread(s);
		                	t.start();
		                	
		                	
		                	
		                	
		                	
		                	
		                	
		                }
				 }
				  
			}
			
			
			this.repaint();

		}
		
	}
}












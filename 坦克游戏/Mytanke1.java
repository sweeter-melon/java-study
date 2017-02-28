
//java如何操作声音
//功能  坦克游戏的1.0
//坦克可以上下左右移动

//不能在同一个包下面定义一个相同的类
package 第33讲;

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
	
	//定义一个开始面板
	Mystart msp=null;
	
	//作出我需要的菜单
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

	//构造函数
	 public Mytanke1 () 
	 {
		// TODO Auto-generated constructor stub

		 jmb1=new JMenuBar();
		 jm1=new JMenu("游戏(G)");
		 jm2=new JMenu("设置(H)");
		 jm3=new JMenu("帮助()");
		 //设置快捷方式
		 jm1.setMnemonic('G');
		 jmi1=new JMenuItem("开始新游戏(N)");
		 jmi2=new JMenuItem("暂停游戏");
		 
		 jmi3=new JMenuItem("关数设置");
		 jmi4=new JMenuItem("玩家记录");
		 jmi5=new JMenuItem("退出游戏");
		
		 jmi7=new JMenuItem("继续游戏");
		 
		 jmi5.setMnemonic('E');
		 //对jmi1进行响应
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
		 
		 this.setJMenuBar(jmb1); //把菜单加入到this
		 
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
			//创建战场
			 mp=new Mypanel("new game");
			 Thread t =new Thread(mp);
			 t.start();
			 //先删除旧的面板
			 this.remove(msp);
			 this.add(mp);
			 this.addKeyListener(mp);
			 
			 //显示刷新
			 this.setVisible(true);
		}
		
		if(arg0.getActionCommand().equals("exit"))
		{
			
			//保存并
			//恢复记录
			Recorder.setEts(mp.ets);
			Recorder.keepandtank();
			//退出
			System.exit(0);
			
		}
		
		
		
		if(arg0.getActionCommand().equals("congame"))
		{
			
			///创建战场
			 mp=new Mypanel("continue");
			
			
;			 Thread t =new Thread(mp);
			 t.start();
			 //先删除旧的面板
			 this.remove(msp);
			 this.add(mp);
			 this.addKeyListener(mp);
			 
			 //显示刷新
			 this.setVisible(true);
			
		}
	} 
	
}
//提示作用
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
	//开关信息的字体
	Font myFont =new Font("华文新魏", Font.BOLD,30);
	g.setFont(myFont);
	g.drawString("Stage:1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//休眠
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



//我的面板

class Mypanel extends JPanel implements KeyListener,Runnable
{
	
	
	//定义一个我的坦克
	Hero hero=null;
	
	//判断是否新游戏
	
	
	Vector<Node> nodes=new Vector<Node>();
	//定义敌人坦克
	Vector<Enemytank>ets=new Vector<Enemytank>();
	
	//定义炸弹集合
	
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	
	//定义三张图片,组成一颗炸弹
   Image image1=null;
   Image image2=null;
   Image image3=null;
   
	int ensize=4;
	boolean a=true;
	
	public Mypanel(String flag)
	{
		
		hero=new Hero(100, 100);
		
		//初始化敌人坦克
		
		if(flag.equals("new game"))
		{
		for(int i=0;i<ensize;i++)
		{
			Enemytank et=new Enemytank((i+1)*50, 0);
			et.setDirect(2);
			et.setColor(0);
			
			//将mypanel敌人坦克向量交给敌人坦克
			et.setEts(ets);
			Thread thread=new Thread(et);
			thread.start();
			//给敌人添加子弹
			Shot s=new Shot(et.x+9, et.y+37, 2);
			
			//加入给敌人
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
				
				//将mypanel敌人坦克向量交给敌人坦克
				et.setEts(ets);
				Thread thread=new Thread(et);
				thread.start();
				//给敌人添加子弹
				Shot s=new Shot(et.x+9, et.y+37, 2);
				
				//加入给敌人
				et.ss.add(s);
				
				Thread t2=new Thread(s);
				t2.start();
				
				ets.add(et);
			}
			
		}
		
		//初始化图片
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
		
		this.showinfo(g);  //画出提示信息
		
		//画出自己坦克
		if(hero.islive==true)
		{
		this.drawtank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		}
		this.drawshot(g);
		
		//画出敌人坦克
		for(int i=0;i<ets.size();i++)
		{
			
			Enemytank temp=ets.get(i);
			if(temp.islive==true)
			{
			this.drawtank(temp.getX(), temp.getY(), g, temp.direct, 1);
			//画出敌人的子弹
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
		//画出炸弹
		
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
	
	//画出坦克提示信息
	public void showinfo(Graphics g)
	{
		//画出提示信息坦克
				this.drawtank(80, 330, g, 0, 1);
				g.setColor(Color.black);
				g.setFont(new Font("宋体", Font.BOLD, 20));
				g.drawString(Recorder.getEnNum()+"", 120, 350);
				
				this.drawtank(160, 330, g, 0, 0);
				g.setColor(Color.black);
				g.drawString(Recorder.getMylife()+" ", 195, 350);
				
				//画出玩家总成绩
				g.drawString("您的总成绩：", 420, 30);
				
				this.drawtank(420, 60, g, 0, 1);
	         g.setColor(Color.black);
	         g.drawString(Recorder.getAllenNum()+"", 460, 80);
	}
	
	
	
	//画出子弹函数
	public void drawshot(Graphics g)
	{
		//从ss中取出每颗子弹并绘制
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
	
	//判断我的子弹是否击中敌人坦克
	public void hitenemytank()
	{
		//判断是否击中敌人坦克
		
		for(int i=0;i<hero.ss.size();i++)
		{
			Shot myShot=hero.ss.get(i);
			
			if(myShot.islive)
			{
				//取出敌人坦克，与他判断
				
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
	
	//判断我的坦克是否被敌人击中
	
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
	
	
	//画出子弹击中坦克函数
	public void hitTank(Shot s, Tank et)
	{
		//判断坦克方向
		
		switch (et.direct) {
		case 0:
			
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				s.islive=false;  //子弹死亡
				et.islive=false;  //坦克死亡
				
				//创建一颗炸弹
				
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
	
	
	
		
	//画出坦克函数
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
		//向上
		case 0:
		
		
		
		//画出我的坦克(再封装成一个类)
		//1.画出左边的矩形
		g.fill3DRect(x, y, 5, 30,false);
		
		//2.画出右边矩形
		g.fill3DRect(x+15, y, 5, 30,false);
		//3.画出中间矩形
		g.fill3DRect(x+5, y+5, 10, 20,false);
		
		//4.画出圆形
		g.fillOval(x+4, y+10, 10, 10);
		
		//5.画出线
		g.drawLine(x+9, y+15, x+9, y-5);
		
		break;
		
		case 1:
			//炮筒向右
			//1.画出上面的矩形
			g.fill3DRect(x, y, 30, 5,false);
			
			//2.画出下面矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			
			//4.画出圆形
			g.fillOval(x+10, y+4, 10, 10);
			
			//5.画出线
			g.drawLine(x+15, y+9, x+35, y+9);
			break;
			
		case 2:
			//炮筒向下
			g.fill3DRect(x, y, 5, 30,false);
			
			//2.画出右边矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			
			//4.画出圆形
			g.fillOval(x+4, y+10, 10, 10);
			
			//5.画出线
			g.drawLine(x+9, y+15, x+9, y+35);
			break;
			
		case 3:
			//炮筒向左
g.fill3DRect(x, y, 30, 5,false);
			
			//2.画出下面矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			
			//4.画出圆形
			g.fillOval(x+10, y+4, 10, 10);
			
			//5.画出线
			g.drawLine(x+15, y+9, x-5, y+9);
			break;
		}
	}

	//键按下处理  
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
		
		//判断玩家按下发射键
		if(arg0.getKeyCode()==KeyEvent.VK_1)
		{
			//发射
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
		
		//每隔100毫秒重绘
		
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




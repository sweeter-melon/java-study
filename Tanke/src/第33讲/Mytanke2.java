package 第33讲;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.PublicKey;
import java.util.Vector;

class Node
{
	int x;
	int y;
	int direct;
	public Node(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}

//记录类，同时可以保存玩家的设置
class Recorder
{
	//记录每关有多少敌人
	 static int enNum=20;
	
	//设置我有多少可以用的人
	   static int mylife=3;
		
	   //记录消灭的敌人数量
	   static int allenNum=0;
	   
	   
	   //把玩家击毁敌人坦克数量保存到文件中
	   private static FileWriter fw=null;
	   private static BufferedWriter bw=null;
	   private static FileReader fr=null;
	   private static BufferedReader br=null;
	   
	   public static Vector<Enemytank> getEts() {
		return ets1;
	}

	public static void setEts(Vector<Enemytank> ets1) {
		Recorder.ets1 = ets1;
	}

	private static Vector<Enemytank> ets1=new Vector<Enemytank>();
	
	static Vector<Node> nodes=new Vector<Node>();
//	   public static void keeprecord()
//	   {
//		   try {
//			fw=new FileWriter("d:\\tank.txt");
//			bw=new BufferedWriter(fw);
//			bw.write(allenNum+"\r\n");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		   finally {
//			try {
//				
//				bw.close();
//				fw.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		   
//	   }
	   
	 //从文件中读取记录
	public Vector<Node> getNoderec()
	{
		 try {
				fr=new FileReader("d:\\tank.txt");
				br=new BufferedReader(fr);
				String n="";
				//先读取第一行
				n=br.readLine();
				allenNum=Integer.parseInt(n);
				while((n=br.readLine())!=null)
				{
					String xyz[]=n.split("");
					
						Node node=new Node(Integer.parseInt(xyz[0]), Integer.parseInt(xyz[1]), Integer.parseInt(xyz[2]));
					
					nodes.add(node);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			   finally {
				try {
					br.close();
					fr.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return nodes;
	}
	
	
	  
//	   public static void getrecord()
//	   {
//		   
//		   try {
//			fr=new FileReader("d:\\tank.txt");
//			br=new BufferedReader(fr);
//			String n=br.readLine();
//			allenNum=Integer.parseInt(n);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		   finally {
//			try {
//				br.close();
//				fr.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		   
//	   }
	   
	   public static void keepandtank()
	   {
		   try {
				fw=new FileWriter("d:\\tank.txt");
				bw=new BufferedWriter(fw);
				bw.write(allenNum+"\r\n");
				
				for(int i=0;i<ets1.size();i++)
				{
					
					Enemytank et=ets1.get(i);
					
					if(et.islive)
					{
						String x=et.x+" "+et.y+" "+et.direct+" ";
						//写入
						bw.write(x+"\r\n");
					}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			   finally {
				try {
					
					bw.close();
					fw.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		   
	   }
	   
	public static int getEnNum() {
		return enNum;
	}

	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}

	public static int getMylife() {
		return mylife;
	}

	public static void setMylife(int mylife) {
		Recorder.mylife = mylife;
	}



public static int getAllenNum() {
	return allenNum;
}

public static void setAllenNum(int allenNum) {
	Recorder.allenNum = allenNum;
}
   
}



//炸弹类

class Bomb
{
	int x;
	int y;
    boolean islive=true;
	int life=9;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
		
	}
	
	public void lifedown()
	{
		
		if(life>0)
		{
			life--;
		}
		else
		{
			this.islive=false;
		}
		
	}
	
}






//坦克类
class Tank 
{
	public int getX() {
		return x;
	}
             
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int x=0; //坦克横坐标
	int y=0; //坦克纵坐标
	int direct;
	
	int color;
    boolean islive=true;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
		
	}
	
	
}

//子弹类
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=1;
	
	boolean islive=true;
	public Shot (int x,int y,int direct) 
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			switch (direct) {
			case 0:
				
				y-=speed;
				break;
             case 1:
				
				x+=speed;
				break;  
				
             case 2:
 				
 				y+=speed;
 				break;
             case 3:
 				
 				x-=speed;
 				break;
			default:
				break;
			}
			//子弹何时死亡
			
			//判断该子弹是否碰到边缘
			
			if(x<-1||x>401||y<-1||y>301)
			{
				this.islive=false;
				break;
			}
		}
	}
}



//我的坦克

class Hero extends Tank
{
	Shot s=null;
	int speed=3;// 坦克速度
	Vector<Shot> ss=new Vector<Shot>();
	public Hero(int x,int y)
	{
		super(x, y);//子类里面调用父类的构造函数
	}
	
	//开火
	
	public void shotenemy()
	{
		
		
	switch (this.direct) {
	case 0:
		
		s=new Shot(x+9, y-7,0);  //创建子弹
		ss.add(s);  //把子弹加入向量
		break;

		case 1:
			s=new Shot(x+37, y+9,1);
			ss.add(s);
			break;
			
		case 2:
			s=new Shot(x+9, y+37,2);
			ss.add(s);
			break;
			
		case 3:
			s=new Shot(x-7, y+9,3);
			ss.add(s);
			break;
	default:
		break;
	}
	Thread t=new Thread(s);
	t.start();
	
	}
	
	public void moveup()
	{
		if(y>5)
		{
		y-=speed;
		}
	}
	
	public void moveright()
	{
		if(x<360)
		{
		x+=speed;
		}
	}
	
	public void movedown()
	{
		if(y<235)
		{
		y+=speed;
		}
	}
	
	public void moveleft()
	{
		if(x>5)
		{
		x-=speed;
		}
	}
}


//敌人坦克

class Enemytank extends Tank implements Runnable
{
	//定义一个向量访问敌人坦克
	Vector<Enemytank> ets=new Vector<Enemytank>();
	
	
	int speed=2;// 坦克速度
	//定义一个向量，存放敌人子弹
	Vector<Shot> ss=new Vector<Shot>();
	
	//敌人发子弹应当在刚创建坦克和敌人坦克死亡后
	
	 public Enemytank(int x,int y) {
	
		super(x, y);//子类里面调用父类的构造函数
	}
	 
	 //得到mypanel的敌人坦克向量
	 public void setEts(Vector<Enemytank> vv)
	 {
		 this.ets=vv;
	 }
	 
	 
	 //判断是否碰到了别的敌人坦克
	 public boolean istouchotherenemy()
	 {
		boolean b=false;
		switch (this.direct) {
		case 0:
			//我的坦克向上
			//取出所有的敌人坦克
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				Enemytank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//敌人方向向下或向上
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
				
					if(et.direct==1||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
					}	
				}
				
				
			}
			
			
			
			break;
        case 1:
			//坦克向右
        	for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				Enemytank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//敌人方向向下或向上
					if(et.direct==0||et.direct==2)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
				
					if(et.direct==1||et.direct==3)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}	
				}
				
				
			}
			break;
       case 2:
    	   //tank向下
    	   
    	   for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				Enemytank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//敌人方向向下或向上
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
				
					if(et.direct==1||et.direct==3)
					{
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
					}	
				}
				
				
			}
    	   
    	   
	        break;
	        
       case 3:
    	   for(int i=0;i<ets.size();i++)
			{
				//取出第一个坦克
				Enemytank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//敌人方向向下或向上
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
				
					if(et.direct==1||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}	
				}
				
				
			}
           break;
		default:
			break;
		}
		
		
		return b;
	 }
	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			
			switch (this.direct) 
			{
			case 0:
				//说明坦克向上移动
				for(int i=0;i<30;i++)
				{
					try 
					{
						Thread.sleep(50);
					}
					catch (Exception e) {
						// TODO: handle exception
					}
					if(y>5&&!istouchotherenemy())
					{
				y-=speed;
					}
				}
				break;
            case 1:
            	for(int i=0;i<30;i++)
				{
					try 
					{
						Thread.sleep(50);
					}
					catch (Exception e) {
						// TODO: handle exception
					}
					if(x<360&&!istouchotherenemy())
					{
				x+=speed;
					}
				}
            	break;
            	
            	case 2:
            		for(int i=0;i<30;i++)
    				{
    					try 
    					{
    						Thread.sleep(50);
    					}
    					catch (Exception e) {
    						// TODO: handle exception
    					}
    					if(y<235&&!istouchotherenemy())
    					{
    					y+=speed;
    					}
    				}
            		break;
            		
            	case 3:
            		for(int i=0;i<30;i++)
    				{
    					try 
    					{
    						Thread.sleep(50);
    					}
    					catch (Exception e) {
    						// TODO: handle exception
    					}
    					if(x>5&&!istouchotherenemy())
    					{
            		x-=speed;
    					}
    				}
            		break;
            		
			default:
				break;
			}
			
				
				if(islive)
				{
					
					if(ss.size()<4)
					{
						Shot s =null;
						switch (direct) {
						case 0:
							
							s=new Shot(x+9, y-7,0);  //创建子弹
							ss.add(s);  //把子弹加入向量
							break;

							case 1:
								s=new Shot(x+37, y+9,1);
								ss.add(s);
								break;
								
							case 2:
								s=new Shot(x+9, y+37,2);
								ss.add(s);
								break;
								
							case 3:
								s=new Shot(x-7, y+9,3);
								ss.add(s);
								break;
						default:
							break;
						}
						Thread t=new Thread(s);
						t.start();
					}
				}
			
			
			//随机产生新的方向
			this.direct=(int)(Math.random()*4);
			
			//判断敌人坦克是否死亡
			if(this.islive==false)
			{
				break;
			}
			
			
		}
		
		
	}
	
}

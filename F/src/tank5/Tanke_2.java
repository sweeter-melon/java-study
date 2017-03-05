package tank5;

import java.security.AllPermission;
import java.util.Vector;

import javax.sound.midi.VoiceStatus;

//记录类，同时也可以保存玩家的设置
class   Recorder
{
	//记录有多少敌人
	private  static int  enNum=20;
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
	//记录我有多少可以用的人
	private  static int  mylife=5;
    
	
	
	//记录消灭多少敌人
	public  static  int  allEnNum=0;
	
	
	
	

    public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	//减少敌人数
    public   static  void reduceEnNum()
    {
    	enNum--;
    }
   
    
    public  static  void  addEnNumRec()
    {
    	allEnNum++;
    }
    
    
    
    
    
    
    
    
    
    



}















//炸弹类
class  Bomb
{
	//定义炸弹的坐标
	int x,y;
	//炸弹的生命
	int  life=9;
	boolean isLive=true;
	public  Bomb(int  x,int  y)
	{
		this.x=x;
		this.y=y;
	} 

    
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}else{
			this.isLive=false;
		}
		
		
	}




}





//子弹类
class Shot   implements Runnable
{
	int  x;
	int  y;
	int  direct;
	int  speed=8;
	//是否还活着
	boolean   isLive=true;
	public  Shot(int  x,int y,int direct)
	{
     this.x=x;
     this.y=y;
     this.direct=direct;
     
    }
	
	public void run() {
		
		while(true)
		{
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.getMessage();
			}
			
			
			
			switch(direct)
			{
			case  0:
				y-=speed;
				break;
			case  1:
				x+=speed;
				break;
				
			case  2:
				y+=speed;
			    break;
			case  3:	
				x-=speed;
				break;
			
			
			}
			//子弹 何时死
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
			
		}
	}
}



//敌人的坦克
class   EnemyTank  extends  Tank  implements   Runnable
{     
	  boolean  isLive=true;
	  
	  //定义一个向量，可以存放敌人的子弹
	  
	  Vector<Shot>   ss=new  Vector<Shot>();
	  //敌人添加子弹，应当在刚刚创建坦克的时候和子弹死亡后
	  
	  
	  
	  
	
	  public  EnemyTank(int x,int y)
	  {
		super(x, y);
	  }

	  
	  
	  
	  
	  
	  
	  
	  
	  
	public void run()
	{
          while(true)
          {
        	 
        	  
        	    
                switch(this.direct)
                {
                case 0:
                	   //说明坦克方向正在向上
                	for(int i=0;i<30;i++)
                	{ 
                	   if(y>0)	
                	   {	   
                	     y-=speed;
                	   }
                	    try {
          				  Thread.sleep(50);
          			   } catch (Exception e) {
          				
          				   e.printStackTrace();
          				
          			      }
                	  
                	  
                	}  
                	break;
                	
                case  1: 	  
                	for(int i=0;i<30;i++)
                	{	if(x<400)
                	    { 
                	        x+=speed;
                	    }
                	    try {
          				  Thread.sleep(50);
          			   } catch (Exception e) {
          				
          				   e.printStackTrace();
          				
          			      }
                	  
                	  
                	}  
                	break;
                case 2:
             	   //说明坦克方向正在向下
                	for(int i=0;i<30;i++)
                	{	if(y<300)
                	      {
                	         y+=speed;
                	      }
                	    try {
          				  Thread.sleep(50);
          			   } catch (Exception e) {
          				
          				   e.printStackTrace();
          				
          			      }
                	  
                	  
                	}  
                	break;
             	       
                case  3: 	  
                    //向左
                	for(int i=0;i<30;i++)
                	{ if(x>0)
                	    {
                	       x-=speed;
                	    }
                	    try {
          				  Thread.sleep(50);
          			   } catch (Exception e) {
          				
          				   e.printStackTrace();
          				
          			      }
                	  
                	  
                	}  
                	break;
                
                
                }
                
                
		
        	     //让坦克随机产生一个新的方向
                this.direct=(int) (Math.random()*4);
        
        	     //判断敌人坦克是否死亡
                if(this.isLive==false)
                {
                	//让坦克死亡后，退出线程
                	break;
                }     
            
                
        	  
          }	
		
	}
}












class  Tank
{  
	
		
	
	
	
	
	
	//定义坦克的横竖坐标

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

	int  x=0;
    int  y=0;
    
    //坦克方向  0表示向上        1表示向右       2表示向下        3表示向左
    int  direct=0;
     
    
    public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//坦克速度
    int  speed=1;  
    //坦克颜色
    int    color;
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
//我的坦克
class  Hero  extends Tank
{   
	
	Vector<Shot>   ss=new  Vector<Shot>();
	//子弹
	Shot s=null;
	
	
	
	
	//开火
	public  void  shotEnemy()
	{   
		
		switch(this.direct)
		{
		case  0:
			s=new  Shot(x+10, y,0);
			//把子弹加入向量
			ss.add(s);
			break;
			
		case  1:
			s=new  Shot(x+30, y+10,1);
			ss.add(s);
			break;
		case  2:
			s=new  Shot(x+10, y+30,2);
			ss.add(s);
			break;
		case  3:
			s=new  Shot(x, y+10,3);
			ss.add(s);
			break;
						
		}
		//启动子弹
		Thread t=new  Thread(s);
		t.start();
		
	}
	

	public Hero(int x,int  y)  
	{
		super(x, y);
	}
    //坦克向上移动
	public  void  moveUp()
	{
		y-=speed;
	}
	 //坦克向右移动	
	public  void  moveRight()
	{
		x+=speed;
	}
	 //坦克向下移动
	public  void  moveDown()
	{
		y+=speed;
	}
	 //坦克向左移动
	public  void  moveLeft()
	{
		x-=speed;
	}
	
}	
	
	
	

	   
package tank5;

import java.security.AllPermission;
import java.util.Vector;

import javax.sound.midi.VoiceStatus;

//��¼�࣬ͬʱҲ���Ա�����ҵ�����
class   Recorder
{
	//��¼�ж��ٵ���
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
	//��¼���ж��ٿ����õ���
	private  static int  mylife=5;
    
	
	
	//��¼������ٵ���
	public  static  int  allEnNum=0;
	
	
	
	

    public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	//���ٵ�����
    public   static  void reduceEnNum()
    {
    	enNum--;
    }
   
    
    public  static  void  addEnNumRec()
    {
    	allEnNum++;
    }
    
    
    
    
    
    
    
    
    
    



}















//ը����
class  Bomb
{
	//����ը��������
	int x,y;
	//ը��������
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





//�ӵ���
class Shot   implements Runnable
{
	int  x;
	int  y;
	int  direct;
	int  speed=8;
	//�Ƿ񻹻���
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
			//�ӵ� ��ʱ��
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
			
		}
	}
}



//���˵�̹��
class   EnemyTank  extends  Tank  implements   Runnable
{     
	  boolean  isLive=true;
	  
	  //����һ�����������Դ�ŵ��˵��ӵ�
	  
	  Vector<Shot>   ss=new  Vector<Shot>();
	  //��������ӵ���Ӧ���ڸոմ���̹�˵�ʱ����ӵ�������
	  
	  
	  
	  
	
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
                	   //˵��̹�˷�����������
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
             	   //˵��̹�˷�����������
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
                    //����
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
                
                
		
        	     //��̹���������һ���µķ���
                this.direct=(int) (Math.random()*4);
        
        	     //�жϵ���̹���Ƿ�����
                if(this.isLive==false)
                {
                	//��̹���������˳��߳�
                	break;
                }     
            
                
        	  
          }	
		
	}
}












class  Tank
{  
	
		
	
	
	
	
	
	//����̹�˵ĺ�������

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
    
    //̹�˷���  0��ʾ����        1��ʾ����       2��ʾ����        3��ʾ����
    int  direct=0;
     
    
    public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//̹���ٶ�
    int  speed=1;  
    //̹����ɫ
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
//�ҵ�̹��
class  Hero  extends Tank
{   
	
	Vector<Shot>   ss=new  Vector<Shot>();
	//�ӵ�
	Shot s=null;
	
	
	
	
	//����
	public  void  shotEnemy()
	{   
		
		switch(this.direct)
		{
		case  0:
			s=new  Shot(x+10, y,0);
			//���ӵ���������
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
		//�����ӵ�
		Thread t=new  Thread(s);
		t.start();
		
	}
	

	public Hero(int x,int  y)  
	{
		super(x, y);
	}
    //̹�������ƶ�
	public  void  moveUp()
	{
		y-=speed;
	}
	 //̹�������ƶ�	
	public  void  moveRight()
	{
		x+=speed;
	}
	 //̹�������ƶ�
	public  void  moveDown()
	{
		y+=speed;
	}
	 //̹�������ƶ�
	public  void  moveLeft()
	{
		x-=speed;
	}
	
}	
	
	
	

	   
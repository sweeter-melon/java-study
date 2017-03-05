package ��33��;

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

//��¼�࣬ͬʱ���Ա�����ҵ�����
class Recorder
{
	//��¼ÿ���ж��ٵ���
	 static int enNum=20;
	
	//�������ж��ٿ����õ���
	   static int mylife=3;
		
	   //��¼����ĵ�������
	   static int allenNum=0;
	   
	   
	   //����һ��ٵ���̹���������浽�ļ���
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
	   
	 //���ļ��ж�ȡ��¼
	public Vector<Node> getNoderec()
	{
		 try {
				fr=new FileReader("d:\\tank.txt");
				br=new BufferedReader(fr);
				String n="";
				//�ȶ�ȡ��һ��
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
						//д��
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



//ը����

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






//̹����
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

	int x=0; //̹�˺�����
	int y=0; //̹��������
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

//�ӵ���
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
			//�ӵ���ʱ����
			
			//�жϸ��ӵ��Ƿ�������Ե
			
			if(x<-1||x>401||y<-1||y>301)
			{
				this.islive=false;
				break;
			}
		}
	}
}



//�ҵ�̹��

class Hero extends Tank
{
	Shot s=null;
	int speed=3;// ̹���ٶ�
	Vector<Shot> ss=new Vector<Shot>();
	public Hero(int x,int y)
	{
		super(x, y);//����������ø���Ĺ��캯��
	}
	
	//����
	
	public void shotenemy()
	{
		
		
	switch (this.direct) {
	case 0:
		
		s=new Shot(x+9, y-7,0);  //�����ӵ�
		ss.add(s);  //���ӵ���������
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


//����̹��

class Enemytank extends Tank implements Runnable
{
	//����һ���������ʵ���̹��
	Vector<Enemytank> ets=new Vector<Enemytank>();
	
	
	int speed=2;// ̹���ٶ�
	//����һ����������ŵ����ӵ�
	Vector<Shot> ss=new Vector<Shot>();
	
	//���˷��ӵ�Ӧ���ڸմ���̹�˺͵���̹��������
	
	 public Enemytank(int x,int y) {
	
		super(x, y);//����������ø���Ĺ��캯��
	}
	 
	 //�õ�mypanel�ĵ���̹������
	 public void setEts(Vector<Enemytank> vv)
	 {
		 this.ets=vv;
	 }
	 
	 
	 //�ж��Ƿ������˱�ĵ���̹��
	 public boolean istouchotherenemy()
	 {
		boolean b=false;
		switch (this.direct) {
		case 0:
			//�ҵ�̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				Enemytank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//���˷������»�����
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
			//̹������
        	for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				Enemytank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//���˷������»�����
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
    	   //tank����
    	   
    	   for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				Enemytank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//���˷������»�����
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
				//ȡ����һ��̹��
				Enemytank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					//���˷������»�����
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
				//˵��̹�������ƶ�
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
							
							s=new Shot(x+9, y-7,0);  //�����ӵ�
							ss.add(s);  //���ӵ���������
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
			
			
			//��������µķ���
			this.direct=(int)(Math.random()*4);
			
			//�жϵ���̹���Ƿ�����
			if(this.islive==false)
			{
				break;
			}
			
			
		}
		
		
	}
	
}

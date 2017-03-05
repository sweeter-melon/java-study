
//作者 zhangwenzhe
//功能 解决丢手帕问题

package 丢手帕问题;

import javax.xml.crypto.Data;

public class D11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cyclink cyclink=new Cyclink();
		cyclink.setlen(5);
		cyclink.setk(2);
		cyclink.setm(2);
		cyclink.creatlink();
		cyclink.show();
		cyclink.play();

	}

}

class Child
{
	int no;
	Child nextChild=null;
	public Child(int no)
	{
		//给一个编号
		this.no=no;
	}
}

//环形链表
class Cyclink
{
	//先定义一个指向链表头的引用
	//指向第一个小孩的引用不能动;
	Child firstChild=null;
	Child temp=null;
	int len=0; //共有多少小孩
	int k=0;
	int m=0;
	
	public void setm(int m)
	{
		this.m=m;
	}
	//设置环形链表大小
	public void setlen(int len)
	{
	this.len=len;
	}
	
	//开始游戏
	public void play()
	{
		Child temp=this.firstChild;
		//1.先找到开始数的人
		for(int i=1;i<k;i++)
		{
			temp=temp.nextChild;
		}
		//2.数m下
		while(this.len!=1)
		{
		for(int j=1;j<m;j++)
		{
			temp=temp.nextChild;
		}
			
		//找到要出圈的前一个小孩
		Child temp2=temp;
		
		while(temp2.nextChild!=temp)
		{
			temp2=temp2.nextChild;
		}
		//3.将数到m的小孩退出圈
		
		temp2.nextChild=temp.nextChild;
		//让temp指向下一个数数的小孩
		temp=temp.nextChild;
		//this.show();
		
		this.len--;
		}
		//最后一个小孩打印出来
		System.out.println("最后结果 "+temp.no);
	}
	//设置从第几个人开始数数
	
	public void setk(int k)
	{
		this.k=k;
	}
	//初始化环形链表
	
	public void creatlink()
	{
		for(int i=1;i<=len;i++)
		{
			if(i==1)
			{
			//创建第一个小孩
			Child ch=new Child(i);
			this.firstChild=ch;
			this.temp=ch;
			}
			else
			{
				//创建最后一个小孩
				if(i==len)
				{
					Child ch=new Child(i);
					temp.nextChild=ch;
					temp=ch;
					temp.nextChild=this.firstChild;
				}
				else
				{
				//继续创建小孩
				Child ch=new Child(i);
				temp.nextChild=ch;
				temp=ch;
				}
			}
		}
	}
	
	//打印环形链表
	public void show()
	{
		//定义一个跑龙套
		Child temp=this.firstChild;
 do 
 {
	System.out.print(temp.no+" ");
	temp=temp.nextChild;
 } 
 while (temp!=this.firstChild);

		
	}
	
	
	
}


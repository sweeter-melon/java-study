package 第21讲;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;


//LinkerList比起ArrayList多了几个用法
public class Demo3 {

	public static void main(String []args)
	{
		/*LinkedList用法
		LinkedList bl=new LinkedList();
		Emp emp1=new Emp("104","zhang", 6000);
		Emp emp2=new Emp("108","zwen", 8000);
		
		bl.addFirst(emp2);//表示往前面加
		bl.addLast(emp1);
		
		for(int i=0;i<bl.size();i++)
		{
			Emp emp=(Emp)bl.get(i);
			System.out.println(emp.getName());
		}*/
		
	/*vector用法
		Vector cl=new Vector();
		Emp emp1=new Emp("104","zhang", 6000);
       cl.add(emp1);
		
		for(int i=0;i<cl.size();i++)
		{
			Emp emp=(Emp)cl.get(i);
			System.out.println(emp.getName());
		}*/
		
		//Stack用法
		/*
		Emp emp1=new Emp("104","zhang", 6000);
		Emp emp2=new Emp("108","zwen", 8000);
		
		
		Stack dl=new Stack();
		dl.add(emp1);
		dl.add(emp2);
		
		for(int i=0;i<dl.size();i++)
		{
			Emp emp=(Emp)dl.get(i);
			System.out.println(emp.getName());
		}
		*/
		
		//创建一个HashMap对象
		/*
		HashMap hm=new HashMap();
		Emp emp1=new Emp("s001", "huahua", 9600);
		Emp emp2=new Emp("s002", "huhu", 6600);
		Emp emp3=new Emp("s003", "haha", 2600);
		//将emp放入hm
		
		hm.put("huahua", emp1);
		hm.put("s002", emp2);
		hm.put("s002", emp3);  //关键字相同，后面的会将前面覆盖
		
		
		//如果你要找编号是s002
		
		if(hm.containsKey("s002"))
		{
		System.out.println("有该员工");
		//如何取出键值
		Emp emp=(Emp)hm.get("s002");
		System.out.println("名字是"+emp.getName());
		
		}
		else
		{
			System.out.println("没有该员工");
		}
		
		//遍历HashMap中所有的key和value
		//Iterator迭代
		Iterator it=hm.keySet().iterator();  //迭代器
		
	//HasNext返回一个boolean	
		while(it.hasNext())
		{
			//取出key
			String key=it.next().toString();
			//通过key取出value
			Emp emp=(Emp)hm.get(key);
			System.out.println("名字："+emp.getName());
			System.out.println("薪水："+emp.getSal());
		}
		*/
		
		//HashMap可以将空值做为key或value，Hashtable不行
		//Hashtable ht=new Hashtable();
		//ht.put(null, null);
		HashMap hm=new HashMap();
			hm.put(null, null);
		System.out.println("测试"+hm.get(null));
	}
}


//Hashtable是同步的，线程安全
//HashMap是异步，线程不安全
//Vector是同步，线程安全
//ArrayList是异步，线程不安全
//linkedlist是异步，线程不安全
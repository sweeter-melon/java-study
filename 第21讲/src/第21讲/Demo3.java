package ��21��;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;


//LinkerList����ArrayList���˼����÷�
public class Demo3 {

	public static void main(String []args)
	{
		/*LinkedList�÷�
		LinkedList bl=new LinkedList();
		Emp emp1=new Emp("104","zhang", 6000);
		Emp emp2=new Emp("108","zwen", 8000);
		
		bl.addFirst(emp2);//��ʾ��ǰ���
		bl.addLast(emp1);
		
		for(int i=0;i<bl.size();i++)
		{
			Emp emp=(Emp)bl.get(i);
			System.out.println(emp.getName());
		}*/
		
	/*vector�÷�
		Vector cl=new Vector();
		Emp emp1=new Emp("104","zhang", 6000);
       cl.add(emp1);
		
		for(int i=0;i<cl.size();i++)
		{
			Emp emp=(Emp)cl.get(i);
			System.out.println(emp.getName());
		}*/
		
		//Stack�÷�
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
		
		//����һ��HashMap����
		/*
		HashMap hm=new HashMap();
		Emp emp1=new Emp("s001", "huahua", 9600);
		Emp emp2=new Emp("s002", "huhu", 6600);
		Emp emp3=new Emp("s003", "haha", 2600);
		//��emp����hm
		
		hm.put("huahua", emp1);
		hm.put("s002", emp2);
		hm.put("s002", emp3);  //�ؼ�����ͬ������ĻὫǰ�渲��
		
		
		//�����Ҫ�ұ����s002
		
		if(hm.containsKey("s002"))
		{
		System.out.println("�и�Ա��");
		//���ȡ����ֵ
		Emp emp=(Emp)hm.get("s002");
		System.out.println("������"+emp.getName());
		
		}
		else
		{
			System.out.println("û�и�Ա��");
		}
		
		//����HashMap�����е�key��value
		//Iterator����
		Iterator it=hm.keySet().iterator();  //������
		
	//HasNext����һ��boolean	
		while(it.hasNext())
		{
			//ȡ��key
			String key=it.next().toString();
			//ͨ��keyȡ��value
			Emp emp=(Emp)hm.get(key);
			System.out.println("���֣�"+emp.getName());
			System.out.println("нˮ��"+emp.getSal());
		}
		*/
		
		//HashMap���Խ���ֵ��Ϊkey��value��Hashtable����
		//Hashtable ht=new Hashtable();
		//ht.put(null, null);
		HashMap hm=new HashMap();
			hm.put(null, null);
		System.out.println("����"+hm.get(null));
	}
}


//Hashtable��ͬ���ģ��̰߳�ȫ
//HashMap���첽���̲߳���ȫ
//Vector��ͬ�����̰߳�ȫ
//ArrayList���첽���̲߳���ȫ
//linkedlist���첽���̲߳���ȫ
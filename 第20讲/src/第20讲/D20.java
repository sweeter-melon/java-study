package ��20��;

public class D20 {
	
	public static void main(String []args)
	{
		
		int a=1>>2; //��������  ��λ���������λ���䣬�÷���λ������ĸ�λ
		int b=-1>>2;
		int c=1<<2;   //��������  ����λ���䣬��λ��0
		int d=-1<<2;
		int e=3>>>2;  //�߼�����  ��λ�������λ��0
		//������
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
               		
               //��������λΪ0������Ϊ1
		//���Բ�����м��㣬��ת����ԭ��
		//����ԭ�룬���룬������ͬ������һ������λ
		System.out.println("~2="+(~2));//ȡ��������λҲ��
		System.out.println("2&3="+(2&3));
		System.out.println("~2="+(~2));
		System.out.println("-3^3="+(-3^3));//���ɼ���ȡ
		System.out.println("~-5="+(~-5));
		
	}

}

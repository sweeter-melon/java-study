package 第20讲;

public class D20 {
	
	public static void main(String []args)
	{
		
		int a=1>>2; //算术右移  低位溢出，符号位不变，用符号位补溢出的高位
		int b=-1>>2;
		int c=1<<2;   //算术左移  符号位不变，低位补0
		int d=-1<<2;
		int e=3>>>2;  //逻辑右移  低位溢出，高位补0
		//输出结果
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
               		
               //正数符号位为0，负数为1
		//都以补码进行计算，再转换成原码
		//正数原码，反码，补码相同，都加一个符号位
		System.out.println("~2="+(~2));//取反，符号位也变
		System.out.println("2&3="+(2&3));
		System.out.println("~2="+(~2));
		System.out.println("-3^3="+(-3^3));//不可兼析取
		System.out.println("~-5="+(~-5));
		
	}

}

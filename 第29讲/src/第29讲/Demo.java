//界面开发演示


package 第29讲;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo extends JFrame{

	//把需要的swing组件定义到这里
	JButton jb1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    Demo demo=new Demo();
		
	}

	
	//构造函数
	
	public Demo()
	{
		//JFrame是一个顶层容器
				//JFrame jfFrame=new JFrame();
				
				jb1=new JButton("开始游戏");
				
				//给窗体设置标题
			this.setTitle("坤哥vs胖子");
			
			//设置大小，按像素（1像素=？厘米）
				this.setSize(200, 200);
				
				//添加JButton组件
				this.add(jb1);
				
				//设置初始位置
				this.setLocation(100,200);
				
				//设置当关闭窗口时，保证jvm也退出
				this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
				
				//显示
				
				this.setVisible(true);
	}
}

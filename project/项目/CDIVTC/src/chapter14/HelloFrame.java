package chapter14;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HelloFrame {
	public static void main(String[] args) {
		//创建一个窗体（作为顶层容器）
		JFrame jf = new JFrame("hello");
		
		//创建一个中间容器
		JPanel p = new JPanel();
		//创建按钮
		JButton j1 = new JButton("普通按钮1");
		p.add(j1);
		JButton j2 = new JButton("普通按钮2");
		p.add(j2);
		jf.add(p);//将中间容器加入到顶层容器中
		//jf.setTitle("我的第一个窗口");
		jf.setSize(400,300);//窗体尺寸，像素
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//窗体显示的位置居中
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//调用该方法后，关闭按钮才可以真正使程序停止
		
	}
}

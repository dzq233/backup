package chapter14;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * 模拟计算器页面
 */
public class Calu {

	public static void main(String[] args) {
		JFrame jf = new JFrame("计算器");
		//上半部分
		JPanel jp1 = new JPanel();
		JTextField jt1 = new JTextField(20);//文本框
		jp1.add(jt1);
		jf.add(jp1,BorderLayout.NORTH);//插入到窗体的NORTH
		//下半部分
		JPanel jp2 = new JPanel();
		//设置布局为GridLayout网格式
		jp2.setLayout(new GridLayout(4,4,5,5));
		String[] n = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		for(int i=0;i<n.length;i++) {
			jp2.add(new JButton(n[i]));
		}
		
		
		jf.add(jp2,BorderLayout.CENTER);
		
		jf.setSize(400,300);//窗体尺寸，像素
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//窗体显示的位置居中
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}

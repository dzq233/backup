package chapter14;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GridLay {

	public static void main(String[] args) {
		JFrame jf = new JFrame("BorderLayout窗体");
		//四个参数：行数，列数，左右间距，上下间距
		jf.setLayout(new GridLayout(3,3,5,5));
		String[] n = {"1","2","3","4","5","6","7","8","9"};
		for(int i=0;i<n.length;i++) {
			jf.add(new JButton(n[i]));
		}
		//老办法
		/*JButton j1 = new JButton("1");
		JButton j2 = new JButton("2");
		JButton j3 = new JButton("3");
		JButton j4 = new JButton("4");
		JButton j5 = new JButton("5");
		JButton j6 = new JButton("6");
		JButton j7 = new JButton("7");
		JButton j8 = new JButton("8");
		JButton j9 = new JButton("9");
		jf.add(j1);
		jf.add(j2);
		jf.add(j3);
		jf.add(j4);
		jf.add(j5);
		jf.add(j6);
		jf.add(j7);
		jf.add(j8);
		jf.add(j9);*/
		
		
		jf.setSize(400,300);//窗体尺寸，像素
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//窗体显示的位置居中
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

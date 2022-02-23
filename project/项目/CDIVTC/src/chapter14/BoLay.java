package chapter14;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BoLay {

	public static void main(String[] args) {
		// JFrame默认布局是BorderLayout
		JFrame jf = new JFrame("BorderLayout窗体");
		jf.setLayout(new BorderLayout(40,10));
		//创建5个按钮，分别插入到5个区域
		JButton j1 = new JButton("上"),
				j2 = new JButton("下"),
				j3 = new JButton("左"),
				j4 = new JButton("右"),
				j5 = new JButton("中");
		//将5个按钮插入到5个区域
		jf.add(j1,BorderLayout.NORTH);
		jf.add(j2,BorderLayout.SOUTH);
		jf.add(j3,BorderLayout.WEST);
		jf.add(j4,BorderLayout.EAST);
		jf.add(j5,BorderLayout.CENTER);
		
		
		jf.setSize(400,300);//窗体尺寸，像素
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//窗体显示的位置居中
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

package chapter14;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CompDemo {

	public static void main(String[] args) {
		JFrame jf = new JFrame("组件演示");
		JPanel p = new JPanel();
		
		//文本标签
		JLabel jl1 = new JLabel("用户名");
		p.add(jl1);
		//图文表情
		JLabel jl2 = new JLabel("百度");
		jl2.setText("百度");
		jl2.setIcon(new ImageIcon("c:/baidulogo.png"));
		jl2.setHorizontalAlignment(SwingConstants.CENTER);
		jl2.setVerticalTextPosition(SwingConstants.BOTTOM);
		p.add(jl2);
		jf.add(p);
		//文本区域
		JTextArea jt = new JTextArea(7,20);
		jt.setLineWrap(true);//自动换行
		JScrollPane jsp = new JScrollPane(jt);
		//创建一个滚动区域，构造方法参数为指定的文本区域文字
		p.add(jsp);
		
		//复选框
		JCheckBox jc1 = new JCheckBox("运动");
		p.add(jc1);
		JCheckBox jc2 = new JCheckBox("唱歌");
		p.add(jc2);
		JCheckBox jc3 = new JCheckBox("上网");
		p.add(jc3);
		
		//单选框
		ButtonGroup bg = new ButtonGroup();//创建按钮组，该组内只允许选择一个
		JRadioButton j1 = new JRadioButton("男");
		p.add(j1);
		p.add(j1);
		JRadioButton j2 = new JRadioButton("女");
		p.add(j2);
		p.add(j2);
		
		//下拉框
		JComboBox jc = new JComboBox();
		jc.addItem("---请选择---");
		jc.addItem("成都");
		jc.addItem("重庆");
		p.add(jc);
		jf.setSize(400,300);//窗体尺寸，像素
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//窗体显示的位置居中
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

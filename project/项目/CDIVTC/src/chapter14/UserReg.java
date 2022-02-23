package chapter14;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class UserReg {
	public static void main(String[] args) {
		JFrame jf = new JFrame("用户注册");
		JPanel p = new JPanel();
		p.setLayout(null);

		// 用户名
		JLabel jl1 = new JLabel("用户名：");
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		// 绝对定位参数依次为：距左，距顶。组件自己所占的宽度、高度
		jl1.setBounds(30, 30, 60, 30);
		p.add(jl1);
		JTextField jt1 = new JTextField(30);
		jt1.setBounds(100, 30, 180, 30);
		p.add(jt1);

		// 密码
		JLabel jl2 = new JLabel("密码：");
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		// 绝对定位参数依次为：距左，距顶。组件自己所占的宽度、高度
		jl2.setBounds(30, 70, 60, 30);
		p.add(jl2);
		JTextField jt2 = new JTextField(30);
		jt2.setBounds(100, 70, 180, 30);
		p.add(jt2);

		// 单选框
		JLabel jl3 = new JLabel("性别：");
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);

		// 绝对定位参数依次为：距左，距顶。组件自己所占的宽度、高度
		jl3.setBounds(30, 110, 60, 30);
		// 单选框
		p.add(jl3);
		ButtonGroup bg = new ButtonGroup();
		JRadioButton jr1 = new JRadioButton("男");
		jr1.setBounds(100, 110, 40, 30);
		JRadioButton jr2 = new JRadioButton("女");
		jr2.setBounds(140, 110, 40, 30);
		bg.add(jr1);
		bg.add(jr2);
		p.add(jr1);
		p.add(jr2);

		// 下拉菜单
		JLabel jl4 = new JLabel("城市：");
		jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		// 绝对定位参数依次为：距左，距顶。组件自己所占的宽度、高度
		jl4.setBounds(30, 150, 60, 30);
		p.add(jl4);

		JComboBox jc = new JComboBox();
		jc.addItem("---请选择---");
		jc.addItem("成都");
		jc.addItem("重庆");
		jc.setBounds(140, 150, 130, 30);
		
		p.add(jc);
		
		

		jf.add(p);
		jf.setSize(350, 300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
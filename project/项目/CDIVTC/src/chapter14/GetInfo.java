package chapter14;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class GetInfo extends JFrame {
	//继承JFrame类,以使GetInfo类具备
	private JLabel jl1;
	private JLabel jl2;
	private JTextField jt1;
	private JButton j1;
	private JPanel p;
	
	public GetInfo() {
		p = new JPanel();//创建一个面板
		//与add（p）的区别：add是添加一个新的面板，而下面方法则是替换默认面板
		setContentPane(p);
		p.setLayout(null);//p默认是流式布局，设置为null后以使用绝对定位
		
		//用户名
		jl1 = new JLabel("用户名:");
		jl1.setBounds(40,40,40,40);
		p.add(jl1);
		
		
		
		setVisible(true);
		setTitle("获取信息");
		setSize(400,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		GetInfo g = new GetInfo();
	}
}

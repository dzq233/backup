package chapter14;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class GetInfo extends JFrame {
	//�̳�JFrame��,��ʹGetInfo��߱�
	private JLabel jl1;
	private JLabel jl2;
	private JTextField jt1;
	private JButton j1;
	private JPanel p;
	
	public GetInfo() {
		p = new JPanel();//����һ�����
		//��add��p��������add�����һ���µ���壬�����淽�������滻Ĭ�����
		setContentPane(p);
		p.setLayout(null);//pĬ������ʽ���֣�����Ϊnull����ʹ�þ��Զ�λ
		
		//�û���
		jl1 = new JLabel("�û���:");
		jl1.setBounds(40,40,40,40);
		p.add(jl1);
		
		
		
		setVisible(true);
		setTitle("��ȡ��Ϣ");
		setSize(400,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		GetInfo g = new GetInfo();
	}
}

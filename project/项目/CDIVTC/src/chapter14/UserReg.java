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
		JFrame jf = new JFrame("�û�ע��");
		JPanel p = new JPanel();
		p.setLayout(null);

		// �û���
		JLabel jl1 = new JLabel("�û�����");
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		// ���Զ�λ��������Ϊ�����󣬾ඥ������Լ���ռ�Ŀ�ȡ��߶�
		jl1.setBounds(30, 30, 60, 30);
		p.add(jl1);
		JTextField jt1 = new JTextField(30);
		jt1.setBounds(100, 30, 180, 30);
		p.add(jt1);

		// ����
		JLabel jl2 = new JLabel("���룺");
		jl2.setHorizontalAlignment(SwingConstants.RIGHT);
		// ���Զ�λ��������Ϊ�����󣬾ඥ������Լ���ռ�Ŀ�ȡ��߶�
		jl2.setBounds(30, 70, 60, 30);
		p.add(jl2);
		JTextField jt2 = new JTextField(30);
		jt2.setBounds(100, 70, 180, 30);
		p.add(jt2);

		// ��ѡ��
		JLabel jl3 = new JLabel("�Ա�");
		jl3.setHorizontalAlignment(SwingConstants.RIGHT);

		// ���Զ�λ��������Ϊ�����󣬾ඥ������Լ���ռ�Ŀ�ȡ��߶�
		jl3.setBounds(30, 110, 60, 30);
		// ��ѡ��
		p.add(jl3);
		ButtonGroup bg = new ButtonGroup();
		JRadioButton jr1 = new JRadioButton("��");
		jr1.setBounds(100, 110, 40, 30);
		JRadioButton jr2 = new JRadioButton("Ů");
		jr2.setBounds(140, 110, 40, 30);
		bg.add(jr1);
		bg.add(jr2);
		p.add(jr1);
		p.add(jr2);

		// �����˵�
		JLabel jl4 = new JLabel("���У�");
		jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		// ���Զ�λ��������Ϊ�����󣬾ඥ������Լ���ռ�Ŀ�ȡ��߶�
		jl4.setBounds(30, 150, 60, 30);
		p.add(jl4);

		JComboBox jc = new JComboBox();
		jc.addItem("---��ѡ��---");
		jc.addItem("�ɶ�");
		jc.addItem("����");
		jc.setBounds(140, 150, 130, 30);
		
		p.add(jc);
		
		

		jf.add(p);
		jf.setSize(350, 300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
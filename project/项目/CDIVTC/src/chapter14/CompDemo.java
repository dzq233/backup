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
		JFrame jf = new JFrame("�����ʾ");
		JPanel p = new JPanel();
		
		//�ı���ǩ
		JLabel jl1 = new JLabel("�û���");
		p.add(jl1);
		//ͼ�ı���
		JLabel jl2 = new JLabel("�ٶ�");
		jl2.setText("�ٶ�");
		jl2.setIcon(new ImageIcon("c:/baidulogo.png"));
		jl2.setHorizontalAlignment(SwingConstants.CENTER);
		jl2.setVerticalTextPosition(SwingConstants.BOTTOM);
		p.add(jl2);
		jf.add(p);
		//�ı�����
		JTextArea jt = new JTextArea(7,20);
		jt.setLineWrap(true);//�Զ�����
		JScrollPane jsp = new JScrollPane(jt);
		//����һ���������򣬹��췽������Ϊָ�����ı���������
		p.add(jsp);
		
		//��ѡ��
		JCheckBox jc1 = new JCheckBox("�˶�");
		p.add(jc1);
		JCheckBox jc2 = new JCheckBox("����");
		p.add(jc2);
		JCheckBox jc3 = new JCheckBox("����");
		p.add(jc3);
		
		//��ѡ��
		ButtonGroup bg = new ButtonGroup();//������ť�飬������ֻ����ѡ��һ��
		JRadioButton j1 = new JRadioButton("��");
		p.add(j1);
		p.add(j1);
		JRadioButton j2 = new JRadioButton("Ů");
		p.add(j2);
		p.add(j2);
		
		//������
		JComboBox jc = new JComboBox();
		jc.addItem("---��ѡ��---");
		jc.addItem("�ɶ�");
		jc.addItem("����");
		p.add(jc);
		jf.setSize(400,300);//����ߴ磬����
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//������ʾ��λ�þ���
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

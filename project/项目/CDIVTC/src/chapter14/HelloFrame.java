package chapter14;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HelloFrame {
	public static void main(String[] args) {
		//����һ�����壨��Ϊ����������
		JFrame jf = new JFrame("hello");
		
		//����һ���м�����
		JPanel p = new JPanel();
		//������ť
		JButton j1 = new JButton("��ͨ��ť1");
		p.add(j1);
		JButton j2 = new JButton("��ͨ��ť2");
		p.add(j2);
		jf.add(p);//���м��������뵽����������
		//jf.setTitle("�ҵĵ�һ������");
		jf.setSize(400,300);//����ߴ磬����
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//������ʾ��λ�þ���
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//���ø÷����󣬹رհ�ť�ſ�������ʹ����ֹͣ
		
	}
}

package chapter14;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BoLay {

	public static void main(String[] args) {
		// JFrameĬ�ϲ�����BorderLayout
		JFrame jf = new JFrame("BorderLayout����");
		jf.setLayout(new BorderLayout(40,10));
		//����5����ť���ֱ���뵽5������
		JButton j1 = new JButton("��"),
				j2 = new JButton("��"),
				j3 = new JButton("��"),
				j4 = new JButton("��"),
				j5 = new JButton("��");
		//��5����ť���뵽5������
		jf.add(j1,BorderLayout.NORTH);
		jf.add(j2,BorderLayout.SOUTH);
		jf.add(j3,BorderLayout.WEST);
		jf.add(j4,BorderLayout.EAST);
		jf.add(j5,BorderLayout.CENTER);
		
		
		jf.setSize(400,300);//����ߴ磬����
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//������ʾ��λ�þ���
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

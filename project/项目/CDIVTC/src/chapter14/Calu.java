package chapter14;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * ģ�������ҳ��
 */
public class Calu {

	public static void main(String[] args) {
		JFrame jf = new JFrame("������");
		//�ϰ벿��
		JPanel jp1 = new JPanel();
		JTextField jt1 = new JTextField(20);//�ı���
		jp1.add(jt1);
		jf.add(jp1,BorderLayout.NORTH);//���뵽�����NORTH
		//�°벿��
		JPanel jp2 = new JPanel();
		//���ò���ΪGridLayout����ʽ
		jp2.setLayout(new GridLayout(4,4,5,5));
		String[] n = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		for(int i=0;i<n.length;i++) {
			jp2.add(new JButton(n[i]));
		}
		
		
		jf.add(jp2,BorderLayout.CENTER);
		
		jf.setSize(400,300);//����ߴ磬����
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//������ʾ��λ�þ���
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}

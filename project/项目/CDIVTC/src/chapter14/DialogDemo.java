package chapter14;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DialogDemo {

	public static void main(String[] args) {
		JFrame jf = new JFrame("�Ի�����ʾ");
		
		//�ĸ���������һ������Ϊ��Ԫ�أ����Ϊnull������Ļ�м�
		//�ڶ����������Ի����е�����
		
		
		//���ĸ��������Ի��������
		JOptionPane.showMessageDialog(null, "������������Ϣ","��ʾ��Ϣ",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "��ͨ����","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "����������Ϣ","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "����������Ϣ","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫɾ�����û�","��ʾ��Ϣ",JOptionPane.YES_NO_CANCEL_OPTION);
		jf.setVisible(true);
		jf.setSize(400,300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

package chapter14;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DialogDemo {

	public static void main(String[] args) {
		JFrame jf = new JFrame("对话框演示");
		
		//四个参数：第一个参数为父元素，如果为null则在屏幕中间
		//第二个餐数：对话框中的文字
		
		
		//第四个参数：对话框的类型
		JOptionPane.showMessageDialog(null, "这里是文字信息","提示信息",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "普通文章","提示信息",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "警告文字信息","提示信息",JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "错误文字信息","提示信息",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showConfirmDialog(null, "你是否要删除该用户","提示信息",JOptionPane.YES_NO_CANCEL_OPTION);
		jf.setVisible(true);
		jf.setSize(400,300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

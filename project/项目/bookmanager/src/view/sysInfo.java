package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class sysInfo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sysInfo frame = new sysInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sysInfo() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7CFB\u7EDF\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("¿¬Ìå", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		
		JLabel label_3 = new JLabel("\u5F00\u53D1\u65F6\u95F4\uFF1A");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3)))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(label)
					.addGap(50)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(label_2)
					.addGap(26)
					.addComponent(label_3)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}

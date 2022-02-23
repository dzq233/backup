package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.UserDao;
import model.BookType;
import model.User;
import util.DbUtil;
import util.JudgeMent;

public class BookUserAdd extends JInternalFrame {
	private JTextField UserNameTxt;
	private JTextField pwdTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUserAdd frame = new BookUserAdd();
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
	public BookUserAdd() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7528\u6237\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		UserNameTxt = new JTextField();
		UserNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		
		pwdTxt = new JTextField();
		pwdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u5B9A\u5BC6\u7801\uFF1A");
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String UserName=UserNameTxt.getText();
					String pwd=pwdTxt.getText();
					String password=passwordTxt.getText();
					if(JudgeMent.isEmpty(UserName)) {
						JOptionPane.showMessageDialog(null, "用户名不能为空");
						return;
					}
					if(JudgeMent.isEmpty(pwd)) {
						JOptionPane.showMessageDialog(null, "密码不能为空");
						return;
					}
					if(JudgeMent.isEmpty(password)) {
						JOptionPane.showMessageDialog(null, "确定密码不能为空");
						return;
					}
					if (!pwd.equals(password)){
						JOptionPane.showMessageDialog(null, "两次输入密码不匹配");
						return;
					}
					User user = new User(UserName,pwd);
				Connection con = null;
				try {
					con = DbUtil.getConnection();
					int n=UserDao.add(con,user);//如果返回值为1则插入记录成功
					if(n==1){
						JOptionPane.showMessageDialog(null, "添加成功");
					}else{
						JOptionPane.showMessageDialog(null, "添加失败");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserNameTxt.setText("");
				pwdTxt.setText("");
				passwordTxt.setText("");

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2)
									.addGap(33)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
										.addComponent(UserNameTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
							.addGap(14)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(86))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(UserNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}

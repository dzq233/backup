package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LogOnFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passWordTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao useDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrame frame = new LogOnFrame();
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
	public LogOnFrame() {
		setResizable(false);
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setIcon(new ImageIcon(LogOnFrame.class.getResource("/images/logo.png")));
		label.setFont(new Font("΢���ź�", Font.BOLD, 14));
		
		JFormattedTextField userNameTxt = new JFormattedTextField();
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setIcon(new ImageIcon(LogOnFrame.class.getResource("/images/userName.png")));
		
		passWordTxt = new JPasswordField();
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setIcon(new ImageIcon(LogOnFrame.class.getResource("/images/password.png")));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LogOnFrame.class.getResource("/images/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameTxt.getText();//��ȡ�û�������û���
				String passWord = passWordTxt.getText();//����
				//���÷����Ի�ȡ����ֵ�жϣ��������true��û������
				if(JudgeMent.isEmpty(userName)) {
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					return;//��ִ���Ժ����
				}
				if(JudgeMent.isEmpty(passWord)) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					return;//��ִ���Ժ����
				}
				//�������Ϸ���������ݿ���бȶ�
				User user = new User(userName,passWord);
				Connection con = null;
				try {
					con = dbUtil.getCon();//�������ݿ�
					UserDao userDao = new UserDao();
					User n_user = userDao.login(user,con);
					if (n_user!=null) {
						//JOptionPane.showMessageDialog(null, "��¼�ɹ�","��ʾ��Ϣ", JOptionPane.PLAIN_MESSAGE);
						//����������MainFrame
						dispose();//���ٵ�ǰ����
						new MainFrame().setVisible(true);
					}else {
						JOptionPane.showInternalConfirmDialog(null, "�û������������","��ʾ��Ϣ",JOptionPane.PLAIN_MESSAGE);
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passWordTxt.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrame.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passWordTxt)
								.addComponent(userNameTxt)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addComponent(btnNewButton)
							.addGap(68)
							.addComponent(btnNewButton_1)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

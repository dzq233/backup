package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;


import dao.BookTypeDao;
import model.BookType;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookTypeAdd extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextField bookTypeDescTxt;
	
	private DbUtil dbutil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAdd frame = new BookTypeAdd();
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
	public BookTypeAdd() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u6458\u8981\uFF1A");
		
		JButton btuNewButton = new JButton("\u63D0\u4EA4");
		btuNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断是否为空
				String bookTypeName = bookTypeNameTxt.getText();//获取用户输入的类别名称
				String bookTypeDesc = bookTypeDescTxt.getText();
				//调用方法对获取到的值判断，如果返回true则没有输入
				if(JudgeMent.isEmpty(bookTypeName)) {
					JOptionPane.showMessageDialog(null, "图书类别不能为空","提示信息",JOptionPane.WARNING_MESSAGE);
					return;//不执行以后语句
					
					
				}
				if(JudgeMent.isEmpty(bookTypeDesc)) {
					JOptionPane.showConfirmDialog(null, "图书摘要不能为空","提示信息",JOptionPane.WARNING_MESSAGE);
					return;
				}
				BookType bt = new BookType(bookTypeName,bookTypeDesc);
				Connection con;
				try {
					con = dbutil.getCon();
					int n = bookTypeDao.add(con, bt);//如果返回值为1，则插入记录成功
					if(n == 1) {
						JOptionPane.showMessageDialog(null, "图书类别添加成功");
					}
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btuNewButton.setIcon(new ImageIcon(BookTypeAdd.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeNameTxt.setText("");
				bookTypeDescTxt.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeAdd.class.getResource("/images/reset.png")));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeNameTxt.setText("");
				bookTypeDescTxt.setText("");
			}
		});
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextField();
		bookTypeDescTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeDescTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(btuNewButton)
							.addGap(92)
							.addComponent(btnNewButton_1)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btuNewButton)
						.addComponent(btnNewButton_1))
					.addGap(39))
		);
		getContentPane().setLayout(groupLayout);

	}
}

package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAdd extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	private JComboBox bookTypeCombox;//下拉框
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAdd frame = new BookAdd();
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
	public BookAdd() {
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 575, 383);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7C7B\u522B\uFF1A");
		
		bookTypeCombox = new JComboBox();
		bookTypeCombox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u6458\u8981\uFF1A");
		
		JTextArea bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookName=bookNameTxt.getText();
				String author=authorTxt.getText();
				String price=priceTxt.getText();
				String bookDesc=bookDescTxt.getText();
				if(JudgeMent.isEmpty(bookName)) {
					JOptionPane.showMessageDialog(null, "图书名称不能为空");
					return;
				}
				if(JudgeMent.isEmpty(author)) {
					JOptionPane.showMessageDialog(null, "作者不能为空");
					return;
				}
				if(JudgeMent.isEmpty(price)) {
					JOptionPane.showMessageDialog(null, "价格不能为空");
					return;
				}
				if(JudgeMent.isEmpty(bookDesc)) {
					JOptionPane.showMessageDialog(null, "图书摘要不能为空");
					return;
				}
				//选择的图书类别的id号获取
				BookType bookType=(BookType)bookTypeCombox.getSelectedItem();
				int bookTypeId=bookType.getId();
				Book book=new Book(bookName,author,Float.parseFloat(price),bookTypeId,bookDesc);
				Connection con=null;
				try {
					con=dbUtil.getCon();
					int p=bookDao.add(con, book);
					if(p==1) {
						JOptionPane.showMessageDialog(null, "图书添加成功");
						bookNameTxt.setText("");
						authorTxt.setText("");
						priceTxt.setText("");
						bookDescTxt.setText("");
						if(bookTypeCombox.getItemCount() > 0) {//如果分类下拉框元素大于0
							bookTypeCombox.setSelectedIndex(0);//则选择第一个
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "图书添加失败");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAdd.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(BookAdd.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(priceTxt)
										.addComponent(bookNameTxt, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
									.addGap(36)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_3))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(bookTypeCombox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(authorTxt, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
								.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(btnNewButton)
							.addGap(119)
							.addComponent(btnNewButton_1)))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookTypeCombox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(44))
		);
		getContentPane().setLayout(groupLayout);
		//调用图书类别初始化方法
		fillBookType();
	}
	
	//初始化图书类别下拉框
	public void fillBookType() {
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while(rs.next()) {
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("TypeName"));
				bookTypeCombox.addItem(bookType);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

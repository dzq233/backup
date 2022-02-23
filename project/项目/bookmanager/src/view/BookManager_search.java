package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BookManager_search extends JInternalFrame {
	private JTable table;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JComboBox bookcomboxBox = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManager_search frame = new BookManager_search();
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
	public BookManager_search() {
		setTitle("\u56FE\u4E66\u67E5\u8BE2");
		setBounds(100, 100, 629, 476);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String bookName=bookNameTxt.getText().toString();
					String author=authorTxt.getText().toString();
					JComboBox bookComboBox;
					BookType bookType=(BookType)bookcomboxBox.getSelectedItem();
					int bookTypeId=bookType.getId();
					if(JudgeMent.isEmpty(bookName)&&JudgeMent.isEmpty(author)&&bookTypeId==-1){
						fillTable(new Book());
						JOptionPane.showMessageDialog(null, "请选择任意一种查询");
						
			}
					Book book=new Book();
					book.setBookName(bookName);
					book.setAuthor(author);
					book.setBookTypeId(bookTypeId);
					
					Connection con=null;
					
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					try {
						con=DbUtil.getConnection();
						ResultSet p=BookDao.list(con, book);
							
							dtm.setRowCount(0);//每一次调用更新填充表格时，先清空更新前已有表格，否则修改时会重复显示之前的表格数据
							while(p.next()) {
							Vector v=new Vector();//向量类，实现了一个动态数组插入任意不同类型的,中间商
								v.add(p.getString("id"));//读取字段里的内容
								v.add(p.getString("bookname"));
								v.add(p.getString("author"));
								v.add(p.getFloat("price"));
								v.add(p.getString("TypeName"));
								v.add(p.getString("bookdesc"));
								dtm.addRow(v);//每循环读取一条记录就填充到表格的行
							}
							
							bookNameTxt.setText("");
							authorTxt.setText("");
							bookcomboxBox.setSelectedIndex(0);//设置选择的索引，如果分类下拉框元素大于0则选择第一个
						
						
							
							bookcomboxBox.setSelectedIndex(0);
							
						}
					catch(Exception e3) {
						e3.printStackTrace();
					}
				}
		});
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u6458\u8981");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookcomboxBox, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(299)
							.addComponent(btnNewButton)
							.addGap(79))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(38, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(171)
										.addComponent(lblNewLabel_1)
										.addContainerGap(200, Short.MAX_VALUE)))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookcomboxBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u4EF7\u683C", "\u6458\u8981", "\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillBookType();
		fillTable(new Book());

	}
	public void fillBookType() {
		Connection con=null;
		BookType bookType=null;
		try {
			con=DbUtil.getConnection();
			ResultSet rs=BookTypeDao.list(con, bookType);
			bookType=new BookType();
			bookType.setBookTypeName("--请选择--");
			bookType.setId(-1);
			
			bookcomboxBox.addItem(bookType);
			while(rs.next()) {
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("TypeName"));
				bookcomboxBox.addItem(bookType);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//定义一个数据填充表格方法
			private void fillTable(Book book) {
				//通过DefaultTableModel类可以实现获取行列以及添加数据到表格
				DefaultTableModel dtm=(DefaultTableModel)table.getModel();
				dtm.setRowCount(0);//每一次调用更新填充表格时，先清空更新前已有表格，否则修改时会重复显示之前的表格数据
				Connection con;
				try {
					con=DbUtil.getConnection();//实现数据库连接,加载数据库驱动
					//获取数据
					ResultSet rs=BookDao.list(con,book);
					//遍历集合
					while(rs.next()) {
						Vector v=new Vector();//向量类，实现了一个动态数组插入任意不同类型的,中间商
						v.add(rs.getString("id"));//读取字段里的内容
						v.add(rs.getString("bookname"));
						v.add(rs.getString("author"));
						v.add(rs.getFloat("price"));
						v.add(rs.getString("TypeName"));
						v.add(rs.getString("bookdesc"));
						
						dtm.addRow(v);//每循环读取一条记录就填充到表格的行
					}
				}catch(Exception e3) {
					e3.printStackTrace();
				}
				
			}
}

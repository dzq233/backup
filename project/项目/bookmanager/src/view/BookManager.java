package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookManager extends JInternalFrame {
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTable table;
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	private JComboBox bookTypeCombox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManager frame = new BookManager();
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
	public BookManager() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 658, 475);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4E0E\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeCombox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u6458\u8981\uFF1A");
		
		JTextArea bookDescTxt = new JTextArea();
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idTxt.getText();
				String bookname=bookNameTxt.getText();
				String author=authorTxt.getText();
				String price=priceTxt.getText();
				BookType booktype=(BookType)bookTypeCombox.getSelectedItem();//获取选择的下拉框项目（分类）
				int booktypeid=booktype.getId();
				
				String bookdesc=bookDescTxt.getText();
				Book book=new Book(Integer.parseInt(id),bookname,author,Float.parseFloat(price),booktypeid,bookdesc);
				try{
					Connection con=null;
					con=DbUtil.getCon();
					int n=bookDao.update(con, book);
					if(n==1){
						JOptionPane.showMessageDialog(null, "修改成功");
						idTxt.setText("");
						bookNameTxt.setText("");
						authorTxt.setText("");
						priceTxt.setText("");
						bookDescTxt.setText("");
						bookTypeCombox.setSelectedIndex(0);//设置为第一个项目“请选择”
						fillTable(new Book());//刷新表格
					}else{
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon(BookManager.class.getResource("/images/edit.png")));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idTxt.getText();//获取选择记录的id号
				if(JudgeMent.isEmpty(id)){
					JOptionPane.showMessageDialog(null, "请选择要删除的图书");
					return ;
				}
				int n=JOptionPane.showConfirmDialog(null, "确定要删除该图书吗？");//返回0为“是”;
				if(n==0){
					try{
						Connection con=null;
						con=DbUtil.getCon();
						int p=bookDao.delete(con,id);
						if(p==1){
							JOptionPane.showMessageDialog(null, "图书删除成功");
							idTxt.setText("");
							bookNameTxt.setText("");
							authorTxt.setText("");
							priceTxt.setText("");
							bookDescTxt.setText("");
							bookTypeCombox.setSelectedIndex(0);//设置为第一个项目“请选择”
							fillTable(new Book());//刷新表格
						}
						else{
							JOptionPane.showMessageDialog(null, "图书删除失败");
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				
			}
		});
		button_1.setIcon(new ImageIcon(BookManager.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(45)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookTypeCombox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
							.addGap(12))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(74)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(95))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeCombox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//表格行点击事件
				int row=table.getSelectedRow();
				 idTxt.setText((String) table.getValueAt(row, 0));
				 bookNameTxt.setText((String) table.getValueAt(row, 1));
				 authorTxt.setText((String) table.getValueAt(row, 2));
				 priceTxt.setText((String) table.getValueAt(row, 3)+"");
				 bookDescTxt.setText((String) table.getValueAt(row, 4));
				 //获取图书类别名称，与下拉框中的类别名称循环比对，如果返回真，则选中该项目
				 String bookTypeName=((String) table.getValueAt(row, 5));
				 int n=bookTypeCombox.getItemCount();//获取下拉框中的选项个数
				for(int i=0;i<n;i++){
					BookType item=(BookType)bookTypeCombox.getItemAt(i);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            			
					if(item.getBookTypeName().equals(bookTypeName)){
						bookTypeCombox.setSelectedIndex(i);
					}
				}
				 
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u4EF7\u683C", "\u6458\u8981", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable(new Book());
		fillBookType();

	}
	 //定义一个数据填充表格方法
		private void fillTable(Book book){
			//通过DefaultTableModel类可以实现获取行、列以及添加数据到表格
			DefaultTableModel dtm=(DefaultTableModel) table.getModel();
			dtm.setRowCount(0);//每次填充表格时，先清空已有表格，否则修改时会重复显示数据
			Connection con=null;
			try{
				con=DbUtil.getCon();
				//获取数据
				ResultSet rs=bookDao.list(con,book);
				//遍历集合
				while(rs.next()){
					Vector v=new Vector();//向量类,实现了一个动态数组,可以插入任意不同类型的对象
					v.add(rs.getString("id"));
					v.add(rs.getString("bookName"));
					v.add(rs.getString("author"));
					v.add(rs.getString("price"));
					v.add(rs.getString("bookdesc"));
					v.add(rs.getString("TypeName"));
					dtm.addRow(v);//每读取一条记录,填充到表格的行
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		

		//初始化图书类别下拉框
		public void fillBookType() {
			Connection con=null;
			BookType bookType=null;
			try {
				con=dbUtil.getCon();
				ResultSet rs=bookTypeDao.list(con, new BookType());
				bookType=new BookType();
				bookType.setBookTypeName("--请选择--");
				bookType.setId(-1);
				bookTypeCombox.addItem(bookType);
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

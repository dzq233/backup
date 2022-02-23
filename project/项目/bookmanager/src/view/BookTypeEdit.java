package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookTypeDao;
import model.BookType;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeEdit extends JInternalFrame {
	private JTable table;

	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeEdit frame = new BookTypeEdit();
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
	public BookTypeEdit() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406\u7F16\u8F91");
		setBounds(100, 100, 592, 398);
		JTextArea bookTypeDescTxt = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4E0E\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u6458\u8981\uFF1A");
		
		JButton bookNewButton = new JButton("\u4FEE\u6539");
		bookNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idTxt.getText();
				String bookTypeName=bookTypeNameTxt.getText();
				String bookTypeDesc=bookTypeDescTxt.getText();
				if(JudgeMent.isEmpty(bookTypeName)) {
					JOptionPane.showMessageDialog(null, "图书名称不能为空");
					return;
				}
				if(JudgeMent.isEmpty(bookTypeDesc)) {
					JOptionPane.showMessageDialog(null, "图书类别摘要不能为空");
					return;
				}
				BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
				Connection con;
				try {
					con=dbUtil.getCon();
					int p=bookTypeDao.update(con, bookType);
					if(p==1) {
						JOptionPane.showMessageDialog(null, "修改成功");
						fillTable(new BookType());//重新填充表格
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		bookNewButton.setIcon(new ImageIcon(BookTypeEdit.class.getResource("/images/edit.png")));
		
		JButton bookTypeButton_1 = new JButton("\u5220\u9664");
		bookTypeButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTxt.getText();
				if(JudgeMent.isEmpty(id)) {
					JOptionPane.showMessageDialog(null, "请选择要删除的记录");
					return;
				}
				int n = JOptionPane.showConfirmDialog(null, "确定要删除吗？");
				if(n == 0) {
					try {
						
					Connection con = null;
					con = dbUtil.getCon();
					int p = bookTypeDao.del(con, id);
					if(p == 1) {
						JOptionPane.showMessageDialog(null, "删除成功");
						fillTable(new BookType());
					}
					else {
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				
				}
				catch(Exception e1){
					e1.printStackTrace();
						}
					}
				}
			});
		bookTypeButton_1.setIcon(new ImageIcon(BookTypeEdit.class.getResource("/images/delete.png")));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(bookNewButton)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(41)
									.addComponent(label)
									.addGap(10)
									.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(78)
									.addComponent(bookTypeButton_1)))))
					.addGap(40))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookNewButton)
						.addComponent(bookTypeButton_1)))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//表格行点击事件，即点击鼠标后获取当前选择行的数据
				int row=table.getSelectedRow();
				idTxt.setText((String) table.getValueAt(row, 0));
				bookTypeNameTxt.setText((String) table.getValueAt(row, 1));
				bookTypeDescTxt.setText((String) table.getValueAt(row, 2));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u6458\u8981"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		
		
		//调用表格填充方法
		fillTable(new BookType());
	}
	
	//定义一个数据填充表格方法
	private void fillTable(BookType bookType) {
		//通过DefaultTableModel类可以实现获取行，列以及添加数据到表格
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//每次填充表格时，先清除已有表格，否则修改时辉重复显示表格数据
		Connection con;
		try {
			con=dbUtil.getCon();
			//获取数据
			ResultSet rs=bookTypeDao.list(con, bookType);
			//遍历集合
			while(rs.next()) {
				Vector v=new Vector();//向量类，实现了一个动态数组，可以插入任意不同类型的对象
				v.add(rs.getString("id"));
				v.add(rs.getString("TypeName"));
				v.add(rs.getString("TypeDesc"));
				dtm.addRow(v);//没读取一条记录，就填充到表格的行
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

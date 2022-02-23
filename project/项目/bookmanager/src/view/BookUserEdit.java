package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookTypeDao;
import dao.UserDao;
import model.BookType;
import model.User;
import util.DbUtil;
import util.JudgeMent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class BookUserEdit extends JInternalFrame {
	private JTextField RenameUserTxt;
	private JTextField ResetPwdTxt;
	private JTextField ResetPasswordTxt;
	private JTable table;
	private UserDao bookuseredit = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUserEdit frame = new BookUserEdit();
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
	public BookUserEdit() {
		setTitle("\u7528\u6237\u4FEE\u6539");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 665, 479);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u7528\u6237");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RenameUser=RenameUserTxt.getText();
				String ResetPwd=ResetPwdTxt.getText();
				String ResetPassword=ResetPasswordTxt.getText();
				if(JudgeMent.isEmpty(RenameUser)){
					JOptionPane.showMessageDialog(null, "重命名不能为空");
					return;
				}
				if(JudgeMent.isEmpty(ResetPwd)){
					JOptionPane.showMessageDialog(null, "重置密码不能为空");
					return;
				}
				if(JudgeMent.isEmpty(ResetPassword)){
					JOptionPane.showMessageDialog(null, "重置确定密码不能为空");
					return;
				}
				if (!ResetPwd.equals(ResetPassword)){
					JOptionPane.showMessageDialog(null, "两次输入密码不匹配");
					return;
				}
				User user = new User(RenameUser,ResetPwd);
				
				try{
					Connection con=null;
					con=DbUtil.getConnection();
					int p=UserDao.update(con, user);
					if(p==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
						fillTable(new User());
					}
					else{
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u7528\u6237");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RenameUser=RenameUserTxt.getText();
				String ResetPwd=ResetPwdTxt.getText();
				String ResetPassword=ResetPasswordTxt.getText();
				int n=JOptionPane.showConfirmDialog(null, "确定要删除吗？");
				User user = new User(RenameUser,ResetPwd);
				if(n==0){
					try{
						Connection con=null;
						con=DbUtil.getConnection();
						int p=UserDao.del(con, user);
						if(p==1){
							JOptionPane.showMessageDialog(null, "删除成功");
							fillTable(new User());
						}else{
							JOptionPane.showMessageDialog(null, "删除失败");
						}
						RenameUserTxt.setText("");
						ResetPwdTxt.setText("");
						ResetPasswordTxt.setText("");
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7528\u6237\u4FEE\u6539\u4E0E\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(208)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		
		table = new JTable();
		table.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u91CD\u7F6E\u7528\u6237\u540D\uFF1A");
		
		RenameUserTxt = new JTextField();
		RenameUserTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u91CD\u7F6E\u5BC6\u7801\uFF1A");
		
		ResetPwdTxt = new JTextField();
		ResetPwdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u5B9A\u91CD\u7F6E\u5BC6\u7801\uFF1A");
		
		ResetPasswordTxt = new JTextField();
		ResetPasswordTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(RenameUserTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(ResetPasswordTxt)
							.addComponent(ResetPwdTxt, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(RenameUserTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ResetPwdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(ResetPasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		panel.setLayout(gl_panel);
	
		getContentPane().setLayout(groupLayout);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//表格行点击事件,即点击鼠标后获取当前选择行的数据
				int row=table.getSelectedRow();
				RenameUserTxt.setText((String) table.getValueAt(row, 1));//第一列
				ResetPwdTxt.setText((String) table.getValueAt(row, 2));//第二列
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u6458\u8981"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
			//调用表格填充方法
			fillTable(new User());
	}
	
		 //定义一个数据填充表格方法
		private void fillTable(User user){
			//通过DefaultTableModel类可以实现获取行、列以及添加数据到表格
			DefaultTableModel dtm=(DefaultTableModel) table.getModel();
			dtm.setRowCount(0);//每次填充表格时，先清空已有表格，否则修改时会重复显示数据
			Connection con;
			try{
				con=DbUtil.getConnection();
				//获取数据
				ResultSet rs=bookuseredit.list(con, user);
				//遍历集合
				while(rs.next()){
					Vector v=new Vector();//向量类,实现了一个动态数组,可以插入任意不同类型的对象
					v.add(rs.getString("id"));
					v.add(rs.getString("UserName"));
					v.add(rs.getString("Password"));
					dtm.addRow(v);//每读取一条记录,填充到表格的行
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
}
	
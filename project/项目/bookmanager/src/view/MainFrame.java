package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 660);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookTypeManager.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAdd btadd=new BookTypeAdd();
				btadd.setVisible(true);
				desktopPane.add(btadd);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u7C7B\u522B\u4FEE\u6539");
		menuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			BookTypeEdit bte=new BookTypeEdit();
			bte.setVisible(true);
			desktopPane.add(bte);
			
		}
	});
		mnNewMenu.add(menuItem);
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookManager.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_6 = new JMenuItem("\u56FE\u4E66\u4FEE\u6539");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManager bm=new BookManager();
				bm.setVisible(true);
				desktopPane.add(bm);
			}
		});
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAdd ba=new BookAdd();
				ba.setVisible(true);
				desktopPane.add(ba);
			}
		});
		menu_1.add(menuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/userName.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u7528\u6237\u6DFB\u52A0");
		mnNewMenu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u7528\u6237\u4FEE\u6539");
		mnNewMenu_1.add(menuItem_4);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u7CFB\u7EDF\u4FE1\u606F");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//将系统信息小窗口加入
				sysInfo s=new sysInfo();
				s.setVisible(true);
				desktopPane.add(s);
				
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5207\u6362\u7528\u6237");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//切换用户（重新加载登陆界面）
				int p=JOptionPane.showConfirmDialog(null, "是否重新登录？");
				if(p==0) {
					dispose();
					new LogOnFrame().setVisible(true);
				}
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_5 = new JMenuItem("\u9000\u51FA");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p=JOptionPane.showConfirmDialog(null, "是否退出？");
				if(p==0) {
					dispose();
					System.exit(0);
				}
			}
		});
		menu.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.PINK);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}

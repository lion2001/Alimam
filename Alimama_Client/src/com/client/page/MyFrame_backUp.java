package com.client.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Entity.IUser;
import com.component.UI.*;

import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JScrollPane;

public class MyFrame_backUp extends JFrame {

	private MyPane_Icon contentPane;
	int mx,my,jx,jy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame_backUp frame = new MyFrame_backUp();
					
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
	public MyFrame_backUp() {
		setUndecorated(true);
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBackground(new Color(0,0,0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 764);
		contentPane = new MyPane_Icon();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(jx+(e.getXOnScreen()-mx),jy+(e.getYOnScreen()-my));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mx = e.getXOnScreen();
				my = e.getYOnScreen();
				jx = getX();
				jy=getY();
			}
		});
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(10, 50, 1198, 704);
		contentPane.add(panel);
		
		JButton button_1 = new JButton("\u53D1\u5E03\u5546\u54C1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setOpaque(false);
		button_1.setBorder(null);
		button_1.setUI(new leftButtonUI_Icon("up_blue.png", "up_yellow.png",new Color(31,174,184),new Color(173,172,6)));
		button_1.setBorderPainted(false);

		
		JButton button = new JButton("\u5546\u54C1\u6D4F\u89C8");
		button.setUI(new leftButtonUI_Icon("che_blue.png", "che_yellow.png",new Color(31,174,184),new Color(173,172,6)));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setOpaque(false);
		button.setBorder(null);
		
		JButton button_2 = new JButton("  我的");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setOpaque(false);
		button_2.setBorder(null);
		button_2.setUI(new leftButtonUI_Icon("zuji_blue.png", "zuji_yellow.png",new Color(31,174,184),new Color(173,172,6)));
		button_2.setBorderPainted(false);

		JPanel panel_3 = new MainPane();

		
		JButton button_2_1 = new JButton("  \u8054\u7CFB");
		button_2_1.setOpaque(false);
		button_2_1.setBorderPainted(false);
		button_2_1.setBorder(null);
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2_1.setUI(new leftButtonUI_Icon("xinxi_blue.png","xinxi_yellow.png",new Color(31,174,184),new Color(173,172,6)));

		JPanel panel_2=new infoPane(IUser.getIPhoto());
//		JPanel panel_2 = new infoPane("touxiang.jpg");
		//panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//panel_3.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 1069, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(536)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(187)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JPanel productsBrowser = new JPanel();
		panel_3.add(productsBrowser, "name_23500748932300");
		productsBrowser.setLayout(new GridLayout(1, 2));
		
		JPanel products = new JPanel();
		products.setOpaque(false);
		productsBrowser.add(products);
		
		//未添加商品浏览界面
		JScrollPane scrollPane = new JScrollPane(new JPanel());
		scrollPane.setPreferredSize(products.getSize());
		GroupLayout gl_products = new GroupLayout(products);
		gl_products.setHorizontalGroup(
			gl_products.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_products.createSequentialGroup()
					.addGap(266)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(268, Short.MAX_VALUE))
		);
		gl_products.setVerticalGroup(
			gl_products.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_products.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(522, Short.MAX_VALUE))
		);
		products.setLayout(gl_products);
		
		JPanel productDetail = new JPanel();
		productsBrowser.add(productDetail);
		productDetail.setLayout(new CardLayout(0, 0));
		
		JPanel details = new JPanel();
		productDetail.add(details, "name_25320360153000");
		
		JPanel nothing2 = new JPanel();
		nothing2.setOpaque(false);
		productDetail.add(nothing2, "name_25325552322500");
		
		JPanel up = new JPanel();
		panel_3.add(up, "name_23506144016500");
		
		JPanel me = new JPanel();
		panel_3.add(me, "name_23510237221100");
		
		JPanel contact = new JPanel();
		panel_3.add(contact, "name_23515380574200");
		
		JPanel nothing = new JPanel();
		nothing.setOpaque(false);
		panel_3.add(nothing, "name_23955891090800");
		panel.setLayout(gl_panel);
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setUI(new MyButtonUI(new Color(23,156,202),new Color(253,210,10),new Color(242,246,96)));
		btnNewButton.setBounds(1139, 10, 69, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("MIN");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setUI(new MyButtonUI(new Color(23,156,202),new Color(253,210,10),new Color(242,246,96)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBounds(1070, 10, 68, 23);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_1 = new logoPane();
		panel_1.setBounds(0, 0, 522, 195);
		contentPane.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}

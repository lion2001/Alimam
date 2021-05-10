//package com.client.page;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.BorderLayout;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.border.LineBorder;
//
//import com.component.UI.browser_everyProductPanel;
//import com.component.UI.productsType_Button;
//import com.component.UI.search_Button;
//import com.component.UI.search_Pane;
//
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import java.awt.Font;
//import javax.swing.JScrollPane;
//
// class Pane_products extends JPanel {
//	ArrayList<browser_everyProductPanel> productPane = new ArrayList<browser_everyProductPanel>();
//	ArrayList<JButton> detail_Buttons = new ArrayList<JButton>();
////	ArrayList<product> products = new ArrayList<product>();
//	private JTextField textField;
//	String sqlString;
//	
//	//传入一个sql语句，默认是select *，起选择作用，不需要是完整的sql语句
//	//完整的sql语句在服务端拼接而成
//	public Pane_products(String sql) {
//		sqlString = sql;
//		JPanel search = new search_Pane();
//		search.setBorder(new LineBorder(new Color(0, 0, 0)));
//		
//		JPanel p_roducts = new JPanel();
//		p_roducts.setBorder(new LineBorder(new Color(0, 0, 0)));
//		
//		JPanel panel_1 = new JPanel();
//		GroupLayout groupLayout = new GroupLayout(this);
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addComponent(p_roducts, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
//				.addComponent(search, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 531, Short.MAX_VALUE)
//					.addContainerGap())
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addComponent(search, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(p_roducts, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
//					.addGap(7))
//		);
//		panel_1.setLayout(new GridLayout(0, 8, 0, 0));
//		
//		JButton all = new productsType_Button("  全部");
//		all.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(all);
//		
//		JButton type_1 = new productsType_Button("电器用品");
//		type_1.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_1);
//		
//		JButton type_2 = new productsType_Button("学习用具");
//		type_2.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_2);
//		
//		JButton type_3 = new productsType_Button("学习书籍");
//		type_3.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_3);
//		
//		JButton type_4 = new productsType_Button("美味食品");
//		type_4.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_4);
//		
//		JButton type_5 = new productsType_Button("日常用品");
//		type_5.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_5);
//		
//		JButton type_6 = new productsType_Button("美容美妆");
//		type_6.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_6);
//		
//		JButton type_7 = new productsType_Button("其他商品");
//		type_7.addActionListener(e->{
//			sqlString ="";
//		});
//		panel_1.add(type_7);
//		p_roducts.setLayout(null);
//		
//
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBorder(null);
//		scrollPane.setBounds(0, 0, 536, 386);
//		int m = 4;
//		//向服务端发出请求，服务端返回商品集合到客户端
//		/*
//		 * productsClient client = new productsClient(sqlString);
//		 * products  = client.getProducts();
//		 */
////		int m = products.size();
////		if(m%2==0) {
////			m = m/2;
////		}else {
////			m=m/2+1
////		}
////		
//		
//		p_roducts.add(scrollPane);
//		
//		JPanel panel = new JPanel();
//	
//		panel.setPreferredSize(new Dimension(515,114*m));
//		panel.setLayout(new GridLayout(m, 2,5,5));
//		
//		/*
//		 * 通过循环添加商品
//		 * for(int i = 0;i<products.size;i++){
//		 * panel.add(new browser_everyProductPanel(product products[i]));
//		 * }
//		 */
//		for(int i=0;i<8;i++) {
//			detail_Buttons.add(new JButton());
//			JButton mButton = detail_Buttons.get(i);
//			panel.add(new browser_everyProductPanel(mButton));
//			mButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					
//					
//				}
//			});
//		}
//
//		scrollPane.setViewportView(panel);
//		search.setLayout(null);
//		
//		JButton soso = new search_Button();
//		soso.setBounds(449, 53, 77, 44);
//		soso.setOpaque(false);
//		soso.setBorder(null);
//		search.add(soso);
//		
//		textField = new JTextField();
//		textField.setBounds(172, 65, 252, 21);
//		textField.setBorder(null);
//		textField.setFont(new Font("微软雅黑", Font.BOLD, 15));
//		textField.setOpaque(false);
//		search.add(textField);
//		textField.setColumns(20);
//		setLayout(groupLayout);
//		setVisible(true);
//		
//	}
//}
//

package com.client.page;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.client.page.MyFrame2.Pane_details;
import com.client.page.MyFrame2.mePanel.auctionPane.product_1;
import com.client.page.MyFrame2.mePanel.auctionPane.state_Renderer;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class mePanel extends JPanel {
	JPanel function_Pane = new JPanel();

	public static void main(String[] args) {
		JFrame textFrame = new JFrame();
		textFrame.add(new mePanel());
		textFrame.setSize(1080,590);
		textFrame.setVisible(true);
	}
	public mePanel() {
		setLayout(null);
		
		JPanel Functions = new JPanel();
		Functions.setBounds(0, 0, 307, 377);
		add(Functions);
		Functions.setLayout(new GridLayout(5, 1));
		me_label jlable_1 = new me_label("查看报表");
		me_label jlable_2 = new me_label("我的拍卖");
		me_label jlable_3 = new me_label("我的收藏");
		me_label jlable_4 = new me_label("上传头像");
		me_label jlable_5 = new me_label("关于");
		jlable_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout)function_Pane.getLayout();
				cardLayout.show(function_Pane, "查看报表");
			}
		});
		jlable_2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout)function_Pane.getLayout();
				cardLayout.show(function_Pane, "我的拍卖");
			}
		});
		jlable_3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout)function_Pane.getLayout();
				cardLayout.show(function_Pane, "我的收藏");
			}
		});
		jlable_4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout)function_Pane.getLayout();
				cardLayout.show(function_Pane, "上传头像");
			}
		});
		jlable_5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout)function_Pane.getLayout();
				cardLayout.show(function_Pane, "关于");
			}
		});
		Functions.add(jlable_1);
		Functions.add(jlable_2);
		Functions.add(jlable_3);
		Functions.add(jlable_4);
		Functions.add(jlable_5);
		
		function_Pane.setBounds(307, 0, 761, 537);
		add(function_Pane);
		function_Pane.setLayout(new CardLayout());
		
		JPanel panel_1 = new tablePane();
		function_Pane.add(panel_1,"查看报表");
		JPanel panel_2 = new auctionPane();
		function_Pane.add(panel_2,"我的拍卖");
		JPanel panel_3 = new collectionPane();
		function_Pane.add(panel_3,"我的收藏");
		JPanel panel_4 = new JPanel();
		function_Pane.add(panel_4,"上传头像");
		JPanel panel_5 = new JPanel();
		function_Pane.add(panel_5,"关于");
		panel_5.setLayout(null);
		
		JPanel panel = new JPanel() {
			BufferedImage image =null;
			{
				try {
					image =ImageIO.read(getClass().getResource("log_alone.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D graphics2d =(Graphics2D)g;
				graphics2d.drawImage(image, 110, 10, getWidth()-160, getHeight()-11, null);
			}
			
		};
		panel.setBorder(null);
		panel.setOpaque(false);
		panel.setBounds(175, 10, 441, 140);
		panel_5.add(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setText("功能介绍(敬请期待)\n\n投诉(抱歉，你不能投诉我们)\n\n检查新版本(你在想桃子)");
		textArea.setFont(new Font("黑体", Font.PLAIN, 17));
		textArea.setBounds(175, 257, 396, 126);
		panel_5.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(">\n\n>\n\n>");
		textArea_1.setOpaque(false);
		textArea_1.setFont(new Font("黑体", Font.PLAIN, 17));
		textArea_1.setBounds(584, 257, 32, 174);
		panel_5.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel.setText("《软件许可及服务协议》");
		lblNewLabel.setBounds(316, 393, 167, 18);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("《隐私保护指引》");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(338, 423, 122, 18);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("阿里吗吗  版权所有");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(338, 451, 145, 15);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Copyright C 2011-2020 Alimama. ");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(316, 476, 208, 15);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("All Rights Reserved.");
		lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBounds(338, 501, 145, 15);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Version 0.0.0.1");
		lblNewLabel_5.setFont(new Font("黑体", Font.BOLD, 15));
		lblNewLabel_5.setBounds(338, 215, 145, 23);
		panel_5.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("阿里吗吗 Aliamam");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_6.setBounds(316, 173, 191, 32);
		panel_5.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\u5207\u6362\u8D26\u53F7");
		btnNewButton.setBackground(Color.white);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(105, 442, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton_1.setBackground(new Color(230,100,100));
		btnNewButton_1.setBounds(105, 487, 97, 23);
		btnNewButton_1.setFocusPainted(false);
		add(btnNewButton_1);
	}
//	public static void main(String[] args) {
//		JFrame textFrame = new JFrame();
//		textFrame.setSize(1090,560);
//		textFrame.getContentPane().add(new mePanel());
//		textFrame.setVisible(true);
//		
//	}
}

	class me_label extends JLabel{
		String textString;
		Color text_normalColor = Color.black;
		Color text_enterColor = Color.DARK_GRAY;
		 Color bg_normalColor = new Color(245,245,245);
		 Color bg_enterColor =new Color(231,230,230);
		 Color textColor = text_normalColor;
		 Color bgColor =bg_normalColor;
		public me_label(String aString) {
			super();
			textString = aString;
			setBorder(null);
			setOpaque(false);		
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					textColor =text_normalColor;
					bgColor = bg_normalColor;
					repaint();
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					textColor = text_enterColor;
					bgColor =bg_enterColor;
					repaint();
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.setColor(bgColor);
			graphics2d.fillRect(0, 0, getWidth()-1, getHeight()-1);
			graphics2d.setFont(new Font("黑体",Font.PLAIN,15));
			graphics2d.setColor(textColor);
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			graphics2d.drawString(textString, 10, getHeight()/2+5);
		}
		
	}
	class auctionPane extends JPanel{
		private JTable table = new JTable();
		JButton actionButton = new JButton();
		DefaultTableModel model;
		JScrollPane scrollPane;
		public auctionPane() {
			setLayout(null);
			
			JPanel panel_6 = new JPanel() {
				BufferedImage image =null;
				@Override
				protected void paintComponent(Graphics g) {
					try {
						image =ImageIO.read(getClass().getResource("auction.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.drawImage(image, 0, 0, getWidth()-1, getHeight()-1, null);
				}
				
			};
			panel_6.setBounds(0, 0, 761, 127);
			add(panel_6);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(0, 130, 761, 407);
			add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_8 = new JPanel();
			actionButton.setVisible(false);
			JButton button01 = new JButton("卖家拍卖");
			JButton button02 = new JButton("买家拍卖");
			button01.setBorder(null);
			button01.setFocusPainted(false);
			button01.setBackground(new Color(210,230,230));
			button02.setBorder(null);
			button02.setFocusPainted(false);
			button02.setBackground(new Color(210,230,230));
			button01.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					actionButton.setVisible(true);
					actionButton.setText("确定交易");
					model = new DefaultTableModel();
					model.addColumn("商品ID");
					model.addColumn("商品名称");
					model.addColumn("价格");
					model.addColumn("状态");
					for(int i =0;i<20;i++) {
						product_1 auction_product = new product_1();
						addInfo(auction_product);
					}
					table.setModel(model);
					TableColumn column3 = table.getColumnModel().getColumn(3);
					column3.setCellRenderer(new state_Renderer());
					scrollPane.setViewportView(table);
				}
			});
			button02.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					actionButton.setVisible(true);
					actionButton.setText("查看详情");
					model = new DefaultTableModel();
					model.addColumn("商品ID");
					model.addColumn("商品名称");
					model.addColumn("价格");
					model.addColumn("状态");
						for(int i =0;i<5;i++) {
							product_1 auction_product = new product_1();
							addInfo(auction_product);
						}
						table.setModel(model);
						TableColumn column3 = table.getColumnModel().getColumn(3);
						column3.setCellRenderer(new state_Renderer());
						scrollPane.setViewportView(table);
				}
				
			});
			panel_8.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel_8.add(button01);
			panel_8.add(button02);
			panel_7.add(panel_8, BorderLayout.NORTH);
			
			scrollPane = new JScrollPane();
			panel_7.add(scrollPane, BorderLayout.CENTER);
			JPanel buttonJPanel = new JPanel();
			buttonJPanel.setPreferredSize(new Dimension(0, 50));
			actionButton.setEnabled(false);
			actionButton.setBorder(null);
			actionButton.setFocusPainted(false);
			actionButton.setBackground(new Color(245,245,245));
			actionButton.addActionListener(e->{
//				CardLayout cardLayout01 = (CardLayout)panel_3.getLayout();
//				cardLayout01.show(panel_3, "productsBrowser");
//				 cardLayout01 = (CardLayout)productDetail.getLayout();
//				cardLayout01.show(productDetail, "details");
			});
			buttonJPanel.add(actionButton);
			panel_7.add(buttonJPanel,BorderLayout.PAGE_END);
			
			
//			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//				
//				@Override
//				public void valueChanged(ListSelectionEvent e) {
//					// TODO Auto-generated method stub
//					int index = table.getSelectedRow();
//					read_Info.setEnabled(true);
//					details = new Pane_details();//传入参数
//					CardLayout cardLayout01 = (CardLayout)panel_3.getLayout();
//					cardLayout01.show(panel_3, "productsBrowser");
//					 cardLayout01 = (CardLayout)productDetail.getLayout();
//					cardLayout01.show(productDetail, "details");
//				}
//			});
			
			model  = new DefaultTableModel();
			table = new JTable(model) {
				  public boolean isCellEditable(int row, int column)
                  {
                             return false;}//表格不允许被编辑
                  
			};
			table.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					actionButton.setEnabled(true);
//					details = new Pane_details();//传入参数
					
				}
				
			});
			table.setSelectionMode(0);
			table.setRowHeight(30);
			model.addColumn("商品ID");
			model.addColumn("商品名称");
			model.addColumn("价格");
			model.addColumn("状态");
			//model.addColumn("操作");
			
			table.setModel(model);
			
	
			
			scrollPane.setViewportView(table);
		}
		
		public void addInfo(product_1 auction_product) {
			Vector<String> rowVector = new Vector<String>();
			rowVector.add("ID");//aucton_prodyct.id;
			rowVector.add("name");//auction_product.name;
			rowVector.add("price");
			rowVector.add("等待");
			//rowVector.add("查看详情"+"ID");
			model.addRow(rowVector);
			}
	class state_Renderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {

			String stateString = (String)value;
			this.setText(stateString);
			if(stateString.equals("等待")) {
				setForeground(new Color(253,210,10));
			}else if (stateString.equals("成功")) {
				setForeground(Color.green);
			}else if (stateString.equals("失败")) {
				setForeground(Color.red);
			}
			setOpaque(true);
			if(isSelected) {
				this.setBackground(table.getSelectionBackground());
			}else {
				this.setBackground(table.getBackground());
			}
			return this;
		}
		
	}

		class product_1{
			
		}
	
}
	class tablePane extends JPanel{
		private JTable table = new JTable();
		DefaultTableModel model;
		JScrollPane scrollPane;
		public tablePane() {
			setLayout(null);
			
			JPanel panel_6 = new JPanel() {
				BufferedImage image =null;
				@Override
				protected void paintComponent(Graphics g) {
					try {
						image =ImageIO.read(getClass().getResource("me_table01.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.drawImage(image, 0, 0, getWidth()-1, getHeight()-1, null);
				}
				
			};
			panel_6.setBounds(0, 0, 761, 127);
			add(panel_6);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(0, 130, 761, 407);
			add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_8 = new JPanel();
			JButton button01 = new JButton("我的购买");
			JButton button02 = new JButton("我的出售");
			JButton button03 = new JButton("全部记录");
			button01.setBorder(null);
			button01.setFocusPainted(false);
			button01.setBackground(new Color(210,230,230));
			button02.setBorder(null);
			button02.setFocusPainted(false);
			button02.setBackground(new Color(210,230,230));
			button03.setBorder(null);
			button03.setFocusPainted(false);
			button03.setBackground(new Color(210,230,230));
			button01.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					model = new DefaultTableModel();
					model.addColumn("商品ID");
					model.addColumn("商品名称");
					model.addColumn("价格");
					model.addColumn("交易时间");
					for(int i =0;i<20;i++) {
						product_1 auction_product = new product_1();
						addInfo(auction_product);
					}
					table.setModel(model);
					TableColumn column3 = table.getColumnModel().getColumn(3);
					scrollPane.setViewportView(table);
				}
			});
			button02.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					model = new DefaultTableModel();
					model.addColumn("商品ID");
					model.addColumn("商品名称");
					model.addColumn("价格");
					model.addColumn("交易时间");
						for(int i =0;i<5;i++) {
							product_1 auction_product = new product_1();
							addInfo(auction_product);
						}
						table.setModel(model);
						TableColumn column3 = table.getColumnModel().getColumn(3);
						scrollPane.setViewportView(table);
				}
				
			});
			button03.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					model = new DefaultTableModel();
					model.addColumn("商品ID");
					model.addColumn("商品名称");
					model.addColumn("价格");
					model.addColumn("交易时间");
					for(int i =0;i<5;i++) {
						product_1 auction_product = new product_1();
						addInfo(auction_product);
					}
					table.setModel(model);
					TableColumn column3 = table.getColumnModel().getColumn(3);
					scrollPane.setViewportView(table);
				}
				
			});
			
			panel_8.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel_8.add(button01);
			panel_8.add(button02);
			panel_8.add(button03);
			panel_7.add(panel_8, BorderLayout.NORTH);
			
			scrollPane = new JScrollPane();
			panel_7.add(scrollPane, BorderLayout.CENTER);
			JPanel buttonJPanel = new JPanel();
			buttonJPanel.setPreferredSize(new Dimension(0, 50));
			panel_7.add(buttonJPanel,BorderLayout.PAGE_END);
			
			model  = new DefaultTableModel();
			table = new JTable(model) {
				  public boolean isCellEditable(int row, int column)
                  {
                             return false;}//表格不允许被编辑
                  
			};
			table.setSelectionMode(0);
			table.setRowHeight(30);
			model.addColumn("商品ID");
			model.addColumn("商品名称");
			model.addColumn("价格");
			model.addColumn("交易时间");
			//model.addColumn("操作");
			
			table.setModel(model);
			
	
			
			scrollPane.setViewportView(table);
		}
		
		public void addInfo(product_1 auction_product) {
			Vector<String> rowVector = new Vector<String>();
			rowVector.add("ID");//aucton_prodyct.id;
			rowVector.add("name");//auction_product.name;
			rowVector.add("price");
			rowVector.add("时间");
			//rowVector.add("查看详情"+"ID");
			model.addRow(rowVector);
			}

		class product_1{
			
		}
		
	
}
	class collectionPane extends JPanel{
		public collectionPane() {
			
		}
	}


	
	
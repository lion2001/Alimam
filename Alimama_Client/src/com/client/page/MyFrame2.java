package com.client.page;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Entity.IUser;
import Entity.Message;
import Entity.Product;
import Entity.User;
import com.client.page.auctionPane.product_1;
import com.client.page.auctionPane.state_Renderer;
import com.client.page.productsBrowserPanel.Pane_details;
import com.client.page.productsBrowserPanel.Pane_products;
import com.client.page.productsBrowserPanel.browser_everyProductPanel;
import com.client.page.productsBrowserPanel.product;
import com.component.UI.*;
import tools.ManageClientConServerThread;
import tools.addCollect.AddCollect;
import tools.addComment.AddComment;
import tools.addFriend.AddFriend;
import tools.closeThread.CloseThread;
import tools.returnPro.ReturnProduct;
import tools.toBuy.ToBuy;
import tools.upPhoto.upPhoto;

import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SingleSelectionModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import static Entity.MessageType.*;

public class MyFrame2 extends JFrame{
	JPanel panel_3;
	JPanel details ;
	JPanel productDetail,chatPane,CHAT ;
	JPanel Auctiondetails ;
	JPanel AuctionproductDetail ;
	JButton button,button_1,button_2,button_2_1,button_2_1_1,alter,close;
	private MyPane_Icon contentPane;
	JPanel auction;
	JPanel productsBrowser;
	int mx,my,jx,jy;
	CardLayout start;
	JPanel contact;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame2 frame = new MyFrame2();

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
	public MyFrame2() {
		setUndecorated(true);
//		try {
//			UIManager.setLookAndFeel(new NimbusLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setBackground(new Color(0,0,0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100+40, 100-50, 1218, 764);


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

		button_1 = new JButton("发布商品");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setOpaque(false);
		button_1.setBorder(null);
		button_1.setUI(new leftButtonUI_Icon("up_blue.png", "up_yellow.png",new Color(31,174,184),new Color(173,172,6)));
		button_1.setBorderPainted(false);


		button = new JButton("商品浏览");
		button.setUI(new leftButtonUI_Icon("che_blue.png", "che_yellow.png",new Color(31,174,184),new Color(173,172,6)));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setOpaque(false);
		button.setBorder(null);

		button_2 = new JButton("  我的");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setOpaque(false);
		button_2.setBorder(null);
		button_2.setUI(new leftButtonUI_Icon("zuji_blue.png", "zuji_yellow.png",new Color(31,174,184),new Color(173,172,6)));
		button_2.setBorderPainted(false);

		panel_3 = new JPanel();


		button_2_1 = new JButton("  联系");
		button_2_1.setOpaque(false);
		button_2_1.setBorderPainted(false);
		button_2_1.setBorder(null);
		button_2_1.setUI(new leftButtonUI_Icon("xinxi_blue.png","xinxi_yellow.png",new Color(31,174,184),new Color(173,172,6)));

		JPanel panel_2 = new infoPane(IUser.getIPhoto());

		button_2_1_1 = new JButton("  拍卖");
		button_2_1_1.setOpaque(false);
		button_2_1_1.setBorderPainted(false);
		button_2_1_1.setBorder(null);
		button_2_1_1.setUI(new leftButtonUI_Icon("paimai_blue.png","paimai_yellow.png",new Color(31,174,184),new Color(173,172,6)));
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
														.addComponent(button_2_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(button, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
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
												.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 533, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup()
												.addGap(187)
												.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(button_2_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(button_2_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
		);
		panel_3.setLayout(new CardLayout(0, 0));

		JPanel nothing = new JPanel();
		nothing.setOpaque(false);
		panel_3.add(nothing, "name_23955891090800");

		productsBrowser = new productsBrowserPanel(IUser.getPro(IUser.getIShowPro()));
		panel_3.add(productsBrowser, "productsBrowser");

		auction =new auctionBrowserPanel(IUser.getAuction(IUser.getIShowPro()));
		panel_3.add(auction,"auction");


		JPanel up = new upPanel();
		panel_3.add(up, "up");

		JPanel me = new mePanel();
		panel_3.add(me, "me");

		contact = new contactPanel();
		panel_3.add(contact, "contact");


		//对功能区分页进行监听
		button.addActionListener(e->leftClicked(e));
		button_2_1.addActionListener(e->leftClicked(e));
		button_2_1_1.addActionListener(e->leftClicked(e));
		button_2.addActionListener(e->leftClicked(e));
		button_1.addActionListener(e->leftClicked(e));


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
				Message message=new Message();
				message.setMesType(message_close);
				message.setSender(IUser.getIid());
				CloseThread close=new CloseThread(message);
				System.out.println(close);
				close.run();
				System.exit(0);
			}
		});


	}

	private void leftClicked(ActionEvent e) {
		JButton m = (JButton)e.getSource();
		 start = (CardLayout)panel_3.getLayout();
		if(m == button ) {
			start.show(panel_3, "productsBrowser");
		}else if(m == button_1) {
			start.show(panel_3,"up");
		}else if(m ==button_2_1) {
			start.show(panel_3, "contact");
		}else if( m == button_2_1_1){
			start.show(panel_3, "auction");
		}else {
			start.show(panel_3, "me");
		}
	}



	//这是我的 界面
	class mePanel extends JPanel {
		JPanel function_Pane = new JPanel();
		JPanel panel_1;
		JPanel panel_2;
		JPanel panel_3;
		JPanel panel_4;
		JPanel panel_5;

		public mePanel() {
			setLayout(null);
			panel_1 = new tablePane();
			panel_2 = new auctionPane();
			panel_3 = new collectionPane();
			panel_4 = new up_touxiang();
			panel_5 = new JPanel();
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
					collectionPane collectionPane1=(collectionPane)panel_3;
					collectionPane1.RecollectionPane();
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

//			JPanel panel_1 = new tablePane();
			function_Pane.add(new JPanel() {
				BufferedImage image =null;
				@Override
				protected void paintComponent(Graphics g) {
					try {
						image = ImageIO.read(getClass().getResource("nothing.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.drawImage(image, 50, 0, 700, 500, null);
				}

			});
			function_Pane.add(panel_1,"查看报表");
//			JPanel panel_2 = new auctionPane();
			function_Pane.add(panel_2,"我的拍卖");
//			JPanel panel_3 = new collectionPane();
			function_Pane.add(panel_3,"我的收藏");
//			JPanel panel_4 = new up_touxiang();
			function_Pane.add(panel_4,"上传头像");
//			JPanel panel_5 = new JPanel();
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

			alter = new JButton("\u5207\u6362\u8D26\u53F7");
			alter.setBackground(Color.white);
			alter.setFocusPainted(false);
			alter.setBounds(105, 442, 97, 23);
			add(alter);

			close = new JButton("\u9000\u51FA\u767B\u5F55");
			close.setBackground(new Color(230,100,100));
			close.setBounds(105, 487, 97, 23);
			close.setFocusPainted(false);
			alter.addActionListener(e->{
//                Message message=new Message();
//                message.setMesType(message_close);
//                message.setSender(IUser.getIid());
//                CloseThread close=new CloseThread(message);
//                System.out.println(close);
//                close.run();
//				MyFrame2.this.setVisible(false);
//				new logPage().setVisible(true);
			});
			close.addActionListener(e->{
				Message message=new Message();
				message.setMesType(message_close);
				message.setSender(IUser.getIid());
				CloseThread close=new CloseThread(message);
				System.out.println(close);
				close.run();
				System.exit(0);
			});
			add(close);
		}

		//自定义label，显示在左侧
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

		//查看报表分页
		class tablePane extends JPanel{
			private JTable table = new JTable();
			DefaultTableModel model;
			JScrollPane scrollPane;
			int nowState=-1;
			JLabel totle;
			JButton commentButton;
			JComboBox<String > dateBox =new JComboBox<String>();
			String total="总金额:  ";
            JPanel panel_8;
            JButton button01 = new JButton("我的购买");
            JButton button02 = new JButton("我的出售");
            JButton button03 = new JButton("全部记录");
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

				panel_8 = new JPanel();
//				JButton button01 = new JButton("我的购买");
//				JButton button02 = new JButton("我的出售");
//				JButton button03 = new JButton("全部记录");
				commentButton = new JButton("评价");
				commentButton.setVisible(false);
				commentButton.setEnabled(false);
				commentButton.setBorder(null);
				commentButton.setFocusPainted(false);
				commentButton.setBackground(new Color(230,230,230));
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
						commentButton.setVisible(true);
						commentButton.setEnabled(false);
						nowState=0;
						showTable(nowState,9999999);
					}
				});
				button02.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						commentButton.setVisible(false);
						commentButton.setEnabled(false);
						nowState=1;
						showTable(nowState,9999999);
					}

				});
				button03.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						commentButton.setVisible(false);
						commentButton.setEnabled(false);
						nowState=2;
						showTable(nowState,9999999);
					}

				});

				panel_8.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel_8.add(button01);
				panel_8.add(button02);
				panel_8.add(button03);
				totle = new JLabel(total);
				dateBox.addItem("三天");
				dateBox.addItem("七天");
				dateBox.addItem("全部");
				dateBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						if(dateBox.getSelectedIndex()==0){
							showTable(nowState,3);
						}else if(dateBox.getSelectedIndex()==1){
							showTable(nowState,7);
						}else{
							showTable(nowState,9999999);
						}
					}
				});
				panel_8.add(dateBox);
				panel_8.add(totle);
				panel_7.add(panel_8, BorderLayout.NORTH);

				scrollPane = new JScrollPane();
				panel_7.add(scrollPane, BorderLayout.CENTER);
				JPanel buttonJPanel = new JPanel();
				buttonJPanel.setPreferredSize(new Dimension(0, 50));
				panel_7.add(buttonJPanel,BorderLayout.PAGE_END);
				buttonJPanel.add(commentButton);
				commentButton.addActionListener(e->{
					//通过获取表格的选中确定用户正在评价的商品
					int index = table.getSelectedRow();
					String commentString = JOptionPane.showInputDialog(null,"请输入你的评价：\n","评价",JOptionPane.PLAIN_MESSAGE);
					if(commentString!=null){
						Message message=new Message();
						message.setMesType(message_add_comment);
						message.setGetter((String)table.getValueAt(index,0));
						message.setCon(commentString);
						AddComment addComment=new AddComment(message);
						addComment.start();
					}

				});
				table.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						commentButton.setEnabled(true);
					}

				});
				model  = new DefaultTableModel();
				table = new JTable(model) {
					public boolean isCellEditable(int row, int column)
					{
						return false;}//表格不允许被编辑

				};
				table.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						commentButton.setEnabled(true);
					}

				});
				table.setSelectionMode(0);
				table.setRowHeight(30);
				model.addColumn("商品ID");
				model.addColumn("商品名称");
				model.addColumn("价格");
				model.addColumn("交易时间");

				//model.addColumn("操作");

				table.setModel(model);



				scrollPane.setViewportView(table);
				setOpaque(false);
			}

			public void addInfo(Product product) {
				String s[]=new String[4];
				s[0]=product.getProductID();
				s[1]=product.getName();
				if(product.getUpUser().equals(IUser.getIid())){
					s[2]="+  "+product.getPrice();
				}else{
					s[2]="-  "+product.getPrice();
				}
				s[3]=product.getSellTime();
				//rowVector.add("查看详情"+"ID");
				model.addRow(s);
			}

			public boolean isTime(String time,int tim){
				int monthDay[]={0,31,59,90,120,151,181,212,243,273,304,334,365};
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String msg = df.format(new Date());
				int year1=new Integer(msg.substring(0,4));
				int month1=new Integer(msg.substring(5,7));
				int day1=new Integer(msg.substring(8,10));
				int year=new Integer(time.substring(0,4));
				int month=new Integer(time.substring(5,7));
				int day=new Integer(time.substring(8,10));
				int num=0;
				if(year!=year){
					num=monthDay[month1-1]+day1+(365-monthDay[month-1]-day);
				}else{
					num=monthDay[month1-1]+day1-monthDay[month-1]-day;
				}
				if(num<=tim)return true;
				else return false;
			}
			public void showTable(int state,int day){
				model = new DefaultTableModel();
				model.addColumn("商品ID");
				model.addColumn("商品名称");
				model.addColumn("价格");
				model.addColumn("交易时间");

				List<Product> products=IUser.getISellTable();
				    int size=products.size();
				    double count=0;
				if(state==0){
					for(int i=0;i<size;i++){
						if(!products.get(i).getUpUser().equals(IUser.getIid())){
							String time=products.get(i).getSellTime();
							if(isTime(time,day)){
								addInfo(products.get(i));
								count+=products.get(i).getPrice();
							}
						}
					}
				}else if(state==1){
					for(int i=0;i<size;i++){
						if(products.get(i).getUpUser().equals(IUser.getIid())){
							String time=products.get(i).getSellTime();
							if(isTime(time,day)){
								addInfo(products.get(i));								count+=products.get(i).getPrice();
								count+=products.get(i).getPrice();
							}
						}
					}
				}else if(state==2){
					for(int i=0;i<size;i++){
						String time=products.get(i).getSellTime();
						if(isTime(time,day)){
							addInfo(products.get(i));
                            if(products.get(i).getUpUser().equals(IUser.getIid())){
                                count+=products.get(i).getPrice();
                            }else{
                                count-=products.get(i).getPrice();

                            }
						}
					}
				}
				totle=new JLabel(total+count);
				panel_8.removeAll();
				panel_8.repaint();
                panel_8.setLayout(new FlowLayout(FlowLayout.LEFT));
                panel_8.add(button01);
                panel_8.add(button02);
                panel_8.add(button03);
                panel_8.add(dateBox);
                panel_8.add(totle);
				panel_8.validate();
				panel_8.repaint();
				table.setModel(model);
				TableColumn column3 = table.getColumnModel().getColumn(3);
				scrollPane.setViewportView(table);
			}
		}

		//我的拍卖分页
		class auctionPane extends JPanel{
			private JTable table = new JTable();
			JButton actionButton = new JButton();
			DefaultTableModel model;
			JScrollPane scrollPane;
			JComboBox<String> dateBox = new JComboBox<String>();
			public auctionPane() {
				setLayout(null);

				//这是一个放拍卖详情上面的图片的panel
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
						Map<String,Product> map=IUser.getIAuctionSell();
						for(String key:map.keySet())
							addInfo(map.get(key));

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
						int size=IUser.getIAuction().size();
						for(int i =0;i<size;i++) {
							if(!IUser.getIAuction().get(i).getUpUser().equals(IUser.getIid()))
								addInfo(IUser.getIAuction().get(i));
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
				dateBox.addItem("三天");
				dateBox.addItem("七天");
				dateBox.addItem("全部");
				panel_8.add(dateBox);
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
					Product product=new Product();
					int index = table.getSelectedRow();
					if(actionButton.getText()=="查看详情") {
						String id=(String)table.getValueAt(index,0);
						int size=IUser.getIAuction().size();
						for(int i=0;i<size;i++){
							if(IUser.getIAuction().get(i).getProductID().equals(id)){
								product=IUser.getIAuction().get(i);
							}
						}
						Pane_details pane_details=(Pane_details)details;
						pane_details.reShow_detail(product);
						CardLayout cardLayout01 = (CardLayout)panel_3.getLayout();
						cardLayout01.show(panel_3, "productsBrowser");
						cardLayout01 = (CardLayout)productDetail.getLayout();
						cardLayout01.show(productDetail, "details");
					}else {
						//完成交易时的操作
						if(table.getValueAt(index,3).equals("等待")){
							product.setProductID((String)table.getValueAt(index,0));
							int size=IUser.getIAuction().size();
							for(int i=0;i<size;i++){
								if(IUser.getIAuction().get(i).getProductID().equals(product.getProductID())){
									product=IUser.getIAuction().get(i);
									IUser.getIAuction().get(i).setState(1);
									System.out.println(IUser.getIAuction().size());
								}
							}
							Message message=new Message();
							message.setMesType(message_final_auction);
							message.setSender(IUser.getIid());
							message.setProduct(product);
							ToBuy toBuy=new ToBuy(message);
							toBuy.start();
						}

					}
				});

				buttonJPanel.add(actionButton);
				panel_7.add(buttonJPanel,BorderLayout.PAGE_END);


//				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//					@Override
//					public void valueChanged(ListSelectionEvent e) {
//						// TODO Auto-generated method stub
//						int index = table.getSelectedRow();
//						read_Info.setEnabled(true);
//						details = new Pane_details();//传入参数
//						CardLayout cardLayout01 = (CardLayout)panel_3.getLayout();
//						cardLayout01.show(panel_3, "productsBrowser");
//						 cardLayout01 = (CardLayout)productDetail.getLayout();
//						cardLayout01.show(productDetail, "details");
//					}
//				});

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
//                      !!!!!!!
//						details = new Pane_details();//传入参数

					}

				});
				table.setSelectionMode(0);
				table.setRowHeight(30);
				model.addColumn("商品ID");
				model.addColumn("商品名称");
				model.addColumn("价格");
				model.addColumn("状态");

				table.setModel(model);



				scrollPane.setViewportView(table);
			}

			public void addInfo(Product product) {
				Vector<String> rowVector = new Vector<String>();
				rowVector.add(product.getProductID());//aucton_prodyct.id;
				rowVector.add(product.getName());//auction_product.name;
				rowVector.add(product.getPrice()+"");
				if(product.getState()==-1){
					rowVector.add("失败");
				}else if(product.getState()==1){
					rowVector.add("成功");
				}else if(product.getState()==0){
					rowVector.add("等待");
				}

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

		//我的收藏分页
		class collectionPane extends JPanel{
			public void create(){
				setLayout(null);

				JPanel panel = new JPanel() {

					BufferedImage image =null;
					@Override
					protected void paintComponent(Graphics g) {
						try {
							image = ImageIO.read(getClass().getResource("collection.png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						g.drawImage(image, 0, 0, getWidth()-1, getHeight()-1, null);
					}

				};
				panel.setBounds(0, 0, 761, 127);
				add(panel);

				JPanel panel_1 = new JPanel();
				panel_1.setBounds(50, 100, 680, 455);
				add(panel_1);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBorder(null);
				scrollPane.setBounds(80, 40, 536, 386);
				panel_1.setLayout(null);
				panel_1.add(scrollPane);

				JPanel panel_2 = new JPanel();
				int m = 0;
				if(IUser.getICollection()!=null){
					int size=IUser.getICollection().size();
					if(size%2==0){
						m=size/2;
					}else{
						m=size/2+1;
					}
				}
				panel_2.setPreferredSize(new Dimension(515,114*m));
				panel_2.setLayout(new GridLayout(m, 2,5,5));
				if(IUser.getICollection()!=null){
					int size=IUser.getICollection().size();
					for(int i=0;i<size;i++) {
						panel_2.add(new browser_everyProductPanel(IUser.getICollection().get(i)));
					}
				}

				scrollPane.setViewportView(panel_2);
			}
			public collectionPane() {
				create();
			}
            public void RecollectionPane(){
				removeAll();
				repaint();
				create();
				revalidate();
			}
		}

		//上传头像分页
		class up_touxiang  extends JPanel{
			BufferedImage touxiang_image = null;
			public up_touxiang() {
				setLayout(null);

				JButton choose = new JButton("choose file");
				choose.setBounds(419, 270, 102, 23);
				add(choose);
				choose.setUI(new MyButtonUI(Color.white, Color.gray, Color.black));
				choose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser chooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Pic Allowed", "jpg","png");
						chooser.setFileFilter(filter);
						int value = chooser.showOpenDialog(up_touxiang.this);
						if(value ==JFileChooser.APPROVE_OPTION ) {
							File imageFile = chooser.getSelectedFile();
							String imagePath=chooser.getSelectedFile().getAbsolutePath();
							try {
								touxiang_image = ImageIO.read(imageFile);
								Thread thread=new upPhoto(imagePath,imageFile);
								thread.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							repaint();
						}
					}
				});

				JButton up = new JButton(" upload image");
				up.setUI(new MyButtonUI(Color.white, Color.gray, Color.black));
				up.setBounds(406, 382, 135, 23);
				add(up);

				JPanel panel = new JPanel() {

					@Override
					protected void paintComponent(Graphics g) {
						Graphics2D g2d = (Graphics2D)g;
						Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, getWidth()-1, getHeight()-1);
						g2d.setClip(shape);
						g2d.setColor(new Color(230,230,230));
						g2d.fillRect(0, 0, getWidth()-1, getHeight()-1);
						g2d.drawImage(touxiang_image, 0, 0, getWidth()-1, getHeight()-1, null);
					}

				};
				panel.setBounds(383, 65, 168, 158);
				add(panel);
			}
		}
	}







	//这是拍卖商品浏览的分页
	class auctionBrowserPanel extends JPanel{
         Pane_Auctionproducts pane_auctionproducts;
		public void repaintAuction(List<Product>products){
			pane_auctionproducts.modify(products);
		}

		public auctionBrowserPanel(List<Product>products) {
			pane_auctionproducts=new Pane_Auctionproducts(products);
			AuctionproductDetail = new JPanel();
			setLayout(new GridLayout(1,2));
			add(pane_auctionproducts);
			add(AuctionproductDetail);
			AuctionproductDetail.setLayout(new CardLayout(0, 0));

			if(products!=null&&products.size()!=0){
				System.out.println("!0");
				Auctiondetails = new Pane_Auctiondetails(products.get(0));
				AuctionproductDetail.add(Auctiondetails, "details");
			}else{
				Auctiondetails = new Pane_Auctiondetails();
				AuctionproductDetail.add(Auctiondetails, "details");
			}


			JPanel nothing2 = new JPanel() {

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D graphics2d_1 = (Graphics2D)g;
					graphics2d_1.setStroke(new BasicStroke(6));
					graphics2d_1.setColor(new Color(233,232,142));
					graphics2d_1.drawLine(0, 0, 0, getHeight());
					BufferedImage img = null;
					try {
						img = ImageIO.read(getClass().getResource("nothing.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.drawImage(img, 80, 150, 400, 250, null);
				}

			};
			AuctionproductDetail.add(nothing2, "nothing2");

			CardLayout cardLayout01 = (CardLayout)AuctionproductDetail.getLayout();
			cardLayout01.show(AuctionproductDetail, "nothing2");

		}







		//这是拍卖商品浏览的左侧部分
		class Pane_Auctionproducts extends JPanel {
			ArrayList<browser_everyProductPanel> productPane = new ArrayList<browser_everyProductPanel>();
			ArrayList<JButton> detail_Buttons = new ArrayList<JButton>();
			//							ArrayList<product> products = new ArrayList<product>();
			private JTextField textField;

			AuctionPanel panel;
			public void modify(List<Product>products){
				panel.modify(products);
			}
			//传入一个sql语句，默认是select *，起选择作用，不需要是完整的sql语句
			//完整的sql语句在服务端拼接而成
			public Pane_Auctionproducts(List<Product>products) {

				JPanel search = new search_Pane();
				search.setBorder(new LineBorder(new Color(0, 0, 0)));

				JPanel p_roducts = new JPanel();
				p_roducts.setBorder(new LineBorder(new Color(0, 0, 0)));

				JPanel panel_1 = new JPanel();
				GroupLayout groupLayout = new GroupLayout(this);
				groupLayout.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(p_roducts, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
								.addComponent(search, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 531, Short.MAX_VALUE)
										.addContainerGap())
				);
				groupLayout.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(search, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(p_roducts, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
										.addGap(7))
				);
				panel_1.setLayout(new GridLayout(0, 8, 0, 0));

				JButton all = new productsType_Button("  全部");
				all.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(-1);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(all);

				JButton type_1 = new productsType_Button("电器用品");
				type_1.addActionListener(e->{
					System.out.println("query");
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(0);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_1);

				JButton type_2 = new productsType_Button("学习用具");
				type_2.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(1);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_2);

				JButton type_3 = new productsType_Button("学习书籍");
				type_3.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(2);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_3);

				JButton type_4 = new productsType_Button("美味食品");
				type_4.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(3);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_4);

				JButton type_5 = new productsType_Button("日常用品");
				type_5.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(4);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_5);

				JButton type_6 = new productsType_Button("美容美妆");
				type_6.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(5);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_6);

				JButton type_7 = new productsType_Button("其他商品");
				type_7.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(6);
					product.setIsAuction(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_7);
				p_roducts.setLayout(null);



				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBorder(null);
				scrollPane.setBounds(0, 0, 536, 386);
				p_roducts.add(scrollPane);

				panel = new AuctionPanel(products);
				scrollPane.setViewportView(panel);
				search.setLayout(null);

				JButton soso = new search_Button();
				soso.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String text=textField.getText();
						Message message=new Message();
						message.setMesType(message_return_product);
						Product product=new Product();
						product.setIntroduce(text);
						product.setIsAuction(1);
						message.setProduct(product);
						Thread thread=new ReturnProduct(message);
						thread.start();
					}
				});
				soso.setBounds(449, 53, 77, 44);
				soso.setOpaque(false);
				soso.setBorder(null);
				search.add(soso);

				textField = new JTextField();
				textField.setBounds(172, 65, 252, 21);
				textField.setBorder(null);
				textField.setFont(new Font("微软雅黑", Font.BOLD, 15));
				textField.setOpaque(false);
				search.add(textField);
				textField.setColumns(20);
				setLayout(groupLayout);
				setVisible(true);

			}
		}

	}

	//这是商品浏览的分页
	class productsBrowserPanel extends JPanel{
        Pane_products pane_products;
        public void repaintProList(List<Product>products){
        	pane_products.modify(products);
		}
		public productsBrowserPanel(List<Product>products) {
			productDetail = new JPanel();
			pane_products=new Pane_products(products);
			setLayout(new GridLayout(1,2));
			add(pane_products);
			add(productDetail);
			productDetail.setLayout(new CardLayout(0, 0));
			if(products!=null&&products.size()!=0){
				details = new Pane_details(products.get(0));
				productDetail.add(details, "details");
			}else{
				details = new Pane_details();
				productDetail.add(details, "details");
			}


			JPanel nothing2 = new JPanel() {

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D graphics2d_1 = (Graphics2D)g;
					graphics2d_1.setStroke(new BasicStroke(6));
					graphics2d_1.setColor(new Color(233,232,142));
					graphics2d_1.drawLine(0, 0, 0, getHeight());
					BufferedImage img = null;
					try {
						img = ImageIO.read(getClass().getResource("nothing.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.drawImage(img, 80, 150, 400, 250, null);
				}

			};
			productDetail.add(nothing2, "nothing2");

			CardLayout cardLayout01 = (CardLayout)productDetail.getLayout();
			cardLayout01.show(productDetail, "nothing2");

		}



		//这是商品浏览的左侧部分
		class Pane_products extends JPanel {
			ArrayList<browser_everyProductPanel> productPane = new ArrayList<browser_everyProductPanel>();
			//						ArrayList<product> products = new ArrayList<product>();
			private JTextField textField;
			ProductPanel panel;
			public void modify(List<Product>products){
				System.out.println("modify");
				panel.modify(products);
			}

			//传入一个sql语句，默认是select *，起选择作用，不需要是完整的sql语句
			//完整的sql语句在服务端拼接而成
			public Pane_products(List<Product> products) {

				JPanel search = new search_Pane();
				search.setBorder(new LineBorder(new Color(0, 0, 0)));

				JPanel p_roducts = new JPanel();
				p_roducts.setBorder(new LineBorder(new Color(0, 0, 0)));

				JPanel panel_1 = new JPanel();
				GroupLayout groupLayout = new GroupLayout(this);
				groupLayout.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(p_roducts, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
								.addComponent(search, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 531, Short.MAX_VALUE)
										.addContainerGap())
				);
				groupLayout.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(search, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(p_roducts, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
										.addGap(7))
				);
				panel_1.setLayout(new GridLayout(0, 8, 0, 0));

				JButton all = new productsType_Button("  全部");
				all.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(-1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
                    thread.start();
				});
				panel_1.add(all);

				JButton type_1 = new productsType_Button("电器用品");
				type_1.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(0);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_1);

				JButton type_2 = new productsType_Button("学习用具");
				type_2.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(1);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_2);

				JButton type_3 = new productsType_Button("学习书籍");
				type_3.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(2);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_3);

				JButton type_4 = new productsType_Button("美味食品");
				type_4.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(3);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_4);

				JButton type_5 = new productsType_Button("日常用品");
				type_5.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(4);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_5);

				JButton type_6 = new productsType_Button("美容美妆");
				type_6.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(5);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_6);

				JButton type_7 = new productsType_Button("其他商品");
				type_7.addActionListener(e->{
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_return_product);
					Product product=new Product();
					product.setSort(6);
					message.setProduct(product);
					Thread thread=new ReturnProduct(message);
					thread.start();
				});
				panel_1.add(type_7);
				p_roducts.setLayout(null);



				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBorder(null);
				scrollPane.setBounds(0, 0, 536, 386);
				p_roducts.add(scrollPane);

				panel = new ProductPanel(products);

				scrollPane.setViewportView(panel);
				search.setLayout(null);

				textField = new JTextField();
				JButton soso = new search_Button();
				soso.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String text=textField.getText();
						Message message=new Message();
						message.setMesType(message_return_product);
						Product product=new Product();
						product.setIntroduce(text);
						message.setProduct(product);
						Thread thread=new ReturnProduct(message);
						thread.start();
					}
				});
				soso.setBounds(449, 53, 77, 44);
				soso.setOpaque(false);
				soso.setBorder(null);
				search.add(soso);

				textField.setBounds(172, 65, 252, 21);
				textField.setBorder(null);
				textField.setFont(new Font("微软雅黑", Font.BOLD, 15));
				textField.setOpaque(false);
				search.add(textField);
				textField.setColumns(20);
				setLayout(groupLayout);
				setVisible(true);

			}
		}



		//这是避免报错，写的商品类
		class product{

		}

	}



	//这是商品浏览的右侧界面，展示商品的详情
	class Pane_details extends JPanel{
		BufferedImage image = null;
		String nameString = null;
		double price =0;
		String introduction = null;
		private JTextArea comments;

		public Pane_details(){

		}
		public void create(Product product){
			setOpaque(false);
			setBackground(new Color(0,0,0,0));
			setBorder(null);
			try {
				image = ImageIO.read(product.getImage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setOpaque(false);

			JTextPane name = new JTextPane();
			JLabel Price = new JLabel();
			JTextPane Introduction = new JTextPane();
			name.setOpaque(false);
			name.setEditable(false);
			Introduction.setOpaque(false);
			Introduction.setEditable(false);
			Introduction.setFont(new Font("新宋体", Font.PLAIN, 14));
			name.setFont(new Font("微软雅黑", Font.BOLD, 16));
			Price.setFont(new Font("华文中宋", Font.BOLD, 18));

			JLabel info1 = new JLabel("\u53D1\u8D27\uFF1A\u5C71\u4E1C\u6D4E\u5357 | \u5FEB\u9012\uFF1A\u5305\u90AE ");
			info1.setFont(new Font("幼圆", Font.BOLD, 14));

			JLabel info02 = new JLabel("\u6D3B\u52A8\uFF1A\u4E0B\u8F7DAlimama APP\u9886\u6700\u9AD8\u7EA2\u53050\u5143");
			info02.setFont(new Font("幼圆", Font.BOLD, 15));

			//测试代码
			name.setText(product.getName());
			Price.setText("￥"+String.valueOf(product.getPrice()));
			Introduction.setText(product.getIntroduce());

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("宋体", Font.BOLD, 12));
			scrollPane.setBorder(null);
			scrollPane.setOpaque(false);

			JButton lianxi = new JButton("联系商家");
			lianxi.setBorder(null);
			lianxi.setBorderPainted(false);
			lianxi.setUI(new details_buttonUI("lianxi_gray.png","lianxi_black.png"));
			lianxi.setOpaque(false);
			////！！！！！！！！！！
			lianxi.addActionListener(e->{
				//需要将卖家添加到联系人
				//初始化和卖家聊天的聊天区
				String buyerId=product.getUpUser();
				List<User>Friends=IUser.getIChatObject();
				User user=new User();
				boolean s=false;
				int size=Friends.size();
				for(int i=0;i<size;i++){
					if(Friends.get(i).getStuId().equals(buyerId)){
						user=Friends.get(i);
						s=true;
//						chatPane = new ChatPane(buyerId,user);
						ChatPane chatPane1=(ChatPane)chatPane;
						chatPane1.ReChatPane(buyerId,user);
						CardLayout mCardLayout = (CardLayout)panel_3.getLayout();
						mCardLayout.show(panel_3, "contact");
						mCardLayout = (CardLayout)CHAT.getLayout();
						mCardLayout.show(CHAT, "chatPane");
					}
				}if(!s){
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_add_chat_object);
					message.setGetter(product.getUpUser());
					Thread addFriend=new AddFriend(message);
					addFriend.start();
				}


			});

			JButton shoucang = new JButton("  收藏");
			int size=IUser.getICollection().size();
			for(int i=0;i<size;i++){
				if(IUser.getICollection().get(i).getProductID().equals(product.getProductID())){
					shoucang = new JButton(" 已收藏");
				}
			}
			shoucang.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int size=IUser.getICollection().size();
					boolean success=false;
					for(int i=0;i<size;i++){
						if(IUser.getICollection().get(i).equals(product.getProductID())){
							success=true;
						}
					}
					if(!success){
						IUser.getICollection().add(product);
						Message message=new Message();
						message.setCon(product.getProductID());
						message.setSender(IUser.getIid());
						message.setMesType(message_add_collection);
						Thread thread=new AddCollect(message);
						thread.start();
					}

				}
			});
			shoucang.setBorder(null);
			shoucang.setOpaque(false);
			shoucang.setBorderPainted(false);
			shoucang.setUI(new details_buttonUI( "shoucang_gray.png", "shoucang_black.png",1));

			JButton goumai = new JButton("  购买");
			goumai.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(
							MyFrame2.this,
							"确定购买?",
							"",
							JOptionPane.YES_NO_OPTION
					);
					if(result== JOptionPane.YES_OPTION){
						Message message=new Message();
						message.setProduct(product);
						message.setSender(IUser.getIid());
						message.setMesType(message_add_deal);
						Thread thread=new ToBuy(message);
						thread.start();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String time = df.format(new Date());
						product.setSellTime(time);
						IUser.getISellTable().add(product);
					}
				}
			});
			goumai.setBorder(null);
			goumai.setOpaque(false);
			goumai.setBorderPainted(false);
			goumai.setUI(new details_buttonUI("goumai_gray.png", "goumai_black.png"));

			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
													.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
													.addGap(26)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(goumai, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
															.addComponent(shoucang, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
															.addComponent(lianxi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
											.addComponent(info02, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
											.addComponent(info1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
													.addComponent(panel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addGroup(groupLayout.createSequentialGroup()
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addComponent(Price, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
															.addGroup(groupLayout.createSequentialGroup()
																	.addGap(18)
																	.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																			.addComponent(Introduction, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
																			.addComponent(name, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(19)
													.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(33)
													.addComponent(name, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(Introduction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(Price)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(info1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(info02)
													.addGap(26)
													.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(93)
													.addComponent(lianxi)
													.addGap(18)
													.addComponent(shoucang)
													.addGap(18)
													.addComponent(goumai)))
									.addContainerGap(21, Short.MAX_VALUE))
			);

			comments = new JTextArea();

			comments.setFont(new Font("Adobe 黑体 Std R", Font.PLAIN, 12));
			comments.setColumns(10);
			String comment="";
			if(product.getComments()!=null){
				int size1=product.getComments().size();
				for(int i=0;i<size1;i++){
					String com=product.getComments()+"\n";
					comment=comment+com;
				}
				comments.setText(comment);
			}
			comments.setLineWrap(true);
			comments.setOpaque(false);
			comments.setEditable(false);
			scrollPane.setViewportView(comments);
			setLayout(groupLayout);
			// TODO Auto-generated constructor stub
		}

		public Pane_details(Product product) {
			create(product);
		}

		public void reShow_detail(Product product){
			this.removeAll();
			this.repaint();
			create(product);
			this.revalidate();
		}

		public Pane_details(Object product){

		}


		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D graphics2d= (Graphics2D)g;
			if(image != null) {
				graphics2d.drawImage(image, 20, 20, 220, 265, null);

			}else {
				try {
					image = ImageIO.read(getClass().getResource("product.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				graphics2d.drawImage(image, 20, 20, 220, 265, null);
			}
			graphics2d.setStroke(new BasicStroke(3));
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.drawRoundRect(15, 355, 355, 170, 20, 20);
			graphics2d.setColor(new Color(238,238,238));
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.drawLine(27, 355, 87, 355);
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			graphics2d.setFont(new Font("幼圆", Font.PLAIN, 15));
			graphics2d.setColor(Color.black);
			graphics2d.drawString("商品评价", 27,360 );
			graphics2d.setColor(new Color(255,255,255));
			graphics2d.setStroke(new BasicStroke(6));
			graphics2d.drawRoundRect(18, 17, 225, 273, 20, 20);
			graphics2d.setColor(new Color(233,232,142));
			graphics2d.drawLine(0, 0, 0, getHeight());
		}


	}

	//这是拍卖商品浏览的右侧界面，展示商品的详情
	class Pane_Auctiondetails extends JPanel{
		BufferedImage image = null;
		String nameString = null;
		double price =0;
		String introduction = null;
		private JTextArea comments;

		public void create(Product product){
			setOpaque(false);
			setBackground(new Color(0,0,0,0));
			setBorder(null);
			try {
				image = ImageIO.read(product.getImage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setOpaque(false);

			JTextPane name = new JTextPane();
			name.setOpaque(false);
			name.setEditable(false);
			name.setFont(new Font("微软雅黑", Font.BOLD, 16));
			name.setText(product.getName());

			JLabel info1 = new JLabel("\u53D1\u8D27\uFF1A\u5C71\u4E1C\u6D4E\u5357 | \u5FEB\u9012\uFF1A\u5305\u90AE ");
			info1.setFont(new Font("幼圆", Font.BOLD, 14));

			JLabel info02 = new JLabel("\u6D3B\u52A8\uFF1A\u4E0B\u8F7DAlimama APP\u9886\u6700\u9AD8\u7EA2\u53050\u5143");
			info02.setFont(new Font("幼圆", Font.BOLD, 15));

			JLabel Price = new JLabel("\uFFE5 389-419");
			Price.setFont(new Font("华文中宋", Font.BOLD, 18));
			Price.setText(String.valueOf("￥"+product.getPrice()));

			JTextPane Introduction = new JTextPane();
			Introduction.setOpaque(false);
			Introduction.setFont(new Font("新宋体", Font.PLAIN, 14));
			Introduction.setText("\u7B80\u4ECB\uFF1A\u6DE1\u9EC4\u7684\u957F\u88D9\uFF0C\u84EC\u677E\u7684\u5934\u53D1\uFF0C\u7275\u7740\u6211\u7684\u624B\u53BB\u770B\u90A3\u65B0\u5C55\u51FA\u7684\u6CB9\u753B\u3002\u65E0\u4EBA\u7684\u8857\u9053 \u7A7A\u8361\u7684\u5BB6\u91CC\uFF0C\u3000\u53EA\u5269\u6211\u4E00\u4E2A\u4EBA\u5728\u90A3\u5F00\u72C2\u6B22\u7684pARty\u3002\u5C31\u5F53\u662F\u4E00\u573A\u68A6\uFF0C\u9192\u4E86\u5F88\u4E45\u4E4B\u540E\u8FD8\u662F\u5F88\u611F\u52A8\u3002\u60F3\u88AB\u4F60\u4FDD\u62A4\u5FC3\u91CC\u7684\u60E8\u75DB\uFF0C\u559C\u6B22\u6211\u5F88\u8F9B\u82E6\uFF0C\u5176\u5B9E\u5168\u90FD\u6E05\u695A\uFF0C\u653E\u5FC3\u8FD9\u4E16\u754C\u5F88\u574F\uFF0C\u4F46\u6211\u8BB0\u5F97\u4F60\u7684\u53EE\u5631\u3002");
			Introduction.setText(product.getIntroduce());
			Introduction.setEditable(false);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("宋体", Font.BOLD, 12));
			scrollPane.setBorder(null);
			scrollPane.setOpaque(false);

			JButton lianxi = new JButton("联系商家");
			lianxi.setBorder(null);
			lianxi.setBorderPainted(false);
			lianxi.setUI(new details_buttonUI("lianxi_gray.png","lianxi_black.png"));
			lianxi.setOpaque(false);

			lianxi.addActionListener(e->{
				//需要将卖家添加到联系人
				//初始化和卖家聊天的聊天区
				System.out.println("toChat");
				String buyerId=product.getUpUser();
				System.out.println(buyerId);
				List<User>Friends=IUser.getIChatObject();
				User user=new User();
				boolean s=false;
				int size=Friends.size();
				for(int i=0;i<size;i++){
					if(Friends.get(i).getStuId().equals(buyerId)){
						user=Friends.get(i);
						s=true;
						ChatPane chatPane1=(ChatPane)chatPane;
						chatPane1.ReChatPane(buyerId,user);
						CardLayout mCardLayout = (CardLayout)panel_3.getLayout();
						mCardLayout.show(panel_3, "contact");
						mCardLayout = (CardLayout)CHAT.getLayout();
						mCardLayout.show(CHAT, "chatPane");
					}
				}if(!s){
					System.out.println("addChatObject");
					Message message=new Message();
					message.setSender(IUser.getIid());
					message.setMesType(message_add_chat_object);
					message.setGetter(product.getUpUser());
					Thread addFriend=new AddFriend(message);
				}


			});
			JButton shoucang = new JButton("  收藏");
			int size=IUser.getICollection().size();
			for(int i=0;i<size;i++){
				if(IUser.getICollection().get(i).getProductID().equals(product.getProductID())){
					shoucang = new JButton(" 已收藏");
				}
			}
			shoucang.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int size=IUser.getICollection().size();
					boolean success=false;
					for(int i=0;i<size;i++){
						if(IUser.getICollection().get(i).getProductID().equals(product.getProductID())){
							success=true;
						}
					}
					if(!success){
						IUser.getICollection().add(product);
						Message message=new Message();
						message.setCon(product.getProductID());
						message.setSender(IUser.getIid());
						message.setMesType(message_add_collection);
						Thread thread=new AddCollect(message);
						thread.start();
					}

				}
			});
			shoucang.setBorder(null);
			shoucang.setOpaque(false);
			shoucang.setBorderPainted(false);
			shoucang.setUI(new details_buttonUI( "shoucang_gray.png", "shoucang_black.png",1));

			JButton goumai = new JButton("  拍卖");
			goumai.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String inputContent = JOptionPane.showInputDialog(
							MyFrame2.this,
							"输入加价:(￥)",
							""
					);
					if(inputContent!=null){
						Double addPrice=Double.valueOf(inputContent);
						product.setPrice(product.getPrice()+addPrice);
						Message message=new Message();
						message.setProduct(product);
						message.setSender(IUser.getIid());
						message.setMesType(message_add_deal);
						Thread thread=new ToBuy(message);
						thread.start();
					}

				}
			});
			goumai.setBorder(null);
			goumai.setOpaque(false);
			goumai.setBorderPainted(false);
			goumai.setUI(new details_buttonUI("goumai_gray.png", "goumai_black.png"));

			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
													.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
													.addGap(26)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(goumai, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
															.addComponent(shoucang, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
															.addComponent(lianxi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
											.addComponent(info02, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
											.addComponent(info1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
													.addComponent(panel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addGroup(groupLayout.createSequentialGroup()
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addComponent(Price, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
															.addGroup(groupLayout.createSequentialGroup()
																	.addGap(18)
																	.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																			.addComponent(Introduction, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
																			.addComponent(name, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(19)
													.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(33)
													.addComponent(name, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(Introduction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(Price)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(info1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(info02)
													.addGap(26)
													.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(93)
													.addComponent(lianxi)
													.addGap(18)
													.addComponent(shoucang)
													.addGap(18)
													.addComponent(goumai)))
									.addContainerGap(21, Short.MAX_VALUE))
			);

			comments = new JTextArea();

			comments.setFont(new Font("Adobe 黑体 Std R", Font.PLAIN, 12));
			comments.setColumns(10);
			String comment="";
			if(product.getComments()!=null){
				int size1=product.getComments().size();
				for(int i=0;i<size1;i++){
					String com="   "+(i+1)+" :"+product.getComments().get(i)+"\n";
					comment=comment+com;
					System.out.println(comment);
				}
				comments.setText(comment);
			}
			comments.setLineWrap(true);
			comments.setOpaque(false);
			comments.setEditable(false);
			scrollPane.setViewportView(comments);
			setLayout(groupLayout);
			// TODO Auto-generated constructor stub
		}
		public Pane_Auctiondetails(Product product) {
			create(product);
		}

		public void reShow_detail(Product product){
			removeAll();
			repaint();
			create(product);
			revalidate();
		}
		public Pane_Auctiondetails(){

		}


		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D graphics2d= (Graphics2D)g;
			if(image != null) {
				graphics2d.drawImage(image, 20, 20, 220, 265, null);

			}else {
				try {
					image = ImageIO.read(getClass().getResource("product.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				graphics2d.drawImage(image, 20, 20, 220, 265, null);
			}
			graphics2d.setStroke(new BasicStroke(3));
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.drawRoundRect(15, 355, 355, 170, 20, 20);
			graphics2d.setColor(new Color(238,238,238));
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.drawLine(27, 355, 87, 355);
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			graphics2d.setFont(new Font("幼圆", Font.PLAIN, 15));
			graphics2d.setColor(Color.black);
			graphics2d.drawString("商品评价", 27,360 );
			graphics2d.setColor(new Color(255,255,255));
			graphics2d.setStroke(new BasicStroke(6));
			graphics2d.drawRoundRect(18, 17, 225, 273, 20, 20);
			graphics2d.setColor(new Color(233,232,142));
			graphics2d.drawLine(0, 0, 0, getHeight());
		}


	}

	//这是每个商品的小窗
	class browser_everyProductPanel extends JPanel{

		private Product mProduct= null;
		private String productImage = null;//商品图片
		private JTextField price;//商品价格
		private BufferedImage image =null;

		//通过传入一个商品对象，进行赋值
		//	public browser_everyProductPanel(product m) {
		public browser_everyProductPanel(Product product) {
			// TODO Auto-generated constructor stub
			setBorder(null);
			setOpaque(false);
			setLayout(null);
			mProduct=product;
			JButton detail = new JButton("     Details") ;
			detail.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//初始化details，商品详情页面
					System.out.println(mProduct.getProductID());
					Pane_details pane_details=(Pane_details)details;
					pane_details.reShow_detail(product);
					CardLayout cardLayout01 = (CardLayout)panel_3.getLayout();
					cardLayout01.show(panel_3, "productsBrowser");
					cardLayout01 = (CardLayout)productDetail.getLayout();
					cardLayout01.show(productDetail, "details");
				}
			});
			detail.setUI(new MyButtonUI(new Color(150,153,159,140), Color.black, Color.GRAY));

			detail.setOpaque(false);
			detail.setBorder(null);
			detail.setBounds(112, 81, 121, 23);
			add(detail);

			JTextPane pro_name = new JTextPane();
			pro_name.setOpaque(false);
			pro_name.setFont(new Font("黑体", Font.PLAIN, 14));
			pro_name.setBorder(null);
			pro_name.setBounds(92, 10, 154, 55);
			pro_name.setEditable(false);
			add(pro_name);


			price = new JTextField();
			price.setBorder(null);
			price.setFont(new Font("隶书", Font.PLAIN, 12));
			price.setOpaque(false);
			price.setBounds(102, 61, 66, 21);
			add(price);
			price.setColumns(10);

			//测试代码
			pro_name.setText(mProduct.getName());

			price.setText("￥"+mProduct.getPrice());
		}



		@Override
		protected void paintComponent(Graphics g) {
			try {
				image = ImageIO.read(mProduct.getImage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.setColor(Color.white);
			graphics2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
			graphics2d.drawImage(image, 10, 10, 80, 80, null);
		}



	}

	//这是每个拍卖品的小窗
	class browser_everyAuctionPanel extends JPanel{

		private Product mProduct= null;
		private String productImage = null;//商品图片
		private JTextField price;//商品价格
		private BufferedImage image =null;

		//通过传入一个商品对象，进行赋值
		//	public browser_everyProductPanel(product m) {
		public browser_everyAuctionPanel(Product product) {
			// TODO Auto-generated constructor stub
			setBorder(null);
			setOpaque(false);
			setLayout(null);
			mProduct=product;
			JButton detail = new JButton("     Details") ;
			detail.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Pane_Auctiondetails pane_auctiondetails=(Pane_Auctiondetails)Auctiondetails;
					pane_auctiondetails.reShow_detail(product);
					CardLayout cardLayout01 = (CardLayout)panel_3.getLayout();
					cardLayout01.show(panel_3, "auction");
					cardLayout01 = (CardLayout)AuctionproductDetail.getLayout();
					cardLayout01.show(AuctionproductDetail, "details");
				}
			});


			detail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			detail.setUI(new MyButtonUI(new Color(150,153,159,140), Color.black, Color.GRAY));
			detail.setOpaque(false);
			detail.setBorder(null);
			detail.setBounds(112, 81, 121, 23);
			add(detail);

			JTextPane pro_name = new JTextPane();
			pro_name.setOpaque(false);
			pro_name.setFont(new Font("黑体", Font.PLAIN, 14));
			pro_name.setBorder(null);
			pro_name.setText(mProduct.getName());
			pro_name.setBounds(92, 10, 154, 55);
			pro_name.setEditable(false);
			add(pro_name);

			price = new JTextField();
			price.setBorder(null);
			price.setFont(new Font("隶书", Font.PLAIN, 12));
			price.setOpaque(false);

			price.setText("￥"+mProduct.getPrice());;
			price.setBounds(102, 61, 66, 21);
			add(price);
			price.setColumns(10);
		}



		@Override
		protected void paintComponent(Graphics g) {
			try {
				image = ImageIO.read(mProduct.getImage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.setColor(Color.white);
			graphics2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
			graphics2d.drawImage(image, 10, 10, 80, 80, null);
		}



	}

	//这是联系分页
	class contactPanel extends JPanel{
		int y=0;
		JPanel Contacts;
		CardLayout chatCardLayout;
		public void create(){
			setLayout(null);
            y=0;

			//contacts是做左边放联系人的部分
			JPanel contacts = new JPanel();
			//CHAT是右边的部分，以CardLayout为布局，分为两页，一也是nothing，一页是chatPane；
			CHAT = new JPanel();
//			chatPane = new ChatPane(null,null);
			chatPane=new ChatPane();

			contacts.setBackground(new Color(233,231,230));
			contacts.setBounds(0, 0, 343, 535);
			add(contacts);

			CHAT.setLayout(new CardLayout());
			chatCardLayout = (CardLayout)CHAT.getLayout();

			//向contacts里添加联系人
			int Contacts_y = 0;
			Contacts = new JPanel();
			Contacts.setBackground(new Color(233,231,230));
			Contacts.setPreferredSize(new Dimension(320,520));
			Contacts.setLayout(null);

			//需要更改i<ArrayList.size()
			if(IUser.getIChatObject()!=null){
				int size = IUser.getIChatObject().size();
				for(int i=0;i<size;i++) {

					//填入参数!!!!!!!!!!!
					User user=IUser.getIChatObject().get(i);
					JPanel aJPanel = new contacts_beside(user);

					aJPanel.addMouseListener(new MouseListener() {

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
							//chatPane = new JPanel();
							ChatPane chatPane1=(ChatPane)chatPane;
							chatPane1.ReChatPane(user.getStuId(),user);
							chatCardLayout.show(CHAT, "chatPane");
						}
					});
					aJPanel.setBounds(0, y, 435, 100);
					y+=100;
					Contacts.add(aJPanel);
					Contacts.repaint();
				}
			}

			JScrollPane scrollPane_1 = new JScrollPane(Contacts);
			if(y>520) {
				Contacts.setPreferredSize(new Dimension(320,y));
			}
			scrollPane_1.validate();
			scrollPane_1.repaint();
			scrollPane_1.setBorder(null);
			scrollPane_1.setPreferredSize(new Dimension(343,530));
			//	contacts.setBackground(new Color(rgb));
			contacts.add(scrollPane_1);
			//	chatPane.setBounds(344, 0, 727, 535);
			CHAT.setBounds(344, 0, 727, 535);
			CHAT.add(chatPane,"chatPane");
			add(CHAT);
			JPanel nothing = new JPanel();
			try {
				nothing = new JPanel() {
					BufferedImage noImage = ImageIO.read(getClass().getResource("nothing.png"));
					@Override
					protected void paintComponent(Graphics g) {
						Graphics2D graphics2d=(Graphics2D)g;
						graphics2d.drawImage(noImage, 0, 100, getWidth()-1, 300, null);
					}

				};
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CHAT.setBackground(new Color(238,238,238));
			nothing.setOpaque(true);
			CHAT.add(nothing,"nothing");
			chatCardLayout.show(CHAT, "nothing");
		}

		public contactPanel() {
			create();
		}
        public void reContact(){
			removeAll();
			repaint();
			create();
			revalidate();
		}

		private void addRight() {
			// TODO Auto-generated method stub

		}

	}



	 class ChatPane extends JPanel{
		JScrollPane scrollPane ;
		JScrollBar mBar;
		JPanel messagesJPanel;
		int y=0;
		String id;
		public ChatPane(){

		}
		public void create(String id,User user){
			y=0;
			this.id=id;
			setOpaque(false);
			setLayout(null);
			JPanel text = new JPanel() {

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D graphics2d =(Graphics2D)g;
					BufferedImage chatBgImage = null;
					try {
						chatBgImage = ImageIO.read(getClass().getResource("chatBg.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					graphics2d.drawImage(chatBgImage, 0, 0, getWidth()-1, getHeight()-1, null);
				}

			};
			text.setOpaque(false);
			text.setBounds(0, 394, 727, 141);
			add(text);
			text.setLayout(null);

			JButton sent = new sent_button();
			sent.setBounds(607, 108, 90, 23);
			text.add(sent);

			JTextArea textArea = new JTextArea();
			textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
			textArea.setOpaque(false);
			textArea.setLineWrap(true);
			textArea.setBounds(10, 38, 707, 62);
			text.add(textArea);

			JPanel userName = new JPanel() ;
			userName.setBounds(0, 0, 727, 49);
			add(userName);
			userName.setLayout(null);

			JLabel user_name = new JLabel(user.getName());
			user_name.setBounds(0, 10, 80, 28);
			user_name.setFont(new Font("微软雅黑", Font.BOLD, 20));
			userName.add(user_name);

			JPanel history = new JPanel();
			history.setBackground(new Color(245,245,245));
			history.setOpaque(false);
			history.setBorder(null);
			history.setBounds(0, 49, 727, 345);
			add(history);

			messagesJPanel = new JPanel() {

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D graphics2d =(Graphics2D)g;
					graphics2d.setColor(new Color(245,245,245));
					graphics2d.fillRect(0, 0, getWidth(), getHeight());
				}

			};
			messagesJPanel.setPreferredSize(new Dimension(710,350));
			//向消息记录里添加消息
			//使用if语句判断添加在左边还是右边!!!!!!


			List<Message> msg=IUser.getIChatMsg().get(id);
			messagesJPanel.setLayout(null);
			if(msg!=null){
				int size =msg.size();
				for(int i=0;i<size;i++) {
					if(msg.get(i).getSender().equals(id)) {
						JPanel panel1 = new contact_Right(msg.get(i));
						panel1.setBounds(0, y, 720, ((contact_Right)panel1).height);
						y = y + ((contact_Right)panel1).height;
						messagesJPanel.add(panel1);
					}else {
						JPanel panel1 = new contact_Left(msg.get(i),user);
						panel1.setBounds(0, y, 720, ((contact_Left)panel1).height);
						y = y + ((contact_Left)panel1).height;
						messagesJPanel.add(panel1);
					}
				}
			}
			if(y>350) {
				messagesJPanel.setPreferredSize(new Dimension(700,y+10));
			}
			history.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			scrollPane = new JScrollPane(messagesJPanel);
			scrollPane.setOpaque(false);
			messagesJPanel.setOpaque(false);
			messagesJPanel.setBackground(new Color(245,245,245));
			mBar = scrollPane.getVerticalScrollBar();
			sent.addActionListener(e->{
				Message message=new Message();
				message.setSender(IUser.getIid());
				message.setGetter(user.getStuId());
				message.setCon(textArea.getText());
				message.setMesType(message_comm_mes);
				try {
					if(IUser.getIChatMsg().containsKey(id)){
						IUser.getIChat().add(message);
						IUser.getIChatMsg().get(id).add(message);
					}else{
						List<Message>messages=new ArrayList<>();
						IUser.getIChatMsg().put(id,messages);
						IUser.getIChat().add(message);
						IUser.getIChatMsg().get(id).add(message);
					}
					ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(IUser.getIid()).getS().getOutputStream());
					oos.writeObject(message);
					textArea.setText("");
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				JPanel jPanel = new contact_Right(message);
				jPanel.setBounds(0, y, 720,( (contact_Right)jPanel).height);
				y = y + ((contact_Right)jPanel).height;
				messagesJPanel.add(jPanel);
				messagesJPanel.repaint();
				if(y>350) {
					messagesJPanel.setPreferredSize(new Dimension(700,y+20));
				}
				scrollPane.repaint();
				scrollPane.validate();
				mBar = scrollPane.getVerticalScrollBar();
//									System.out.println(mBar.getMaximum());
//									mBar.setValue(mBar.getMaximum());
//									System.out.println("value:"+mBar.getValue());
//									mBar.setValue(mBar.getMaximum());
//									System.out.println("value:"+mBar.getValue());
				mBar.setValue(mBar.getMaximum());
//									System.out.println("y "+y+" mbar "+mBar.getValue()+" max "+mBar.getMaximum());
				scrollPane.repaint();
			});

			scrollPane.setPreferredSize(new Dimension(723,345));
			scrollPane.setBorder(null);

			//妈的，不知道为什么一定要设置两次才生效？？？！！！！！
			//设置JScrollPanel的视图在最下方
			mBar.setValue(mBar.getMaximum());
			mBar.setValue(mBar.getMaximum());
			//	System.out.println("y "+y+" mbar "+mBar.getValue()+" max "+mBar.getMaximum());
			scrollPane.repaint();

			history.add(scrollPane);
		}
		public void ReChatPane(String id,User user) {
			removeAll();
			repaint();
			create(id,user);
		    revalidate();
		}


		public void showMessage(Message message){
			System.out.println(message.getSender());
			User friend=new User();
			Iterator<User> iterator = IUser.getIChatObject().iterator();
			while (iterator.hasNext()) {
				User user=iterator.next();
				if(user.getStuId().equals(message.getSender())){
                     friend=user;
					System.out.println("okk");
				}
			}
			JPanel jPanel = new contact_Left(message,friend);
			jPanel.setBounds(0, y, 720,( (contact_Left)jPanel).height);
			y = y + ((contact_Left)jPanel).height;
			messagesJPanel.add(jPanel);
			messagesJPanel.repaint();
			if(y>350) {
				messagesJPanel.setPreferredSize(new Dimension(700,y+20));
			}
			scrollPane.repaint();
			scrollPane.validate();
			mBar = scrollPane.getVerticalScrollBar();
//									System.out.println(mBar.getMaximum());
//									mBar.setValue(mBar.getMaximum());
//									System.out.println("value:"+mBar.getValue());
//									mBar.setValue(mBar.getMaximum());
//									System.out.println("value:"+mBar.getValue());
			mBar.setValue(mBar.getMaximum());
//									System.out.println("y "+y+" mbar "+mBar.getValue()+" max "+mBar.getMaximum());
			scrollPane.repaint();
		}
	}
      public void showIn(Message message){
		ChatPane c=(ChatPane)chatPane;
		c.showMessage(message);
	  }
	 public void Pane_toChat(User user){
//		chatPane = new ChatPane(user.getStuId(),user);
		 contactPanel con=(contactPanel)contact;
		con.reContact();
		ChatPane chatPane1=(ChatPane)chatPane;
		chatPane1.ReChatPane(user.getStuId(),user);
		CardLayout mCardLayout = (CardLayout)panel_3.getLayout();
		mCardLayout.show(panel_3, "contact");
		mCardLayout = (CardLayout)CHAT.getLayout();
		mCardLayout.show(CHAT, "chatPane");
	}
	//显示回来的商品
	public void showProduct(List<Product>products,int isAuction){
		System.out.println(isAuction);
		if(isAuction==1){
			auctionBrowserPanel auction1=(auctionBrowserPanel)auction;
            auction1.pane_auctionproducts.modify(products);
			this.repaint();
			start.show(panel_3, "auction");
		}else{
			System.out.println("showProduct");
			productsBrowserPanel product1=(productsBrowserPanel)productsBrowser;
			product1.pane_products.modify(products);
			this.repaint();
			start.show(panel_3, "productsBrowser");
		}

	}
	class ProductPanel extends JPanel{
		public void create(List<Product>products){
			int m = 0;
			if(products!=null){
				int k=products.size();
				m=k;
				if(m%2==0) { m = m/2; }else { m=m/2+1; }
			}

			this.setPreferredSize(new Dimension(515,114*m));
			this.setLayout(new GridLayout(m, 2,5,5));
			if(products!=null){
				int size=products.size();
				for(int i=0;i<size;i++){
					this.add(new MyFrame2.browser_everyProductPanel(products.get(i)));

				}
			}
		}
		public ProductPanel(List<Product>products){
			create(products);
		}
		public void modify(List<Product>products){
			removeAll();
			repaint();
			create(products);
			validate();
		}
	}
	class AuctionPanel extends JPanel{
		public void create(List<Product>products){
			int m = 0;
			if(products!=null){
				int k=products.size();
				for(int i=0;i<k;i++){
					if(products.get(i).getIsAuction()==1){
						m++;
					}
				}
				if(m%2==0) { m = m/2; }else { m=m/2+1; }
			}
			this.setPreferredSize(new Dimension(515,114*m));
			this.setLayout(new GridLayout(m, 2,5,5));
			if(products!=null){
				int size=products.size();
				for(int i=0;i<size;i++){
					this.add(new MyFrame2.browser_everyAuctionPanel(products.get(i)));
					}
				}

		}
		public AuctionPanel(List<Product>products){
			create(products);
		}
		public void modify(List<Product>products){
			removeAll();
			repaint();
			create(products);
			validate();
		}
	}
	public void showSellMessage(Message message){
		if(message.getMesType().equals(message_final_auction)){
			int size1=IUser.getIAuction().size();
			String id=message.getProduct().getProductID();
			for(int i=0;i<size1;i++){
				if(id.equals(IUser.getIAuction().get(i).getProductID())){
					IUser.getIAuction().get(i).setState(1);
				}
			}

			JOptionPane.showMessageDialog(this,"ID:"+id+"的商品拍卖成功，请尽快催货");
		}else {
			IUser.getISellTable().add(message.getProduct());
			String id=message.getProduct().getProductID();
			JOptionPane.showMessageDialog(this,"ID:"+id+"的商品已被购买，请尽快发货");
		}

	}
}

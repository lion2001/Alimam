package com.client.page;

import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.component.UI.MyButtonUI;
//import com.component.UI.MyButtonUI;
import com.component.UI.details_buttonUI;
import com.component.UI.productsType_Button;
import com.component.UI.search_Button;
import com.component.UI.search_Pane;

 class productsBrowserPanel extends JPanel{
	JPanel details = new Pane_details();
	JPanel productDetail = new JPanel();
	 public static void main(String[] args) {
		 JFrame jFrame=new JFrame();
		 jFrame.add(new productsBrowserPanel());
		 jFrame.setVisible(true);
	 }

	public productsBrowserPanel() {
		setLayout(new GridLayout(1,2));
		add(new Pane_products(""));
		add(productDetail);
		productDetail.setLayout(new CardLayout(0, 0));
		
		details = new Pane_details();
		productDetail.add(details, "details");
		
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
	class Pane_details extends JPanel{

		BufferedImage image = null;
		String nameString = null;
		double price =0;
		String introduction = null;
		private JTextArea comments;
		
		 public Pane_details() {
		 	setOpaque(false);
		 	setBackground(new Color(0,0,0,0));
		 	setBorder(null);
		 	try {
				image = ImageIO.read(getClass().getResource("puma.jpg"));
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
		 	name.setText("PUMA/\u5F6A\u9A6C\u5B98\u65B9\u6B63\u54C12020\u6625\u5B63\u65B0\u6B3E\u7537\u5B50\u7ACB\u9886\u9632\u98CE\u4FDD\u6696\u8FD0\u52A8\u4F11\u95F2\u5916\u5957");
		 	
		 	JLabel info1 = new JLabel("\u53D1\u8D27\uFF1A\u5C71\u4E1C\u6D4E\u5357 | \u5FEB\u9012\uFF1A\u5305\u90AE ");
		 	info1.setFont(new Font("幼圆", Font.BOLD, 14));
		 	
		 	JLabel info02 = new JLabel("\u6D3B\u52A8\uFF1A\u4E0B\u8F7DAlimama APP\u9886\u6700\u9AD8\u7EA2\u53050\u5143");
		 	info02.setFont(new Font("幼圆", Font.BOLD, 15));
		 	
		 	JLabel Price = new JLabel("\uFFE5 389-419");
		 	Price.setFont(new Font("华文中宋", Font.BOLD, 18));
		 	
		 	JTextPane Introduction = new JTextPane();
		 	Introduction.setOpaque(false);
		 	Introduction.setFont(new Font("新宋体", Font.PLAIN, 14));
		 	Introduction.setText("\u7B80\u4ECB\uFF1A\u6DE1\u9EC4\u7684\u957F\u88D9\uFF0C\u84EC\u677E\u7684\u5934\u53D1\uFF0C\u7275\u7740\u6211\u7684\u624B\u53BB\u770B\u90A3\u65B0\u5C55\u51FA\u7684\u6CB9\u753B\u3002\u65E0\u4EBA\u7684\u8857\u9053 \u7A7A\u8361\u7684\u5BB6\u91CC\uFF0C\u3000\u53EA\u5269\u6211\u4E00\u4E2A\u4EBA\u5728\u90A3\u5F00\u72C2\u6B22\u7684pARty\u3002\u5C31\u5F53\u662F\u4E00\u573A\u68A6\uFF0C\u9192\u4E86\u5F88\u4E45\u4E4B\u540E\u8FD8\u662F\u5F88\u611F\u52A8\u3002\u60F3\u88AB\u4F60\u4FDD\u62A4\u5FC3\u91CC\u7684\u60E8\u75DB\uFF0C\u559C\u6B22\u6211\u5F88\u8F9B\u82E6\uFF0C\u5176\u5B9E\u5168\u90FD\u6E05\u695A\uFF0C\u653E\u5FC3\u8FD9\u4E16\u754C\u5F88\u574F\uFF0C\u4F46\u6211\u8BB0\u5F97\u4F60\u7684\u53EE\u5631\u3002");
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
		 	
		 	JButton shoucang = new JButton("  收藏");
		 	shoucang.setBorder(null);
		 	shoucang.setOpaque(false);
		 	shoucang.setBorderPainted(false);
		 	shoucang.setUI(new details_buttonUI( "shoucang_gray.png", "shoucang_black.png",1));
		 	
		 	JButton goumai = new JButton("  购买");
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
		 	comments.setText("简介：淡黄的长裙，蓬松的头发，牵着我的手去看那新展出的油画。无人的街道 空荡的家里，　只剩我一个人在那开狂欢的pARty。就当是一场梦，醒了很久之后还是很感动。想被你保护心里的惨痛，喜欢我很辛苦，其实全都清楚，放心这世界很坏，但我记得你的叮嘱简介：淡黄的长裙，蓬松的头发，牵着我的手去看那新展出的油画。无人的街道 空荡的家里，　只剩我一个人在那开狂欢的pARty。就当是一场梦，醒了很久之后还是很感动。想被你保护心里的惨痛，喜欢我很辛苦，其实全都清楚，放心这世界很坏，但我记得你的叮嘱");
		 	comments.setLineWrap(true);
		 	comments.setOpaque(false);
		 	comments.setEditable(false);
		 	scrollPane.setViewportView(comments);
		 	setLayout(groupLayout);
			// TODO Auto-generated constructor stub
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
	 class Pane_products extends JPanel {
			ArrayList<browser_everyProductPanel> productPane = new ArrayList<browser_everyProductPanel>();
			ArrayList<JButton> detail_Buttons = new ArrayList<JButton>();
//			ArrayList<product> products = new ArrayList<product>();
			private JTextField textField;
			String sqlString;
			
			//传入一个sql语句，默认是select *，起选择作用，不需要是完整的sql语句
			//完整的sql语句在服务端拼接而成
			public Pane_products(String sql) {
				sqlString = sql;
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
					sqlString ="";
				});
				panel_1.add(all);
				
				JButton type_1 = new productsType_Button("电器用品");
				type_1.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_1);
				
				JButton type_2 = new productsType_Button("学习用具");
				type_2.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_2);
				
				JButton type_3 = new productsType_Button("学习书籍");
				type_3.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_3);
				
				JButton type_4 = new productsType_Button("美味食品");
				type_4.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_4);
				
				JButton type_5 = new productsType_Button("日常用品");
				type_5.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_5);
				
				JButton type_6 = new productsType_Button("美容美妆");
				type_6.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_6);
				
				JButton type_7 = new productsType_Button("其他商品");
				type_7.addActionListener(e->{
					sqlString ="";
				});
				panel_1.add(type_7);
				p_roducts.setLayout(null);
				

				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBorder(null);
				scrollPane.setBounds(0, 0, 536, 386);
				int m = 4;
				//向服务端发出请求，服务端返回商品集合到客户端
				/*
				 * productsClient client = new productsClient(sqlString);
				 * products  = client.getProducts();
				 */
//				int m = products.size();
//				if(m%2==0) {
//					m = m/2;
//				}else {
//					m=m/2+1
//				}
//				
				
				p_roducts.add(scrollPane);
				
				JPanel panel = new JPanel();
			
				panel.setPreferredSize(new Dimension(515,114*m));
				panel.setLayout(new GridLayout(m, 2,5,5));
				
				/*
				 * 通过循环添加商品
				 * for(int i = 0;i<products.size;i++){
				 * panel.add(new browser_everyProductPanel(product products[i]));
				 * }
				 */
				for(int i=0;i<8;i++) {
				panel.add(new browser_everyProductPanel());
				}

				scrollPane.setViewportView(panel);
				search.setLayout(null);
				
				JButton soso = new search_Button();
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
	 class browser_everyProductPanel extends JPanel{
			
			private product mProduct= null;
			private String  ImageStrings = "product.jpg";
			private String productImage = null;//商品图片
			private JTextField price;//商品价格
			private BufferedImage image =null;
			
			//通过传入一个商品对象，进行赋值
		    //	public browser_everyProductPanel(product m) {
			public browser_everyProductPanel() {
				// TODO Auto-generated constructor stub
				setBorder(null);
				setOpaque(false);
				setLayout(null);
				if(productImage!=null) {
					ImageStrings = productImage;
				}
					JButton detail = new JButton("     Details") ;
					detail.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							details = new Pane_details();
							CardLayout mCardLayout = (CardLayout)productDetail.getLayout();
							mCardLayout.show(productDetail, "details");
						}
					});
				
					
					detail.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					detail.setUI(new MyButtonUI(new Color(150,153,159,140), Color.black, Color.GRAY));
//					JButton detail = new JButton("查看详情") {
		//
//					Color mColor = Color.black;
		//
//					@Override
//					protected void paintComponent(Graphics g) {
//						Graphics2D graphics2d =(Graphics2D)g;
//						
//						g.setColor(new Color(150,153,159,140));
//						g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
//						g.setColor(mColor);
//						graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//						g.drawString("查看详情", 40,15);
//					}
//				};
				detail.setOpaque(false);
				detail.setBorder(null);
				detail.setBounds(112, 81, 121, 23);
				add(detail);
				
				JTextPane pro_name = new JTextPane();
				pro_name.setOpaque(false);
				pro_name.setFont(new Font("黑体", Font.PLAIN, 14));
				pro_name.setBorder(null);
				pro_name.setText("PUMA/彪马官方正品2020春季新款男子立领防风保暖运动休闲外套");
				pro_name.setBounds(92, 10, 154, 55);
				add(pro_name);
				
				price = new JTextField();
				price.setBorder(null);
				price.setFont(new Font("隶书", Font.PLAIN, 12));
				price.setOpaque(false);
				price.setText("￥416");
				price.setBounds(102, 61, 66, 21);
				add(price);
				price.setColumns(10);
			}


			
			@Override
			protected void paintComponent(Graphics g) {
				try {
					image = ImageIO.read(getClass().getResource(ImageStrings));
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
		class product{
			
		}
	
}

//package com.component.UI;
//
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.GridLayout;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//
//
//import javax.swing.JButton;
//import javax.swing.JTextPane;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import javax.swing.JTextField;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//
//
// class browser_everyProductPanel extends JPanel{
//	
//	private product mProduct= null;
//	private String  ImageStrings = "product.jpg";
//	private String productImage = null;//��ƷͼƬ
//	private JTextField price;//��Ʒ�۸�
//	private BufferedImage image =null;
//	
//	//ͨ������һ����Ʒ���󣬽��и�ֵ
//    //	public browser_everyProductPanel(product m) {
//	public browser_everyProductPanel(JButton mButton ) {
//		// TODO Auto-generated constructor stub
//		setBorder(null);
//		setOpaque(false);
//		setLayout(null);
//		if(productImage!=null) {
//			ImageStrings = productImage;
//		}
//			JButton detail = new JButton("     Details") ;
//			mButton = detail;
//			detail.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//				}
//			});
//			detail.setUI(new MyButtonUI(new Color(150,153,159,140), Color.black, Color.GRAY));
////			JButton detail = new JButton("�鿴����") {
////
////			Color mColor = Color.black;
////
////			@Override
////			protected void paintComponent(Graphics g) {
////				Graphics2D graphics2d =(Graphics2D)g;
////				
////				g.setColor(new Color(150,153,159,140));
////				g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
////				g.setColor(mColor);
////				graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
////				g.drawString("�鿴����", 40,15);
////			}
////		};
//		detail.setOpaque(false);
//		detail.setBorder(null);
//		detail.setBounds(112, 81, 121, 23);
//		add(detail);
//		
//		JTextPane pro_name = new JTextPane();
//		pro_name.setOpaque(false);
//		pro_name.setFont(new Font("����", Font.PLAIN, 14));
//		pro_name.setBorder(null);
//		pro_name.setText("PUMA/����ٷ���Ʒ2020�����¿�����������籣ů�˶���������");
//		pro_name.setBounds(92, 10, 154, 55);
//		add(pro_name);
//		
//		price = new JTextField();
//		price.setBorder(null);
//		price.setFont(new Font("����", Font.PLAIN, 12));
//		price.setOpaque(false);
//		price.setText("��416");
//		price.setBounds(102, 61, 66, 21);
//		add(price);
//		price.setColumns(10);
//	}
//
//
//	
//	@Override
//	protected void paintComponent(Graphics g) {
//		try {
//			image = ImageIO.read(getClass().getResource(ImageStrings));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    Graphics2D graphics2d = (Graphics2D)g;
//	    graphics2d.setColor(Color.white);
//	    graphics2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
//	    graphics2d.drawImage(image, 10, 10, 80, 80, null);
//	}
//
//
//
//}
//class product{
//	
//}

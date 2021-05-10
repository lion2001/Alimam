//package com.client.page;
//
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//
//import Entity.IUser;
//import Entity.User;
//import com.component.UI.contact_Left;
//import com.component.UI.contact_Right;
//import com.component.UI.contacts_beside;
//import com.component.UI.sent_button;
//
//import javax.imageio.ImageIO;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.border.LineBorder;
//
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JLabel;
//import javax.swing.JTextArea;
//
//public class contactPanel extends JPanel{
//	int y=0;
//	public contactPanel() {
//		setLayout(null);
//
//
//		//contacts是做左边放联系人的部分
//		JPanel contacts = new JPanel();
//		//CHAT是右边的部分，以CardLayout为布局，分为两页，一也是nothing，一页是chatPane；
//		JPanel CHAT = new JPanel();
//		JPanel chatPane = new ChatPane();
//
//
//		contacts.setBackground(new Color(233,231,230));
//		contacts.setBounds(0, 0, 343, 535);
//		add(contacts);
//
//		CHAT.setLayout(new CardLayout());
//		CardLayout chatCardLayout = (CardLayout)CHAT.getLayout();
//
//		//向contacts里添加联系人
//		int Contacts_y = 0;
//		JPanel Contacts = new JPanel();
//		Contacts.setBackground(new Color(233,231,230));
//		Contacts.setPreferredSize(new Dimension(320,520));
//		Contacts.setLayout(null);
//        List<User> users=new ArrayList<>();
//        for(int i=0;i<10;i++){
//            User user=new User();
//            user.setName("ahhahah"+i);
//            user.setStuId("00000"+i);
//            user.setPhoto(new File("D:\\学习资料\\query.jpg"));
//            users.add(user);
//        }
//        IUser.setIChatObject(users);
//        int size=IUser.getIChatObject().size();
//		for(int i=0;i<size;i++) {
//		    JPanel aJPanel = new contacts_beside(IUser.getIChatObject().get(i));
//			aJPanel.addMouseListener(new MouseListener() {
//
//				@Override
//				public void mouseReleased(MouseEvent e) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void mousePressed(MouseEvent e) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					// TODO Auto-generated method stub
//					//chatPane = new JPanel();
//
//					chatCardLayout.show(CHAT, "chatPane");
//				}
//			});
//			aJPanel.setBounds(0, y, 435, 100);
//			y+=100;
//			Contacts.add(aJPanel);
//		}
//		JScrollPane scrollPane_1 = new JScrollPane(Contacts);
//		if(y>520) {
//			Contacts.setPreferredSize(new Dimension(320,y));
//		}
//		scrollPane_1.validate();
//		scrollPane_1.repaint();
//		scrollPane_1.setBorder(null);
//		scrollPane_1.setPreferredSize(new Dimension(343,530));
//	//	contacts.setBackground(new Color(rgb));
//		contacts.add(scrollPane_1);
//	//	chatPane.setBounds(344, 0, 727, 535);
//		CHAT.setBounds(344, 0, 727, 535);
//		CHAT.add(chatPane,"chatPane");
//		add(CHAT);
//		JPanel nothing = new JPanel();
//		try {
//			nothing = new JPanel() {
//				BufferedImage noImage = ImageIO.read(getClass().getResource("nothing.png"));
//				@Override
//				protected void paintComponent(Graphics g) {
//					Graphics2D graphics2d=(Graphics2D)g;
//					graphics2d.drawImage(noImage, 0, 100, getWidth()-1, 300, null);
//				}
//
//			};
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		CHAT.setBackground(new Color(238,238,238));
//		nothing.setOpaque(true);
//		CHAT.add(nothing,"nothing");
//		chatCardLayout.show(CHAT, "nothing");
//	}
//
//	private void addRight() {
//		// TODO Auto-generated method stub
//
//	}
//
//	public static void main(String[] args) {
//		JFrame textFrame = new JFrame();
//		textFrame.setSize(1080,575);
//		textFrame.getContentPane().add(new contactPanel());
//		textFrame.setVisible(true);
//	}
//}
//
//
//
//class ChatPane extends JPanel{
//	JScrollPane scrollPane ;
//	JScrollBar mBar;
//	JPanel messagesJPanel;
//	int y=0;
//		public ChatPane() {
//			setOpaque(false);
//			setLayout(null);
//			JPanel text = new JPanel() {
//
//				@Override
//				protected void paintComponent(Graphics g) {
//				Graphics2D graphics2d =(Graphics2D)g;
//				BufferedImage chatBgImage = null;
//				try {
//					chatBgImage = ImageIO.read(getClass().getResource("chatBg.png"));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				graphics2d.drawImage(chatBgImage, 0, 0, getWidth()-1, getHeight()-1, null);
//				}
//
//			};
//			text.setOpaque(false);
//			text.setBounds(0, 394, 727, 141);
//			add(text);
//			text.setLayout(null);
//
//			JButton sent = new sent_button();
//			sent.setBounds(607, 108, 90, 23);
//			text.add(sent);
//
//			JTextArea textArea = new JTextArea();
//			textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
//			textArea.setOpaque(false);
//			textArea.setLineWrap(true);
//			textArea.setBounds(10, 38, 707, 62);
//			text.add(textArea);
//
//			JPanel userName = new JPanel() ;
//			userName.setBounds(0, 0, 727, 49);
//			add(userName);
//			userName.setLayout(null);
//
//			JLabel user_name = new JLabel("\u4F55\u6708\u5F53\u7A7A");
//			user_name.setBounds(0, 10, 80, 28);
//			user_name.setFont(new Font("微软雅黑", Font.BOLD, 20));
//			userName.add(user_name);
//
//			JPanel history = new JPanel();
//			history.setBackground(new Color(245,245,245));
//			history.setOpaque(false);
//			history.setBorder(null);
//			history.setBounds(0, 49, 727, 345);
//			add(history);
//
//			messagesJPanel = new JPanel() {
//
//				@Override
//				protected void paintComponent(Graphics g) {
//					Graphics2D graphics2d =(Graphics2D)g;
//					graphics2d.setColor(new Color(245,245,245));
//					graphics2d.fillRect(0, 0, getWidth(), getHeight());
//				}
//
//			};
//			messagesJPanel.setPreferredSize(new Dimension(710,350));
//			//向消息记录里添加消息
//			//使用if语句判断添加在左边还是右边
//			int count=10;
//			messagesJPanel.setLayout(null);
//			for(int i=0;i<count;i++) {
//				if(i%2==0) {
//					JPanel panel1 = new contact_Left();
//					panel1.setBounds(0, y, 720, ((contact_Left)panel1).height);
//					y = y + ((contact_Left)panel1).height;
//					messagesJPanel.add(panel1);
//				}else {
//					JPanel panel1 = new contact_Right();
//					panel1.setBounds(0, y, 720, ((contact_Right)panel1).height);
//					y = y + ((contact_Right)panel1).height;
//					messagesJPanel.add(panel1);
//				}
//			}
//			if(y>350) {
//				messagesJPanel.setPreferredSize(new Dimension(700,y+10));
//			}
//			history.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//
//		   scrollPane = new JScrollPane(messagesJPanel);
//			scrollPane.setOpaque(false);
//			messagesJPanel.setOpaque(false);
//			messagesJPanel.setBackground(new Color(245,245,245));
//			 mBar = scrollPane.getVerticalScrollBar();
//			sent.addActionListener(e->{
//				JPanel jPanel = new contact_Right();
//				jPanel.setBounds(0, y, 720,( (contact_Right)jPanel).height);
//				y = y + ((contact_Right)jPanel).height;
//				messagesJPanel.add(jPanel);
//				messagesJPanel.repaint();
//				if(y>350) {
//					messagesJPanel.setPreferredSize(new Dimension(700,y+20));
//				}
//				scrollPane.repaint();
//				scrollPane.validate();
//				mBar = scrollPane.getVerticalScrollBar();
////				System.out.println(mBar.getMaximum());
////				mBar.setValue(mBar.getMaximum());
////				System.out.println("value:"+mBar.getValue());
////				mBar.setValue(mBar.getMaximum());
////				System.out.println("value:"+mBar.getValue());
//				mBar.setValue(mBar.getMaximum());
////				System.out.println("y "+y+" mbar "+mBar.getValue()+" max "+mBar.getMaximum());
//				scrollPane.repaint();
//			});
//
//			scrollPane.setPreferredSize(new Dimension(723,345));
//			scrollPane.setBorder(null);
//
//	//妈的，不知道为什么一定要设置两次才生效？？？！！！！！
//	//设置JScrollPanel的视图在最下方
//			mBar.setValue(mBar.getMaximum());
//			mBar.setValue(mBar.getMaximum());
//		//	System.out.println("y "+y+" mbar "+mBar.getValue()+" max "+mBar.getMaximum());
//			scrollPane.repaint();
//
//			history.add(scrollPane);
//		}
//		}

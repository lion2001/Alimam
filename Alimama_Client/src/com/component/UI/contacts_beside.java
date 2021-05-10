package com.component.UI;

import Entity.User;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class contacts_beside extends JPanel{
	BufferedImage image = null;
	String nameString = null;
	Color bg_normalColor = new Color(233,231,230);
	Color bg_enterColor = new Color(220,218,217);
	Color bg_Color = bg_normalColor; 
	int height =280;
    User friend;
	public contacts_beside(User user) {
		friend =user;
		setLayout(null);
		try {
			image = ImageIO.read(user.getPhoto());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nameString = user.getName();
		JPanel panel = new JPanel() {
			BufferedImage touxiang = image;
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D graphics2d = (Graphics2D)g;
				graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				graphics2d.setStroke(new BasicStroke(8));
				graphics2d.drawImage(touxiang, 4, 4, getWidth()-9, getHeight()-9, null);
				graphics2d.setColor(new Color(245,245,245));
				graphics2d.drawRoundRect(4, 4, getWidth()-9, getHeight()-9, 20, 20);
			}
			
		};
		panel.setBounds(10, 10, 84, 80);
		add(panel);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(nameString);
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
		lblNewLabel.setBounds(104, 10, 273, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7B7E\u540D\u529F\u80FD\uFF0C\u656C\u8BF7\u671F\u5F85");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(104, 68, 249, 22);
		add(lblNewLabel_1);
		
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
				bg_Color=bg_normalColor;
				repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bg_Color = bg_enterColor;
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
	Graphics2D graphics2d =(Graphics2D)g;
	graphics2d.setColor(bg_Color);
	graphics2d.fillRect(0, 0, getWidth()-1, getHeight()-1);
//	g.setColor(Color.red);
//	g.drawRect(0, 0, 420, 100);
	}






public static void main(String[] args) {
	JFrame textFrame = new JFrame();
	textFrame.setSize(435, 280);
	textFrame.setLayout(new GridLayout(2,1));
	User user=new User();
	user.setName("ahhahah");
	user.setPhoto(new File("D:\\学习资料\\图片存放\\me.png"));
	textFrame.add(new contacts_beside(user));
	textFrame.add(new contacts_beside(user));
	textFrame.setVisible(true);
}
	
	
}

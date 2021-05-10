package com.component.UI;

import Entity.Message;
import Entity.User;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class contact_Left extends JPanel{
	public int height = 0;
	int texthight = 0;
	BufferedImage textfiled = null;
	double w =235.0;

	public contact_Left(Message message, User user) {
		setOpaque(false);
		setLayout(null);
		JPanel panel = new JPanel() {
			BufferedImage userImage = null;
			@Override
			protected void paintComponent(Graphics g) {
				try {
					userImage = ImageIO.read(user.getPhoto());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.drawImage(userImage, 3, 3, getWidth()-6-3, getHeight()-6-3, null);
				Graphics2D graphics2d = (Graphics2D)g;
				graphics2d.setStroke(new BasicStroke(4));
				graphics2d.setColor(Color.white);
				graphics2d.drawRoundRect(2, 2, getWidth()-4-3, getHeight()-4-3, 15, 15);
			}
			
		};
	//	panel.setBorder(new EmptyBorder(2,2,2,2));
		panel.setBounds(10, 10, 51, 49);
		add(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		textArea.setLineWrap(true);
		textArea.setText(message.getCon());
		textArea.setEditable(false);
		
//		textArea.setBounds(78, 29, 247, 15);
//		textArea.setBounds(x, y, width, height);
		int num = textArea.getText().length();
		int line = 1;
		if(num>=12) {
		if(num%12==0) {
			line = num/12;
		}else {
			line =num/12+1;
		}}else {
			w = w/12*num;
		}
		textArea.setBounds(78, 22, (int) w, 25*line);
		textArea.setOpaque(false);
		textArea.setBackground(new Color(0,0,0,0));
		texthight = 25*line;
		height = 25*line +35;
		add(textArea);
	}
	
	public static void main(String[] args) {
		JFrame textFrame = new JFrame();
		User user=new User();
		user.setName("ahhahah");
		user.setStuId("00000");
		user.setPhoto(new File("D:\\Ñ§Ï°×ÊÁÏ\\query.jpg"));
		Message m=new Message();
		m.setCon("ajkflajslkfa0");
		textFrame.getContentPane().add(new contact_Left(m,user));
		textFrame.setSize(500, 300);
		textFrame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		try {
			textfiled = ImageIO.read(getClass().getResource("left.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graphics2D graphics2d =(Graphics2D)g;

		graphics2d.setColor(Color.white);
		graphics2d.drawImage(textfiled, 70, 25,15, 15, null);
		graphics2d.fillRoundRect(75, 22-2, (int)w+5, texthight+10, 15, 15);
//		graphics2d.setColor(Color.red);
//		graphics2d.drawRect(0, 0, getWidth()-1, height);
	}
	
	
}

package com.client.page;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Pane_nothing extends JPanel {
	BufferedImage image = null;
	public Pane_nothing() {
		try {
			image = ImageIO.read(getClass().getResource("nothing.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.drawImage(image, 150, 150,250,200 ,null);
	}


	public static void main(String[] args) {
		JFrame textFrame = new JFrame();
		textFrame.setBounds(200, 200, 600, 575);
		textFrame.getContentPane().add(new Pane_nothing());
		textFrame.setVisible(true);
	}
}

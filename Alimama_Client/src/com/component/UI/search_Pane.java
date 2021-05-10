package com.component.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class search_Pane extends JPanel{
	private BufferedImage image = null;
	
	public search_Pane() {
		try {
			image = ImageIO.read(getClass().getResource("search.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setColor(new Color(185,197,220));
		graphics2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
		graphics2d.fillRect(0, 100, getWidth()-1, getHeight()-100);
		graphics2d.drawImage(image, 30, 10, 500, 150, null);
	}

	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintBorder(g);
	}


}

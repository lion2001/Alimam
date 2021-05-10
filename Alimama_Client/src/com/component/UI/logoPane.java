package com.component.UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class logoPane extends JPanel {
	BufferedImage img = null;
	
	public logoPane() {
		super();
		try {
			img = ImageIO.read(getClass().getResource("logo_al.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;
		  if(img != null) {
		  	  g2d.drawImage(img, 5, 50, 510, 160, null);
		  
	  }

	}

	@Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		super.paintChildren(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintBorder(g);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	
}

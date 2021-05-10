package com.component.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicPanelUI;

public class registerPanel extends JPanel{
	private 	BufferedImage image =null;
	
	public registerPanel() {
		setOpaque(false);
	try {
		image = ImageIO.read(getClass().getResource("log_3.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	protected void paintComponent(Graphics g) {
	Graphics2D graphics2d = (Graphics2D)g;
//	graphics2d.setColor(new Color(255, 255,255,100));
//	graphics2d.fillRoundRect(0, 0, 800, 600, 20, 20);
	 graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);          
	 graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);            

	graphics2d.drawImage(image, 0, 0, 600, 500, null);
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
	




}

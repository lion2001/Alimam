package com.component.UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.Text;

public class MyPane_Icon extends JPanel {
	BufferedImage img = null;
	
	public MyPane_Icon() {
		// TODO Auto-generated constructor stub
		super();
		try {
			img = ImageIO.read(getClass().getResource("gouwu.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		  Graphics2D g2d = (Graphics2D)g;
		  
		  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		  g2d.setColor(new Color(13,146,154,140));
		  g2d.fillRoundRect(4, 4,getWidth()-6, getHeight()-6, 20, 20);
		  
		  g2d.setColor(new Color(255,255,255,140));
		  g2d.fillRoundRect(4, 25, getWidth()-9, 166, 20, 20);
		  g2d.setColor(new Color(253,210,10));
		  g2d.fillRoundRect(4,4, getWidth()-9, 35, 20, 20);

		  g2d.setStroke(new BasicStroke(4));
		  g2d.setColor(new Color(23,156,202));
		  g2d.drawRoundRect(2, 2, getWidth()-5, getHeight()-5, 20, 20);
		  g2d.setColor(Color.WHITE);
		  g2d.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,17));
		  g2d.drawString("Alimama", 50, 27);
		  if(img != null) {
			  	  g2d.drawImage(img, 15, 9, 25, 25, null);
			  
		  }
		  g2d.setColor(new Color(221,221,216));
		  g2d.fillRoundRect(13, 230, 200, 298, 20, 20);
		  g2d.fillRoundRect(120-10, 195, 1088+10, 560, 20, 20);
		  g2d.setColor(new Color(238,238,238));
		  g2d.fillRoundRect(120, 200, 1078, 550, 20, 20);
	//	  g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

//			g.setColor(Color.black);
//			g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20	, 20);
	}
}

package com.component.UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class search_Button extends JButton{
		private BufferedImage image = null;
		String normal = "search_blue.png";
		String enter ="search_or.png";
		String textString = normal;
		 public search_Button() {
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
					textString = normal;
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					textString = enter;
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			try {
				image = ImageIO.read(getClass().getResource(textString));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.drawImage(image, 9, 5, 35, 35, null);
		}
		
		
		 
		 
}

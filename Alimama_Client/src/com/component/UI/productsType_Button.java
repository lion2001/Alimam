package com.component.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class productsType_Button extends JButton {
		public String text;
		private Color normalColor = Color.DARK_GRAY ;
		private Color enterColor = Color.black;
		private Color color = normalColor;
		
		public productsType_Button(String textString) {
			text = textString;
			setBorder(null);
			setFocusPainted(false);
			setOpaque(false);
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
				color = normalColor;
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				color = enterColor;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
		
			}
		});
		}

		@Override
		protected void paintComponent(Graphics g) {
			
			Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.setColor(new Color(185,197,220));
			graphics2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
			graphics2d.setColor(color);
			graphics2d.setFont(new Font("ºÚÌå", Font.PLAIN, 13));
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			graphics2d.drawString(text, 8, 18);
		}
		
		
}

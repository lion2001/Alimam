package com.component.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class sent_button extends JButton{
	Color bg_normalColor = new Color(245,245,245);
	Color bg_enterColor = new Color(18,150,17);
	Color text_normalColor = new Color(96,96,96);
	Color text_enterColor = Color.white;
	Color bgColor=bg_normalColor;
	Color textColor= text_normalColor;
	public sent_button() {
		setBorder(null);
		setFocusPainted(false);
		setOpaque(false);
		MouseListener mListener = new MouseListener() {
			
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
				bgColor = bg_normalColor;
				textColor = text_normalColor;
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bgColor = bg_enterColor;
				textColor =text_enterColor;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		addMouseListener(mListener);
	}
			

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			graphics2d.setColor(bgColor);
			graphics2d.fillRect(0, 0, getWidth(), getHeight()-1);
			graphics2d.setColor(new Color(229,229,229));
			graphics2d.drawRect(0, 0, getWidth()-1, getHeight()-1);
			graphics2d.setFont(new Font("µ»œﬂ", Font.PLAIN, 14));
			graphics2d.setColor(textColor);
			graphics2d.drawString("∑¢ÀÕ(S)", 24, 15);
			
		}
		
	}
	


package com.component.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MainPane extends JPanel{

	public  MainPane() {
		super();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setColor(new Color(180,197,210,180));
		graphics2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	}


}

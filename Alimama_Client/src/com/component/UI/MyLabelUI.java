package com.component.UI;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicLabelUI;

public class MyLabelUI extends BasicLabelUI {

	@Override
	protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		// TODO Auto-generated method stub
		super.paintEnabledText(l, g, s, textX, textY);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		// TODO Auto-generated method stub
		super.paint(g, c);
	}

	@Override
	protected void installListeners(JLabel c) {
		// TODO Auto-generated method stub
		super.installListeners(c);
	}

}

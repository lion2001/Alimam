package com.component.UI;

import Entity.IUser;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;

public class infoPane extends JPanel{
	BufferedImage img = null;
	JLabel jLabel =new JLabel("1787878");
	public infoPane(File file) {//可传入用户作为参数，以获取信息
		
		
		// TODO Auto-generated constructor stub
				super();
		//		setOpaque(false);
				try {
					img = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		JLabel lblxxxxxxxxxxx = new JLabel("\u7528\u6237\u540D\uFF1A"+ IUser.getIName());
		lblxxxxxxxxxxx.setOpaque(false);
		lblxxxxxxxxxxx.setFont(new Font("幼圆", Font.BOLD, 16));
		lblxxxxxxxxxxx.setBorder(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A"+IUser.getIid());
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 14));
		lblNewLabel.setBorder(null);
		
		JTextPane tips = new JTextPane();
		tips.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		tips.setText("\n1.文明交流，请勿XX\n2.本产品仅作为Java课设，并无实际用途\n3.WHQ很帅，但比TZY差一点");
		tips.setEditable(false);
		tips.setOpaque(false);
		tips.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(159)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblxxxxxxxxxxx)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(tips, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblxxxxxxxxxxx)
							.addGap(34)
							.addComponent(lblNewLabel))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(tips, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
					.addContainerGap())
		);

		setLayout(groupLayout);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		 Ellipse2D.Double shape = new Ellipse2D.Double(20, 10, 100, 90);
		g2d.setClip(shape);
		g2d.drawImage(img, 20, 10, 100, 90, null);
		g2d.setClip(null);
		g2d.setColor(new Color(255,255,255,140));
		g2d.setStroke(new BasicStroke(8f));
		g2d.drawOval(20, 10, 100, 90);
		g2d.setStroke(new BasicStroke(10f));
		g2d.drawOval(15, 5, 110, 100);
		g2d.setStroke(new BasicStroke(2.5f));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(310, 10, 350, 100, 10, 10);
		g2d.setStroke(new BasicStroke(6f));
		g2d.setColor(new Color(189,223,228));
		g2d.drawLine(325, 9, 388, 9);
		g2d.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		g2d.setColor(Color.black);
		g2d.drawString("用户需知：", 325, 15);
	}

//	@Override
//	protected void paintChildren(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintChildren(g);
//	}

	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
		super.paintBorder(g);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}

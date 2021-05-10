//package com.component.UI;
//
//import javax.swing.JPanel;
//import javax.swing.filechooser.FileNameExtensionFilter;
//
//import com.client.page.upPanel;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.geom.Ellipse2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//
//public class up_touxiang  extends JPanel{
//	BufferedImage touxiang_image = null;
//	public up_touxiang() {
//		setLayout(null);
//		
//		JButton choose = new JButton("choose file");
//		choose.setBounds(419, 270, 102, 23);
//		add(choose);
//		choose.setUI(new MyButtonUI(Color.white, Color.gray, Color.black));
//		choose.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser chooser = new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("Pic Allowed", "jpg","png");
//				chooser.setFileFilter(filter);
//				int value = chooser.showOpenDialog(up_touxiang.this);
//				if(value ==JFileChooser.APPROVE_OPTION ) {
//				File	imageFile = chooser.getSelectedFile();
//				try {
//					touxiang_image = ImageIO.read(imageFile);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				repaint();
//				}
//			}
//		});
//		
//		JButton up = new JButton(" upload image");
//		up.setUI(new MyButtonUI(Color.white, Color.gray, Color.black));
//		up.setBounds(406, 382, 135, 23);
//		add(up);
//		
//		JPanel panel = new JPanel() {
//
//			@Override
//			protected void paintComponent(Graphics g) {
//				Graphics2D g2d = (Graphics2D)g;
//				 Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, getWidth()-1, getHeight()-1);
//				g2d.setClip(shape);
//				g2d.setColor(new Color(230,230,230));
//				g2d.fillRect(0, 0, getWidth()-1, getHeight()-1);
//				g2d.drawImage(touxiang_image, 0, 0, getWidth()-1, getHeight()-1, null);
//			}
//			
//		};
//		panel.setBounds(383, 65, 168, 158);
//		add(panel);
//	}
//	public static void main(String[] args) {
//		JFrame textFrame = new JFrame();
//		textFrame.getContentPane().add(new up_touxiang());
//		textFrame.setSize(980,650);
//		textFrame.setVisible(true);
//	}
//}

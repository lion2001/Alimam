package com.client.page;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import Entity.IUser;
import Entity.Message;
import Entity.User;
import com.component.UI.MyButtonUI;
import com.component.UI.MyButtonUI_2;
import com.component.UI.logPanel;
import model.ClientUser;
import tools.ManageClientConServerThread;
import tools.NowChatObject;
import tools.closeThread.CloseThread;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static Entity.MessageType.message_close;
import static Entity.MessageType.message_get_all;

public class logPage extends JFrame implements ActionListener{
	int mx,my,jx,jy;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton register;
	JButton log;
	public logPage() {
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setBounds(new Rectangle(400, 200, 800, 600));
		
		JPanel contentPane = new logPanel();
		
		contentPane.setOpaque(false);
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(jx+(e.getXOnScreen()-mx),jy+(e.getYOnScreen()-my));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mx = e.getXOnScreen();
				my = e.getYOnScreen();
				jx = getX();
				jy=getY();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0,0,0,0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
		);
		
		log = new JButton(" Log");
		log.setUI(new MyButtonUI_2(new Color(252,102,0), Color.black, Color.white));
		log.setBorderPainted(false);
		log.setFocusPainted(false);
		log.addActionListener(this);
		log.setOpaque(false);
		
		
		register = new JButton("sign up");
		register.setUI(new MyButtonUI_2(new Color(252,102,0), Color.black, Color.white));
		register.setBorderPainted(false);
		register.setFocusPainted(false);
		register.addActionListener(this);
		register.setOpaque(false);
		
		
		JButton exit = new JButton("EXIT");
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setUI(new MyButtonUI_2(new Color(248,160,17),new Color(253,210,10),new Color(241,23,9)));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setOpaque(false);
		exit.setBounds(1070, 10, 68, 23);
		
		textField = new JTextField();
		textField.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 16));
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 16));
		passwordField.setOpaque(false);
		passwordField.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(280)
								.addComponent(log, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGap(61)
								.addComponent(register))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(489)
								.addComponent(exit, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(303)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(125)
					.addComponent(exit)
					.addGap(149)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(register)
						.addComponent(log))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	public static void main(String[] args) {
		logPage textLogPage = new logPage();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==log){
			User user =new User();
			user.setStuId(textField.getText());
			user.setPassword(new String(passwordField.getPassword()));
			ClientUser clientUser=new ClientUser();
			if(clientUser.checkUserLogin(user)){
				IUser.setIid(textField.getText());
				System.out.println("µ«¬Ω≥…π¶");
				MyFrame2 myFrame2=new MyFrame2();
				myFrame2.setVisible(true);
				NowChatObject.setMyFrame2(myFrame2);
				this.dispose();
				try {

					ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(user.getStuId()).getS().getOutputStream());
					Message m=new Message();
					m.setSender(IUser.getIid());
					m.setMesType(message_get_all);
					oos.writeObject(m);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(log,"’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			}
		}else if(e.getSource()==register){
			this.dispose();
			new registerPage();
		}
	}
}

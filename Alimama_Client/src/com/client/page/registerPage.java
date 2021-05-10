package com.client.page;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
import com.component.UI.registerPanel;
import model.ClientUser;
import tools.ManageClientConServerThread;
import tools.NowChatObject;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static Entity.MessageType.message_get_all;

public class registerPage extends JFrame{
	int mx,my,jx,jy;
	private JTextField ID;
	private JPasswordField password;
	private JTextField name;
	public registerPage() {
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setBounds(new Rectangle(400, 200, 800, 600));
		
		JPanel contentPane = new registerPanel();
		
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
		
		
		JButton register = new JButton("sign up");
		register.setUI(new MyButtonUI_2(new Color(252,102,0), Color.black, Color.white));
		register.setBorderPainted(false);
		register.setFocusPainted(false);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//登录
				User user=new User();
				user.setPassword(new String(password.getPassword()));
				user.setStuId(ID.getText());
				user.setName(name.getText());
				ClientUser clientUser=new ClientUser();
				if(clientUser.checkUserRegister(user)){
					IUser.setIid(ID.getText());
					System.out.println("登陆成功");
					MyFrame2 myFrame2=new MyFrame2();
					myFrame2.setVisible(true);
					NowChatObject.setMyFrame2(myFrame2);
					dispose();
					try {

						ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(user.getStuId()).getS().getOutputStream());
						Message m=new Message();
						m.setSender(IUser.getIid());
						m.setMesType(message_get_all);
						oos.writeObject(m);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}


			}
		});
		register.setOpaque(false);
		
		
		JButton exit = new JButton("EXIT");
		exit.setBorder(null);
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
		
		ID = new JTextField();
		ID.setFont(new Font("宋体", Font.PLAIN, 16));
		ID.setBorder(null);
		ID.setOpaque(false);
		ID.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setFont(new Font("宋体", Font.PLAIN, 16));
		password.setOpaque(false);
		password.setColumns(10);
		
		name = new JTextField();
		name.setOpaque(false);
		name.setFont(new Font("宋体", Font.PLAIN, 16));
		name.setBorder(null);
		name.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(489)
							.addComponent(exit, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(356)
							.addComponent(register)))
					.addContainerGap(237, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(309, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addComponent(password, 214, 214, 214))
					.addGap(277))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(323)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(411, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(125)
					.addComponent(exit)
					.addGap(107)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(password, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(register)
					.addGap(176))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	public static void main(String[] args) {
		registerPage textLogPage = new registerPage();
		
	}
}

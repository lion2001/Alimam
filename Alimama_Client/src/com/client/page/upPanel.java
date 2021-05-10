package com.client.page;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Entity.Product;
import com.component.UI.MyButtonUI;
import tools.upProduct.UpProduct;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class upPanel extends JPanel implements ActionListener {
	private BufferedImage image = null;
	private BufferedImage product_image = null;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> sort = new JComboBox();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	private JButton btnNewButton;
	private File imageFile;
	private String imagePath;
	private JComboBox comboBox;
	public upPanel() {
		setOpaque(false);
		System.out.println("upPanel");
		try {
			image = ImageIO.read(getClass().getResource("nothing.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(null);
		
		JLabel label_1 = new JLabel("��Ʒ����");
		label_1.setBounds(39, 33, 58, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("��Ʒ�۸�");
		label_2.setBounds(39, 78, 73, 15);
		add(label_2);

		JLabel label_num=new JLabel("��Ʒ����");
		label_num.setBounds(39, 120, 73, 15);
		add(label_num);

		JLabel label_3 = new JLabel("�ϴ�ͼƬ��");
		label_3.setBounds(39, 177, 73, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("��Ʒ��飺");
		label_4.setBounds(39, 336, 72, 15);
		add(label_4);
		
		sort.setBounds(693, 37, 106, 23);
		sort.addItem("������Ʒ");
		sort.addItem("ѧϰ�þ�");
		sort.addItem("ѧϰ�鼮");
		sort.addItem("��ζʳƷ");
		sort.addItem("�ճ���Ʒ");
		sort.addItem("������ױ");
		sort.addItem("������Ʒ");
		sort.setBorder(null);
		sort.setOpaque(false);
		add(sort);
		
		JLabel label_5 = new JLabel("��Ʒ����");
		label_5.setBounds(602, 40, 58, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("�Ƿ�����");
		label_6.setBounds(602, 103, 58, 15);
		add(label_6);
		
		comboBox = new JComboBox();
		comboBox.setOpaque(false);
		comboBox.setBorder(null);
		comboBox.addItem("��");
		comboBox.addItem("��");

		
		
		comboBox.setBounds(693, 99, 58, 23);
		add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setOpaque(false);
		textPane.setEditable(false);
		textPane.setFont(new Font("����", Font.PLAIN, 15));
		textPane.setText("���ҵ绰��123456789");
		textPane.setBounds(602, 177, 185, 21);
		add(textPane);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("����", Font.PLAIN, 15));
		textField.setText("�Ƿ���ʣ���");
		textField.setOpaque(false);
		textField.setBounds(602, 240, 119, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setOpaque(false);
		textField_1.setText("�ʷѣ���0.0");
		textField_1.setFont(new Font("����", Font.PLAIN, 15));
		textField_1.setBounds(602, 302, 119, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("release");
		btnNewButton.setUI(new MyButtonUI(new Color(250,140,79), Color.white, Color.black));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(746, 465, 85, 25);
		btnNewButton.addActionListener(this);
		add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBounds(91, 30, 285, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setBounds(101, 75, 66, 21);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setBounds(101, 120, 66, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("choose file");
		btnNewButton_1.setUI(new MyButtonUI(Color.white, Color.gray, Color.black));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Pic Allowed", "jpg","png");
				chooser.setFileFilter(filter);
				int value = chooser.showOpenDialog(upPanel.this);
				if(value ==JFileChooser.APPROVE_OPTION ) {
					imageFile = chooser.getSelectedFile();
					imagePath=imageFile.getPath();
				try {
					product_image = ImageIO.read(imageFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();
				}
			}
		});
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_1.setBounds(24, 202, 110, 25);
		add(btnNewButton_1);
		
		JPanel panel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D graphics2d =(Graphics2D)g;
				if(product_image != null) {
					graphics2d.drawImage(product_image, 0, 0, getWidth()-1, getHeight()-1, null);
				}
			}
		};
		panel.setBorder(BorderFactory.createRaisedSoftBevelBorder()); 
		
		panel.setBounds(151, 177, 133, 146);
		add(panel);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 16));
		textArea.setOpaque(false);
		textArea.setBounds(39, 363, 337, 109);
		add(textArea);
	}
	
	public static void main(String[] args) {
		JFrame teFrame =new JFrame();
		teFrame.getContentPane().add(new upPanel());
		teFrame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d =(Graphics2D)g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.drawImage(image, 200, 0, getWidth()-200, getHeight(), null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnNewButton){
			System.out.println("�ϴ�");
			Product product=new Product();
			product.setName(textField_2.getText());
			product.setPrice(Double.parseDouble(textField_3.getText()));
			product.setIntroduce(textArea.getText());
			product.setImage(imageFile);
			product.setSort(sort.getSelectedIndex());
			product.setImagePath(imagePath);
			product.setNumber(Integer.parseInt(textField_4.getText()));
			product.setIsAuction(comboBox.getSelectedIndex());
			Thread upProduct=new UpProduct(product);
			upProduct.start();
		}
	}


}

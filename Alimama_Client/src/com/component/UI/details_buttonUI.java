package com.component.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;

public class details_buttonUI extends BasicButtonUI{
    private static Rectangle viewRect = new Rectangle();
    private static Rectangle textRect = new Rectangle();
    private static Rectangle iconRect = new Rectangle();
	private String textString;
	private String normal;
	private String enter;
	private String shoucang = "shoucang_yellow.png";
	private int check;
	private Color normalColor = new Color(28,157,221);
	private Color enterColor = new Color(0,3,4);
	private Color textColor = normalColor;
	BufferedImage img = null;
	public details_buttonUI() {}
	
	public details_buttonUI(	String normalIcon,String enterICon ) {
		normal = normalIcon;
		enter = enterICon;
		check = 0;
		try {
			img = ImageIO.read(getClass().getResource(normalIcon));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public details_buttonUI(String normalIcon ,String enterICon,int check) {
		normal = normalIcon;
		enter = enterICon;
		this.check = check;

		try {
			if(check == 1) {
			img = ImageIO.read(getClass().getResource(shoucang));}
			else			img = ImageIO.read(getClass().getResource(normalIcon));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void installListeners(AbstractButton b) {
		BasicButtonListener listener = createButtonListener(b);
		MouseListener mLister = new MouseListener() {
			
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
				try {
					textColor = normalColor;
					if(check != 1) {
					img = ImageIO.read(getClass().getResource(normal));}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					textColor = enterColor;
					if(check!=1) {
					img = ImageIO.read(getClass().getResource(enter));}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(check == 1) {
					try {
						img = ImageIO.read(getClass().getResource(shoucang));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		};
		if(listener != null) {
			
			b.addMouseListener(listener);
			b.addMouseListener(mLister);
//             b.addMouseMotionListener(listener);
			//            b.addFocusListener(listener);
			//           b.addPropertyChangeListener(listener);
			//           b.addChangeListener(listener);
		}
	}
	
    
    @Override
	public void paint(Graphics g, JComponent c) {
		 AbstractButton b = (AbstractButton) c;
		   String text =( (JButton)c).getText();
	        ButtonModel model = b.getModel();
	        Graphics2D g2d = (Graphics2D)g;
	        g2d.setColor(new Color(146,131,131,60));
	        g2d.fillRoundRect(5, 0, c.getWidth()-6, c.getHeight()-1, 10, 10);
	        if(img != null) {
			  	  g2d.drawImage(img, 14,4, 20, 20, null);
			  
		  }
	        clearTextShiftOffset();

	        // perform UI specific press action, e.g. Windows L&F shifts text
	        if (model.isArmed() && model.isPressed()) {
	            paintButtonPressed(g,b);
	        }

	        // Paint the Icon
	        if(b.getIcon() != null) {
	            paintIcon(g,c,iconRect);
	        }
	        if (text != null && !text.isEmpty()){
	            View v = (View) c.getClientProperty(BasicHTML.propertyKey);
	            if (v != null) {
	                v.paint(g, textRect);
	            } else {
	                paintText(g, b, textRect, text);
	            }
	        }


	 
	}

	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		// TODO Auto-generated method stub
		super.paintButtonPressed(g, b);
	}

	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
		// TODO Auto-generated method stub
		super.paintIcon(g, c, iconRect);
	}

	@Override
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
		 AbstractButton b = (AbstractButton) c;
	        ButtonModel model = b.getModel();
	    //    FontMetrics fm = Font.getFontMetrics(c, g);
	        int mnemonicIndex = b.getDisplayedMnemonicIndex();

	        /* Draw the Text */
	        Graphics2D g2d = (Graphics2D)g;
	        if(model.isEnabled()) {
	            /*** paint the text normally */
	        	//new Color(253,210,10)
	      	    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	            g2d.setColor(textColor);
	            g2d.setFont(new Font("свт╡", Font.PLAIN, 13));
	          g2d.drawString(text, 36, 18);
	        }
	        else {
	            /*** paint the text disabled ***/
	            g2d.setColor(b.getBackground().brighter());
	            g2d.setFont(new Font("свт╡", Font.BOLD, 13));
	            g2d.drawString(text, 36, 18);
	        }
	}
	
	
}

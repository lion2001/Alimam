package com.component.UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;






public class leftButtonUI extends BasicButtonUI{
    private static Rectangle viewRect = new Rectangle();
    private static Rectangle textRect = new Rectangle();
    private static Rectangle iconRect = new Rectangle();
    private Color roundColor,textColor,changeColor,normalColor;
    
    public leftButtonUI() {}
    

	public leftButtonUI(Color round,Color text) {
		roundColor = round;
		textColor =text;
		normalColor = text;
    }
	
	public leftButtonUI(Color round,Color text,Color change) 
	{
		roundColor = round;
		textColor =text;
		changeColor = change ;
		normalColor = text;
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
				textColor = normalColor;
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				textColor = changeColor;
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
	        ButtonModel model = b.getModel();

	        String text =( (JButton)c).getText();
	        Graphics2D g2d = (Graphics2D)g;
	        //new Color(23,156,202)
	        g2d.setColor(roundColor);
	        g2d.fillRoundRect(2, 2, c.getWidth()-3, c.getHeight()-3, 20, 20);
	        g2d.setColor(new Color(20,155,223));
	        g2d.setStroke(new BasicStroke(2));
	        g2d.drawRoundRect(1, 1, c.getWidth()-2, c.getHeight()-2, 20, 20);
	        g2d.setStroke(new BasicStroke(2));
	        g2d.drawRoundRect(6, 5, c.getWidth()-12, c.getHeight()-10, 15, 15);
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

	        if (b.isFocusPainted() && b.hasFocus()) {
	            // paint UI specific focus
	          paintFocus(g,b,viewRect,textRect,iconRect);
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
	            g2d.setColor(textColor);
	            g2d.setFont(new Font("????", Font.BOLD, 15));
	          g2d.drawString(text, 20, 22);
	        }
	        else {
	            /*** paint the text disabled ***/
	            g2d.setColor(b.getBackground().brighter());
	            g2d.setFont(new Font("????", Font.BOLD, 15));
	            g2d.drawString(text, 20, 22);
	        }
	}

}

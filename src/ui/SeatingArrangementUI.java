package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeatingArrangementUI extends JPanel 
{
	/*
	 * This is where the reservation of
	 * movie tickets and seat will take
	 * place.
	 */

    private int rows = 5;
    private int columns = 8;
    private Icon res = (UIManager.getIcon("OptionPane.errorIcon"));
    private SystemUI systemUI;
    private JPanel centerP;
    private JLabel titleL;
    private JButton logoutB;
    private JToggleButton a1B, a2B, a3B, a4B, a5B, a6B, a7B, a8B, a9B, a10B,
    						b1B, b2B, b3B, b4B, b5B, b6B, b7B, b8B, b9B, b10B,
    						c1B, c2B, c3B, c4B, c5B, c6B, c7B, c8B, c9B, c10B,
    						d1B, d2B, d3B, d4B, d5B, d6B, d7B, d8B, d9B, d10B;
    
    public SeatingArrangementUI(SystemUI systemUI) 
    {
    	setLayout(new GridLayout(1, 1));
    	
    	this.systemUI = systemUI;
    	
    	logoutB = new JButton("Sign out");
    	
        a1B = new JToggleButton("A1");
        a2B = new JToggleButton("A2");
        a3B = new JToggleButton("A3");
        a4B = new JToggleButton("A4");
        a5B = new JToggleButton("A5");
        a6B = new JToggleButton("A6");
        a7B = new JToggleButton("A7");
        a8B = new JToggleButton("A8");
        a9B = new JToggleButton("A9");
        a10B = new JToggleButton("A10");
        
        b1B = new JToggleButton("B1");
        b2B = new JToggleButton("B2");
        b3B = new JToggleButton("B3");
        b4B = new JToggleButton("B4");
        b5B = new JToggleButton("B5");
        b6B = new JToggleButton("B6");
        b7B = new JToggleButton("B7");
        b8B = new JToggleButton("B8");
        b9B = new JToggleButton("B9");
        b10B = new JToggleButton("B10");
        
        c1B = new JToggleButton("C1");
        c2B = new JToggleButton("C2");
        c3B = new JToggleButton("C3");
        c4B = new JToggleButton("C4");
        c5B = new JToggleButton("C5");
        c6B = new JToggleButton("C6");
        c7B = new JToggleButton("C7");
        c8B = new JToggleButton("C8");
        c9B = new JToggleButton("C9");
        c10B = new JToggleButton("C10");
        
        d1B = new JToggleButton("D1");
        d2B = new JToggleButton("D2");
        d3B = new JToggleButton("D3");
        d4B = new JToggleButton("D4");
        d5B = new JToggleButton("D5");
        d6B = new JToggleButton("D6");
        d7B = new JToggleButton("D7");
        d8B = new JToggleButton("D8");
        d9B = new JToggleButton("D9");
        d10B = new JToggleButton("D10");
        
        logoutB.setBounds(725, 320, 120, 25);
        
        a1B.setBounds(30,120,70,25);
        a2B.setBounds(110,120,70,25);
        a3B.setBounds(190,120,70,25);
        a4B.setBounds(290,120,70,25);
        a5B.setBounds(370,120,70,25);
        a6B.setBounds(450,120,70,25);
        a7B.setBounds(530,120,70,25);
        a8B.setBounds(630,120,70,25);
        a9B.setBounds(710,120,70,25);
        a10B.setBounds(790,120,70,25);
        
        b1B.setBounds(30,170,70,25);
        b2B.setBounds(110,170,70,25);
        b3B.setBounds(190,170,70,25);
        b4B.setBounds(290,170,70,25);
        b5B.setBounds(370,170,70,25);
        b6B.setBounds(450,170,70,25);
        b7B.setBounds(530,170,70,25);
        b8B.setBounds(630,170,70,25);
        b9B.setBounds(710,170,70,25);
        b10B.setBounds(790,170,70,25);
        
        c1B.setBounds(30,220,70,25);
        c2B.setBounds(110,220,70,25);
        c3B.setBounds(190,220,70,25);
        c4B.setBounds(290,220,70,25);
        c5B.setBounds(370,220,70,25);
        c6B.setBounds(450,220,70,25);
        c7B.setBounds(530,220,70,25);
        c8B.setBounds(630,220,70,25);
        c9B.setBounds(710,220,70,25);
        c10B.setBounds(790,220,70,25);
        
        d1B.setBounds(30,270,70,25);
        d2B.setBounds(110,270,70,25);
        d3B.setBounds(190,270,70,25);
        d4B.setBounds(290,270,70,25);
        d5B.setBounds(370,270,70,25);
        d6B.setBounds(450,270,70,25);
        d7B.setBounds(530,270,70,25);
        d8B.setBounds(630,270,70,25);
        d9B.setBounds(710,270,70,25);
        d10B.setBounds(790,270,70,25);
        
    	titleL = new JLabel("Screen");
    	titleL.setOpaque(true);
    	titleL.setBackground(Color.BLUE);
    	titleL.setForeground(Color.WHITE);
    	titleL.setHorizontalAlignment(SwingConstants.CENTER);
    	titleL.setFont(new Font("Tahoma", Font.PLAIN, 26));
        titleL.setBounds(95, 5, 700, 32);
        
        centerP = new JPanel();
		centerP.setLayout(null);
        
		centerP.add(titleL);
		centerP.add(logoutB);
		
        centerP.add(a1B);
        centerP.add(a2B);
        centerP.add(a3B);
        centerP.add(a4B);
        centerP.add(a5B);
        centerP.add(a6B);
        centerP.add(a7B);
        centerP.add(a8B);
        centerP.add(a9B);
        centerP.add(a10B);
        
        centerP.add(b1B);
        centerP.add(b2B);
        centerP.add(b3B);
        centerP.add(b4B);
        centerP.add(b5B);
        centerP.add(b6B);
        centerP.add(b7B);
        centerP.add(b8B);
        centerP.add(b9B);
        centerP.add(b10B);
        
        centerP.add(c1B);
        centerP.add(c2B);
        centerP.add(c3B);
        centerP.add(c4B);
        centerP.add(c5B);
        centerP.add(c6B);
        centerP.add(c7B);
        centerP.add(c8B);
        centerP.add(c9B);
        centerP.add(c10B);
        
        centerP.add(d1B);
        centerP.add(d2B);
        centerP.add(d3B);
        centerP.add(d4B);
        centerP.add(d5B);
        centerP.add(d6B);
        centerP.add(d7B);
        centerP.add(d8B);
        centerP.add(d9B);
        centerP.add(d10B);
        
        /*
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                final JToggleButton button = new JToggleButton("Row " + row + " seat " + column);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                        boolean selected = abstractButton.getModel().isSelected();
                        if (selected) {
                            button.setIcon(res);
                        } else {
                            button.setIcon(null);
                        }
                    }
                });
                centerP.add(button);
            }
        }
        */
        
        validate();
        add(centerP);
    }
}
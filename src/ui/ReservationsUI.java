package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import domain.Reservations;

public class ReservationsUI extends JPanel 
{
	/*
	 * This is where the reservation of
	 * movie tickets and seat will take
	 * place.
	 */
	
	private static final long serialVersionUID = 1L;

    private SystemUI systemUI;
    private JPanel centerP;
    private JLabel screenL, movieL, timeL;
    private JButton cancelB, confirmB;
    private JToggleButton a1B, a2B, a3B, a4B, a5B, a6B, a7B, a8B, a9B, a10B,
    						b1B, b2B, b3B, b4B, b5B, b6B, b7B, b8B, b9B, b10B,
    						c1B, c2B, c3B, c4B, c5B, c6B, c7B, c8B, c9B, c10B,
    						d1B, d2B, d3B, d4B, d5B, d6B, d7B, d8B, d9B, d10B;
    private ImageIcon green, red;
    
    private ReservationsHandler reservationsHandler;
    
    private List<String> seatList;
    private String movieId, time;
    
    public ReservationsUI(SystemUI systemUI) 
    {
    	setLayout(new GridLayout(1, 1));
    	
    	this.systemUI = systemUI;
    	reservationsHandler = new ReservationsHandler();
    	green = new ImageIcon("../Movie Seating/lib/images/green.png");
    	red = new ImageIcon("../Movie Seating/lib/images/red.png");
    	
        centerP = new JPanel();
		centerP.setLayout(null);
    	    	
        a1B = new JToggleButton("A1");
        initializeToggleButtons(a1B);
        a2B = new JToggleButton("A2");
        initializeToggleButtons(a2B);
        a3B = new JToggleButton("A3");
        initializeToggleButtons(a3B);
        a4B = new JToggleButton("A4");
        initializeToggleButtons(a4B);
        a5B = new JToggleButton("A5");
        initializeToggleButtons(a5B);
        a6B = new JToggleButton("A6");
        initializeToggleButtons(a6B);
        a7B = new JToggleButton("A7");
        initializeToggleButtons(a7B);
        a8B = new JToggleButton("A8");
        initializeToggleButtons(a8B);
        a9B = new JToggleButton("A9");
        initializeToggleButtons(a9B);
        a10B = new JToggleButton("A10");
        initializeToggleButtons(a10B);
        
        b1B = new JToggleButton("B1");
        initializeToggleButtons(b1B);
        b2B = new JToggleButton("B2");
        initializeToggleButtons(b2B);
        b3B = new JToggleButton("B3");
        initializeToggleButtons(b3B);
        b4B = new JToggleButton("B4");
        initializeToggleButtons(b4B);
        b5B = new JToggleButton("B5");
        initializeToggleButtons(b5B);
        b6B = new JToggleButton("B6");
        initializeToggleButtons(b6B);
        b7B = new JToggleButton("B7");
        initializeToggleButtons(b7B);
        b8B = new JToggleButton("B8");
        initializeToggleButtons(b8B);
        b9B = new JToggleButton("B9");
        initializeToggleButtons(b9B);
        b10B = new JToggleButton("B10");
        initializeToggleButtons(b10B);
        
        c1B = new JToggleButton("C1");
        initializeToggleButtons(c1B);
        c2B = new JToggleButton("C2");
        initializeToggleButtons(c2B);
        c3B = new JToggleButton("C3");
        initializeToggleButtons(c3B);
        c4B = new JToggleButton("C4");
        initializeToggleButtons(c4B);
        c5B = new JToggleButton("C5");
        initializeToggleButtons(c5B);
        c6B = new JToggleButton("C6");
        initializeToggleButtons(c6B);
        c7B = new JToggleButton("C7");
        initializeToggleButtons(c7B);
        c8B = new JToggleButton("C8");
        initializeToggleButtons(c8B);
        c9B = new JToggleButton("C9");
        initializeToggleButtons(c9B);
        c10B = new JToggleButton("C10");
        initializeToggleButtons(c10B);
        
        d1B = new JToggleButton("D1");
        initializeToggleButtons(d1B);
        d2B = new JToggleButton("D2");
        initializeToggleButtons(d2B);
        d3B = new JToggleButton("D3");
        initializeToggleButtons(d3B);
        d4B = new JToggleButton("D4");
        initializeToggleButtons(d4B);
        d5B = new JToggleButton("D5");
        initializeToggleButtons(d5B);
        d6B = new JToggleButton("D6");
        initializeToggleButtons(d6B);
        d7B = new JToggleButton("D7");
        initializeToggleButtons(d7B);
        d8B = new JToggleButton("D8");
        initializeToggleButtons(d8B);
        d9B = new JToggleButton("D9");
        initializeToggleButtons(d9B);
        d10B = new JToggleButton("D10");
        initializeToggleButtons(d10B);
        
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
        
    	screenL = new JLabel("Screen");
    	screenL.setOpaque(true);
    	screenL.setBackground(Color.BLUE);
    	screenL.setForeground(Color.WHITE);
    	screenL.setHorizontalAlignment(SwingConstants.CENTER);
    	screenL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        screenL.setBounds(95, 5, 700, 20);
        
        movieL = new JLabel();
        movieL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        movieL.setBounds(30, 36, 830, 20);
        centerP.add(movieL);
        
        timeL = new JLabel();
        timeL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        timeL.setBounds(30, 67, 330, 20);
        centerP.add(timeL);
        
		centerP.add(screenL);
		
    	cancelB = new JButton("Cancel");
    	cancelB.setBounds(510, 335, 120, 25);
		cancelB.addActionListener(reservationsHandler);

		confirmB = new JButton("Confirm");
		confirmB.setBounds(260, 335, 120, 25);
		confirmB.addActionListener(reservationsHandler);
		
		centerP.add(confirmB);
		centerP.add(cancelB);
		
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

        validate();
        add(centerP);
    }
    
    private class ReservationsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("Confirm"))
			{
				checkChanges();
				
				if(systemUI.isAdmin())
				{
					systemUI.getReservationsDAO().addReservations(
							null, movieId, time, seatList);
					systemUI.showAdminMenu();
				}
				else
				{
					systemUI.getReservationsDAO().addReservations(
							systemUI.getLoginCustomer().getCustomerId(), movieId, time, seatList);
					systemUI.showCustomerMenu();
				}
				
			}
			else
				systemUI.showMovieSelection();
		}
	}
    
    public void setupUI(String movieId, String movieTitle, String time)
    {
    	this.movieId = movieId;
    	this.time = time;
    	confirmB.setEnabled(false);
    	
    	seatList = new ArrayList<String>();
    	
    	movieL.setText("Movie Title: " + movieTitle);
    	timeL.setText("Time: " + time);
    	
    	resetToggleButtons();
    	checkListToggle();
	}

    private void checkListToggle()
    {
    	for(Reservations reservations: systemUI.getReservationsDAO().getReservationsList())
    	{
    		if(reservations.getSeatNo().equals("A1"))
    			setSeatTaken(a1B);
    		else if(reservations.getSeatNo().equals("A2"))
    			setSeatTaken(a2B);
    		else if(reservations.getSeatNo().equals("A3"))
    			setSeatTaken(a3B);
    		else if(reservations.getSeatNo().equals("A4"))
    			setSeatTaken(a4B);
    		else if(reservations.getSeatNo().equals("A5"))
    			setSeatTaken(a5B);
    		else if(reservations.getSeatNo().equals("A6"))
    			setSeatTaken(a6B);
    		else if(reservations.getSeatNo().equals("A7"))
    			setSeatTaken(a7B);
    		else if(reservations.getSeatNo().equals("A8"))
    			setSeatTaken(a8B);
    		else if(reservations.getSeatNo().equals("A9"))
    			setSeatTaken(a9B);
    		else if(reservations.getSeatNo().equals("A10"))
    			setSeatTaken(a10B);
    		
    		else if(reservations.getSeatNo().equals("B1"))
    			setSeatTaken(b1B);
    		else if(reservations.getSeatNo().equals("B2"))
    			setSeatTaken(b2B);
    		else if(reservations.getSeatNo().equals("B3"))
    			setSeatTaken(b3B);
    		else if(reservations.getSeatNo().equals("B4"))
    			setSeatTaken(b4B);
    		else if(reservations.getSeatNo().equals("B5"))
    			setSeatTaken(b5B);
    		else if(reservations.getSeatNo().equals("B6"))
    			setSeatTaken(b6B);
    		else if(reservations.getSeatNo().equals("B7"))
    			setSeatTaken(b7B);
    		else if(reservations.getSeatNo().equals("B8"))
    			setSeatTaken(b8B);
    		else if(reservations.getSeatNo().equals("B9"))
    			setSeatTaken(b9B);
    		else if(reservations.getSeatNo().equals("B10"))
    			setSeatTaken(b10B);
    		
    		else if(reservations.getSeatNo().equals("C1"))
    			setSeatTaken(c1B);
    		else if(reservations.getSeatNo().equals("C2"))
    			setSeatTaken(c2B);
    		else if(reservations.getSeatNo().equals("C3"))
    			setSeatTaken(c3B);
    		else if(reservations.getSeatNo().equals("C4"))
    			setSeatTaken(c4B);
    		else if(reservations.getSeatNo().equals("C5"))
    			setSeatTaken(c5B);
    		else if(reservations.getSeatNo().equals("C6"))
    			setSeatTaken(c6B);
    		else if(reservations.getSeatNo().equals("C7"))
    			setSeatTaken(c7B);
    		else if(reservations.getSeatNo().equals("C8"))
    			setSeatTaken(c8B);
    		else if(reservations.getSeatNo().equals("C9"))
    			setSeatTaken(c9B);
    		else if(reservations.getSeatNo().equals("C10"))
    			setSeatTaken(c10B);
    		
    		else if(reservations.getSeatNo().equals("D1"))
    			setSeatTaken(d1B);
    		else if(reservations.getSeatNo().equals("D2"))
    			setSeatTaken(d2B);
    		else if(reservations.getSeatNo().equals("D3"))
    			setSeatTaken(d3B);
    		else if(reservations.getSeatNo().equals("D4"))
    			setSeatTaken(d4B);
    		else if(reservations.getSeatNo().equals("D5"))
    			setSeatTaken(d5B);
    		else if(reservations.getSeatNo().equals("D6"))
    			setSeatTaken(d6B);
    		else if(reservations.getSeatNo().equals("D7"))
    			setSeatTaken(d7B);
    		else if(reservations.getSeatNo().equals("D8"))
    			setSeatTaken(d8B);
    		else if(reservations.getSeatNo().equals("D9"))
    			setSeatTaken(d9B);
    		else if(reservations.getSeatNo().equals("D10"))
    			setSeatTaken(d10B);
    		
    	}
    }
    
    private void resetToggleButtons()
    {
    	resetToggleButtons(a1B);
    	resetToggleButtons(a2B);
    	resetToggleButtons(a3B);
    	resetToggleButtons(a4B);
    	resetToggleButtons(a5B);
    	resetToggleButtons(a6B);
    	resetToggleButtons(a7B);
    	resetToggleButtons(a8B);
    	resetToggleButtons(a9B);
    	resetToggleButtons(a10B);
    	
    	resetToggleButtons(b1B);
    	resetToggleButtons(b2B);
    	resetToggleButtons(b3B);
    	resetToggleButtons(b4B);
    	resetToggleButtons(b5B);
    	resetToggleButtons(b6B);
    	resetToggleButtons(b7B);
    	resetToggleButtons(b8B);
    	resetToggleButtons(b9B);
    	resetToggleButtons(b10B);
    	
    	resetToggleButtons(c1B);
    	resetToggleButtons(c2B);
    	resetToggleButtons(c3B);
    	resetToggleButtons(c4B);
    	resetToggleButtons(c5B);
    	resetToggleButtons(c6B);
    	resetToggleButtons(c7B);
    	resetToggleButtons(c8B);
    	resetToggleButtons(c9B);
    	resetToggleButtons(c10B);
    	
    	resetToggleButtons(d1B);
    	resetToggleButtons(d2B);
    	resetToggleButtons(d3B);
    	resetToggleButtons(d4B);
    	resetToggleButtons(d5B);
    	resetToggleButtons(d6B);
    	resetToggleButtons(d7B);
    	resetToggleButtons(d8B);
    	resetToggleButtons(d9B);
    	resetToggleButtons(d10B);
    	
    	resetTextColor(a1B);
    	resetTextColor(a2B);
    	resetTextColor(a3B);
    	resetTextColor(a4B);
    	resetTextColor(a5B);
    	resetTextColor(a6B);
    	resetTextColor(a7B);
    	resetTextColor(a8B);
    	resetTextColor(a9B);
    	resetTextColor(a10B);
    	
    	resetTextColor(b1B);
    	resetTextColor(b2B);
    	resetTextColor(b3B);
    	resetTextColor(b4B);
    	resetTextColor(b5B);
    	resetTextColor(b6B);
    	resetTextColor(b7B);
    	resetTextColor(b8B);
    	resetTextColor(b9B);
    	resetTextColor(b10B);
    	
    	resetTextColor(c1B);
    	resetTextColor(c2B);
    	resetTextColor(c3B);
    	resetTextColor(c4B);
    	resetTextColor(c5B);
    	resetTextColor(c6B);
    	resetTextColor(c7B);
    	resetTextColor(c8B);
    	resetTextColor(c9B);
    	resetTextColor(c10B);
    	
    	resetTextColor(d1B);
    	resetTextColor(d2B);
    	resetTextColor(d3B);
    	resetTextColor(d4B);
    	resetTextColor(d5B);
    	resetTextColor(d6B);
    	resetTextColor(d7B);
    	resetTextColor(d8B);
    	resetTextColor(d9B);
    	resetTextColor(d10B);
    }
    
    private void resetTextColor(JToggleButton tb)
    {
    	tb.setForeground(Color.BLACK);
    }
    
    private void checkChanges()
    {
    	if(a1B.isSelected() && a1B.isEnabled())
    		seatList.add("A1");
    	if(a2B.isSelected() && a2B.isEnabled())
    		seatList.add("A2");
    	if(a3B.isSelected() && a3B.isEnabled())
    		seatList.add("A3");
    	if(a4B.isSelected() && a4B.isEnabled())
    		seatList.add("A4");
    	if(a5B.isSelected() && a5B.isEnabled())
    		seatList.add("A5");
    	if(a6B.isSelected() && a6B.isEnabled())
    		seatList.add("A6");
    	if(a7B.isSelected() && a7B.isEnabled())
    		seatList.add("A7");
    	if(a8B.isSelected() && a8B.isEnabled())
    		seatList.add("A8");
    	if(a9B.isSelected() && a9B.isEnabled())
    		seatList.add("A9");
    	if(a10B.isSelected() && a10B.isEnabled())
    		seatList.add("A10");
    	
    	if(b1B.isSelected() && b1B.isEnabled())
    		seatList.add("B1");
    	if(b2B.isSelected() && b2B.isEnabled())
    		seatList.add("B2");
    	if(b3B.isSelected() && b3B.isEnabled())
    		seatList.add("B3");
    	if(b4B.isSelected() && b4B.isEnabled())
    		seatList.add("B4");
    	if(b5B.isSelected() && b5B.isEnabled())
    		seatList.add("B5");
    	if(b6B.isSelected() && b6B.isEnabled())
    		seatList.add("B6");
    	if(b7B.isSelected() && b7B.isEnabled())
    		seatList.add("B7");
    	if(b8B.isSelected() && b8B.isEnabled())
    		seatList.add("B8");
    	if(b9B.isSelected() && b9B.isEnabled())
    		seatList.add("B9");
    	if(b10B.isSelected() &&b10B.isEnabled())
    		seatList.add("B10");
    	
    	if(c1B.isSelected() && c1B.isEnabled())
    		seatList.add("C1");
    	if(c2B.isSelected() && c2B.isEnabled())
    		seatList.add("C2");
    	if(c3B.isSelected() && c3B.isEnabled())
    		seatList.add("C3");
    	if(c4B.isSelected() && c4B.isEnabled())
    		seatList.add("C4");
    	if(c5B.isSelected() && c5B.isEnabled())
    		seatList.add("C5");
    	if(c6B.isSelected() && c6B.isEnabled())
    		seatList.add("C6");
    	if(c7B.isSelected() && c7B.isEnabled())
    		seatList.add("C7");
    	if(c8B.isSelected() && c8B.isEnabled())
    		seatList.add("C8");
    	if(c9B.isSelected() && c9B.isEnabled())
    		seatList.add("C9");
    	if(c10B.isSelected() && c10B.isEnabled())
    		seatList.add("C10");
    	
    	if(d1B.isSelected() && d1B.isEnabled())
    		seatList.add("D1");
    	if(d2B.isSelected() && d2B.isEnabled())
    		seatList.add("D2");
    	if(d3B.isSelected() && d3B.isEnabled())
    		seatList.add("D3");
    	if(d4B.isSelected() && d4B.isEnabled())
    		seatList.add("D4");
    	if(d5B.isSelected() && d5B.isEnabled())
    		seatList.add("D5");
    	if(d6B.isSelected() && d6B.isEnabled())
    		seatList.add("D6");
    	if(d7B.isSelected() && d7B.isEnabled())
    		seatList.add("D7");
    	if(d8B.isSelected() && d8B.isEnabled())
    		seatList.add("D8");
    	if(d9B.isSelected() && d9B.isEnabled())
    		seatList.add("D9");
    	if(d10B.isSelected() && d10B.isEnabled())
    		seatList.add("D10");
    }
    
    private void setSeatTaken(JToggleButton tb)
    {
    	tb.setEnabled(false);
    	tb.setSelected(true);
    	tb.setIcon(red);
    }
    
    
    private void resetToggleButtons(JToggleButton tb)
    {
    	tb.setEnabled(true);
    	tb.setSelected(false);
    	tb.setIcon(green);
    }
    
    private void initializeToggleButtons(JToggleButton tb)
    {
    	tb.setOpaque(true);
    	tb.setIcon(green);
    	tb.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		confirmB.setEnabled(true);
        		JToggleButton button = (JToggleButton) e.getSource();
                boolean selected = button.isSelected();
                if(selected) 
                {
                	tb.setIcon(red);
                	tb.setForeground(Color.WHITE);
                }
                else 
                {
                	tb.setIcon(green);
                	tb.setForeground(Color.BLACK);
                }
        	}
        });
    	tb.setDisabledSelectedIcon(red);
    	tb.setHorizontalTextPosition(JButton.CENTER);
    	tb.setVerticalTextPosition(JButton.CENTER);
    }

}
package ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import ui.LoginUI.LoginHandler;

public class CustomerMenuUI extends JPanel
{
	/*
	 * This UI will contain Customner Menu
	 * that includes Profile Viewing/Management
	 * and Reservation of Movies.
	 * 
	 * 450 x 300
	 */
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JLabel bgL;
	private JButton profileB, reserveB, signoutB;
	private SystemUI systemUI;
	private MenuHandler menuHandler;
	
	public CustomerMenuUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		menuHandler = new MenuHandler();
		
		this.systemUI = systemUI;
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon("../Movie Seating/lib/images/bg2.jpg"));

		centerP = new JPanel();
		centerP.setLayout(null);
		
		profileB = new JButton("View Profile");
		profileB.setActionCommand("View");
		profileB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileB.setForeground(Color.BLUE);
		profileB.setOpaque(false);
		profileB.setContentAreaFilled(false);
		profileB.addActionListener(menuHandler);
		profileB.setBounds(60, 15, 180, 30);

		centerP.add(profileB);
		
		reserveB = new JButton("Reserve a Movie Ticket");
		reserveB.setActionCommand("Reserve");
		reserveB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reserveB.setOpaque(false);
		reserveB.setForeground(Color.BLUE);
		reserveB.setContentAreaFilled(false);
		reserveB.setBounds(60, 56, 180, 30);
		reserveB.addActionListener(menuHandler);
		centerP.add(reserveB);
		
		signoutB = new JButton("Sign Out");
		signoutB.setOpaque(false);
		signoutB.setForeground(Color.BLUE);
		signoutB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signoutB.setContentAreaFilled(false);
		signoutB.setBounds(112, 97, 75, 25);
		signoutB.addActionListener(menuHandler);
		centerP.add(signoutB);

		bgL.setBounds(0,-80,500,500);

		centerP.add(bgL);
		
		validate();
		
		add(centerP);
	}
	
	private class MenuHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("View"))
				systemUI.showProfileManagement();
			else if(action.equals("Reserve"))
				systemUI.showMovieSelection();
			else
				systemUI.showLogin();
		}
	}
}

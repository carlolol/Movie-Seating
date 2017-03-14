package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminMenuUI extends JPanel
{
	/*
	 * Contains Menus for an Admin like
	 * Management of Movies and their 
	 * Movie Times, Editting Users,
	 * Reserve Movies for non-users,
	 * and View Analysis of Move Goers.
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JLabel bgL;
	private JButton moviesB, signoutB, reserveB, analysisB;
	private SystemUI systemUI;
	private MenuHandler menuHandler;
	
	public AdminMenuUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		menuHandler = new MenuHandler();
		
		this.systemUI = systemUI;
		
		centerP = new JPanel();
		centerP.setLayout(null);
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));
		
		moviesB = new JButton("Manage Movies");
		moviesB.setActionCommand("Movie");
		moviesB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moviesB.setForeground(Color.BLUE);
		moviesB.setOpaque(false);
		moviesB.setContentAreaFilled(false);
		moviesB.setBounds(60, 10, 160, 30);
		moviesB.addActionListener(menuHandler);
		centerP.add(moviesB);
		
		reserveB = new JButton("Reserve a Movie Ticket");
		reserveB.setActionCommand("Reserve");
		reserveB.setOpaque(false);
		reserveB.setForeground(Color.BLUE);
		reserveB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reserveB.setContentAreaFilled(false);
		reserveB.setBounds(60, 51, 160, 30);
		reserveB.addActionListener(menuHandler);
		centerP.add(reserveB);
		
		analysisB = new JButton("Analysis");
		analysisB.setOpaque(false);
		analysisB.setForeground(Color.BLUE);
		analysisB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		analysisB.setContentAreaFilled(false);
		analysisB.setBounds(60, 91, 160, 30);
		centerP.add(analysisB);
		
		signoutB = new JButton("Sign Out");
		signoutB.setOpaque(false);
		signoutB.setForeground(Color.BLUE);
		signoutB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signoutB.setContentAreaFilled(false);
		signoutB.setBounds(105, 131, 75, 25);
		signoutB.addActionListener(menuHandler);
		centerP.add(signoutB);

//		usersB = new JButton("Edit Users");
//		usersB.setOpaque(false);
//		usersB.setForeground(Color.BLUE);
//		usersB.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		usersB.setContentAreaFilled(false);
//		usersB.setBounds(62, 179, 200, 45);
//		centerP.add(usersB);
		
		bgL.setBounds(0,-80,500,500);
		
		centerP.add(bgL);

		//printScreenB.addActionListener(loginHandler);
		//companyB.addActionListener(loginHandler);
		
		validate();
		
		add(centerP);
	}
	
	private class MenuHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("Movie"))
				systemUI.showMovieManagement();
			else if(action.equals("Reserve"))
				systemUI.showMovieSelection();
//			else if(action.equals("Analysis"))
//				systemUI.showAnalysis();
			else
				systemUI.showLogin();
		}
	}
}

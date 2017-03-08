package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.UserDAO;
import javax.swing.JComboBox;

public class MovieSelectionUI extends JPanel
{
	/*
	 * Small window containing dropboxes
	 * for selecting a movie and its 
	 * showing time.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JLabel bgL;
	private JButton reserveB;
	private SystemUI systemUI;
//	private LoginHandler loginHandler;
	private UserDAO userDAO;
	private Connection connection;
	private JButton cancelB;
	private JComboBox movieSelectCB;
	private JComboBox timeCB;
	
	public MovieSelectionUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
//		loginHandler = new LoginHandler();
		userDAO = new UserDAO(systemUI.getConnection());
		
		this.systemUI = systemUI;
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));
//		loginB.addActionListener(loginHandler);

		centerP = new JPanel();
		centerP.setLayout(null);
		
		reserveB = new JButton("Reserve a Ticket");
		reserveB.setOpaque(false);
		reserveB.setForeground(Color.BLUE);
		reserveB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveB.setContentAreaFilled(false);
		reserveB.setBounds(46, 107, 115, 23);
		
		centerP.add(reserveB);
		centerP.add(reserveB);
		centerP.add(reserveB);
		
		cancelB = new JButton("Cancel");
		cancelB.setOpaque(false);
		cancelB.setForeground(Color.BLUE);
		cancelB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cancelB.setContentAreaFilled(false);
		cancelB.setBounds(198, 107, 115, 23);
		centerP.add(cancelB);
		
		movieSelectCB = new JComboBox();
		movieSelectCB.setName("--Select a Movie--");
		movieSelectCB.setBounds(46, 30, 265, 25);
		centerP.add(movieSelectCB);
		
		timeCB = new JComboBox();
		timeCB.setName("--Select time--");
		timeCB.setBounds(108, 64, 144, 25);
		centerP.add(timeCB);
		centerP.add(bgL);
		
		bgL.setBounds(0,-80,500,500);
		
		//printScreenB.addActionListener(loginHandler);
		//companyB.addActionListener(loginHandler);
		
		validate();
		
		add(centerP);
	}
}

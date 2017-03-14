package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Movie;
import domain.Showtime;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class MovieSelectionUI extends JPanel
{
	/*
	 * Small window containing dropboxes
	 * for selecting a movie and its 
	 * showing time.
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JLabel bgL, timeL, titleL;
	private JButton reserveB, cancelB;
	private JComboBox<String> movieSelectCB, timeCB;
	private SystemUI systemUI;
	
	private SelectionHandler selectionHandler;
	private ItemHandler itemHandler;

	private List<Movie> movieList;
	
	private String movieId;

	
	public MovieSelectionUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		selectionHandler = new SelectionHandler();
		itemHandler = new ItemHandler();
		
		this.systemUI = systemUI;
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));

		centerP = new JPanel();
		centerP.setLayout(null);
		
		titleL = new JLabel("Select a Movie:");
		titleL.setForeground(Color.BLUE);
		titleL.setBounds(140, 11, 96, 14);
		centerP.add(titleL);
		
		movieSelectCB = new JComboBox<String>();
		movieSelectCB.setBounds(46, 36, 265, 25);
		centerP.add(movieSelectCB);
		
		timeL = new JLabel("Time:");
		timeL.setHorizontalAlignment(SwingConstants.RIGHT);
		timeL.setForeground(Color.BLUE);
		timeL.setBounds(22, 77, 74, 14);
		centerP.add(timeL);
		
		timeCB = new JComboBox<String>();
		timeCB.setBounds(106, 72, 144, 25);
		centerP.add(timeCB);
		
		reserveB = new JButton("Reserve a Ticket");
		reserveB.setActionCommand("Reserve");
		reserveB.setOpaque(false);
		reserveB.setForeground(Color.BLUE);
		reserveB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveB.setContentAreaFilled(false);
		reserveB.setBounds(44, 115, 115, 23);
		reserveB.addActionListener(selectionHandler);
		centerP.add(reserveB);
		
		
		cancelB = new JButton("Cancel");
		cancelB.setOpaque(false);
		cancelB.setForeground(Color.BLUE);
		cancelB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cancelB.setContentAreaFilled(false);
		cancelB.setBounds(196, 115, 115, 23);
		cancelB.addActionListener(selectionHandler);
		centerP.add(cancelB);
		
		bgL.setBounds(0,-80,500,500);

		centerP.add(bgL);
		
		validate();
		
		add(centerP);
	}
	
	public void restartUI()
	{
		movieSelectCB.removeAllItems();
		movieSelectCB.removeItemListener(itemHandler);

		movieList = systemUI.getMovieDAO().getMovieList();
		
		for(Movie movie : movieList)
			movieSelectCB.addItem(movie.getTitle());
		
		movieSelectCB.setSelectedIndex(0);
		
		movieSelectCB.addItemListener(itemHandler);
		for(Movie movie : movieList)
		{
			timeCB.removeAllItems();

			
			for(Movie movie2 : movieList)
				if(movie2.getTitle().equals(movieSelectCB.getSelectedItem().toString()))
					movieId = movie2.getMovieId();
			
			if(movie.getMovieId().equals(movieId))
			{
				for(Showtime showtime : movie.getShowtimeList())
				{
					timeCB.addItem(showtime.getTime().toString().substring(0, 5));
					timeCB.setSelectedIndex(0);
				}
				break;
			}
		}
		
		movieSelectCB.addItemListener(itemHandler);
	}
	
	private class SelectionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();
			
			if(action.equals("Reserve"))
				systemUI.showReservations(movieSelectCB.getSelectedItem().toString(), movieId, 
						timeCB.getSelectedItem().toString());
			else
			{
				if(systemUI.isAdmin())
					systemUI.showAdminMenu();
				else
					systemUI.showCustomerMenu();
			}

		}
	}
	
	private class ItemHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) 
		{
			timeCB.removeAllItems();

			for(Movie movie : movieList)
			{
				
				for(Movie movie2 : movieList)
					if(movie2.getTitle().equals(e.getItem().toString()))
						movieId = movie2.getMovieId();
				
				if(movie.getMovieId().equals(movieId))
				{
					for(Showtime showtime : movie.getShowtimeList())
					{
						timeCB.addItem(showtime.getTime().toString().substring(0, 5));
						timeCB.setSelectedIndex(0);
					}
					break;
				}
			}
		}
	}
}

package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import domain.Movie;
import domain.Reservations;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketUI extends JPanel
{

	/*
	 * This class will contain the management
	 * of the movies. Functions would be Add and Edit.
	 * The admins will be the ones who can
	 * access this.
	 */
	
	private static final long serialVersionUID = 1L;

	private JPanel centerP;
	private JLabel bgL;
	private JButton returnB, cancelB;
	
	private JTable ticketT;
	private DefaultTableModel ticketM;
	private JScrollPane ticketSP;
	private TableColumn ticketTC;
	private JTableHeader ticketTH;

	private SystemUI systemUI;
	private List<Reservations> reservationList;
	private List<String> selectedRow;
	
	private TicketHandler ticketHandler;

	public TicketUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1,1));

		this.systemUI = systemUI;
		ticketHandler = new TicketHandler();
		
		centerP = new JPanel();
		centerP.setLayout(null);
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon("../Movie Seating/lib/images/bg2.jpg"));
		
		returnB = new JButton("Return");
		returnB.addActionListener(ticketHandler);
		returnB.setContentAreaFilled(false);
		
		setupTable();
		ticketSP.setBounds(20, 11, 450, 90);
		
		centerP.add(ticketSP);
		centerP.add(returnB);
		returnB.setBounds(379, 144, 80, 25);
		
		cancelB = new JButton("Cancel Reservation");
		cancelB.setActionCommand("Cancel");
		cancelB.setContentAreaFilled(false);
		cancelB.setBounds(151, 112, 177, 25);
		cancelB.addActionListener(ticketHandler);
		centerP.add(cancelB);

		centerP.add(bgL);
		bgL.setBounds(0,-80,500,500);
		
		add(centerP);
	}
	
	public void restartUI()
	{		
		reservationList = systemUI.getReservationsDAO().getUserReservations();
		selectedRow = new ArrayList<String>();
		
		setupTableData();
	}
	
	@SuppressWarnings("serial")
	private void setupTable()
	{
		Vector<String> columnName = new Vector<String>();
		columnName.add("Title");
		columnName.add("Time");
		columnName.add("Hall");
		columnName.add("Seat Number");

		ticketM = new DefaultTableModel()
		{
			public boolean isCellEditable(int row, int column) 
			{
				switch(column)
				{
				default: return false;
				}
			}
		};

		ticketM.setColumnIdentifiers(columnName);
		ticketT = new JTable(ticketM);
		ticketT.setGridColor(Color.BLUE);
		ticketTC = null;
		
		for (int i = 0; i < columnName.size(); i++) 
		{
			ticketTC = ticketT.getColumnModel().getColumn(i);
			ticketTC.setPreferredWidth(112);
		}

		ticketTH = ticketT.getTableHeader();
		ticketTH.setBackground(Color.YELLOW);
		ticketTH.setReorderingAllowed(false);
		ticketTH.setResizingAllowed(false);
		
		ticketT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ticketSP = new JScrollPane(ticketT);
	}
	
	private void setupTableData()
	{
		int tableNumRows = reservationList.size();
		ticketM.setRowCount(tableNumRows);
		
		for(int rowNumber = 0; rowNumber < tableNumRows; rowNumber++)
		{
			for(Movie movie: systemUI.getMovieDAO().getMovieList())
			{
				if(movie.getMovieId().equals(reservationList.get(rowNumber).getMovieId()))
				{
					ticketM.setValueAt(movie.getTitle(),rowNumber,0);
					break;
				}
			}
			ticketM.setValueAt(reservationList.get(rowNumber).getTime(),rowNumber,1);
			ticketM.setValueAt(reservationList.get(rowNumber).getHallNo(),rowNumber,2);
			ticketM.setValueAt(reservationList.get(rowNumber).getSeatNo(),rowNumber,3);
		}
	}
	
	private class TicketHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			String action = arg0.getActionCommand();
			if(action.equals("Cancel"))
			{
				for(Movie movie: systemUI.getMovieDAO().getMovieList())
				{
					if(movie.getTitle().equals(ticketM.getValueAt(ticketT.getSelectedRow(), 0).toString()))
					{
						selectedRow.add(movie.getMovieId());
						break;
					}
				}
				
				for(int a = 1; a < 4; a++)
					selectedRow.add(ticketM.getValueAt(ticketT.getSelectedRow(), a).toString());
				
				systemUI.getReservationsDAO().deleteReservation(selectedRow);
				
				reservationList = systemUI.getReservationsDAO().getUserReservations();
				setupTableData();
			}
			else
				systemUI.showCustomerMenu();
			
		}
		
	}
}

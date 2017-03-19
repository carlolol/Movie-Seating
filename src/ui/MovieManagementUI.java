package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import domain.Movie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieManagementUI extends JPanel
{

	/*
	 * This class will contain the management
	 * of the movies. Functions would be Add and Edit.
	 * The admins will be the ones who can
	 * access this.
	 */
	
	private static final long serialVersionUID = 1L;

	private JPanel centerP;
	private JLabel titleL, genreL, durationL, ratingL, bgL, movieIdL;
	private JComboBox<String> titleCB;
	private JTextField genreTF, durationTF, ratingTF, titleTF, movieIdTF;
	private JButton addMovieB, addTimeB, returnB, editB, deleteB;
	
	private JTable showtimeT;
	private DefaultTableModel showtimeM;
	private JScrollPane showtimeSP;
	private TableColumn showtimeTC;
	private JTableHeader showtimeTH;

	private SystemUI systemUI;
	private List<Movie> movieList;
	private Movie selectedMovie;
	
	private MovieHandler movieHandler;
	private ItemHandler itemHandler;
	private JLabel timeL;
	private JTextField timeTF;
	private JLabel hallL;
	private JTextField hallTF;

	public MovieManagementUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1,1));

		this.systemUI = systemUI;
		movieHandler = new MovieHandler();
		itemHandler = new ItemHandler();

		centerP = new JPanel();
		centerP.setLayout(null);
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon("../Movie Seating/lib/images/bg2.jpg"));
		
		addMovieB = new JButton("Add Movie");
		addMovieB.setContentAreaFilled(false);
		addMovieB.addActionListener(movieHandler);
		
		addTimeB = new JButton("Add Time");
		addTimeB.setContentAreaFilled(false);
		addTimeB.addActionListener(movieHandler);
		
		returnB = new JButton("Return");
		returnB.addActionListener(movieHandler);
		returnB.setContentAreaFilled(false);
		
		titleL = new JLabel("Title:");
		genreL = new JLabel("Genre:");
		movieIdL = new JLabel("Movie Id:");
		durationL = new JLabel("Duration:");
		ratingL = new JLabel("Rating:");
		titleCB = new JComboBox<String>();
		genreTF = new JTextField(15);
		durationTF = new JTextField(15);
		ratingTF = new JTextField(15);
		titleTF = new JTextField(64);
		movieIdTF = new JTextField(15);
		
		timeL = new JLabel("Time:");
		timeL.setBounds(115, 85, 39, 25);
		centerP.add(timeL);
		
		timeTF = new JTextField(15);
		centerP.add(timeTF);
		
		hallL = new JLabel("Hall:");
		hallL.setBounds(256, 85, 34, 25);
		centerP.add(hallL);
		
		hallTF = new JTextField(15);
		centerP.add(hallTF);
		
		centerP.add(titleL);
		centerP.add(titleCB);
		centerP.add(genreL);
		centerP.add(genreTF);
		centerP.add(durationL);
		centerP.add(durationTF);
		centerP.add(ratingL);
		centerP.add(ratingTF);
		centerP.add(titleTF);
		centerP.add(movieIdL);
		centerP.add(movieIdTF);
		
		setupTable();
		showtimeSP.setBounds(114, 85, 250, 90);
		movieIdL.setBounds(115, 85, 50, 25);
		
		centerP.add(showtimeSP);
		centerP.add(addMovieB);
		centerP.add(addTimeB);
		centerP.add(returnB);
		
		titleL.setBounds(21, 11, 34, 25);
		titleCB.setBounds(65, 11, 404, 25);
		genreL.setBounds(31, 49, 39, 25);
		durationL.setBounds(215, 49, 52, 25);
		ratingL.setBounds(352, 49, 39, 25);
		addMovieB.setBounds(25, 185, 100, 25);
		addTimeB.setBounds(355, 185, 100, 25);
		returnB.setBounds(385, 222, 80, 25);
		
		movieIdTF.setBounds(175, 85, 190, 25);
		movieIdTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				
				if(movieIdTF.getText().length() < 5)
				{
					
				}
				else
					e.consume();
			}
		});
		
		titleTF.setBounds(65, 11, 404, 25);
		titleTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				
				if(titleTF.getText().length() < 64)
				{
					
				}
				else
					e.consume();
			}
		});
		
		genreTF.setBounds(75, 49, 130, 25);
		genreTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				
				if(genreTF.getText().length() < 24)
				{
					
				}
				else
					e.consume();
				
				char c = e.getKeyChar();

				if(Character.isLetter(c) || Character.isISOControl(c) || c == ' ')
				{
					
				}
				else
				{
					e.consume();
				}
			}
		});
		
		ratingTF.setBounds(401, 49, 50, 25);
		ratingTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();

				if(Character.isDigit(c) || Character.isISOControl(c) || c == '.')
				{
					if(!ratingTF.getText().trim().equals(""))
					{
						if(Double.parseDouble(ratingTF.getText()) < 100)
						{
							
						}
						else
						{
							e.consume();
							ratingTF.setText("" + 100.00);
						}
					}
				}
				else
				{
					e.consume();
				}
			}
		});
		
		durationTF.setBounds(277, 49, 65, 25);
		durationTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();

				if(Character.isDigit(c) || Character.isISOControl(c))
				{
					
				}
				else
				{
					e.consume();
				}
			}
		});
		
		timeTF.setBounds(164, 85, 65, 25);
		timeTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				if(timeTF.getText().length() < 5)
				{
					
				}
				else
					e.consume();
				
				char c = e.getKeyChar();

				if(Character.isDigit(c) || Character.isISOControl(c) || c == ':')
				{
					
				}
				else
				{
					e.consume();
				}
			}
		});
		
		hallTF.setBounds(300, 85, 65, 25);
		hallTF.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();

				if(Character.isDigit(c) || Character.isISOControl(c))
				{
					if(!hallTF.getText().trim().equals(""))
					{
						if(Integer.parseInt(hallTF.getText()) < 10)
						{
							
						}
						else
						{
							e.consume();
							hallTF.setText("" + 10);
						}
					}
				}
				else
				{
					e.consume();
				}
			}
		});
		
		editB = new JButton("Edit Movie");
		editB.setContentAreaFilled(false);
		editB.setBounds(135, 185, 100, 25);
		editB.addActionListener(movieHandler);
		centerP.add(editB);
		
		deleteB = new JButton("Delete");
		deleteB.setContentAreaFilled(false);
		deleteB.setBounds(245, 185, 100, 25);
		deleteB.addActionListener(movieHandler);
		centerP.add(deleteB);

		centerP.add(bgL);
		bgL.setBounds(0,-80,500,500);
		
		add(centerP);
	}
	
	public void restartUI()
	{		
		titleCB.removeAllItems();

		movieList = systemUI.getMovieDAO().getMovieList();
		
		for(Movie movie : movieList)
			titleCB.addItem(movie.getTitle());
		
		titleCB.setSelectedIndex(0);
		selectedMovie = movieList.get(0);
		
		titleCB.addItemListener(itemHandler);
		
		setupTextFields();
		toggleTextFields(false);
		toggleAdd(false);
		toggleForTime(false);
		toggleEdit(false);
		
		setupTableData();
	}
	
	private void setupTextFields()
	{
		movieIdTF.setText(selectedMovie.getMovieId());
		titleTF.setText(selectedMovie.getTitle());
		genreTF.setText(selectedMovie.getGenre());
		durationTF.setText("" + selectedMovie.getDuration());
		ratingTF.setText("" + selectedMovie.getRating());
	}
	
	private void toggleTextFields(boolean toggle)
	{
		genreTF.setEditable(toggle);
		durationTF.setEditable(toggle);
		ratingTF.setEditable(toggle);
	}
	
	private void toggleForTime(boolean toggle)
	{
		titleL.setVisible(!toggle);
		titleCB.setVisible(!toggle);
		genreL.setVisible(!toggle);
		genreTF.setVisible(!toggle);
		durationL.setVisible(!toggle);
		durationTF.setVisible(!toggle);
		ratingL.setVisible(!toggle);
		ratingTF.setVisible(!toggle);
		showtimeSP.setVisible(!toggle);
		returnB.setVisible(!toggle);
		editB.setVisible(!toggle);
		deleteB.setVisible(!toggle);

		timeL.setVisible(toggle);
		timeTF.setVisible(toggle);
		hallL.setVisible(toggle);
		hallTF.setVisible(toggle);
		
		if(toggle)
		{
			addMovieB.setText("Add");
			addTimeB.setText("Cancel");
		}
		else
		{
			addMovieB.setText("Add Movie");
			addTimeB.setText("Add Time");
		}
	}
	
	private void toggleAdd(boolean toggle)
	{
		titleTF.setVisible(toggle);
		movieIdTF.setVisible(toggle);
		movieIdL.setVisible(toggle);
		showtimeSP.setVisible(!toggle);
		toggleTextFields(toggle);
		returnB.setVisible(!toggle);
		editB.setVisible(!toggle);
		deleteB.setVisible(!toggle);
		titleCB.setVisible(!toggle);

		if(toggle)
		{
			addMovieB.setText("Confirm");
			addTimeB.setText("Cancel");
		}
		else
		{
			addMovieB.setText("Add Movie");
			addTimeB.setText("Add Time");
		}
	}
	
	private void toggleEdit(boolean toggle)
	{
		titleCB.setVisible(!toggle);
		titleTF.setVisible(toggle);
		titleTF.setEditable(toggle);
		genreTF.setEditable(toggle);
		durationTF.setEditable(toggle);
		ratingTF.setEditable(toggle);
		showtimeSP.setVisible(!toggle);
		
		editB.setVisible(!toggle);
		deleteB.setVisible(!toggle);
		titleCB.setVisible(!toggle);
		
		if(toggle)
		{
			addMovieB.setText("Append");
			addTimeB.setText("Cancel");
		}
		else
		{
			addMovieB.setText("Add Movie");
			addTimeB.setText("Add TIme");
		}
	}

	private void clearTextFields()
	{
		genreTF.setText("");
		durationTF.setText("");
		ratingTF.setText("");
		titleTF.setText("");
		movieIdTF.setText("");
		timeTF.setText("");
		hallTF.setText("");
	}
	
	private List<String> getFormListForAdd()
	{
		List<String> formList = new ArrayList<String>();
		
		formList.add(0, movieIdTF.getText());
		formList.add(1, titleTF.getText());
		formList.add(2, genreTF.getText());
		formList.add(3, durationTF.getText());
		formList.add(4, ratingTF.getText());
		
		return formList;
	}
	
	private List<String> getFormListForTime()
	{
		List<String> formList = new ArrayList<String>();
		
		formList.add(0, selectedMovie.getMovieId());
		formList.add(1, hallTF.getText());
		formList.add(2, timeTF.getText());
		
		return formList;
	}
	
	private List<String> getFormListForEdit()
	{
		List<String> formList = new ArrayList<String>();
		
		formList.add(0, titleTF.getText());
		formList.add(1, genreTF.getText());
		formList.add(2, durationTF.getText());
		formList.add(3, ratingTF.getText());
		formList.add(4, selectedMovie.getMovieId());
		
		return formList;
	}
	
	private boolean isNothingEmpty()
	{
		if(movieIdTF.getText().trim().isEmpty() || titleTF.getText().trim().isEmpty()
				|| genreTF.getText().trim().isEmpty() || durationTF.getText().trim().isEmpty()
				|| ratingTF.getText().trim().isEmpty())
			return false;
		else
			return true;	
	}
	
	@SuppressWarnings("serial")
	private void setupTable()
	{
		Vector<String> columnName = new Vector<String>();
		columnName.add("Time");
		columnName.add("Hall");

		showtimeM = new DefaultTableModel()
		{
			public boolean isCellEditable(int row, int column) 
			{
				switch(column)
				{
				default: return false;
				}
			}
		};

		showtimeM.setColumnIdentifiers(columnName);
		showtimeT = new JTable(showtimeM);
		showtimeT.setGridColor(Color.BLUE);
		showtimeTC = null;
		
		for (int i = 0; i < columnName.size(); i++) 
		{
			showtimeTC = showtimeT.getColumnModel().getColumn(i);
			showtimeTC.setPreferredWidth(125);
		}

		showtimeTH = showtimeT.getTableHeader();
		showtimeTH.setBackground(Color.YELLOW);
		showtimeTH.setReorderingAllowed(false);
		showtimeTH.setResizingAllowed(false);
		
		showtimeT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		showtimeSP = new JScrollPane(showtimeT);
	}
	
	private void setupTableData()
	{
		int tableNumRows = selectedMovie.getShowtimeList().size();
		showtimeM.setRowCount(tableNumRows);
		
		for(int rowNumber = 0; rowNumber < tableNumRows; rowNumber++)
		{
			showtimeM.setValueAt(selectedMovie.getShowtimeList().get(rowNumber).getTime(),rowNumber,0);
			showtimeM.setValueAt(selectedMovie.getShowtimeList().get(rowNumber).getHallNo(),rowNumber,1);
		}
	}
	
	private class MovieHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("Add Movie"))
			{
				toggleAdd(true);
				clearTextFields();
			}
			else if(action.equals("Confirm") && isNothingEmpty())
			{
				systemUI.getMovieDAO().addMovie(getFormListForAdd());
				titleCB.addItem(titleTF.getText());
				movieList = systemUI.getMovieDAO().getMovieList();
				toggleAdd(false);
			}
			else if(action.equals("Edit Movie"))
			{
				toggleEdit(true);
			}
			else if(action.equals("Append") && isNothingEmpty())
			{
				systemUI.getMovieDAO().editMovie(getFormListForEdit());
				movieList = systemUI.getMovieDAO().getMovieList();
				selectedMovie = movieList.get(titleCB.getSelectedIndex());
				titleCB.addItem(selectedMovie.getTitle());
				titleCB.removeItemAt(titleCB.getSelectedIndex());
				titleCB.setSelectedIndex(titleCB.getItemCount() - 1);

				toggleEdit(false);
			}
			else if(action.equals("Add Time"))
			{
				toggleForTime(true);
				clearTextFields();
			}
			else if(action.equals("Add") && !timeTF.getText().trim().isEmpty() 
					&& !hallTF.getText().trim().isEmpty())
			{
				systemUI.getMovieDAO().getShowtimeDAO().addShowtime(getFormListForTime());
				systemUI.getMovieDAO().initializeMovieList();
				movieList = systemUI.getMovieDAO().getMovieList();
				
				for(Movie movie: movieList)
					if(movie.getMovieId().equals(selectedMovie.getMovieId()))
						selectedMovie = movie;
				
				setupTextFields();
				setupTableData();
				toggleForTime(false);
				repaint();
			}
			else if(action.equals("Delete"))
			{
				systemUI.getMovieDAO().deleteMovie(selectedMovie.getMovieId());
				movieList = systemUI.getMovieDAO().getMovieList();
				titleCB.removeItemAt(titleCB.getSelectedIndex());
				titleCB.setSelectedIndex(0);
				setupTextFields();
				setupTableData();
			}
			else if(action.equals("Cancel"))
			{
				toggleAdd(false);
				toggleForTime(false);
				setupTextFields();
			}
			else if(action.equals("Return"))
			{
				titleCB.removeItemListener(itemHandler);
				systemUI.showAdminMenu();
			}
			else
				JOptionPane.showMessageDialog(null,	"Fill up blank forms.",
						"Add Movie Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private class ItemHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) 
		{
			for(Movie movie: movieList)
			{
				if(movie.getTitle().equals(titleCB.getSelectedItem().toString()))
				{
					selectedMovie = movie;
					setupTextFields();
					setupTableData();
				}
			}
		}
	}
}

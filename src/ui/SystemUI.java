package ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import dao.*;
import domain.Customer;

public class SystemUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Container container;
	private CardLayout card;
	
	private MovieDAO movieDAO;
	private ReservationsDAO reservationsDAO;
	private ShowtimeDAO showtimeDAO;
	private UserDAO userDAO;
	private Customer loginCustomer;
	
	private ReservationsUI reservationsUI;
	private LoginUI loginUI;
	private RegistrationUI registrationUI;
	private CustomerMenuUI customerMenuUI;
	private AdminMenuUI adminMenuUI;
	private MovieSelectionUI movieSelectionUI;
	private MovieManagementUI movieManagementUI;
	private MovieTimeManagementUI movieTimeManagementUI;
	private ProfileManagementUI profileManagementUI;
	
	private ImageIcon img;
	
	private Connection connection;
	
	public SystemUI()
	{	
		connection = setupConnection();
		
		userDAO = new UserDAO(connection);
		movieDAO = new MovieDAO(connection);
		
		
		img = new ImageIcon("");
		setIconImage(img.getImage());
		
		container = getContentPane();
		
		card = new CardLayout();
		container.setLayout(card);
		
		reservationsUI = new ReservationsUI(this);
		container.add(reservationsUI, "Reservations");
		
		loginUI = new LoginUI(this);
		container.add(loginUI, "Login");
		
		registrationUI = new RegistrationUI(this);
		container.add(registrationUI, "Registration");
		
		customerMenuUI = new CustomerMenuUI(this);
		container.add(customerMenuUI, "Customer Menu");
		
		adminMenuUI = new AdminMenuUI(this);
		container.add(adminMenuUI, "Admin Menu");
		
		movieSelectionUI = new MovieSelectionUI(this);
		container.add(movieSelectionUI, "Movie Selection");
		
		movieManagementUI = new MovieManagementUI(this);
		container.add(movieManagementUI, "Movie Management");
		
		movieTimeManagementUI = new MovieTimeManagementUI(this);
		container.add(movieTimeManagementUI, "Movie Time Management");
		
		profileManagementUI = new ProfileManagementUI(this);
		container.add(profileManagementUI, "Profile Management");
		
		setTitle("Movie Seating System");	
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void showReservations(String movieTitle, String movieId, String time)
	{
		setSize(900, 400);
		setLocationRelativeTo(null);
		card.show(container, "Reservations");
		reservationsDAO = new ReservationsDAO(connection, movieId, time);
		reservationsUI.setupUI(movieId, movieTitle, time);
		repaint();
	}
	
	public void showLogin()
	{
		setSize(400, 400);
		setLocationRelativeTo(null);
		card.show(container, "Login");
		repaint();
	}
	
	public void showRegistration()
	{
		setSize(455, 240);
		setLocationRelativeTo(null);
		card.show(container, "Registration");
		repaint();
	}
	
	public void showCustomerMenu()
	{
		setSize(315, 160);
		setLocationRelativeTo(null);
		card.show(container, "Customer Menu");
		repaint();
	}
	
	public void showAdminMenu()
	{
		setSize(290, 235);
		setLocationRelativeTo(null);
		card.show(container, "Admin Menu");
		repaint();
	}
	
	public void showMovieSelection()
	{
		setSize(365, 190);
		setLocationRelativeTo(null);
		card.show(container, "Movie Selection");
		movieSelectionUI.updateComboBoxes();
		repaint();
	}
	
	public void showMovieManagement()
	{
		setSize(490, 330);
		setLocationRelativeTo(null);
		card.show(container, "Movie Management");
		repaint();
	}
	
	public void showMovieTimeManagement()
	{
		setSize(485, 275);
		setLocationRelativeTo(null);
		card.show(container, "Movie Time Management");
		repaint();
	}
	
	public void showProfileManagement()
	{
		setSize(455, 240);
		setLocationRelativeTo(null);
		card.show(container, "Profile Management");
		profileManagementUI.showProfile();
		repaint();
	}
	
	public Customer getLoginCustomer() 
	{
		return loginCustomer;
	}

	public void setLoginCustomer(Customer loginCustomer) 
	{
		this.loginCustomer = loginCustomer;
	}
	
	public UserDAO getUserDAO() 
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) 
	{
		this.userDAO = userDAO;
	}
	
	public ShowtimeDAO getShowtimeDAO() 
	{
		return showtimeDAO;
	}

	public void setShowtimeDAO(ShowtimeDAO showtimeDAO) 
	{
		this.showtimeDAO = showtimeDAO;
	}

	public ReservationsDAO getReservationsDAO() 
	{
		return reservationsDAO;
	}

	public void setReservationsDAO(ReservationsDAO reservationsDAO) 
	{
		this.reservationsDAO = reservationsDAO;
	}

	public MovieDAO getMovieDAO() 
	{
		return movieDAO;
	}

	public void setMovieDAO(MovieDAO movieDAO) 
	{
		this.movieDAO = movieDAO;
	}
	
	private Connection setupConnection()
	{
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			connection = DriverManager.getConnection("jdbc:db2://localhost:50000/moviesDB",
					"carlolol", "rAyquaza");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		
		return connection;
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
		
	public static void main(String[] args)
	{
		new SystemUI().showLogin();
	}

}
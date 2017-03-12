package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Reservations;

public class ReservationsDAO 
{
	private List<Reservations> reservationsList;
	private Reservations reservations;
	private ResultSet resultSet;
	private Connection connection;
	private String movieId;
	private String time;
	
	public ReservationsDAO(Connection connection, String movieId, String time)
	{
		this.connection = connection;
		this.movieId = movieId;
		this.time = time;
		
		initializeReservationsList();
	}
	
	private void initializeReservationsList()
	{
		reservationsList = new ArrayList<Reservations>();

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM reservations WHERE movieId = ? AND time = ?";

			s = connection.prepareStatement(query);
			s.setString(1, movieId);
			s.setString(2, time);
			
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				reservations = new Reservations();

				reservations.setMovieId(resultSet.getString(1));
				reservations.setCustomerId(resultSet.getString(2));
				reservations.setTime(resultSet.getTime(3));
				reservations.setSeatNo(resultSet.getString(4));

				reservationsList.add(reservations);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Reservations> getReservationsList()
	{
		return reservationsList;
	}
	
	public void addReservations(String customerId, String movieId, String time, List<String> seatList)
	{
		try
		{
			for(String seat: seatList)
			{
				PreparedStatement s = null;
				String query;
	
				query = "INSERT INTO reservations VALUES(?, ?, ?, ?)";
	
				s = connection.prepareStatement(query);
				s.setString(1, customerId);
				s.setString(2, movieId);
				s.setString(3, time);
				s.setString(4, seat);
	
				s.executeUpdate();
	
				initializeReservationsList();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}

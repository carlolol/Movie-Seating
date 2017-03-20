package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import domain.Reservations;

public class ReservationsDAO 
{
	private List<Reservations> reservationsList;
	private List<Reservations> specificList;
	private Reservations reservations;
	private ResultSet resultSet;
	private Connection connection;
	private String movieId;
	private String time;
	private String hallNo;
	private String customerId;
	
	public ReservationsDAO(Connection connection, String customerId)
	{
		this.customerId = customerId;
		this.connection = connection;

		initializeUserReservation();
	}
	
	public ReservationsDAO(Connection connection, String movieId, String time, String hallNo)
	{
		this.connection = connection;
		this.movieId = movieId;
		this.time = time;
		this.hallNo = hallNo;
		
		initializeReservationsList();
	}
	
	private void initializeReservationsList()
	{
		reservationsList = new ArrayList<Reservations>();

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM reservations WHERE movieId = ? AND time = ? AND hallNo = ?";

			s = connection.prepareStatement(query);
			s.setString(1, movieId);
			s.setString(2, time);
			s.setString(3, hallNo);
			
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				reservations = new Reservations();

				reservations.setCustomerId(resultSet.getString(1));
				reservations.setMovieId(resultSet.getString(2));
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
	
	public void addReservations(String customerId, String movieId, String time, List<String> seatList, String hallNo)
	{
		try
		{
			for(String seat: seatList)
			{
				PreparedStatement s = null;
				String query;
	
				query = "INSERT INTO reservations VALUES(?, ?, ?, ?, ?)";
	
				s = connection.prepareStatement(query);
				
				if(customerId == null)
					s.setNull(1, Types.VARCHAR);
				else
					s.setString(1, customerId);
				s.setString(2, movieId);
				s.setString(3, time);
				s.setString(4, seat);
				s.setInt(5, Integer.parseInt(hallNo));
	
				s.executeUpdate();
	
				initializeReservationsList();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void initializeUserReservation()
	{
		specificList = new ArrayList<Reservations>();
		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM reservations WHERE customerId = ?";

			s = connection.prepareStatement(query);
			s.setString(1, customerId);
			
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				reservations = new Reservations();

				reservations.setCustomerId(resultSet.getString(1));
				reservations.setMovieId(resultSet.getString(2));
				reservations.setTime(resultSet.getTime(3));
				reservations.setSeatNo(resultSet.getString(4));
				reservations.setHallNo(Integer.parseInt(resultSet.getString(5)));

				specificList.add(reservations);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteReservation(List<String> selected)
	{
		try
		{
			PreparedStatement s = null;
			String query;

			query = "DELETE FROM reservations WHERE customerId = ? AND movieId = ? "
					+ "AND time = ? AND hallNo = ? AND seatNo = ?";
			s = connection.prepareStatement(query);
			s.setString(1, customerId);
			s.setString(2, selected.get(0));
			s.setString(3, selected.get(1).substring(0, 5));
			s.setString(4, selected.get(2));
			s.setString(5, selected.get(3));

			s.executeUpdate();
			
			s = null;
			
			initializeUserReservation();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Reservations> getUserReservations()
	{
		return specificList;
	}
}

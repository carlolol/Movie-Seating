package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Showtime;

public class ShowtimeDAO 
{
	private List<Showtime> showtimeList;
//	private List<Customer> customerList;
	private Showtime showtime;
//	private Customer customer;
	private ResultSet resultSet;
	private Connection connection;
	private String movieId;
	
	public ShowtimeDAO(Connection connection, String movieId)
	{
		this.connection = connection;
		this.movieId = movieId;
		
		initializeShowtimeList();
	}
	
	private void initializeShowtimeList()
	{
		showtimeList = new ArrayList<Showtime>();

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM showtime WHERE movieId = ?";

			s = connection.prepareStatement(query);
			s.setString(1, movieId);
			
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				showtime = new Showtime();

				showtime.setMovieId(resultSet.getString(1));
				showtime.setHallNo(Integer.parseInt(resultSet.getString(2)));
				showtime.setTime(resultSet.getTime(3));
				
				showtimeList.add(showtime);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Showtime> getShowtime()
	{
		return showtimeList;
	}
}

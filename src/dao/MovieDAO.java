package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Movie;

public class MovieDAO 
{
	private List<Movie> movieList;
//	private List<Customer> customerList;
	private Movie movie;
//	private Customer customer;
	private ResultSet resultSet;
	private Connection connection;
	
	public MovieDAO(Connection connection)
	{
		this.connection = connection;
		
		initializeMovieList();
	}
	
	private void initializeMovieList()
	{
		movieList = new ArrayList<Movie>();

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM movie";

			s = connection.prepareStatement(query);
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				movie = new Movie();

				movie.setMovieId(resultSet.getString(1));
				movie.setTitle(resultSet.getString(2));
				movie.setGenre(resultSet.getString(3));
				movie.setDuration(Integer.parseInt(resultSet.getString(4)));
				movie.setRating(Double.parseDouble(resultSet.getString(5)));
				
				ShowtimeDAO showtimeDAO = new ShowtimeDAO(connection, resultSet.getString(1));
				movie.setShowtimeList(showtimeDAO.getShowtime());

				movieList.add(movie);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}

}

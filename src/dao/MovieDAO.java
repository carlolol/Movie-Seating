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
	private ShowtimeDAO showtimeDAO;
	
	public MovieDAO(Connection connection)
	{
		this.connection = connection;
		
		initializeMovieList();
	}
	
	public void initializeMovieList()
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
				
				showtimeDAO = new ShowtimeDAO(connection, resultSet.getString(1));
				movie.setShowtimeList(showtimeDAO.getShowtime());

				movieList.add(movie);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addMovie(List<String> formList)
	{
		try
		{
			PreparedStatement s = null;
			String query;

			query = "INSERT INTO movie VALUES(?, ?, ?, ?, ?)";

			s = connection.prepareStatement(query);
			s.setString(1, formList.get(0));
			s.setString(2, formList.get(1));
			s.setString(3, formList.get(2));
			s.setInt(4, Integer.parseInt(formList.get(3)));
			s.setDouble(5, Double.parseDouble(formList.get(4)));

			s.executeUpdate();

//			moduleDA.addModule(loginUser.getUsername(), textFieldList.get(0), checkBoxList);

			initializeMovieList();
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
	
	public ShowtimeDAO getShowtimeDAO()
	{
		return showtimeDAO;
	}

}

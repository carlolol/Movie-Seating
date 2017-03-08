package domain;

import java.util.List;

public class Movie 
{
	private String movieId;
	private String title;
	private String genre;
	private int duration;
	private double rating;
	private List<Showtime> showtimeList;
	
	public String getMovieId()
	{
		return movieId;
	}
	
	public void setMovieId(String movieId) 
	{
		this.movieId = movieId;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getGenre() 
	{
		return genre;
	}

	public void setGenre(String genre) 
	{
		this.genre = genre;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration) 
	{
		this.duration = duration;
	}

	public double getRating()
	{
		return rating;
	}

	public void setRating(double rating) 
	{
		this.rating = rating;
	}

	public List<Showtime> getShowtimeList() 
	{
		return showtimeList;
	}

	public void setShowtimeList(List<Showtime> showtimeList) 
	{
		this.showtimeList = showtimeList;
	}
	

}

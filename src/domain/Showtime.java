package domain;

import java.sql.Time;

public class Showtime 
{
	private String movieId;
	private int hallNo;
	private Time time;
	
	public String getMovieId() 
	{
		return movieId;
	}
	
	public void setMovieId(String movieId)
	{
		this.movieId = movieId;
	}

	public int getHallNo() 
	{
		return hallNo;
	}

	public void setHallNo(int hallNo)
	{
		this.hallNo = hallNo;
	}

	public Time getTime() 
	{
		return time;
	}

	public void setTime(Time time) 
	{
		this.time = time;
	}
	
	
}

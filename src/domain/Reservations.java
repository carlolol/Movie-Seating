package domain;

import java.sql.Time;

public class Reservations 
{
	private String customerId;
	private String movieId;
	private Time time;
	private String seatNo;

	public String getMovieId() 
	{
		return movieId;
	}

	public void setMovieId(String movieId) 
	{
		this.movieId = movieId;
	}

	public String getSeatNo() 
	{
		return seatNo;
	}

	public void setSeatNo(String seatNo) 
	{
		this.seatNo = seatNo;
	}

	public String getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(String customerId) 
	{
		this.customerId = customerId;
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

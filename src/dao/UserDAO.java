package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserDAO 
{
	private List<User> userList;
	private User userDB, loginUser;
	private ResultSet resultSet;
	private Connection connection;
	
	public UserDAO(Connection connection)
	{
		userList = new ArrayList<User>();
		this.connection = connection;

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM users";

			s = connection.prepareStatement(query);
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				userDB = new User();

				userDB.setName(resultSet.getString(1));
				userDB.setPassword(resultSet.getString(2));
				userDB.setRights(resultSet.getString(3).charAt(0));

				userList.add(userDB);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public User getUser(User paramUser)
	{
		User validUser = new User();
		for(User userTemp: userList)
		{
			if(userTemp.getName().equals(paramUser.getName()) && 
					userTemp.getPassword().equals(paramUser.getPassword()))
			{
				validUser = userTemp;
				break;
			}
		}

		return validUser;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import domain.Admin;
import domain.Customer;

public class UserDAO 
{
	private List<Admin> adminList;
	private List<Customer> customerList;
	private Admin admin;
	private Customer customer;
	private ResultSet resultSet;
	private Connection connection;
	
	public UserDAO(Connection connection)
	{
		this.connection = connection;
		
		initializeAdminList();
		initializeCustomerList();
	}
	
	private void initializeAdminList()
	{
		adminList = new ArrayList<Admin>();

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM admin";

			s = connection.prepareStatement(query);
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				admin = new Admin();

				admin.setAdminId(resultSet.getString(1));
				admin.setName(resultSet.getString(2));
				admin.setPassword(resultSet.getString(3));
				admin.setPosition(resultSet.getString(4));

				adminList.add(admin);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void initializeCustomerList()
	{
		customerList = new ArrayList<Customer>();

		try
		{
			PreparedStatement s = null;
			String query;
			query = "SELECT * FROM customer";

			s = connection.prepareStatement(query);
			resultSet = s.executeQuery();

			while(resultSet.next())
			{
				customer = new Customer();

				customer.setCustomerId(resultSet.getString(1));
				customer.setName(resultSet.getString(2));
				customer.setPassword(resultSet.getString(3));
				customer.setAge(Integer.parseInt(resultSet.getString(4)));
				customer.setGender(resultSet.getString(5).charAt(0));
				customer.setOccupation(resultSet.getString(6));

				customerList.add(customer);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean findAdmin(Admin paramAdmin)
	{
		boolean checker = false;
		
		for(Admin adminTemp: adminList)
			if(adminTemp.getAdminId().equals(paramAdmin.getAdminId()) && 
					adminTemp.getPassword().equals(paramAdmin.getPassword()))
			{
				checker = true;
				break;
			}

		return checker;
	}
	
	public boolean findCustomer(Customer paramCustomer)
	{
		boolean checker = false;
		
		for(Customer customerTemp: customerList)
			if(customerTemp.getCustomerId().equals(paramCustomer.getCustomerId()) && 
					customerTemp.getPassword().equals(paramCustomer.getPassword()))
			{
				checker = true;
				break;
			}

		return checker;
	}
	
	public Customer getCustomer(Customer paramCustomer)
	{
		Customer loginCustomer = new Customer();
		for(Customer customerTemp: customerList)
			if(customerTemp.getCustomerId().equals(paramCustomer.getCustomerId()) && 
					customerTemp.getPassword().equals(paramCustomer.getPassword()))
			{
				loginCustomer = customerTemp;
				break;
			}

		return loginCustomer;
	}
	
	public void addCustomer(List<String> formList)
	{
		try
		{
			PreparedStatement s = null;
			String query;

			query = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?)";

			s = connection.prepareStatement(query);
			s.setString(1, formList.get(0));
			s.setString(2, formList.get(1));
			s.setString(3, formList.get(2));
			s.setInt(4, Integer.parseInt(formList.get(3)));
			s.setString(5, formList.get(4));
			s.setString(6, formList.get(5));

			s.executeUpdate();

//			moduleDA.addModule(loginUser.getUsername(), textFieldList.get(0), checkBoxList);

			initializeCustomerList();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void editCustomer(List<String> formList)
	{
		try
		{
			PreparedStatement s = null;
			String query;

//			formList.add(0, nameTF.getText());
//			formList.add(1, passwordTF.getText());
//			formList.add(2, ageTF.getText());
//			formList.add(3, occupationTF.getText());
			
			query = "UPDATE customer SET name = ? WHERE customerId = ?";

			s = connection.prepareStatement(query);
			s.setString(1, formList.get(0));
			s.setString(2, formList.get(4));
			s.executeUpdate();

			s = null;

			query = "UPDATE customer SET password = ? WHERE customerId = ?";

			s = connection.prepareStatement(query);
			s.setString(1, formList.get(1));
			s.setString(2, formList.get(4));
			s.executeUpdate();

			s = null;
			
			query = "UPDATE customer SET age = ? WHERE customerId = ?";

			s = connection.prepareStatement(query);
			s.setInt(1, Integer.parseInt(formList.get(2)));
			s.setString(2, formList.get(4));
			s.executeUpdate();

			s = null;
			
			query = "UPDATE customer SET occupation = ? WHERE customerId = ?";

			s = connection.prepareStatement(query);
			s.setString(1, formList.get(3));
			s.setString(2, formList.get(4));
			s.executeUpdate();

			initializeCustomerList();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}

package domain;

public class Customer 
{
	private String customerId;
	private String name;
	private String password;
	private int age;
	private char gender;
	private String occupation;
	
	public String getCustomerId() 
	{
		return customerId;
	}
	
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public char getGender()
	{
		return gender;
	}

	public void setGender(char gender) 
	{
		this.gender = gender;
	}

	public String getOccupation()
	{
		return occupation;
	}

	public void setOccupation(String occupation) 
	{
		this.occupation = occupation;
	}
	

}

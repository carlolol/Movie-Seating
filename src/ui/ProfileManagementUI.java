package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UserDAO;
import domain.Customer;

public class ProfileManagementUI extends JPanel
{
	/*
	 * Customers and Admins will be using this
	 * UI. Admins can View and Edit Customer
	 * Details, while Customers can only view 
	 * their own profile.
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private SystemUI systemUI;
	private ProfileHandler profileHandler;
	private Customer loginCustomer;
	private JTextField nameTF, ageTF, occupationTF, genderTF, usernameTF, passwordTF;
	private JLabel bgL, nameL, usernameL, passwordL, ageL, genderL, occupationL;
	private JButton backB, editB;
	
	public ProfileManagementUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		profileHandler = new ProfileHandler();
		
		this.systemUI = systemUI;
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));

		centerP = new JPanel();
		centerP.setLayout(null);

		backB = new JButton("Back");
		backB.setOpaque(false);
		backB.setForeground(Color.BLUE);
		backB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backB.setContentAreaFilled(false);
		backB.setBounds(251, 177, 75, 25);
		backB.addActionListener(profileHandler);
		centerP.add(backB);
		
		editB = new JButton("Edit");
		editB.setOpaque(false);
		editB.setForeground(Color.BLUE);
		editB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		editB.setContentAreaFilled(false);
		editB.setBounds(123, 177, 75, 25);
		editB.addActionListener(profileHandler);
		centerP.add(editB);
		
		nameL = new JLabel("Name:");
		nameL.setHorizontalAlignment(SwingConstants.RIGHT);
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameL.setForeground(Color.BLUE);
		nameL.setBounds(27, 7, 46, 20);
		centerP.add(nameL);
		
		nameTF = new JTextField();
		nameTF.setBounds(83, 8, 357, 20);
		nameTF.setColumns(10);
		centerP.add(nameTF);
		
		usernameL = new JLabel("Username:");
		usernameL.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameL.setForeground(Color.BLUE);
		usernameL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameL.setBounds(0, 38, 73, 20);
		centerP.add(usernameL);
		
		usernameTF = new JTextField();
		usernameTF.setColumns(10);
		usernameTF.setBounds(83, 39, 357, 20);
		usernameTF.setEditable(false);
		centerP.add(usernameTF);
		
		passwordL = new JLabel("Password:");
		passwordL.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordL.setForeground(Color.BLUE);
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordL.setBounds(0, 70, 73, 20);
		centerP.add(passwordL);
		
		passwordTF = new JTextField();
		passwordTF.setColumns(10);
		passwordTF.setBounds(83, 71, 357, 20);
		centerP.add(passwordTF);
		
		ageL = new JLabel("Age:");
		ageL.setHorizontalAlignment(SwingConstants.RIGHT);
		ageL.setForeground(Color.BLUE);
		ageL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ageL.setBounds(0, 102, 73, 20);
		centerP.add(ageL);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(83, 103, 115, 20);
		centerP.add(ageTF);
		
		genderL = new JLabel("Gender:");
		genderL.setHorizontalAlignment(SwingConstants.RIGHT);
		genderL.setForeground(Color.BLUE);
		genderL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderL.setBounds(242, 101, 73, 20);
		centerP.add(genderL);
		
		genderTF = new JTextField();
		genderTF.setBounds(325, 102, 32, 20);
		genderTF.setEditable(false);
		genderTF.setColumns(10);
		centerP.add(genderTF);
		
		occupationL = new JLabel("Occupation:");
		occupationL.setHorizontalAlignment(SwingConstants.RIGHT);
		occupationL.setForeground(Color.BLUE);
		occupationL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		occupationL.setBounds(0, 133, 73, 20);
		centerP.add(occupationL);
		
		occupationTF = new JTextField();
		occupationTF.setColumns(10);
		occupationTF.setBounds(83, 134, 189, 20);
		centerP.add(occupationTF);

		
		bgL.setBounds(0,-80,500,500);

		centerP.add(bgL);
		
		toggleTextFields(false);
		
		validate();
		
		add(centerP);
	}
	
	private class ProfileHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("Edit"))
			{
				toggleTextFields(true);
				editB.setText("Confirm");
				backB.setText("Cancel");
			}
			else if(action.equals("Confirm"))
			{
				systemUI.getUserDAO().editCustomer(getFormList());
				updateLoginCustomer();
				editB.setText("Edit");
				backB.setText("Back");
				toggleTextFields(false);
			}
			else if(action.equals("Cancel"))
			{
				toggleTextFields(false);
				editB.setText("Edit");
				backB.setText("Back");
			}
			else
				systemUI.showCustomerMenu();
		}
	}
	
	private List<String> getFormList()
	{
		List<String> formList = new ArrayList<String>();
		
		formList.add(0, nameTF.getText());
		formList.add(1, passwordTF.getText());
		formList.add(2, ageTF.getText());
		formList.add(3, occupationTF.getText());
		formList.add(4, loginCustomer.getCustomerId());

		return formList;
	}
	
	private void updateLoginCustomer()
	{
		loginCustomer.setName(nameTF.getText());
		loginCustomer.setPassword(passwordTF.getText());
		loginCustomer.setAge(Integer.parseInt(ageTF.getText()));
		loginCustomer.setOccupation(occupationTF.getText());
		
		systemUI.setLoginCustomer(loginCustomer);
	}
	
	public void showProfile()
	{
		loginCustomer = systemUI.getLoginCustomer();
		
		nameTF.setText(loginCustomer.getName());
		usernameTF.setText(loginCustomer.getCustomerId());
		passwordTF.setText(loginCustomer.getPassword());
		ageTF.setText("" + loginCustomer.getAge());
		occupationTF.setText(loginCustomer.getOccupation());
		genderTF.setText("" + loginCustomer.getGender());
	}
	
	private void toggleTextFields(boolean toggle)
	{
		nameTF.setEditable(toggle);
		passwordTF.setEditable(toggle);
		ageTF.setEditable(toggle);
		occupationTF.setEditable(toggle);
	}
}

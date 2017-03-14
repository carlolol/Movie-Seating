package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import dao.UserDAO;
import domain.Customer;
import domain.Admin;

public class LoginUI extends JPanel
{
	/*
	 * This UI will contain login with username
	 * and password. New users can also register
	 * to have their own account.
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JLabel usernameL, passwordL, bgL;
	private JTextField usernameTF;
	private JPasswordField passwordPF;
	private JButton loginB, registerB;
	
	private SystemUI systemUI;
	private LoginHandler loginHandler;
	private UserDAO userDAO;
	
	public LoginUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		loginHandler = new LoginHandler();
		userDAO = systemUI.getUserDAO();
		
		this.systemUI = systemUI;
				
		usernameL = new JLabel("Username:");
		passwordL = new JLabel("Password:");
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));
		
		usernameTF = new JTextField(10);
		usernameTF.getCursor();
		passwordPF = new JPasswordField(10);
		
		loginB = new JButton("Login");
		loginB.setForeground(Color.BLUE);
		loginB.setOpaque(false);
		loginB.setContentAreaFilled(false);
		loginB.addActionListener(loginHandler);

		centerP = new JPanel();
		centerP.setLayout(null);
		
		centerP.add(usernameL); 
		centerP.add(usernameTF); 
		centerP.add(passwordL); 
		centerP.add(passwordPF); 
		centerP.add(loginB);
		
		registerB = new JButton("Not yet registered? Click here to sign-up.");
		registerB.setActionCommand("Register");
		registerB.setBorder(null);
		registerB.setFont(new Font("Tahoma", Font.BOLD, 9));
		registerB.setOpaque(false);
		registerB.setForeground(Color.BLUE);
		registerB.setContentAreaFilled(false);
		registerB.setBounds(85, 240, 225, 15);
		registerB.addActionListener(loginHandler);
		
		centerP.add(registerB);
		centerP.add(bgL);
		
		bgL.setBounds(0,-80,500,500);
		usernameTF.setBounds(75,170,250,25); 
		passwordPF.setBounds(75,210,250,25); 
		loginB.setBounds(171,266,70,25); 
		usernameL.setBounds(75,150,80,25);
		passwordL.setBounds(75,190,80,25);

		
		validate();
		
		add(centerP);
		
//		usernameTF.addKeyListener(new KeyAdapter()
//		{
//			public void keyPressed(KeyEvent e)
//			{
//				int key = e.getKeyCode();
//				
//				if(key==KeyEvent.VK_ENTER && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
//				{
//					validateUser();
//					usernameTF.setText("");
//					passwordPF.setText("");
//				}
//				
//				else if(key==KeyEvent.VK_ENTER && getUsernameTF().getText().isEmpty() && getPasswordPF().getText().isEmpty())
//				{
//					JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
//							"Login Error", JOptionPane.ERROR_MESSAGE);
//					usernameTF.setText("");
//					passwordPF.setText("");
//				}	
//			}
//		});
//		
//		passwordPF.addKeyListener(new KeyAdapter()
//		{
//			public void keyPressed(KeyEvent e)
//			{
//				int key = e.getKeyCode();
//				
//				if(key==KeyEvent.VK_ENTER && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
//				{
//					validateUser();
//					usernameTF.setText("");
//					passwordPF.setText("");
//				}
//				
//				else if(key==KeyEvent.VK_ENTER && getUsernameTF().getText().isEmpty() && getPasswordPF().getText().isEmpty())
//				{
//					JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
//							"Login Error", JOptionPane.ERROR_MESSAGE);
//					usernameTF.setText("");
//					passwordPF.setText("");
//				}	
//			}
//		});
//		
//		loginB.addKeyListener(new KeyAdapter()
//		{
//			public void keyPressed(KeyEvent e)
//			{
//				int key = e.getKeyCode();
//				
//				if(key==KeyEvent.VK_ENTER && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
//				{
//					validateUser();
//					usernameTF.setText("");
//					passwordPF.setText("");
//				}
//				
//				else if(key==KeyEvent.VK_ENTER && getUsernameTF().getText().isEmpty() && getPasswordPF().getText().isEmpty())
//				{
//					JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
//							"Login Error", JOptionPane.ERROR_MESSAGE);
//					usernameTF.setText("");
//					passwordPF.setText("");
//				}	
//			}
//		});
	}
	
	private class LoginHandler implements ActionListener
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("Login") && !usernameTF.getText().isEmpty() && !passwordPF.getText().isEmpty())
			{
				if(usernameTF.getText().contains("admin"))
				{
					validateLoginAdmin();
					systemUI.setAdmin(true);
				}
				else
				{
					validateLoginCustomer();
					systemUI.setAdmin(false);
				}
			}
			else if(action.equals("Register"))
			{
				systemUI.showRegistration();
			}
			else
			{
				JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
						"Login Error", JOptionPane.ERROR_MESSAGE);
			}	
			
			usernameTF.setText("");
			passwordPF.setText("");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private void validateLoginAdmin()
	{
		Admin admin = new Admin();
		admin.setAdminId(usernameTF.getText());
		admin.setPassword(passwordPF.getText());
		
		if(userDAO.findAdmin(admin))
		{
//			Admin loginAdmin = new Admin();
//			loginAdmin = userDAO.getAdmin(admin);
//			userDAO = new UserDAO(systemUI.getConnection(), loginUser);

//			systemUI.showMainMenu(loginUser, userDAO);
			systemUI.showAdminMenu();

		}
		else
		{
			JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
					"Login Error", JOptionPane.ERROR_MESSAGE);
			usernameTF.setText("");
			passwordPF.setText("");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void validateLoginCustomer()
	{
		Customer customer = new Customer();
		customer.setCustomerId(usernameTF.getText());
		customer.setPassword(passwordPF.getText());
		
		if(userDAO.findCustomer(customer))
		{
			systemUI.setLoginCustomer(systemUI.getUserDAO().getCustomer(customer));
			systemUI.showCustomerMenu();
		}
		else
		{
			JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
					"Login Error", JOptionPane.ERROR_MESSAGE);
			usernameTF.setText("");
			passwordPF.setText("");
		}
	}
}

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class RegistrationUI extends JPanel
{
	/*
	 * This is where new users will
	 * register a new account.
	 * 
	 * Constraints:
	 * 	10 char max for CustomerId
	 * 	36 char max for Name
	 * 	18 char max for Password
	 * 	integer only for Age
	 * 	1 char for Gender
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JButton confirmB;
	private SystemUI systemUI;
	private JButton cancelB;
	private JTextField nameTF, usernameTF, passwordTF, ageTF, occupationTF, genderTF;
	private JLabel bgL, occupationL, nameL, usernameL, passwordL, genderL, ageL;
	private JComboBox<String> genderCB;
	
	private RegistrationHandler registrationHandler;
	
	public RegistrationUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		registrationHandler = new RegistrationHandler();
		
		this.systemUI = systemUI;
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));

		centerP = new JPanel();
		centerP.setLayout(null);
		
		confirmB = new JButton("Confirm");
		confirmB.setOpaque(false);
		confirmB.setForeground(Color.BLUE);
		confirmB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		confirmB.setContentAreaFilled(false);
		confirmB.setBounds(125, 175, 75, 25);
		centerP.add(confirmB);

		cancelB = new JButton("Cancel");
		cancelB.setOpaque(false);
		cancelB.setForeground(Color.BLUE);
		cancelB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cancelB.setContentAreaFilled(false);
		cancelB.setBounds(235, 175, 75, 25);
		centerP.add(cancelB);
		
		nameL = new JLabel("Name:");
		nameL.setHorizontalAlignment(SwingConstants.RIGHT);
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameL.setForeground(Color.BLUE);
		nameL.setBounds(27, 7, 46, 20);
		centerP.add(nameL);
		
		nameTF = new JTextField();
		nameTF.setBounds(83, 8, 357, 20);
		centerP.add(nameTF);
		nameTF.setColumns(10);
		
		usernameL = new JLabel("Username:");
		usernameL.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameL.setForeground(Color.BLUE);
		usernameL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameL.setBounds(0, 38, 73, 20);
		centerP.add(usernameL);
		
		usernameTF = new JTextField();
		usernameTF.setColumns(10);
		usernameTF.setBounds(83, 39, 357, 20);
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
				
		genderTF = new JTextField("M");
		genderTF.setColumns(10);
		genderTF.setVisible(false);
		genderTF.setBounds(325, 102, 46, 20);
		centerP.add(genderTF);
		
		genderCB = new JComboBox<String>();
		genderCB.setBounds(325, 102, 46, 20);
		genderCB.addItem("M");
		genderCB.addItem("F");
		genderCB.addItemListener (new ItemListener () {
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().toString().equals("M"))
					genderTF.setText("M");
				else
					genderTF.setText("F");
				
			}
		});
		centerP.add(genderCB);
		
		occupationTF = new JTextField();
		occupationTF.setColumns(10);
		occupationTF.setBounds(83, 134, 189, 20);
		centerP.add(occupationTF);
		
		occupationL = new JLabel("Occupation:");
		occupationL.setHorizontalAlignment(SwingConstants.RIGHT);
		occupationL.setForeground(Color.BLUE);
		occupationL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		occupationL.setBounds(0, 133, 73, 20);
		centerP.add(occupationL);
		centerP.add(bgL);
		
		bgL.setBounds(0,-80,500,500);
		
		confirmB.addActionListener(registrationHandler);
		cancelB.addActionListener(registrationHandler);
		
		validate();
		
		add(centerP);
	}
	
	private class RegistrationHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();

			if(action.equals("Confirm") && isNothingEmpty())
			{
				systemUI.getUserDAO().addCustomer(getFormList());
				emptyForms();
				systemUI.showLogin();
			}
			else if(action.equals("Cancel"))
			{
				systemUI.showLogin();
				emptyForms();
			}
			else
				JOptionPane.showMessageDialog(null,	"Fill up blank forms.",
						"Registration Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private List<String> getFormList()
	{
		List<String> formList = new ArrayList<String>();
		
		formList.add(0, usernameTF.getText());
		formList.add(1, nameTF.getText());
		formList.add(2, passwordTF.getText());
		formList.add(3, ageTF.getText());
		formList.add(4, genderTF.getText());
		formList.add(5, occupationTF.getText());
		
		return formList;
	}
	
	private boolean isNothingEmpty()
	{
		if(usernameTF.getText().trim().isEmpty() || nameTF.getText().trim().isEmpty()
				|| passwordTF.getText().trim().isEmpty() || ageTF.getText().trim().isEmpty()
				|| genderTF.getText().trim().isEmpty() || occupationTF.getText().trim().isEmpty())
			return false;
		else
			return true;
	}
	
	private void emptyForms()
	{
		usernameTF.setText("");
		nameTF.setText("");
		passwordTF.setText("");
		ageTF.setText("");
		genderTF.setText("");
		occupationTF.setText("");
	}
}

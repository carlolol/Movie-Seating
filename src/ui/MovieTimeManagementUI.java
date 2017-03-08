package ui;

import java.awt.GridLayout;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class MovieTimeManagementUI extends JPanel
{
	/*
	 * Adding and Editting of Movie
	 * Showtimes will take place here.
	 */
	private JPanel centerP;
	private JLabel titleL, bgL;
	private JButton firstB, addB, deleteB, editB, lastB, returnB;
//	private JComboBox departmentCB, jobCB;
	
//	private JTable jobHistoryT;
//	private JTable jobHistoryRowT;
//	private DefaultTableModel jobHistoryM;
//	private DefaultTableModel jobHistoryRowM;
//	private JScrollPane jobHistorySP;
//	private JScrollPane jobHistoryRowSP;
//	private TableColumn jobHistoryTC;
//	private TableColumn jobHistoryRowTC;
//	private JTableHeader jobHistoryTH;
//	private JTableHeader jobHistoryRowTH;
//	
	private SystemUI systemUI;
	
	private Boolean forRow = false;
	private Boolean addingRow = false;
	private Boolean stillAddingRow = false;
	private Boolean forEmployee = false;
	
	private Date currentDate = new Date(System.currentTimeMillis());
	private JComboBox titleCB;

	public MovieTimeManagementUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1,1));

		this.systemUI = systemUI;

		bgL = new JLabel();
		addB = new JButton("Add");
		addB.setContentAreaFilled(false);
//		deleteB = new JButton("Delete");
//		deleteB.setContentAreaFilled(false);
		editB = new JButton("Edit");
		editB.setContentAreaFilled(false);
//		lastB = new JButton(">>");
//		lastB.setContentAreaFilled(false);
		returnB = new JButton("Return");
		returnB.setContentAreaFilled(false);
		titleL = new JLabel("Title:");

		centerP = new JPanel();
		centerP.setLayout(null);
		centerP.add(titleL);
		
		titleCB = new JComboBox();
		titleCB.setBounds(58, 35, 357, 25);
		centerP.add(titleCB);
		centerP.add(addB);
//		centerP.add(deleteB);
		centerP.add(editB);
//		centerP.add(lastB);
		centerP.add(returnB);
		titleL.setBounds(210, 11, 34, 16);
		addB.setBounds(125, 177, 65, 25);
//		deleteB.setBounds(200, 177, 90, 25);
		editB.setBounds(290, 177, 65, 25);
//		lastB.setBounds(420, 177, 50, 25);
		returnB.setBounds(390, 213, 80, 25);

//		firstB.addActionListener(maintainEmployeeHandler);
//		previousB.addActionListener(maintainEmployeeHandler);
//		addB.addActionListener(maintainEmployeeHandler);
//		deleteB.addActionListener(maintainEmployeeHandler);
//		editB.addActionListener(maintainEmployeeHandler);
//		nextB.addActionListener(maintainEmployeeHandler);
//		lastB.addActionListener(maintainEmployeeHandler);
//		returnB.addActionListener(maintainEmployeeHandler);
//		
//		searchTF.addKeyListener(new KeyAdapter()
//		{
//			public void keyTyped(KeyEvent e)
//			{
//				searchEmployee();
//			}
//
//			public void keyReleased(KeyEvent e)
//			{
//				searchEmployee();
//			}
//		});


		centerP.add(bgL);
		bgL.setBounds(0,-80,500,500);
		
		add(centerP);
	}
}

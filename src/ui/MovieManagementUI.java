package ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class MovieManagementUI extends JPanel
{
	/*
	 * This class will contain the management
	 * of the movies. Functions would be Add and Edit.
	 * The admins will be the ones who can
	 * access this.
	 */
	
	private JPanel centerP;
	private JLabel searchL, titleL, genreL, durationL, ratingL, bgL;
	private JTextField searchTF, titleTF, genreTF, durationTF, ratingTF;
	private JButton firstB, previousB, addB, deleteB, editB, nextB, lastB, returnB;
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

	public MovieManagementUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1,1));

		this.systemUI = systemUI;

		bgL = new JLabel();
		
//		jobCB = new JComboBox();
//		departmentCB = new JComboBox();
		
//		firstB = new JButton("<<");
//		firstB.setContentAreaFilled(false);
		previousB = new JButton("<");
		previousB.setContentAreaFilled(false);
		addB = new JButton("Add");
		addB.setContentAreaFilled(false);
//		deleteB = new JButton("Delete");
//		deleteB.setContentAreaFilled(false);
		editB = new JButton("Edit");
		editB.setContentAreaFilled(false);
		nextB = new JButton(">");
		nextB.setContentAreaFilled(false);
//		lastB = new JButton(">>");
//		lastB.setContentAreaFilled(false);
		returnB = new JButton("Return");
		returnB.setContentAreaFilled(false);

		searchL = new JLabel("Search: ");
		titleL = new JLabel("Title:");
		genreL = new JLabel("Genre:");
		durationL = new JLabel("Duration:");
		ratingL = new JLabel("Rating:");

		searchTF = new JTextField(10);
		titleTF = new JTextField(10);
		genreTF = new JTextField(15);
		durationTF = new JTextField(15);
		ratingTF = new JTextField(15);

		centerP = new JPanel();
		centerP.setLayout(null);
		centerP.add(searchL);
		centerP.add(searchTF);
		centerP.add(titleL);
		centerP.add(titleTF);
		centerP.add(genreL);
		centerP.add(genreTF);
		centerP.add(durationL);
		centerP.add(durationTF);
		centerP.add(ratingL);
		centerP.add(ratingTF);
//		centerP.add(firstB);
		centerP.add(previousB);
		centerP.add(addB);
//		centerP.add(deleteB);
		centerP.add(editB);
		centerP.add(nextB);
//		centerP.add(lastB);
		centerP.add(returnB);
		
		searchL.setBounds(130, 10, 50, 25);
		searchTF.setBounds(180, 10, 165, 25);
		titleL.setBounds(223, 46, 34, 16);
		titleTF.setBounds(36, 62, 404, 25);
		genreL.setBounds(58, 98, 39, 25);
		genreTF.setBounds(107, 98, 130, 25);
		durationL.setBounds(269, 98, 52, 25);
		durationTF.setBounds(331, 98, 65, 25);
		ratingL.setBounds(191, 134, 39, 25);
		ratingTF.setBounds(240, 134, 50, 25);
//		firstB.setBounds(20, 177, 50, 25);
		previousB.setBounds(75, 177, 50, 25);
		addB.setBounds(130, 177, 65, 25);
//		deleteB.setBounds(200, 177, 90, 25);
		editB.setBounds(295, 177, 65, 25);
		nextB.setBounds(365, 177, 50, 25);
//		lastB.setBounds(420, 177, 50, 25);
		returnB.setBounds(396, 213, 80, 25);

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

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieManagementUI extends JPanel
{
	/*
	 * This class will contain the management
	 * of the movies. Functions would be Add and Edit.
	 * The admins will be the ones who can
	 * access this.
	 */
	
	private JPanel centerP;
	private JLabel titleL, genreL, durationL, ratingL, bgL;
	private JComboBox titleTF;
	private JTextField genreTF, durationTF, ratingTF;
	private JButton firstB, addMovieB, addTimeB, deleteB, editMovieB, editTimeB, lastB, returnB;
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
	private JTable table;

	public MovieManagementUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1,1));

		this.systemUI = systemUI;

		bgL = new JLabel();
		
//		jobCB = new JComboBox();
//		departmentCB = new JComboBox();
		
//		firstB = new JButton("<<");
//		firstB.setContentAreaFilled(false);
		addMovieB = new JButton("Add Movie");
		addMovieB.setContentAreaFilled(false);
		addTimeB = new JButton("Add Time");
		addTimeB.setContentAreaFilled(false);
//		deleteB = new JButton("Delete");
//		deleteB.setContentAreaFilled(false);
		editMovieB = new JButton("Edit Movie");
		editMovieB.setContentAreaFilled(false);
		editTimeB = new JButton("Edit TIme");
		editTimeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		editTimeB.setContentAreaFilled(false);
//		lastB = new JButton(">>");
//		lastB.setContentAreaFilled(false);
		returnB = new JButton("Return");
		returnB.setContentAreaFilled(false);
		titleL = new JLabel("Title:");
		genreL = new JLabel("Genre:");
		durationL = new JLabel("Duration:");
		ratingL = new JLabel("Rating:");
		titleTF = new JComboBox();
		genreTF = new JTextField(15);
		durationTF = new JTextField(15);
		ratingTF = new JTextField(15);

		centerP = new JPanel();
		centerP.setLayout(null);
		centerP.add(titleL);
		centerP.add(titleTF);
		centerP.add(genreL);
		centerP.add(genreTF);
		centerP.add(durationL);
		centerP.add(durationTF);
		centerP.add(ratingL);
		centerP.add(ratingTF);
		
		table = new JTable();
		table.setBounds(114, 85, 248, 132);
		centerP.add(table);
//		centerP.add(firstB);
		centerP.add(addMovieB);
		centerP.add(addTimeB);
//		centerP.add(deleteB);
		centerP.add(editMovieB);
		centerP.add(editTimeB);
//		centerP.add(lastB);
		centerP.add(returnB);
		titleL.setBounds(21, 15, 34, 16);
		titleTF.setBounds(65, 11, 404, 25);
		genreL.setBounds(31, 49, 39, 25);
		genreTF.setBounds(75, 49, 130, 25);
		durationL.setBounds(215, 49, 52, 25);
		durationTF.setBounds(277, 49, 65, 25);
		ratingL.setBounds(352, 49, 39, 25);
		ratingTF.setBounds(401, 49, 50, 25);
//		firstB.setBounds(20, 177, 50, 25);
		addMovieB.setBounds(30, 228, 95, 25);
		addTimeB.setBounds(135, 228, 97, 25);
//		deleteB.setBounds(200, 177, 90, 25);
		editMovieB.setBounds(242, 228, 100, 25);
		editTimeB.setBounds(350, 228, 101, 25);
//		lastB.setBounds(420, 177, 50, 25);
		returnB.setBounds(389, 264, 80, 25);

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

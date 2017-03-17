package dao;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportsDAO 
{
	private Connection connection;
	private JasperPrint jasperPrint;
	
	public ReportsDAO(Connection connection)
	{
		this.connection = connection;
	}
	
	public void displayAnalysis()
	{
		try
		{
			jasperPrint = JasperFillManager.fillReport("../Movie Seating/lib/reports/analysisChart.jasper", null, connection);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, "../Movie Seating/lib/reports/analysisChart.pdf");
			
			if(Desktop.isDesktopSupported()) 
			{
				try
				{
					File myFile = new File("../Movie Seating/lib/reports/analysisChart.pdf");
					Desktop.getDesktop().open(myFile);
				}
				catch(IOException ex)
				{
					System.out.println("Error occurred: " + ex.getMessage());
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
	
	public void displayReceiptAdmin(String reportFile, String movieId, String hallNo, String time)
	{
		try
		{
			Map<String, Object> paramReport = new HashMap<String, Object>();
			paramReport.put("param2", movieId);
			paramReport.put("param3", hallNo);
			paramReport.put("param4", time);

			jasperPrint = JasperFillManager.fillReport("../Movie Seating/lib/reports/receiptAdmin.jasper", paramReport, connection);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, "../Movie Seating/lib/reports/" + reportFile + ".pdf");
			
			if(Desktop.isDesktopSupported()) 
			{
				try
				{
					File myFile = new File("../Movie Seating/lib/reports/" + reportFile + ".pdf");
					Desktop.getDesktop().open(myFile);
				}
				catch(IOException ex)
				{
					System.out.println("Error occurred: " + ex.getMessage());
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
	
	public void displayReceipt(String reportFile, String customerId, String movieId, String hallNo, String time)
	{
		try
		{
			Map<String, Object> paramReport = new HashMap<String, Object>();
			paramReport.put("param", customerId);
			paramReport.put("param2", movieId);
			paramReport.put("param3", hallNo);
			paramReport.put("param4", time);

			jasperPrint = JasperFillManager.fillReport("../Movie Seating/lib/reports/receipt.jasper", paramReport, connection);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, "../Movie Seating/lib/reports/" + reportFile + ".pdf");
			
			if(Desktop.isDesktopSupported()) 
			{
				try
				{
					File myFile = new File("../Movie Seating/lib/reports/" + reportFile + ".pdf");
					Desktop.getDesktop().open(myFile);
				}
				catch(IOException ex)
				{
					System.out.println("Error occurred: " + ex.getMessage());
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
}

package com.railways.userinterface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.railways.datahandling.ApplicationDatabaseConnect;

public class TabEntryView extends UserInterfaceView
{
	public static void tabEntryViewWindow(JButton currentButton)
	{
		JFrame currentWindow = createWindow(currentButton.getName(), 815, 640);
		JPanel toolbarPanel = createPanel(10,10,780,30);
		JPanel frontBackButtonPanel = createPanel(10,50,780,30);
		JPanel tablePaginationPanel = createPanel(10,90,780,30);
		JPanel viewTablePanel = createPanel(10,120,780,250);
		setViewTablePanel(viewTablePanel);
		JPanel entryPanel = createPanel(10,380,780,215);
		addComponentsToWindow(currentWindow, toolbarPanel, frontBackButtonPanel, tablePaginationPanel, viewTablePanel, entryPanel );
		currentWindow.setLayout(null);
		currentWindow.setVisible(true);
		if(currentButton.getText().equals("Display Train"))
		{
			setViewTableLowLimit(0);
			setViewTableHighLimit(10);
			renderTableInTabEntryView(0, 10);
			renderEntryInTabEntryView(entryPanel);
		}
		
		JButton previousButton = createButton("Previous");
		JButton nextButton = createButton("Next");
		tablePaginationPanel.add(previousButton);
		tablePaginationPanel.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPageinViewTable();
			}
		});
		
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				previousPageinViewTable();
			}
		});
	}
	
	private static void renderEntryInTabEntryView(JPanel entryPanel)
	{
		JTextField trainNumber = createTextField(null);
		trainNumber.setPreferredSize(new Dimension(250,25));
		trainNumber.setEnabled(false);
		JTextField trainName = createTextField(null);
		trainName.setPreferredSize(new Dimension(250,25));
		trainName.setEnabled(false);
		JTextField trainSourceStation = createTextField(null);
		trainSourceStation.setPreferredSize(new Dimension(250,25));
		trainSourceStation.setEnabled(false);
		JTextField trainDestinationStation = createTextField(null);
		trainDestinationStation.setPreferredSize(new Dimension(250,25));
		trainDestinationStation.setEnabled(false);
		JTextField trainAvailableSeats = createTextField(null);
		trainAvailableSeats.setPreferredSize(new Dimension(250,25));
		trainAvailableSeats.setEnabled(false);
		JTextField trainIsPantryAvailable = createTextField(null);
		trainIsPantryAvailable.setPreferredSize(new Dimension(250,25));
		trainIsPantryAvailable.setEnabled(false);
		JLabel trainNumberLabel = createLabel("Train Number");
		JLabel trainNameLabel = createLabel("Train Name        ");
		JLabel trainSourceStationLabel = createLabel("Source Station");
		JLabel trainDestinationStationLabel = createLabel("Destination Station");
		JLabel trainAvailableSeatsLabel = createLabel("Available Seats");
		JLabel trainIsPantryAvailableLabel = createLabel("Pantry Availablity");
		entryPanel.add(trainNumberLabel);
		entryPanel.add(trainNumber);
		entryPanel.add(trainNameLabel);
		entryPanel.add(trainName);
		entryPanel.add(Box.createRigidArea(new Dimension(800, 25)));
		entryPanel.add(trainSourceStationLabel);
		entryPanel.add(trainSourceStation);
		entryPanel.add(trainDestinationStationLabel);
		entryPanel.add(trainDestinationStation);
		entryPanel.add(Box.createRigidArea(new Dimension(800, 25)));
		entryPanel.add(trainAvailableSeatsLabel);
		entryPanel.add(trainAvailableSeats);
		entryPanel.add(trainIsPantryAvailableLabel);
		entryPanel.add(trainIsPantryAvailable);
		setTrainNumber(trainNumber);
		setTrainName(trainName);
		setTrainSourceStation(trainSourceStation);
		setTrainDestinationStation(trainDestinationStation);
		setTrainAvailableSeats(trainAvailableSeats);
		setTrainIsPantryAvailable(trainIsPantryAvailable);
	}
	
	private static void renderTableInTabEntryView(Integer lowLimit, Integer highLimit)
	{
		getViewTablePanel().removeAll();
		getViewTablePanel().revalidate();
		getViewTablePanel().repaint();
		ResultSet resultData = ApplicationDatabaseConnect.getApplicationDatabaseConnectionObject().retrieveTrainDetailsRange(lowLimit, highLimit);
		DefaultTableModel myTableModel = new DefaultTableModel()
				{
					private static final long serialVersionUID = 1L;

					@Override 
					public boolean isCellEditable(int row,int col)
					{
						return false;
					}
				};
		JTable trainTable = new JTable(myTableModel);
		JScrollPane myScrollPane= new JScrollPane(trainTable);
		myTableModel.addColumn("Train Number");
		myTableModel.addColumn("Train Name");
		myTableModel.addColumn("Source Station");
		myTableModel.addColumn("Destination Station");
		myTableModel.addColumn("Seats Available");
		myTableModel.addColumn("Pantry Availablity");
		myScrollPane.setPreferredSize(new Dimension(770, 240));
		trainTable.setFont(new Font(myScrollPane.getFont().getFontName(),  Font.BOLD, 13));
		trainTable.getTableHeader().setFont(new Font(myScrollPane.getFont().getFontName(),  Font.BOLD, 15));
		trainTable.setRowSelectionAllowed(true);
		trainTable.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent me)
			{
				if(me.getClickCount()==2)
				{
					JTable currentTable = (JTable)me.getSource();
					Integer selectedRow = currentTable.getSelectedRow();
					getTrainNumber().setText(currentTable.getValueAt(selectedRow, 0).toString());
					getTrainName().setText((String)currentTable.getValueAt(selectedRow, 1));
					getTrainSourceStation().setText((String)currentTable.getValueAt(selectedRow, 2));
					getTrainDestinationStation().setText((String)currentTable.getValueAt(selectedRow, 3));
					getTrainAvailableSeats().setText(currentTable.getValueAt(selectedRow, 4).toString());
					getTrainIsPantryAvailable().setText(currentTable.getValueAt(selectedRow, 5).toString());
				}
			}
		});
		try 
		{
			while(resultData.next())
			{
				Integer trainNumber = resultData.getInt("train_no");
				String trainName = resultData.getString("train_name");
				String trainSourceStation = resultData.getString("train_source_station");
				String trainDestinationStation= resultData.getString("train_destination_station");
				Short trainSeatsAvailable = resultData.getShort("train_available_seats");
				Boolean trainIsPantryAvailable = resultData.getBoolean("train_is_pantry_available");
				myTableModel.addRow(new Object[] {trainNumber, trainName, trainSourceStation, trainDestinationStation, trainSeatsAvailable, trainIsPantryAvailable} );
			}
			
		} 
		catch (SQLException e) 
		{
			
		}
		
		getViewTablePanel().add(myScrollPane);
	}
	
	private static void nextPageinViewTable()
	{
		Integer lowLimit = getViewTableLowLimit();
		Integer highLimit = getViewTableHighLimit();
		Integer newLowLimit = lowLimit+highLimit;
		setViewTableLowLimit(newLowLimit);
		renderTableInTabEntryView(newLowLimit, highLimit);
	}
	
	private static void previousPageinViewTable()
	{
		Integer lowLimit = getViewTableLowLimit();
		Integer highLimit = getViewTableHighLimit();
		Integer newLowLimit = lowLimit-highLimit;
		setViewTableLowLimit(newLowLimit);
		renderTableInTabEntryView(newLowLimit, highLimit);
	}
}

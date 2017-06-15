import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StaffDisplay extends JFrame{

	
//Private Data Members----------------------------------------------------------------------------------------Private Data Members
	
	//Database items
	private StaffQueries staff;
	private List<Staff> results;
	private int numberOfEntries;
	private int currentEntryIndex;
	private Staff currentStaff;
	
	//Navigation Panel
	private JPanel naviPanel;
	private JButton previousBtn;
	private JLabel recordLbl;
	private JTextField recordTextField;
	private JLabel ofLbl;
	private JTextField maxRecordTextField;
	private JButton nextBtn;
	
	//Details Panel
	private JPanel detailsPanel;
	private JLabel staffIDLbl;
	private JTextField staffIDTextField;
	private JLabel firstNameLbl;
	private JTextField firstNameTextField;
	private JLabel lastNameLbl;
	private JTextField lastNameTextField;
	private JLabel dobLbl;
	private JTextField dobTextField;
	private JLabel deptLbl;
	private JTextField deptTextField;
	private JLabel salaryLbl;
	private JTextField salaryTextField;
	private JLabel startDateLbl;
	private JTextField startDateTextField;
	private JLabel fullTimeLbl;
	private JTextField fullTimeTextField;

	//Search Panel
	private JPanel searchPanel;
	private JLabel searchFirstNameLbl;
	private JTextField searchFirstNameTextField;
	private JLabel searchLastNameLbl;
	private JTextField searchLastNameTextField;
	private JLabel searchDeptLbl;
	private JTextField searchDeptTextField;
	private JLabel blankLbl;
	private JButton searchBtn;
	
	//Extra Buttons
	private JButton viewAllBtn;
	private JButton insertBtn;
	private JButton saveBtn;
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------
	
	public StaffDisplay(){
		
		
//Set Layout--------------------------------------------------------------------------------------------------Set Layout
		
		super ("Staff");
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));		
		
//Connect to Database-----------------------------------------------------------------------------------------Connect to Database
		
		staff = new StaffQueries();
		
//Navigation Panel--------------------------------------------------------------------------------------------Navigation Panel
	
		//Initialise items for NaviPanel
		naviPanel = new JPanel();
		previousBtn = new JButton("Previous");
		recordLbl = new JLabel("Record");
		recordTextField = new JTextField(2);
		ofLbl = new JLabel("of");
		maxRecordTextField = new JTextField(2);
		maxRecordTextField.setEditable(false);
		nextBtn = new JButton ("Next");
		
		//Set Layout for NaviPanel
		naviPanel.setLayout(new BoxLayout(naviPanel, BoxLayout.X_AXIS));
		naviPanel.setBorder(BorderFactory.createTitledBorder("Staff Navigation"));
		
		//add items to panel
		naviPanel.add(Box.createVerticalStrut(30));
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(previousBtn);
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(recordLbl);
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(recordTextField);
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(ofLbl);
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(maxRecordTextField);
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(nextBtn);
		naviPanel.add(Box.createHorizontalStrut(10));
		naviPanel.add(Box.createVerticalStrut(30));
		
		//add panel to JFrame
		add(naviPanel);
		
		//add button listeners
		nextBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				NextBtnPressed(e);
				
			}
			
			
		});
		
		
//Details Panel------------------------------------------------------------------------------------------------ Details Panel
		
		//initialise items for DisplayPanel
		detailsPanel = new JPanel();
		staffIDLbl = new JLabel("Staff ID:");
		staffIDTextField = new JTextField(14);
		staffIDTextField.setEditable(false);
		firstNameLbl = new JLabel("First Name:");
		firstNameTextField = new JTextField(14);
		lastNameLbl = new JLabel("Last Name:");
		lastNameTextField = new JTextField(14);
		dobLbl = new JLabel("Date of Birth:");
		dobTextField = new JTextField(14);
		deptLbl = new JLabel("Department:");
		deptTextField = new JTextField(14);
		salaryLbl = new JLabel("Salary:");
		salaryTextField = new JTextField(14);
		startDateLbl = new JLabel("Start Date:");
		startDateTextField = new JTextField(14);
		fullTimeLbl = new JLabel("Full Time:");
		fullTimeTextField = new JTextField(14);
		
		//set Layout
		detailsPanel.setLayout(new GridLayout(8,2,5,5));
		detailsPanel.setBorder(BorderFactory.createTitledBorder("Staff Details"));
		
		//add items to panel
		detailsPanel.add(staffIDLbl);
		detailsPanel.add(staffIDTextField);
		detailsPanel.add(firstNameLbl);
		detailsPanel.add(firstNameTextField);
		detailsPanel.add(lastNameLbl);
		detailsPanel.add(lastNameTextField);
		detailsPanel.add(dobLbl);
		detailsPanel.add(dobTextField);
		detailsPanel.add(deptLbl);
		detailsPanel.add(deptTextField);
		detailsPanel.add(salaryLbl);
		detailsPanel.add(salaryTextField);
		detailsPanel.add(startDateLbl);
		detailsPanel.add(startDateTextField);
		detailsPanel.add(fullTimeLbl);
		detailsPanel.add(fullTimeTextField);
		
		//add panel to JFrame
		add(detailsPanel);
		
//Search Panel------------------------------------------------------------------------------------------------Search Panel
		
		//Initialise items
		
		searchPanel = new JPanel();
		searchFirstNameLbl = new JLabel("First Name:");
		searchFirstNameTextField = new JTextField(14);
		searchLastNameLbl = new JLabel("Last Name:");
		searchLastNameTextField = new JTextField(14);
		searchDeptLbl = new JLabel("Department:");
		searchDeptTextField = new JTextField(14);
		blankLbl = new JLabel();
		searchBtn = new JButton("Search");
		
		//set Layout
		
		searchPanel.setLayout(new GridLayout(4,2,5,5));
		searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
		
		//add items to Layout
		searchPanel.add(searchFirstNameLbl);
		searchPanel.add(searchFirstNameTextField);
		searchPanel.add(searchLastNameLbl);
		searchPanel.add(searchLastNameTextField);
		searchPanel.add(searchDeptLbl);
		searchPanel.add(searchDeptTextField);
		searchPanel.add(blankLbl);
		searchPanel.add(searchBtn);
		
		//add panel to JFrame
		add(searchPanel);
		
//Extra Buttons -------------------------------------------------------------------------------------------- Extra Buttons
		
		//initialise items
		viewAllBtn = new JButton("View All");
		insertBtn = new JButton("Insert");
		saveBtn = new JButton("Save");
		
		add(viewAllBtn);
		add(insertBtn);
		add(saveBtn);
		

//Display All Staff ---------------------------------------------------------------------------------------Display All Results
		
		results = staff.getAllStaff();
		numberOfEntries = results.size();
		
		try{
			if(numberOfEntries != 0){
				
				currentEntryIndex = 0;
				currentStaff = results.get(currentEntryIndex);
				
				recordTextField.setText((currentEntryIndex + 1) + "");
				maxRecordTextField.setText(numberOfEntries + "");
				
				staffDisplay(currentStaff);		
			}

		}catch (Exception ex){
			ex.printStackTrace();
		}
		

	}

//NextBtnPressed ------------------------------------------------------------------------------------------------------NetBtnPressed
	public void NextBtnPressed (ActionEvent e){
			
			currentEntryIndex = Integer.parseInt(recordTextField.getText()) ;
			
			System.out.println(currentEntryIndex);
			System.out.println(numberOfEntries);
			
			if(currentEntryIndex < numberOfEntries){
				recordTextField.setText((currentEntryIndex + 1) + "");
		
				RecordIndexChanged(e);
			}	
		
	}
	

//Record Index Changed ----------------------------------------------------------------------------------------- Record Index Changed
	public void RecordIndexChanged (ActionEvent e){
		
		try{
			
			currentEntryIndex = Integer.parseInt(recordTextField.getText()) -1 ;
			
			if(numberOfEntries !=0 && currentEntryIndex <= numberOfEntries){
				
				currentStaff = results.get(currentEntryIndex);
				staffDisplay(currentStaff);
				
			}
			
		}catch (Exception ex){
			
		}

		
	}
	

	
//Display Method ------------------------------------------------------------------------------------------------------------- Display Method
	public void staffDisplay(Staff currentStaff){
		
		staffIDTextField.setText(currentStaff.getStaffID()+"");
		firstNameTextField.setText(currentStaff.getFirstName());
		lastNameTextField.setText(currentStaff.getLastName());
		dobTextField.setText(currentStaff.getDOB()+"");
		deptTextField.setText(currentStaff.getDept());
		salaryTextField.setText("€ " + currentStaff.getSalary());
		startDateTextField.setText(currentStaff.getStartDate() +"");
		
		if(currentStaff.getFullTime().equalsIgnoreCase("y")){
			fullTimeTextField.setText("Permanent");
		}else{
			fullTimeTextField.setText("Temporary");
		}
		
		
	}
	
	
	
	
}

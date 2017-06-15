import java.util.Date;

public class Staff {
	
	private int staffID;
	private String firstName;
	private String lastName;
	private Date dob;
	private String dept;
	private double salary;
	private Date startDate;
	//private boolean fullTime;
	private String fullTime;
	
//Constructors-----------------------------------------------------------------------------------------------------------Constructors
	
	//Empty Constructor
	public Staff(){};
	
	//Constructor
	public Staff(int id, String fn, String ln, Date dob, String d, double s, Date sd, String ft){
		
		setStaffID(id);
		setFirstName(fn);
		setLastName(ln);
		setDOB(dob);
		setDept(d);
		setSalary(s);
		setStartDate(sd);
		setFullTime(ft);
		
	}
	
//Setters-----------------------------------------------------------------------------------------------------------------Setters
	
	public void setStaffID(int id){
		staffID = id;
	}
	
	public void setFirstName(String fn){
		firstName = fn;
	}
	
	public void setLastName(String ln){
		lastName = ln;
	}
	
	public void setDOB(Date db){
		dob = db;
		
		//convert to string??
	}
	
	public void setDept(String d){
		dept = d;
	}
	
	public void setSalary(Double s){
		salary = s;
	}
	
	public void setStartDate(Date sd){
		startDate = sd;
	}
	
	public void setFullTime(String ft){
		fullTime = ft;
	}
	
//Getters-----------------------------------------------------------------------------------------------------------------Getters
	
	public int getStaffID(){
		return staffID;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public Date getDOB(){
		return dob;
	}
	
	public String getDept(){
		return dept;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	
	public String getFullTime(){
		return fullTime;
	}
	
//toString--------------------------------------------------------------------------------------------------------------toString
	
	@Override
	public String toString(){
		
		String s = String.format("Staff ID: %d\n", getStaffID());
			s+= String.format("First Name: %s\n", getFirstName());
			s+= String.format("Last Name: %s\n", getLastName());
			s+= String.format("Date of Birth: %td/&tm/%ty\n", getDOB());
			s+= String.format("Department: %s\n", getDept());
			s+= String.format("Salary: %.2f\n", getSalary());
			s+= String.format("Start Date: %td/%tm/%tyyyy\n", getStartDate());
			s+= String.format("Full Time: %b\n", getFullTime());
		
		return s;
		
	}


	
	
}

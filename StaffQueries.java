import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class StaffQueries {

	
//Private Data Members--------------------------------------------------------------------------------------------private data members
	
	//connet to datbase
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";	
	private static final String USERNAME = "SYSTEM";
	private static final String PASSWORD = "Passw0rd";
	private Connection conn;
	
	//prepared statements
	private PreparedStatement displayAll;
	
	public StaffQueries(){
		
		try{
			//load Oracle drivers
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drivers Loaded ok");
			
			//connect to data base
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected OK");
	
			//create prepared statements
			String sql1 = "SELECT * FROM Staff";
			displayAll = conn.prepareStatement(sql1);
			
			
		
		}catch(Exception e){
			System.out.println("Error");
			e.printStackTrace();	
			System.exit(2);
		}
		
	}
		
	
//Get All Staff----------------------------------------------------------------------------------------------------Get All Staff
		public List<Staff> getAllStaff(){
			
			List<Staff> staff = null;
			ResultSet rs = null;
			

			//System.out.println(staff);
			
			try{
				
				rs = displayAll.executeQuery();	
				staff = new ArrayList <Staff>();
				
				while(rs.next()){
					
					staff.add(new Staff(rs.getInt("StaffID"), 
							rs.getString("FirstName"),
							rs.getString("LastName"),
							rs.getDate("DOB"),
							rs.getString("Department"),
							rs.getDouble("Salary"),
							rs.getDate("StartDate"),
							rs.getString("FullTime")));
					
					//System.out.println(staff);
					
				}
					
			}catch(SQLException e){
				System.out.println("SHOOT!!");
				e.printStackTrace();
			}
			
			//System.out.println(staff);

			return staff;
			
		}
		
//------------------------------------------------------------------------------------------------------------------------
		
		
		
		

		
		
		
	
	
}

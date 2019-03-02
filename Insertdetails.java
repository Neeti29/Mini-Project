package Project;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;


public class Insertdetails extends Createconnection
{
	PreparedStatement pstm;
	
	public void insertDetails()  throws Exception
	{
		try
		{
			String query = " insert into Employee (First_Name, Last_Name, DOB, Gender, Email_Id, Phone_Number, Address, Salary, Resume)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
			// create the mysql insert preparedstatement
			
		      pstm = con.prepareStatement(query);
		      
		      pstm.setString (1, "Bharti");
		      pstm.setString (2, "Bauhara");
		      pstm.setDate(3, java.sql.Date.valueOf("2013-09-04"));
		      pstm.setString(4,"Female");
		      pstm.setString(5, "bharti@gmail.com");
		      pstm.setString (6, "8765678976");
		      pstm.setString (7, "house no-50,new delhi");
		      pstm.setInt(8,60000); 
		      File file = new File("johndoe_resume.pdf");
	          FileInputStream input = new FileInputStream(file);
	 
	            // set parameters
	            pstm.setBinaryStream(1, input);

		      // execute the preparedstatement
		      pstm.execute();
		      
		      con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}

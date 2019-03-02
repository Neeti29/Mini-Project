package Project;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetchdata {

	Connection con;
	Statement stmt;
	ResultSet rs;
	
	Fetchdata()
	{
		
	}

	
	 
	public void readEmployeeDetails(int E_Id)
	{
		/*try
		{
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("Select * from Employee e inner join department d where e.E_Id=d.D_Id");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " + rs.getString(3) + " " + rs.getDate(4) + " "+ rs.getCharacterStream(5) + " "+rs.getString(6)+ " " +rs.getString(7)+ " "+ rs.getString(8)+ " "+rs.getInt(9)+ " "+rs.getBlob(10));   
				
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}*/
		
		String query = "{ call Employee(?) }";

		try {
			CallableStatement stmt = con.prepareCall(query);
			stmt.setInt(1, E_Id);
			rs = stmt.executeQuery();
			while (rs.next()) {

				System.out.println(String.format("%s - %s",
						rs.getInt(E_Id)+ " " +rs.getString("First_Name")+ " " + rs.getString("Last_Name") + " " + rs.getDate("DOB") + " "+ rs.getString("Gender") + " "+rs.getString("Email_Id")+ " " +rs.getString("Phone_Number")+ " "+ rs.getString("Address")+ " "+rs.getInt("Salary")+ " "+rs.getBlob("Resume")));
			}
		}

		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
	

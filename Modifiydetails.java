package Project;
import java.sql.Statement;


public class Modifiydetails extends Createconnection 
{
	Statement stmt;
	
	void modifications() throws Exception
	{
		stmt = con.createStatement();
		con.setAutoCommit(false);
		
		try
		{
			
			int i2= stmt.executeUpdate("Update Department set Dept_Name= 'Development' where D_Id=1");
			
			int i3= stmt.executeUpdate("Delete from Project where D_Id = 2");
			
			con.commit();
			
			System.out.println(" Success !!");
			
		}
		catch(Exception e)
		{
			
			try
			{
				con.rollback();
				System.out.println(" Failed,please try again !");
			}
			
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		
		stmt.close();
		con.close();
		System.out.println("Connection is closed");
		
	}
	
}


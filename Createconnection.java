package Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Createconnection {
	Connection con;
	
		void createConnection()
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // cj is a latest driver //loading and registering the driver
				con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc", "root", "connection");
			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
	}


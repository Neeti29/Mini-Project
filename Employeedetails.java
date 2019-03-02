package Project;

import java.sql.Connection;

public class Employeedetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Createconnection cObj=new Createconnection();
		cObj.createConnection();
		
		Fetchdata fObj=new Fetchdata();
		fObj.readEmployeeDetails(3);
		
		Modifiydetails mObj=new Modifiydetails();
		mObj.modifications();
		
		Insertdetails iObj=new Insertdetails();
		iObj.insertDetails();
		
	}

}

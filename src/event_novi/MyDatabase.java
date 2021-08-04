package event_novi;


import java.sql.Connection;
import java.sql.DriverManager;

public class MyDatabase {
	String url="jdbc:sqlserver://DESKTOP-RAIG008\\SQLEXPRESS01;DatabaseName=master;integratedSecurity=true";
	
	String username="root";
	String password="MYsql_posvecenost2021";
	String url1="jdbc:mysql://localhost:3306/event_database";
	public void createDatabase(){
	
		try {
			System.out.println("Connecting to database: "+ url1);
			Connection  myconn=DriverManager.getConnection(url1, username, password);
			System.out.println("Connection succesful");
			
		}catch(Exception e) {
			e.printStackTrace();}
	}

}

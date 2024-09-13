package project;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

	static Connection con; 

	public static Connection getConnection()
     {
       try {

            String mysqlJDBCDriver= "com.mysql.cj.jdbc.Driver"; 

			String url= "jdbc:mysql://localhost:3306/epreparationsystem"; 

			String user = "root";	 

			String password = "12345"; 

			Class.forName(mysqlJDBCDriver);

			con = DriverManager.getConnection(url, user, password);

		}
         catch (Exception e) {

			System.out.println("Connection Failed!");

		}
   return con;

	}

}

// import java.sql.*;

// public class connection {

//     private static final String url="jdbc:mysql://localhost:3306/E_preparation_system";

//     private static final String User="root";

//     private static final String password="1234";

//     public static Connection getconnection(){

//         Connection con=null;

//         try{

//         con=DriverManager.getConnection(url,User,password);

//             System.out.println("Connected to the database!");

//     }

//     catch(SQLException e){

//         e.printStackTrace();

//     }

//     return con;

// }

//     public static Connection getConnection() {




//         throw new UnsupportedOperationException("Unimplemented method 'getConnection'");

//     }

// }

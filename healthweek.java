package Health;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Finance.weeklydata;

public class healthweek
{
	public void disp()throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/finance and health", "root", "");
		Statement stmt = null;
		String query = "SELECT * FROM health WHERE `Date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE( )";
		
		
		System.out.println("\n\nData for this week");
		System.out.println("\t\t*********************************\n");
		
		 try {
		        stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	double w = rs.getDouble("Weight");
		            double h = rs.getDouble("Height");
		            double bmi = rs.getDouble("BMI");
		            double cal = rs.getDouble("Calories_consume");
		            Date d = rs.getDate("Date");
		            
		            System.out.println("Date:" + "\t" + d + "\nWeight:" + "\t" + w + "\nHeight:\t" + h + "\nBMI:\t" + bmi + "\nCalories Consume:\t" + cal + "\n");
		        	
		        }
		    } catch (SQLException e ) {
		        healthweek.printSQLException(e);
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
	}

	private static void printSQLException(SQLException e)
	{
		// TODO Auto-generated method stub
		
	}
}


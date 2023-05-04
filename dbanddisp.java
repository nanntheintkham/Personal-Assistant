package Finance;

import java.sql.*;
import java.util.*;

public class dbanddisp extends tax
{
	double usedamt;

	dbanddisp(double income, int c, double amt)
	{
		super(income, c);
		amt = usedamt;
	}

	public dbanddisp()
	{
		// TODO Auto-generated constructor stub
	}

	public void remainCalc(int c) throws SQLException, ClassNotFoundException
	{
		tax t = new tax();
		dbanddisp d = new dbanddisp();
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/finance and health", "root", "");
		System.out.println("Finance Manager");

		Scanner s = new Scanner(System.in);
	
		System.out.print("Enter the amounts you have used: ");
		usedamt = s.nextDouble();
		//System.out.println(t.c);
		Statement st = connection.createStatement();
		if (c == 0)
		{
			String sql = "UPDATE finance SET Daily_Costs = ? WHERE Date = CURRENT_DATE()";
			PreparedStatement pstatement = connection.prepareStatement(sql);

			pstatement.setDouble(1, usedamt);
			pstatement.executeUpdate();
			

			sql = "UPDATE finance SET Balance = Income WHERE Date = CURRENT_DATE()";
			pstatement.executeUpdate(sql);
		}

		else
		{
			String sql = "INSERT INTO finance (Daily_Costs) VALUES (?)";
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setDouble(1, usedamt);
			pstatement.executeUpdate();
			
			sql = "UPDATE finance SET Income = (SELECT Income FROM finance WHERE Date = DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY)) WHERE Date = CURRENT_DATE()";
			pstatement.executeUpdate(sql);
						
			sql = "UPDATE finance SET Balance = (SELECT Remained_Bal FROM finance WHERE Date = DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY)) WHERE Date = CURRENT_DATE()";
			pstatement.executeUpdate(sql);
			
		}

		String sql = "UPDATE finance SET Remained_Bal = (SELECT Balance - Daily_Costs) WHERE Date = CURRENT_DATE()";
		st.executeUpdate(sql);

		String query = "SELECT Income FROM finance";
		ResultSet rs = st.executeQuery(query);
		while (rs.next())
			income = rs.getDouble("Income");
		//System.out.println(re);
		d.expenseCal(income, usedamt);
		connection.close();
	}

	void expenseCal(double income, double expe)
	{
		double warning = (income * 0.7) / 30;
		if (expe > warning)
			System.out.println("Oh no!!! You're spending too much..");
		else
		{
			System.out.println("Good Job! You're spending okay");
			System.out.println(warning);
		}
	}
}

package Finance;

import java.sql.*;
import java.util.*;
import java.util.Date;

//import com.mysql.cj.protocol.Warning;

public class tax
{
	public double income;
	double tax;
	public int c = 1;

	public tax(double inco, int co)
	{
		inco = income;
		co = c;
	}

	public tax()
	{
		// TODO Auto-generated constructor stub
	}

	public double taxCal(double income)
	{
		if (income < 170000)
			tax = 0;
		else if (income < 416666 && income > 170001)
			tax = income * 0.05;
		else if (income < 833333.33 && income > 416667)
			tax = income * 0.1;
		else if (income < 1666666.67 && income > 833334.33)
			tax = income * 0.15;
		else if (income < 2500000 && income > 1666667.67)
			tax = income * 0.2;
		else
			tax = income * 0.3;

		return tax;
	}

	public int getC()
	{
		return c;
	}

	public void setC(int c)
	{
		this.c = c;
	}

	public void incomeip() throws SQLException, ClassNotFoundException
	{
		Scanner s = new Scanner(System.in);
		fmain ff = new fmain();

		Date today = Calendar.getInstance().getTime();
		if (getFirstDateOfMonth(new Date()) == today)
			c = 0;
		else
		{
			System.out.println("Update the Income?? (y/n) ");
			char ch = s.next().charAt(0);

			if (ch == 'y')
				c = 0;
			else
			{
				c++;
				ff.ffmain();
			}
		}

		if (c == 0)
		{
			System.out.print("Enter Your Income: ");

			income = s.nextDouble();

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/finance and health", "root", "");
			String sql = "INSERT INTO finance (Income) VALUES (?)";
			PreparedStatement pstatement = connection.prepareStatement(sql);

			pstatement.setDouble(1, income);
			pstatement.executeUpdate();
			// s.close();
		}
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

	public static Date getFirstDateOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

}
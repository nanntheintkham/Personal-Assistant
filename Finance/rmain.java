package Finance;

import java.sql.SQLException;
import java.util.Scanner;
import Health.mmain;

public class rmain
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		fmain ff = new fmain();
		mmain hh = new mmain();
		System.out.println("Welcome to 'Your Personal Assistant'");
		System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("What would you like us to do for you: ");
		System.out.println("\n1. Finance Manager\n2. Personal Health Care\n3.Exit");
		Scanner s = new Scanner(System.in);
		int ch = s.nextInt();
		
		if(ch ==1)
			ff.ffmain();
		else if(ch == 2)
			hh.hmain();
		else
			System.exit(0);
		s.close();
	}
}

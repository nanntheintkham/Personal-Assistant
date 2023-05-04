package Finance;

import Finance.dbanddisp;

import java.sql.SQLException;
import java.util.*;

public class fmain
{
	int ch;
	private rmain rmain;

	public void ffmain() throws ClassNotFoundException, SQLException
	{
		Finance.tax t1 = new Finance.tax();
		dbanddisp d1 = new dbanddisp();
		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to Finance Manager..\nI'm here to help you with your finance management!");
		System.out.println("\t\t*******************\n");
		char ans;
		do
		{
			System.out.println("1. Calculation of tax you have to pay");
			System.out.println("2. Finance Manager");
			System.out.println("3. About the software");
			System.out.println("Enter your choice: ");

			ch = s.nextInt();

			switch(ch)
			{
			case 1: 
				{
					t1.incomeip();
					System.out.println("You need to pay: " + t1.taxCal(t1.income));
				}
				break;	

			case 2:
				{
					d1.remainCalc(t1.c);

				}
				break;
			
			case 3:
				rmain.main(null);
				break;
			}
			
			System.out.println("Menu again?(y/n) ");
			ans = s.next().charAt(0);
			t1.c = 0;
		} while(ans != 'n');
		 //s.close();
	}

}

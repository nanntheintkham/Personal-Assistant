package Health;

import java.util.*;

import Finance.rmain;

import java.sql.*;
import Finance.*;
public class mmain
{
	private static char yesno1;// ********
	//private static int i;

	public void hmain() throws SQLException, ClassNotFoundException
	{
		rmain r = new rmain();
		Health.healthweek hw = new Health.healthweek();
		double cal = 0;
		double w;
		double h;
		String g;
		int a, choice1;
		System.out.println("----------------------------------------------------");
		System.out.println("                Health Care");
		System.out.println("----------------------------------------------------");
		System.out.println("Your Gender : male/female");
		System.out.print("Choice:  ");
		Scanner mf = new Scanner(System.in);
		g = mf.nextLine();

		System.out.print("Enter your age: ");
		a = mf.nextInt();
		System.out.println("----------------------------------------------------");
		System.out.println("");
		System.out.println("Enter your Weight and Height pls,");
		System.out.println("");
		System.out.print("Enter Your Weight in Pounds:  ");
		w = mf.nextDouble();
		System.out.print("Enter Your Height in Inches: ");
		h = mf.nextDouble();
		System.out.println("");
		do
		{
			System.out.println("....................................");
			System.out.println("                 Menu        ");
			System.out.println("....................................");
			System.out.println("  1.BMI             2.DailyCalories		    3.Main Menu");
			System.out.print("Pls Choose a number: ");
			choice1 = mf.nextInt();
			System.out.println("");
			switch(choice1)
			{
				case 1:
				{
				bmi bmi = new bmi();
				bmi.calculatebmi(w, h);
				}
				break;

				case 2:
				{
				Input input1 = new Input();
				cal = input1.calories(w, h, a, g);
				System.out.println("Your Total Calories: " + cal);
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/finance and health", "root", "");
				String sql = "UPDATE health SET Calories_consume = ? WHERE Date = CURRENT_DATE()";
				PreparedStatement pstatement = connection.prepareStatement(sql);
				
				pstatement.setDouble(1, cal);
				pstatement.executeUpdate();
				connection.close();
				} 
				break;
				
				case 3:
				{
					rmain.main(null);
				}
				break;
				
				case 4:
				{
					hw.disp();
				}
				break;
				
				/*default:
				{
				System.out.println("Try Again.");
				continue;
				}*/
			}
			System.out.println("Menu again? :y/n");
			System.out.print("Choice:");
			yesno1 = mf.next().charAt(0);
			//i++;
		} while (yesno1 != 'n');
		
		mf.close();
	}
}

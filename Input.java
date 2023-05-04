package Health;

import java.util.*;

public class Input
{
	int choice2;
	double calories;
	double BMR;
	private char calc1;

	double calories(double weight, double height, int age, String gender)
	{
		Scanner s = new Scanner(System.in);

		do
		{
			System.out.println("---------------------------------------------------------------------");
			System.out.println("                        Choose the Categories");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("        1.Rice   2.DiaryProduct   3.Grain    4.Meat     5.Fastfood");

			System.out.print("Choice: ");

			choice2 = s.nextInt();

			switch (choice2)
			{
				case 1:
				{
					RiceDairy ricedairy = new RiceDairy();
					ricedairy.rice();
					calories += ricedairy.ricedairycalories;

				}
					break;
				case 2:
				{
					RiceDairy ricedairy = new RiceDairy();
					ricedairy.dairyproduct();
					calories += ricedairy.ricedairycalories;

				}
					break;
				case 3:
				{
					GrainandFastfood grainfastfood = new GrainandFastfood();
					grainfastfood.grain();
					calories += grainfastfood.grainfastfoodcalories;
				}
					break;
				case 4:
				{
					Meat meat = new Meat();
					meat.meat();
					calories += meat.meatcalories;
				}
					break;
				case 5:
				{
					GrainandFastfood grainfastfood = new GrainandFastfood();
					grainfastfood.fastfood();
					calories += grainfastfood.grainfastfoodcalories;
				}
					break;
			}
			System.out.println("Calories Menu again? :y/n");
			System.out.print("Choice: ");
			calc1 = s.next().charAt(0);

		} while (calc1 != 'n');

		if (gender.equalsIgnoreCase("male"))
		{
			BMR = (((4.536 * weight) + (15.88 * height)) - (5 * age)) + 5;

		} else
		{
			BMR = (((4.536 * weight) + (15.88 * height)) - (5 * age)) - 161;

		}

		System.out.println("..............Choose your exercise activity(num only).................");
		System.out.println("1.No exercise   2.1-3 days a week   3.3-5 days a week ");
		System.out.println("4.6-7 days a week        5.2x Training ");
		System.out.print("Choice: ");
		int check1 = s.nextInt();

		if (check1 == 1)
		{

			System.out.println("Calories you need: " + (BMR * 1.2));

		}

		if (check1 == 2)
		{

			System.out.println("Calories you need: " + (BMR * 1.375));

		}
		if (check1 == 3)
		{

			System.out.println("Calories you need: " + (BMR * 1.55));

		}

		if (check1 == 4)
		{

			System.out.println("Calories you need: " + (BMR * 1.725));

		}

		if (check1 == 5)
		{

			System.out.println("Calories you need: " + (BMR * 1.9));

		}

		return calories;

	}
}

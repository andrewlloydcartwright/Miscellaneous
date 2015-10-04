/* The purpose of this program is to test the true randomness
 * of Java's provided "util.Random" class. If given an odd
 * number of coin flips, the program will round up to the
 * nearest even number to ensure that both "heads" and "tails"
 * have an equal opportunity.
 *
 * The largest number this program will handle is 2,147,483,647 -
 * the maximum regular Integer size defined by Java.
 */

import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class CoinFlipper
{
	public static void main(String[] args)
	{

		Scanner s = new Scanner(System.in);

		while (true)
		{
		int flips;

		System.out.print("How many times would you like to flip a coin?\t");
		flips = s.nextInt();

		flipCoin(flips);
		}
	}

	public static void flipCoin(int tosses)
	{
		DecimalFormat f = new DecimalFormat("#,##0");
		DecimalFormat g = new DecimalFormat("0.00000000");
		int heads = 0, tails = 0;

		if (tosses % 2 != 0)
			tosses += 1;

		long start = System.currentTimeMillis();

		for(int i = 0; i < tosses; i++)
		{
			Random rand = new Random();
			double randomNum = rand. nextDouble();

			if (randomNum >= 0.5)
				heads += 1;
			else
				tails += 1;
		}

		long stop = System.currentTimeMillis();

		double hRatio = (heads/(tosses/2.0));
		double tRatio = (tails/(tosses/2.0));

		System.out.println("\n\nTOTAL FLIPS:\n-----------\n" + f.format(tosses));
		System.out.println("\nFLIP TOTALS\n-----------\nHeads:\t" + f.format(heads) + "\nTails:\t" + f.format(tails)
							+ "\n\nFLIP RATIOS\n-----------\nHeads\t    :\t  Tails\n" + g.format(hRatio) + "  :  " + g.format(tRatio) + "\n\n");
		if ((stop-start) < 1000)
			System.out.println("Elapsed time:\t" + (f.format((stop - start))) + " milliseconds.\n");
		else
			System.out.println("Elapsed time:\t" + (f.format((stop - start)/1000)) + " seconds.\n");
	}
}
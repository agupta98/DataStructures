import java.text.DecimalFormat;
import java.util.*;

public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		double distance;
		/*
		 * Miles Travelled 
		 */
		System.out.println("Miles Travelled");
		distance = sc.nextDouble();
		double fuelConsumed;
		/*
		 * Fuel Consumed
		 */
		System.out.println("Gallons of fuel consumed");
		fuelConsumed = sc.nextDouble();
		double mpg = distance / fuelConsumed;
		/* To calculate average upto two decimal places
		 * 
		 */
		DecimalFormat df = new DecimalFormat("#.##");
		float milege = Float.valueOf(df.format(mpg));
		System.out.println("Average MPG: "+milege);
		

	}

}

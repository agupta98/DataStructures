import java.util.Scanner;

public class JacobstalNumber {
	
	final String MESSAGE_1 = "The elapsed time was ";

	final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

	final String MESSAGE_2 = " seconds.";
	long startTime,finishTime,elapsedTime;
	
	final static  long MAX_VALUE =100;
	final static String ERROR_MESSAGE = "\nThe number entered must be " +
			 "greater than 0 and at most " + MAX_VALUE + ".";
	public static void main(String[] args){
		new JacobstalNumber().run();
	}
	
	
	public void run(){
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the nth value");
		int n = sc.nextInt();
		System.out.println("Long recursive version");
		startTime = System.nanoTime();
		for (int i =0; i< n;i++){
			
			System.out.print(f(i) + " ");
			
		}
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println();
		System.out.println ("Long Recursive Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		System.out.println();
		
		System.out.println("Iterative Version");
		startTime = System.nanoTime();
		for(int i=0;i < n;i++){
			
			System.out.print(iterativeJN(i) + " ");
		}
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println();
		System.out.println ("Iterative Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		System.out.println();
		
		System.out.println("ClosedForm Verson");
		startTime = System.nanoTime();
		for(int i=0;i < n;i++){
			//System.out.println(i);
			System.out.print(mJN(i) + " ");
		}
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println();
		System.out.println ("Closed Form Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		System.out.println();
		
		
	}

	
	public static long f (int n)  
	   {
		   
		   
		   if (n < 0 || n > MAX_VALUE)
			   throw new IllegalArgumentException (ERROR_MESSAGE);
		   if (n == 0)
			   return 0;
	       if (n <= 2 )
	           return 1;
	       return f (n - 1) + 2 *f(n-2);
	   } 
	
public static long iterativeJN(int n){
		
		final int MAX_N = 92;
		   final String ERROR_MESSAGE = "\nThe number entered must be " +
					 "greater than 0 and at most " + MAX_N + ".";
		   
		   if (n < 0 || n > MAX_N){
			   throw new IllegalArgumentException (ERROR_MESSAGE);
		   }
		
		if (n == 0){
			return 0;
		}
		if (n <=2){
			return 1;
		}
		
		long f_s=1,s=1;
		for (int i =3;i<=n;i++){
			long temp = 2*f_s + s;
			f_s =s;
			s = temp;
			
		}
		return s;
	}

public static long mJN(int n){
	
	final int MAX_N = 92;
	   final String ERROR_MESSAGE = "\nThe number entered must be " +
				 "greater than 0 and at most " + MAX_N + ".";
	   
	   if (n < 0 || n > MAX_N){
		   throw new IllegalArgumentException (ERROR_MESSAGE);
	   }
	  return (long)(((Math.pow(2, n)) - (Math.pow(-1,n)))/3);
}
}

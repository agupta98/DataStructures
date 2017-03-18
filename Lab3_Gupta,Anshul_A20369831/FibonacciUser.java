import java.util.*;

class FibonacciUser{
	
	final String MESSAGE_1 = "The elapsed time was ";

	final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

	final String MESSAGE_2 = " seconds.";
	long startTime,finishTime,elapsedTime;

	

	
	
	public static void main(String[] args){
		
		
		//System.out.println(iterativefib(5));
		//System.out.println(FibonacciUser.f(5));
		//System.out.println(brecursive(5, 1, 1));
		//System.out.println(mrecursive(5));
		new FibonacciUser().run();
		}
		
	
	
	
public void run() 
	  { 
	      final int SENTINEL = -1;
	 
	     final String INPUT_PROMPT = "\n\nPlease enter the " +
	        "positive integer whose Fibonacci number you want (or " +
	         SENTINEL + " to quit): ";    
	           
	     final String FIBONACCI_MESSAGE = "\nIts Fibonacci number is ";
	         
	     Scanner sc = new Scanner (System.in);
	    
	 int n;

	     while (true)
	     {
	        try
	        {
	          System.out.print (INPUT_PROMPT);
	          n = sc.nextInt();
	          if (n == SENTINEL){
	        	  sc.close();
	           break;  
	          }
	          //System.out.println (FIBONACCI_MESSAGE + iterativefib(n));
	        //Iterative Version
	        startTime = System.nanoTime();
	   		System.out.println (FIBONACCI_MESSAGE + iterativefib (n));
	   		finishTime = System.nanoTime();
	   		elapsedTime = finishTime - startTime;
	   		System.out.println ("Iterative Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
	   		
	   		//Mathematical Version
	   		startTime = System.nanoTime();
	   		System.out.println (FIBONACCI_MESSAGE + mrecursive (n));
	   		finishTime = System.nanoTime();
	   		elapsedTime = finishTime - startTime;
	   		System.out.println ("Mathematical Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
	   		
	   		////Long Recursive Version
	   		startTime = System.nanoTime();
	   		System.out.println (FIBONACCI_MESSAGE + f (n));
	   		finishTime = System.nanoTime();
	   		elapsedTime = finishTime - startTime;
	   		System.out.println ("Long Recursive Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
	   		
	   		//recursive Version
	   		startTime = System.nanoTime();
	   		System.out.println (FIBONACCI_MESSAGE + brecursive (n,1,1));
	   		finishTime = System.nanoTime();
	   		elapsedTime = finishTime - startTime;
	   		System.out.println ("recursive Version "+MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
	        }
	        catch (Exception e)
	        {
	          System.out.println (e);
	          sc.nextLine();
	        }     
	     }//End Of while   
	     
	     
	     
	  } 

	
	
	
	
		//Long Recursive Version
	   public static long f (int n)  
	   {
		   
		   final int MAX_N = 92;
		   final String ERROR_MESSAGE = "\nThe number entered must be " +
					 "greater than 0 and at most " + MAX_N + ".";
		   if (n < 0 || n > MAX_N)
			   throw new IllegalArgumentException (ERROR_MESSAGE);
	       if (n <= 2 )
	           return 1;
	       return f (n - 1) + f (n - 2); 
	   } 
	 //Iterative Version  
	public static long iterativefib(int n){
		
		final int MAX_N = 92;
		   final String ERROR_MESSAGE = "\nThe number entered must be " +
					 "greater than 0 and at most " + MAX_N + ".";
		   
		   if (n < 0 || n > MAX_N){
			   throw new IllegalArgumentException (ERROR_MESSAGE);
		   }
		
		
		if (n <=2){
			return 1;
		}
		
		long f_s=1,s=1;
		for (int i =3;i<=n;i++){
			long temp = f_s + s;
			f_s =s;
			s = temp;
			
		}
		return s;
	}
	//My Recursive Version
	public static long brecursive(int n,long f_s,long s){
		
		final int MAX_N = 92;
		   final String ERROR_MESSAGE = "\nThe number entered must be " +
					 "greater than 0 and at most " + MAX_N + ".";
		   
		   if (n < 0 || n > MAX_N){
			   throw new IllegalArgumentException (ERROR_MESSAGE);
		   }
		   
		   if (n <= 2){
			   return s;
		   }
		   else{
			   long temp = f_s + s;
			   f_s = s;
			   s = temp;
		   
		   return brecursive(n-1,f_s,s);
		   }
		   
		
	}
	
	public static long mrecursive(int n){
		
		final int MAX_N = 92;
		   final String ERROR_MESSAGE = "\nThe number entered must be " +
					 "greater than 0 and at most " + MAX_N + ".";
		   
		   if (n < 0 || n > MAX_N){
			   throw new IllegalArgumentException (ERROR_MESSAGE);
		   }
		  return (long)((Math.pow((1 + Math.sqrt(5))/2, n)- Math.pow((1 - Math.sqrt(5))/2,n))*(1/Math.sqrt(5)));
	}
	
}
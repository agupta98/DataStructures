import java.util.Scanner;

public class WrapperPower {
	
	final static  long MAX_VALUE =922334566;
	final static String ERROR_MESSAGE = "\nThe number entered must be " +
			 "greater than 0 and at most " + MAX_VALUE + ".";
	
	
	public static void main(String[] args){
		
		new WrapperPower().run();
	}
	
	public void run(){
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the base power");
		int a = sc.nextInt();
		System.out.println("Enter the nth power");
		int b = sc.nextInt();
		System.out.println("Recursive Version "+power(a,b));
		System.out.println("Iterative Version " +ipower(a,b));
		System.out.println("LognVersion " +rpower(a,b));
		
		
		
	}
	//Recursive Version
	public static long power(int i,int n){
		
		
		if (n < 0 || n > MAX_VALUE){
			
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		
		else if (n ==0){
			return 1;
		}
		
		else{
			return i * power(i,n-1);
		}
		
		
	}
	//Iterative Bersion
	public static long ipower(int i,int n){
		
        if (n < 0 || n > MAX_VALUE){
			
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		long cal = 1;
		for (int j =0;j < n;j++){
			cal  = i * cal;
		}
		return cal;
	}
	//LogNVersion
	public static long rpower(int i,int n){
		
		if (n < 0 || n > MAX_VALUE){
			
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		
		else if (n ==0){
			return 1;
		}
		
		
		else{
			if (n % 2 ==0){
				return rpower(i * i,n/2);
			}
			else{
				return i * rpower(i * i,n/2);
			}
		}
		
		
		

	}

}

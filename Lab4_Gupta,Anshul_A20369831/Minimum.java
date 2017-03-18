
public class Minimum {
	
	public static int minimum(int A[],int size){
		
		//size = A.length -1;
		//int count = 0;
		System.out.println(size);
		//count = count + 1;
		//System.out.println(count);
		if (size == 0){
			return A[0];
		}
		
		else{
			
			if (A[size] < minimum(A,size - 1)){
				
				return A[size];
			}
			else{
				return minimum(A,size -1 );
			}
		}
	    
	    
	    

}

public static void main(String[] args){
	int A[] ={10,-20,1,2,0,5,100};
	int s = minimum(A,A.length - 1);
	System.out.println(s);
}
}
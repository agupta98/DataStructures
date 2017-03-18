import java.util.*;

public class PermuteUser
{
    public static void main (String [ ] args)
    {
        new PermuteUser().run();
    } // method main
    
 
  public void run()
  {
    final String SENTINEL = "***";

    final String INPUT_PROMPT =
        "\nPlease enter a string (or " + SENTINEL + " to quit): ";

    String line;
 
    Scanner sc = new Scanner (System.in);
     
    while (true)
    {
      try
      {
        System.out.print (INPUT_PROMPT);
        line = sc.nextLine(); 
        if (line.equals (SENTINEL))
            break;
        System.out.println (permute (new StringBuilder(line)));
      }//try
      catch (Exception e) 
      {
        System.out.println (e);
      }//catch Exception
    }//while
  } // method run

 
  public static StringBuilder permute (StringBuilder s)
   { 
      return recPermute (s, 0);
   } // method permute
                             
 
  protected static StringBuilder recPermute (StringBuilder sb, int k)
  {
	  if (k == sb.length() - 1){
		  return new StringBuilder(sb + "\n");
		
	  }
	  else{
		  StringBuilder allPermutaions = new StringBuilder();
		  char temp;
		  for(int i =k;i < sb.length();i++){
			  temp = sb.charAt(i);
			  sb.setCharAt(i, sb.charAt(k));
			  sb.setCharAt(k, temp);
			  System.out.print("k::"+ k);
			  System.out.println("sb:"+sb);
			  allPermutaions.append(recPermute(sb,k+1));
			  temp=sb.charAt(k);
	        	sb.setCharAt(k, sb.charAt(i));
	        	sb.setCharAt(i, temp);
			  
		  }
		  return allPermutaions;
			  
			  
			  
	
       
     }
 } 
  
} 
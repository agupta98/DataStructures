import java.io.*;
	 
public class Lab7Shell  {
	static CS401StackLinkedListImpl<Character> st;
	static CS401StackLinkedListImpl<Double> evaluate_st;
	
	public static String inToPost(String infix){
		String postFix ="";
		char element;
		for (int i =0;i < infix.length();i++){
			 element = infix.charAt(i);
			 //System.out.println(element);
			 if (Character.isDigit(element)){
				 postFix = postFix + element;
			 }
			 else if (element == '('){
				 st.push(element);
			 }
			 
			 else if (element == ')'){
				 while (st.peek() !='('){
					 postFix =postFix + st.pop();
				 }
				 st.pop();
			 }
			 else{
				 while(!((st.size() == 0)) && !((st.peek() =='(')) && prec(element) <=prec(st.peek())){
					 postFix = postFix + st.pop();
				
				 }
				 st.push(element);
			 }
			
			
		}
		while (!(st.size() == 0)){
			postFix = postFix + st.pop();
			//System.out.println(postFix);
		}
		
		return postFix;
	}
	static int prec(char x)
	{
		if (x == '+' || x == '-')
			return 1;
		if (x == '*' || x == '/')
			return 2;
		return 0;
	}
	
	public static double evaluate(String postFix){
		char pf_arr[] = postFix.toCharArray();
		evaluate_st = new CS401StackLinkedListImpl<Double>();
		for(int i =0;i < pf_arr.length;i++){
			char c = pf_arr[i];
			if (c >='0' && c <='9'){
				evaluate_st.push(Double.parseDouble(Character.toString(c)));
				
				
			}
			else{
				double a = evaluate_st.pop();
				double b = evaluate_st.pop();
				if(c == '*'){
					evaluate_st.push(a*b);
				}
				if(c == '+'){
					evaluate_st.push(a+b);
				}
				if(c == '/'){
					evaluate_st.push(b/a);
				}
				if(c == '-'){
					evaluate_st.push(b-a);
				}
			}
		}
		return evaluate_st.pop();
		
		
	}
   public static void main(String[] args) throws java.io.IOException {
	  
	  st = new CS401StackLinkedListImpl<Character>();
      String commandLine;
      BufferedReader console = new BufferedReader
                               (new InputStreamReader(System.in));
	 
      // Break out with <control><C> or "quit"
      while (true) {
         // Prompt and read what the user entered
         System.out.print("lab7> ");
         commandLine = console.readLine().trim().replaceAll("\\s+", "");
	 if (commandLine.equals("quit"))  {
             break; 
         }
         // if the user entered a return, just loop again
         if (commandLine.equals(""))  {
	    continue;
         }
         else{
        	 System.out.println(evaluate(inToPost(commandLine)));
        	 //System.out.println(inToPost(commandLine));
         }

         
      }
      
      
	   
   }
   
   
   
}
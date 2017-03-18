import java.util.EmptyStackException;

public class CS401StackArrayImpl<E> implements CS401StackInterface<E> 
{
   private int num_elements;
   private int max_elements;
   private E[] elements;

   public CS401StackArrayImpl(int n)
   {
      max_elements = n; 
      num_elements = 0;
      elements = (E[]) new Object[max_elements];
   }
   /**
    * Push an element on the stack.  If the stack is full, then allocate
    * more memory to hold a new stack, copy existing elements to the new
    * stack and add the new element to the newly enlarged stack.
    * Do not use System.arraycopy().  You are essentially implementing
    * what System.arraycopy() will do when you expand an existing array. **/
   public void push(E e)
   {
      /** Add code here **/
	   if (num_elements == max_elements){
		   max_elements = max_elements * 2;
		   E[] temp =elements;
		   elements = (E[]) new Object[max_elements];
		   for(int i=0;i < temp.length;i++){
			   elements[i] = temp[i];
		   }
		   
	   }
	   elements[num_elements] = e;
	   num_elements++;
	   
      return;
   }

   public E pop()
   {
      /** Add code here **/
	   if (num_elements ==0){
		   throw new EmptyStackException();
	   }
	   num_elements--;
	   E e = elements[num_elements];
	   return e;
   }

   public E peek()
   {
	   if (num_elements == 0){
		   throw new EmptyStackException();
	   }
      /** Add code here **/
	   return elements[num_elements - 1];
	   
   }

   public int size()
   {
      /** Add code here **/
	   return num_elements;
   }
   
   public static void main(String[] args){
	   
	   CS401StackArrayImpl<Character> st = new CS401StackArrayImpl<Character>(10);
	   st.push('a');
	   st.push('b');
	   st.push('c');
	   st.push('d');
	   st.push('e');
	   st.push('f');
	   st.push('g');
	   st.push('h');
	   st.push('i');
	   st.push('j');
	   
	   System.out.println(st.size());
	   st.push('k');
	   System.out.println(st.size());
	   System.out.println("Deleted "+st.pop());
	   System.out.println("Deleted "+st.pop());
	   System.out.println(st.peek());
	   System.out.println(st.size());
	   
	   
		
   }

} /* CS401StackArrayImpl<E> */

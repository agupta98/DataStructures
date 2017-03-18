import java.util.NoSuchElementException;

/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      /*** Add code ***/
	   if(back == capacity){
		   capacity = capacity * 2;
		   E[] temp = data;
		   data = (E[]) new Object[capacity];
		   for (int i =0;i< temp.length;i++){
			   data[i] = temp[i];
		   }
		   
		   }
	  
		   data[back] = element;
		   back++;
	   
   }

   public E remove()  {
      
      /*** Add code ***/
	   if (back == 0){
		   throw new NoSuchElementException("Queue is empty");
	   }
	   E e = data[front];
	   for(int i =0;i < back - 1;i++){
		   data[i] = data[i+1];
	   }
	   back--;
	   return e;
	   
   }

   public E peek()  {

      /*** Add code ***/
	   return data[front];
	   
   }

   public int size()  {

      /*** Add code ***/
	   return back;
   }
   public static void main(String[] args){
	   
	   CS401QueueArrayFixedImpl<Character> qu = new CS401QueueArrayFixedImpl<Character>(10);
	   qu.add('a');
	   qu.add('b');
	   qu.add('c');
	   qu.add('d');
	   qu.add('e');
	   qu.add('f');
	   qu.add('g');
	   qu.add('h');
	   qu.add('i');
	   qu.add('j');
	   System.out.println(qu.size());
	   qu.add('k');
	   System.out.println(qu.size());
	   System.out.println("Deleted "+qu.remove());
	   System.out.println("Deleted "+qu.remove());
	   System.out.println(qu.peek());
	   System.out.println(qu.size());
	   
	   
	   
   }

}
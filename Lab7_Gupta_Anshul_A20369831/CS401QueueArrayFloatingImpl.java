import java.util.NoSuchElementException;

/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;
   private int size;

   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      /*** Add code ***/
	   if ((back + 1) % capacity==front){
		   capacity = capacity * 2;
		   E[] temp = data;
		   data = (E[]) new Object[capacity];
		   for (int i=0;i< temp.length;i++){
			   data[i] = temp[i];
		   }
		   data[back] = element;
		   back++;
		   size++;
		   
	   }
	   
   }

   public E remove()  {
      
      /*** Add code ***/
	   if (back == 0 && front == 0){
		   throw new IllegalStateException("Queue is empty, cant dequeue");
		   
	   }
   else if (back == front){
		   E e = data[front];
		   front =0;
		   back =0;
		   return e;
	   }
	   else{
		   E e =data[front];
		   front = (front + 1)% capacity;
		   return e;
	   }

   }
   public E peek()  {

      /*** Add code ***/
	   return data[front];

   }

   public int size()  {

      /*** Add code ***/
	   return size;
	   
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
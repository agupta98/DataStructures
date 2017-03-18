import java.util.Iterator;


public class CS401DblLinkedListImpl<E> implements CS401CollectionInterface<E>,Iterable<E>
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements = 0;

   public CS401DblLinkedListImpl()
   {
      head = tail = null;
   }

   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /*
    * Add e to the end of the doubly linked list.
    * Returns true - if e was successfully added, false otherwise.
    */
   public boolean add(E e)
   {
      /** Add code here **/ 
	   add(Where.BACK, e);
	      
	      return true;
      
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
      /**
       * Add code here. */
	   E element = null;
	   LinkEntry<E> temp = head;
	   LinkEntry<E> current = null;
	   if (i < 0 && i >size()){
			 return null;
			 
		 }
	   if (i == 1){
		   element = head.element;
		   head = head.next;
		   num_elements--;
		   return element;
		   
	   }
	   for (int j=1;j < i;j++){
		   current = temp;
		   temp = temp.next;
	   }
	   current.next = temp.next;
	   element = temp.element;
	   current = temp.previous;
	   num_elements--;
	   if(current.next == null){
		   tail = current;
		   tail.previous=current.previous;
	   }
	   
	   
      return element;
   }

   /**
    * Determines if e is in the collection.
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      /**
       * Add code here. */
	  for(LinkEntry<E> current=head;current !=null;current=current.next){
		  if (e.equals(current.element))
			  return true;
	  }
      return false;
   }

   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

      if (where == Where.MIDDLE)
          return false;

      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;
      
    if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
         ne.previous = tail;
      }

      /**
       * Add code here.
       * Hint: follow the same logic as 
       * CS401LinkedListImpl::add(Where where, E e) except account for 
       * the previous and next references in the doubly linked list. */
      else if (where == Where.FRONT)  {
          /**
           * Add code here. */
    	  
    	  
    	  
    	  head.previous=ne;
    	  ne.next =head;
    	  head = ne;
    	  
    	  ne.previous=null;
    	  
      }
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  
    * First element of the linked list is 1, second is 2, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {

      /**
       * Add code here. 
       * Hint: follow the same logic as 
       * CS401LinkedListImpl::add(Where where, int index, E e) except 
       * account for the previous and next references in the doubly 
       * linked list. */
	   if (where ==Where.MIDDLE){
		   LinkEntry<E> temp = head,current = null;
		   LinkEntry<E> ne = new LinkEntry<E>();
		      ne.element = e;
		      
		      
		   for(int i =0;i < index;i++){

			   
			   current = temp;
			   temp = temp.next;
		   }
		   
		   ne.next = temp;
		   temp.previous=ne;
		   current.next = ne;
		   ne.previous=current;
			   num_elements++;
			   
		   
		   } 

      return true;
   }

   /**
    * Print the doubly linked list starting at the beginning.
    */
   public void print_from_beginning()
   {
     
	   //CS401DblLinkedListImpl<E> obj = 
	   //System.out.println(obj.size());
	   
	  CS401LinkedListIterator itr =  new CS401LinkedListIterator();
	  
	  while(itr.hasNext()){
		  //System.out.println("Helloooooooo");
		  E element = itr.next();
		  System.out.print(element+" ");
	  }
	  
	  
      return;
   }
   
  

   private boolean hasNext() {
	// TODO Auto-generated method stub
	return false;
}

public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new CS401LinkedListIterator();
	}

/**
    * Print the doubly linked list starting the end.
    */
   public void print_recursive(LinkEntry<E> h){
	   if (h!=null){
		   print_recursive(h.next);
		   System.out.print(h.element);
	   }
   }
   public void print_from_end()
   {
      /** Add code here **/
	   print_recursive(head);
      return;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry<E> previous;

      protected LinkEntry() { element = null; next = previous = null; }
   }
   protected class CS401LinkedListIterator implements Iterator<E>{
		
		protected LinkEntry<E> current;
		protected LinkEntry<E> previous;
		
		public  CS401LinkedListIterator() {
			// TODO Auto-generated constructor stub
			current = head;
			previous = null;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			if (current !=null){
				
					return true;
			}
			return false;
			
			
		}
		public boolean hasPrevious(){
			if (previous !=null){
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if (hasNext()){
				E e = current.element;
				//previous = current;
			    current = current.next;
				return e;
			}
			return null;
		}
		
	}
} /* CS401LinkedListImpl<E> */

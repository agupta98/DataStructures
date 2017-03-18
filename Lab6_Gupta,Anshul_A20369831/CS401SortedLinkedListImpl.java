

public class CS401SortedLinkedListImpl<E> extends CS401LinkedListImpl<E>


{
   public CS401SortedLinkedListImpl()
   {
      super();
   }

   /** 
    * Adds element e in sorted order in the collection class (linked 
    * list).
    * Returns true if e was added successfully, false otherwise.
    */
   public boolean add(E e)
   {
      /**
       * Add code here. */
	   LinkEntry<E> ne = new LinkEntry<E>();
	      ne.element = e;

	      if (head == null && tail == null)
	      {
	          head = tail = ne;
	          
	          num_elements++;
	      }
	      
	      else{
	    	  LinkEntry<E> prev = null;
	          LinkEntry<E> temp;

	          for (temp = head; temp != null; temp = temp.next)
	          {
	        	  //System.out.println(temp.element);
	        	  //System.out.println(e);
	             int comp = ((Comparable)e).compareTo(temp.element);
	             if (comp < 0)  /*Element added is less than one on list*/
	             {
	                 break;
	             }
	             prev = temp;
	          }
	          num_elements++;

	          if (prev == null)   /*Adding as new head*/
	          {
	              ne.next = head;
	              head = ne;
	          }
	          else if (temp == null)  /*Adding as new tail*/ 
	          {
	              tail.next = ne;
	              tail = ne;
	          }
	          else    
	          {
	              ne.next = temp;
	              prev.next=ne;
	          }
	       }
	      return true;
	   
     
   }

   /**
    * Print the sorted linked list in reverse order using recursion.
    */
   public void reverse_print()  {
      /**
       * Add code here 
       * 
       */
	   print_recursive(head);
   }
   
   public void print_recursive(LinkEntry<E> h){
	   if (h!=null){
		   print_recursive(h.next);
		   System.out.print(h.element);
	   }
   }

} /* CS401SortedLinkedListImpl<E> */

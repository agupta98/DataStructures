public class CS401ArrayImpl<E> implements CS401CollectionInterface<E> {
	private static final char[][] E = null;
	private E[] elements;
	private int num_elements;
	private int capacity;
	private CS401ArrayImpl<E> sub;

	@SuppressWarnings("unchecked")
	public CS401ArrayImpl(int size) {
		elements = (E[]) new Object[size];
		num_elements = 0;
		capacity = size;
	}

	@SuppressWarnings("unchecked")
	public CS401ArrayImpl() {
		/**
		 * Call the c'tor that takes the 'size' parameter.
		 **/
		this(5);
	}

	/**
	 * Methods inherited from CS401CollectionInterface
	 */
	public boolean is_full() {
		if (num_elements == capacity)
			return true;
		return false;
	}

	public boolean is_empty() {
		if (num_elements == 0)
			return true;
		return false;
	}

	public int size() {
		return num_elements;
	}

	public boolean add(E e) {
		add(Where.BACK, e); // Add at the end
		return true;
	}

	/*
	 * Remove element at index i. If the element exists in the collection,
	 * return that element back to the user. If the index is out of bounds,
	 * return null.
	 */
	public E remove(int i) {
		/*
		 * Add code here. Remember to compact the array so there are no spaces
		 * in between if an element from the middle is removed or an element at
		 * the beginning of the array is removed.
		 */
		E e;
		if (i < 0 || i >= (num_elements - 1)) {
			return null;

		}

		e = elements[i];
		for (int j = i + 1; j < num_elements; j++) {
			elements[j - 1] = elements[j];

		}
		num_elements--;
		return e;

	}

	/*
	 * Return true if e is in the collection class, false otherwise.
	 */
	public boolean contains(E e) {
		/*
		 * Add code here
		 */
		for (int i = 0; i < num_elements; i++) {
			if (elements[i] == e)
				return true;
		}
		return false;

	}

	/**
	 * ---- Methods defined by this class
	 * ---------------------------------------------------------- Methods that
	 * are added by this class and not in the CS401CollectionInterface
	 */

	/**
	 * Add element in middle. Preconditions: where == MIDDLE index <=
	 * num_elements - 1
	 */
	public boolean add(Where where, int index, E e) {

		/*
		 * If there is no space to add the new element, grow the array.
		 */
		if (is_full()) {
			grow();
		}

		if (index < 0 || index > capacity - 1) {
			return false;
		}

		/**
		 * Add code here
		 */
		//System.out.println("JJJJJJJ "+num_elements);
		for (int i=num_elements;i >=index;i--){
			elements[i]=elements[i-1];
		}
		if (where == Where.MIDDLE && index <= num_elements - 1)
			elements[index] = e;
		num_elements++;
		return true;

	}

	/**
	 * Add element in front or at the end, as dictated by where. Preconditions:
	 * where != MIDDLE
	 */
	public boolean add(Where where, E e) {

		/*
		 * If there is no space to add the new element, grow the array.
		 */
		if (is_full()) {
			grow();
		}

		if (where == Where.BACK) {
			System.out.println("Inserting element at index " + num_elements);
			elements[num_elements] = e;
			num_elements++;
		} else if (where == Where.FRONT) {
			System.out.println("Inserting element at index 0");
			System.out.println("Compacting storage");
			/*
			 * Add code here. You will add the new element at index 0, and shift
			 * all the elements down by one.
			 * 
			 */
			for(int i =num_elements; i >= 0;i--){
				elements[i+1] = elements[i];
				
			}
			elements[0] = e;
			num_elements++;
		}

		return true;
	}

	/*
	 * Gets the element at index i (0 <= i <= num_elements-1)
	 */
	public E get(int i) {

		if (i < 0 && i > num_elements)
			return null;

		return (elements[i]);
	}

	/**
	 * ----------- Private methods
	 */
	/*
	 * Grows elements array to hold more elements. Copies old (existing)
	 * elements in the new array.
	 * 
	 * Postcondition: (a) elements must contain the contents of the old array
	 * (b) elements must now have twice as much capacity as before
	 */
	@SuppressWarnings("unchecked")
	private boolean grow() {

		/*
		 * Add code here Expand capacity (double it) and copy old array contents
		 * to the new one.
		 */
		if (capacity == elements.length){
			 capacity =elements.length * 2;
		}
	//	
		E[] temp = elements;
		
		
		
		elements = (E[]) new Object[capacity];
		for(int i =0;i < num_elements;i++){
			elements[i] = temp[i] ;
		}
		

		System.out.println("Capacity reached.  Increasing storage...");
		System.out.println("New capacity is " + capacity + " elements");
		

		return true;
	}
	
	   public CS401ArrayImpl<E> subList(int from, int to){
		   
		   if (from < 0 && from > num_elements && to < 0 && to > num_elements){
			   return null;
		   }
		   
		   sub = new CS401ArrayImpl<E>() ;
		   for(int i=from;i < to;i++){
			  sub.add(elements[i]);
		   }
		
		   return sub;
		   
	   }
}

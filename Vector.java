import java.util.Iterator;

public class Vector<E> implements SimpleList<E> 
{

	//class fields
	private int capacity;
	private Object[] list;
	private int listSize;
	
	/**
	*Constructor without any parameters
	*/
	public Vector()
	{
		capacity = 10;
		list = new Object[capacity];
		listSize = 0;
	}
	
	/**
	*Constructor with parameter that determines size of MyList
	*/
	public Vector(int n)
	{
		capacity = n;
		list = new Object[capacity];
		listSize = 0;
	}
	
	/**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this list
     */
	public boolean add(Object e)
	{
		if(size() == -1)
			list = biggerList();
			
		list[size()] = e;
		
		listSize++;
		
		return true;
	}
	
	/**
     * Returns the number of elements in this list.  If this list contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this list
     */
	public int size()
	{
		
		if(listSize < capacity)
			return listSize;
		else
			return -1;
	}
	
	
	/**
	*Helper method that creates a new list with a bigger capacity
	*so more things can be added to the MyList
	*@return bigger the Object[] that is created with a bigger capacity 
	*/
	public Object[] biggerList()
	{
		capacity *= 2;
		Object[] bigger = new Object[capacity];
		
		for(int i = 0; i < list.length; i++)
		{
			bigger[i] = list[i];
		}
		
		return bigger;
	}
	
	/**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
	public boolean isEmpty()
	{
		return listSize == 0;
	}
	
	/**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
	public boolean contains(Object e)
	{
		for(int i = 0; i < listSize; i++)
		{
			if(list[i].equals(e))
				return true;
		}
		return false;
	}
	
	 /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */

	public void clear()
	{
		Object[] newList = new Object[10];
		list = newList;
		listSize = 0;
		int capacity = 10;
	}
	
	/**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */

	public E get(int index)
	{
		if(index < listSize)
			return (E)list[index];
		else
			throw new IndexOutOfBoundsException("Index is out of range");
	}
	
	/**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and
     *         this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	public E set(int index, Object element)
	{
		if(index < listSize)
		{
			Object temp = list[index];
			list[index] = element;
			return (E)temp;
		}
		else
			throw new IndexOutOfBoundsException("Index is out of range");
	}
	
	/**
     * Compares the specified object with this list for equality.  Returns
     * <tt>true</tt> if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements <tt>e1</tt> and
     * <tt>e2</tt> are <i>equal</i> if <tt>(e1==null ? e2==null :
     * e1.equals(e2))</tt>.)  In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.  This
     * definition ensures that the equals method works properly across
     * different implementations of the <tt>List</tt> interface.
     *
     * @param o the object to be compared for equality with this list
     * @return <tt>true</tt> if the specified object is equal to this list
     */
	public boolean equals(Object e)
	{
		int count = 0;
		if(e instanceof Vector)
		{
			if(((Vector)e).size() == this.size())
			{
				for(int i = 0; i < this.size(); i++)
				{
					if(((Vector)e).get(i).equals(this.get(i)))
						count++;
				}
				if(count == this.size())
					return true;
			}
		}
		return false;
	}
	
	/**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and
     *         this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
	public void add(int index, Object element)
	{
		if(index < listSize)
		{

			if(size() == -1)
				list = biggerList();

			Object temp;
		
		
			for(int i = index; i < listSize; i++)
			{
				temp = list[i];
				list[i] = element;
				element = temp;
			}
			listSize++;
		}
		else if(listSize == 0)
		{
			listSize++;
			list[0] = element;
		}
		else
			throw new IndexOutOfBoundsException("Index is out of range");
	}
	
	/**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	public E remove(int index)
	{
		if(index < listSize)
		{
			Object removed = list[index];
		
		
		
			for(int i = index; i < listSize; i++)
			{
				list[i] = list[i+1];
			}
			listSize--;
		
			return (E)removed;
		}
		else
			throw new IndexOutOfBoundsException("Index is out of range");
	}
	
	 /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
	public int indexOf(Object e)
	{
		for(int i = 0; i < listSize; i++)
		{
			if(list[i].equals(e))
				return i;
		}
		return -1;
	}
	
	 /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this list
     */
	public boolean remove(Object e)
	{
		if(indexOf(e) >= 0)
		{
			this.remove(indexOf(e));
			return true;
		}
		
		return false;
	}
	 
	 /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
	public Iterator<E> iterator()
	{
		return new myListIterator(this);
	}
}

import java.util.Iterator;

public class Linked<E> implements SimpleList<E> 
{

	//class fields
	private ListNode<E> frontNode;
	private ListNode<E> backNode;
	private int linkSize;
	
	/**
	*Constructor without any parameters
	*/
	public Linked()
	{
		frontNode = null;
		backNode = null;
	}
	
	/**
	*Constructor with parameter that puts in one element in the list
	*/
	public Linked(E element)
	{
		frontNode = new ListNode<E>(element);
		backNode = frontNode;
		linkSize++;
		
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
		ListNode<E> addNode = new ListNode<E>((E)e);
		if(linkSize == 0)
		{
			frontNode = addNode;
			backNode = frontNode;
		}
		
		else
		{
			backNode.setReference(addNode);
			backNode = addNode;
			
		}
		
		linkSize++;
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
		return linkSize;
	}
	
	/**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
	public boolean isEmpty()
	{
		return linkSize == 0;
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
		
		ListNode<E> currentNode = frontNode;
		
		for(int i = 0; i < linkSize; i++)
		{
			if(currentNode.getData().equals((E)e))
				return true;
			else
				currentNode = currentNode.getReference();
		}
		return false;
	}
	
	 /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */

	public void clear()
	{
		frontNode = null;
		backNode = null;
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
		if(index >= 0 && index < linkSize)
		{
			ListNode<E> currentNode = frontNode;
			for(int i = 0; i < index; i++)
			{
				currentNode = currentNode.getReference();
			}
		
			return currentNode.getData();
		}
		
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
		if(index >= 0 && index < linkSize)
		{
			ListNode<E> currentNode = frontNode;
			for(int i = 0; i < index; i++)
			{
				currentNode = currentNode.getReference();
			}
		
			E temp = currentNode.getData();
			currentNode.setData((E)element);
			return temp;
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
		if(e instanceof Linked)
		{
			if(((Linked)e).size() == this.size())
			{
				for(int i = 0; i < this.size(); i++)
				{
					if(((Linked)e).get(i).equals(this.get(i)))
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
		ListNode<E> addNode = new ListNode((E)element);
		
		if(index < 0 || index > linkSize)
			throw new IndexOutOfBoundsException("Index is out of range");
		else if(index > 0)
		{
			ListNode<E> currentNode = frontNode;
			for(int i = 1; i < index; i++)
			{
				currentNode = currentNode.getReference();
			}
			
			ListNode<E> temp = currentNode.getReference();
			currentNode.setReference(addNode);
			addNode.setReference(temp);
			
			linkSize++;

			
		}
		else
		{
			linkSize++;
			frontNode = addNode;
			backNode = frontNode;
		}
		
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
		ListNode<E> currentNode = frontNode;
		if(index >0 && index < linkSize)
		{
			
			for(int i = 0; i < index-1; i++)
			{
				currentNode = currentNode.getReference();
			}
		
			E temp = currentNode.getReference().getData();
		
			currentNode.setReference(currentNode.getReference().getReference());
		
			return temp;
		}
		else if(index == 0)
		{
			E temp2 = frontNode.getData();
			frontNode = currentNode.getReference();
			return temp2;
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
		ListNode<E> currentNode = frontNode;
		for(int i = 0; i < linkSize; i++)
		{
			if(currentNode.getData().equals((E)e))
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
		return new LinkedIterator(this);
	}
}

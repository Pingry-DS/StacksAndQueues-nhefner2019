public class LinkedStack<E> extends Linked<E> implements Stack<E>
{
	public boolean push(E e)
	{
		add(0, e);
		return true;
	}
	
	public E pop()
	{
		return remove(0);
		
	}
	
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
	
	public int size()
	{
		return super.size();
	}
	
	public E peek()
	{
		return get(0);
	}
}
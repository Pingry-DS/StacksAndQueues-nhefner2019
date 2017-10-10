public class LinkedQueue extends Linked implements Queue
{
	public boolean add(E e)
	{
		add(e);
		return true;
	}
	
	public E remove()
	{
		return remove(0);
		
	}
	
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
	
	public int size()
	{
		return linkSize;
	}
	
	public E peek()
	{
		return get(0);
	}
}
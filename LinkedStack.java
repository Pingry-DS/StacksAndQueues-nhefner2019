public class LinkedStack extends Linked implements Stack
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
		return listSize;
	}
	
	public E peek()
	{
		return get(0);
	}
}
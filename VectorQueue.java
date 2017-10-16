public class VectorQueue<E> extends Vector<E> implements Queue<E>
{
	public boolean offer(E e)
	{
		add(e);
		return true;
	}
	
	public E poll()
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
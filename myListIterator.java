import java.util.NoSuchElementException;
import java.util.Iterator;

public class myListIterator<E> implements Iterator<E>
{
	private int counter = -1;
	private Vector m;
	
	public myListIterator(Vector current)
	{
		m = current;
	}
	
	public E next()
	{
		if(hasNext())
		{
			counter++;
			return (E)m.get(counter);
		}
		else
			throw new NoSuchElementException("No more elements in Vector");
			
	}
	
	public boolean hasNext()
	{
		return counter < m.size();
	}
}
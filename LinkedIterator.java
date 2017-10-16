import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedIterator<E> implements Iterator<E>
{
	private int counter = -1;
	private Linked m;
	
	public LinkedIterator(Linked current)
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
			throw new NoSuchElementException("No more elements in Linked");
			
	}
	
	public boolean hasNext()
	{
		return counter < m.size();
	}
}
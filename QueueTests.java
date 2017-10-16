import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class QueueTests
{

    private Queue<String> e;
    private Queue<String> f;
    
	@Before
  	public void setUp()
  	{
		e = new LinkedQueue<String>();
		f = new LinkedQueue<String>();
		f.offer("hi");
		f.offer("world");
    }
    
	//push empty
	@Test
	public void addEmpty()
	{
		e.offer("hello");
		assertEquals("hello", e.poll());
	}

	//push not empty
	@Test
	public void addNotEmpty()
	{
		f.offer("hello");
		assertEquals("hi", f.poll());
	}
	
	//pop 
	@Test
	public void removeTest()
	{
		assertEquals(f.poll(), "hi");
	}
	
	@Test
	public void addSize()
	{
		f.offer("hi");
		assertEquals(f.size(), 3);
	}
	
	//
}
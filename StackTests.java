import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class StackTests
{

    private Stack<String> e;
    private Stack<String> f;
    
	@Before
  	public void setUp()
  	{
		e = new vectorStack<String>();
		f = new vectorStack<String>();
		f.push("hello");
		f.push("world");
    }
    
	//push empty
	@Test
	public void pushEmpty()
	{
		e.push("hello");
		assertEquals("hello", e.pop());
	}

	//push not empty
	@Test
	public void pushNotEmpty()
	{
		f.push("hello");
		assertEquals("hello", f.pop());
	}
	
	//pop 
	@Test
	public void popTest()
	{
		assertEquals(f.pop(), "world");
	}
	
	@Test
	public void pushSize()
	{
		f.push("hi");
		assertEquals(f.size(), 3);
	}
	
	//
}
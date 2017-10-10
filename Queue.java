public interface Queue
{
	public boolean add (E e);
	
	public E remove ( );
	
	public boolean isEmpty( );
	
	public int size ( );
	
	public E peek ( ); //doesn’t remove anything
	
}
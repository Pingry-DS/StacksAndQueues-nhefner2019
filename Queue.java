public interface Queue<E>
{
	public boolean offer (E e);
	
	public E poll ( );
	
	public boolean isEmpty( );
	
	public int size ( );
	
	public E peek ( ); //doesn’t remove anything
	
}
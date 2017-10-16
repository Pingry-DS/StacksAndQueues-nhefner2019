public class ListNode<E>
{
	private E data;
	private ListNode<E> reference;
	
	public ListNode()
	{
		data = null;
		reference = null;
	}
	
	public ListNode(E e)
	{
		data = e;
	}
	
	public E getData()
	{
		return data;
	}
	
	public ListNode<E> getReference()
	{
		return reference;
	}
	
	public void setReference(ListNode<E> e)
	{
		reference = e;
	}
	
	public void setData(E e)
	{
		data = e;
	}
}
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
/**
 * 
 * @author SeanCui
 *
 * @param <AnyType>
 */
public class DoublyLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> prev;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> p, Node<AnyType> n)
    {
      setData(d);
      setPrev(p);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getPrev() { return prev; }

    public void setPrev(Node<AnyType> p) { prev = p; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private int modCount;
  private Node<AnyType> header;
  private Node<AnyType> trailer;

  public DoublyLinkedList()
  {
    header = new Node<AnyType>(null, null, null);
    trailer = new Node<AnyType>(null, null, null);
    modCount = 0;
    clear();
  }

  public void clear()
  {
    header.setNext(trailer);
    trailer.setPrev(header);
    theSize = 0;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return (size() == 0);
  }

  public AnyType get(int index)
  { 
	  return (getNode(index).data);
  }
  /**
   * implementation of set
   */
  public AnyType set(int index,AnyType newValue)
  {
	  Node<AnyType> p = getNode(index);
	  AnyType oldValue = p.data;
	  p.data = newValue;
	  return oldValue;
  }

  public boolean add(AnyType newValue)
  {
    add(size(), newValue);
    return true;
  }
//implementation of add method
  public void add(int index,AnyType  newValue)
  {
	  // if index is invalid
	  if (index < 0 || index > size())
		  throw new IndexOutOfBoundsException();
	  //when the list is empty, insert it to the position that right 
	  //after the header

		  // else, insert it to the position right after index
		  Node<AnyType> n = new Node<AnyType>(newValue,null,null);
		  Node<AnyType> currNode = getNode(index,0,size());
		  if(currNode.getPrev()!=null){
			  n.setPrev(currNode.getPrev());
			  currNode.getPrev().setNext(n);
			  n.setNext(currNode);
			  currNode.setPrev(n);
			  theSize++;
			  modCount++;
		  }
  }
  

  public AnyType remove(int index)
  {
    return remove(getNode(index));
  }

  public Iterator<AnyType> iterator()
  {
    return  new LinkedListIterator();    
  }

  private Node<AnyType> getNode(int index)
  {
	  if(index > size() || index < 0) throw new IndexOutOfBoundsException();
	  return (getNode(index, 0, size()-1));
  }

  private Node<AnyType> getNode(int index, int lower, int upper)
  {
	  Node<AnyType> p;
	  
	  if(index < size()/2){
		  p = header.next;
		  for ( int i =0; i < index; i++){
			  p = p.next;
		  }
	  }
	  else {
		  p = trailer;
		  for(int i = size(); i > index; i--){
			  p = p.prev;
		  }
	  }
	  return p;
  }
//implementation of remove method
  private AnyType remove(Node<AnyType> currNode)
  {
	  currNode.next.prev = currNode.prev;
	  currNode.prev.next = currNode.next;
	  theSize--;
	  modCount++;
	  
	  return currNode.data;
  }

  private class LinkedListIterator implements Iterator<AnyType>
  {
    private Node<AnyType> current;
    private int expectedModCount;
    private boolean okToRemove;

    LinkedListIterator()
    {
      current = header.getNext();
      expectedModCount = modCount;
      okToRemove = false;
    }

    public boolean hasNext()
    {
      return (current != trailer);
    }

    public AnyType next()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!hasNext())
        throw new NoSuchElementException();

      AnyType nextValue = current.getData();
      current = current.getNext();
      okToRemove = true;
      return nextValue;
    }

    public void remove()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!okToRemove)
        throw new IllegalStateException();

      DoublyLinkedList.this.remove(current.getPrev());
      expectedModCount++;
      okToRemove = false;
    }
  }
  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException
  {
    if (i < 0 || i >= n)
      throw new IndexOutOfBoundsException("Illegal index: " + i);
  }
}
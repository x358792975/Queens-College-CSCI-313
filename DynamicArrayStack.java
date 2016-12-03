/**
 * The implementation of DynamicArrayStack<AnyType> class
 * @author Xiang Cui
 *
 * @param <AnyType>
 */
public class DynamicArrayStack<AnyType> implements Stack<AnyType>
{
  public static final int DEFAULT_CAPACITY = 1024;
  AnyType[] data;
  int topOfStack;

  public DynamicArrayStack() { this(DEFAULT_CAPACITY); }

  public DynamicArrayStack(int capacity)
  {
    topOfStack = -1;
    data = (AnyType[]) new Object[capacity];
  }
  //the size is topOfStack + 1 because the initial value of topOfStack is -1;
  public int size()
  {
	  return (topOfStack+1) ;
  }

  public boolean isEmpty()
  {		// or size()==0;
	  return topOfStack == -1;
  }
  /**
   * if the stack is full, increase the size as double as it was
   * insert the value to the top of the stack as the end of array.
   */
  public void push(AnyType newValue) throws IndexOutOfBoundsException
  {
	  if(isEmpty()) data[size()] = newValue;
	  int n = size();
	  if(n==data.length) resize(data.length*2);
	  data[size()] = newValue;
	  topOfStack++;
  }
  /**
   * return the top element of the stack as the last element of array
   */
  public AnyType top()
  {
	  if(isEmpty()) return null;
	  
	  return data[topOfStack];
  }
  /**
   * remove and return the top element of the stack
   * if the stack is empty, return null;
   * if the size of the stack is less than 1/4 of data.length, decrease the size to 1/2
   * decrease the size of the stack
   */
  public AnyType pop()
  {
	  if(isEmpty()) return null;
	  int n = size();
	  if ( n <= (data.length /4)) resize(data.length / 2);
	  AnyType oldValue = data[topOfStack];
	  data[topOfStack] = null;
	  topOfStack--;
	  return oldValue;
	  
  }
  /**
   * make a new array and copy the element in data to the new array with new capacity
   * @param newCapacity
   */
  public void resize(int newCapacity){

	  AnyType[] temp = (AnyType[]) new Object[newCapacity];
	  for(int i=0;i<size(); i++){
		  temp[i] = data[i];
	  }
	  data = temp;
  }
}
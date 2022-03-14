import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T>
{
  private LinkedList<T> list = new LinkedList<>();


  @Override public boolean isEmpty()
  {
    return list==null;
  }

  @Override public void push(T elm)
  {
    list.addToFront(elm);
  }

  @Override public T pop() throws EmptyStackException
  {
    return list.removeFirst();
  }
}

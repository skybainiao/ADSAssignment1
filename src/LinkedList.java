import java.util.EmptyStackException;

public class LinkedList<T> implements List<T>
{

  private Node<T> head;
  private int size;

  public LinkedList(Node<T> head,int size){
    this.head=head;
    this.size=size;
  }

  @Override public boolean isEmpty()
  {
    return size==0;
  }

  @Override public int size()
  {
    return size;
  }

  @Override public void addToFront(T data)
  {
    Node<T> newNode = new Node<T>(data);
    newNode.setNext(head);
    head = newNode;
    size++;

  }

  @Override public T removeFirst() throws EmptyStackException
  {
    try
    {
      head = head.getNext();
      size--;
    }
    catch (EmptyStackException e){
      e.getMessage();
    }
    return head.getData();
  }
}

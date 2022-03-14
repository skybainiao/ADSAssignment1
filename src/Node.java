public class Node<T>
{
  private T data;
  private Node<T> next;

  public Node(T data)
  {
    this.data=data;
  }

  public void setData(T data)
  {
    this.data = data;
  }

  public T getData()
  {
    return data;
  }

  public void setNext(Node next){
    this.next=next;
  }

  public Node<T> getNext(){
    return next;
  }





}

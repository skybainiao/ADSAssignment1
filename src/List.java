import java.util.EmptyStackException;

public interface List<T>
{


  boolean isEmpty();

  int size();

  void addToFront(T data);

  T removeFirst() throws EmptyStackException;

}

import java.util.ArrayList;

public class Client
{

  private CalculatorVisitor visitor;

  private Token token;

  public Client(CalculatorVisitor visitor){
    this.visitor=visitor;

  }


  public int evaluateExpression(ArrayList<Token> tokens) throws MalformedExpressionException
  {
    for (Token token : tokens)
    {
      token.accept(visitor);
    }
    return visitor.getResult();
  }


}

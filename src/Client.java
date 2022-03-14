import java.util.ArrayList;

public class Client
{

  private CalculatorVisitor visitor;

  private Token token;

  public Client(CalculatorVisitor visitor,Token token){
    this.visitor=visitor;
    this.token=token;
  }


  public int evaluateExpression(ArrayList<Token> tokens){
    for (Token token : tokens)
    {
      token.accept(visitor);
    }
    return visitor.getResult();
  }


}

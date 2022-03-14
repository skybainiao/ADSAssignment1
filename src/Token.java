public abstract class Token
{


  private CalculatorVisitor visitor;

  public Token(CalculatorVisitor visitor){
    this.visitor=visitor;
  }

  public abstract void accept(CalculatorVisitor visitor) throws MalformedExpressionException;

}

public class Operand extends Token
{

  private int value;

  public Operand(CalculatorVisitor visitor,int value){
    super(visitor);
    this.value=value;

  }

  @Override public void accept(CalculatorVisitor visitor)
  {
    visitor.visit(this);
  }

  public int getValue()
  {
    return value;
  }
}

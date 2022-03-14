import java.lang.reflect.MalformedParametersException;

public class CalculatorVisitor implements Visitor,Calculator

{
  private LinkedStack<Token> tokenStack;


  public void pushOperand(Operand operand){
    tokenStack.push(operand);
  }


  public void performOperation(Operator operator)throws MalformedParametersException
  {

    Operand firstOperand = (Operand) tokenStack.pop();
    Operand secondOperand = (Operand) tokenStack.pop();
    if (firstOperand != null || secondOperand != null) {
      int firstValue = firstOperand.getValue();
      int secondValue = secondOperand.getValue();
      int result = 0;
      switch (operator.getOperation()) {
        case plus:
          result = firstValue + secondValue;
          break;
        case minus:
          result = firstValue - secondValue;
          break;
        case divide:
          result = firstValue / secondValue;
          break;
        case multiply:
          result = firstValue * secondValue;
          break;
      }
      Operand operand = new Operand(this, result);
      tokenStack.push(operand);
    }
    else{
      throw new MalformedParametersException("There is not enough operands");
    }

  }


  @Override public int getResult() throws MalformedParametersException
  {
    Operand operand = (Operand) tokenStack.pop();
    return operand.getValue();
  }


  @Override public void visit(Operand operand)
  {
    pushOperand(operand);

  }


  @Override public void visit(Operator operator)
  {
    performOperation(operator);

  }

}

public class CalculatorVisitor implements Visitor,Calculator

{
  private LinkedStack<Token> tokenStack = new LinkedStack<>();


  public void pushOperand(Operand operand){
    tokenStack.push(operand);
  }


  public void performOperation(Operator operator) throws  MalformedExpressionException
  {
    Operand firstOperand = (Operand) tokenStack.pop();
    Operand secondOperand = (Operand) tokenStack.pop();

    if (firstOperand != null || secondOperand != null) {
      int firstValue = firstOperand.getValue();
      int secondValue = secondOperand.getValue();
      int result = 0;
      if (operator.getOperation().equals(Operation.plus)){
        result = firstValue + secondValue;
      }
      else if (operator.getOperation().equals(Operation.minus)){
        result = firstValue - secondValue;
      }
      else if (operator.getOperation().equals(Operation.divide)){
        result = firstValue / secondValue;
      }
      else if (operator.getOperation().equals(Operation.multiply)){
        result = firstValue * secondValue;
      }
      Operand operand = new Operand(this, result);
      tokenStack.push(operand);
    }
    else{
      throw new MalformedExpressionException("There is not enough operands");
    }

  }


  @Override public int getResult() throws MalformedExpressionException
  {
    Operand operand = (Operand) tokenStack.pop();
    return operand.getValue();
  }


  @Override public void visit(Operand operand)
  {
    pushOperand(operand);

  }


  @Override public void visit(Operator operator)
      throws MalformedExpressionException
  {
    performOperation(operator);

  }

}

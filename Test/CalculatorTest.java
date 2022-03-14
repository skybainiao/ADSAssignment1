import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CalculatorTest
{

  private Client client;
  private Calculator calculator;

  @Before public void setUp() {
    calculator = new CalculatorVisitor();
    client = new Client((CalculatorVisitor) calculator);

  }

  @Test public void evaluateExpression() throws MalformedExpressionException
  {
    ArrayList<Token> tokenList = new ArrayList<Token>();
    Operand operand1 = new Operand((CalculatorVisitor) calculator, 2);
    Operand operand2 = new Operand((CalculatorVisitor) calculator, 4);
    Operand operand3 = new Operand((CalculatorVisitor) calculator, 5);
    Operand operand4 = new Operand((CalculatorVisitor) calculator, 6);
    Operand operand5 = new Operand((CalculatorVisitor) calculator, 8);
    Operator operator1 = new Operator(Operation.plus, (CalculatorVisitor) calculator);
    Operator operator2 = new Operator(Operation.minus, (CalculatorVisitor) calculator);
    Operator operator3 = new Operator(Operation.divide, (CalculatorVisitor) calculator);
    Operator operator4 = new Operator(Operation.multiply, (CalculatorVisitor) calculator);
    tokenList.add(operand1);
    tokenList.add(operand2);
    tokenList.add(operand3);
    tokenList.add(operand4);
    tokenList.add(operand5);
    tokenList.add(operator1);
    tokenList.add(operator2);
    tokenList.add(operator3);
    tokenList.add(operator4);

    System.out.println(client.evaluateExpression(tokenList));

    assertEquals(4,client.evaluateExpression(tokenList));


  }


}

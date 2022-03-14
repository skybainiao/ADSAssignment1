public interface Visitor
{

  void visit(Operand operand);

  void visit(Operator operator) throws MalformedExpressionException;
}

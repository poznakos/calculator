package org.konrad.domain;

public class Calculator {

    private final MathematicalExpressionValidator validator = new MathematicalExpressionValidator();
    private final MathematicalExpressionSplitter splitter = new MathematicalExpressionSplitter();
    private final Inputable inputable;
    public Calculator(Inputable inputable) {
        this.inputable = inputable;
    }

    public Double calculate() {
        String possibleMathExpression = inputable.getInput().replaceAll("\\s","");
        String infixMathExpression = validator.validate(possibleMathExpression);
        String[] infixMathExpressionArray = splitter.split(infixMathExpression);
        return calculateByRPN(infixMathExpressionArray);
    }

    private Double calculateByRPN(String[] infixMathExpressionArray) {
        Infix infix = new Infix(infixMathExpressionArray);
        Postfix postfix = infix.toPostfix();
        Double result = postfix.calculate();
        return result;
    }


}

package org.konrad.domain;

public class Calculator {

    private final MathematicalExpressionValidator validator = new MathematicalExpressionValidator();
    private final MathematicalExpressionSplitter splitter = new MathematicalExpressionSplitter();
    private final Inputable inputable;
    public Calculator(Inputable inputable) {
        this.inputable = inputable;
    }

    public void run(){
        String possibleMathExpression = inputable.getInput();
        String mathExpression = validator.validate(possibleMathExpression);
        calculate(mathExpression);
    }

    private void calculate(String mathExpression) {
        String[] mathExpressionComponents = splitter.split(mathExpression);
        calculateByRPN(mathExpressionComponents);
    }

    private void calculateByRPN(String[] mathExpressionComponents) {

    }


}

package org.konrad.domain;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

import static org.konrad.domain.OperandHelper.isNumeric;

public class Infix {

    private final String[] expression;

    public Infix(String expression) {
        this.expression = new MathematicalExpressionSplitter().split(expression);
    }

    public Infix(String[] expression) {
        this.expression = expression;
    }

    public Postfix toPostfix() {
        List<String> output = new ArrayList<>();
        Stack<String> operatorsStack = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            String currentElement = expression[i];

            if (isNumeric(currentElement)) {

                output.add(currentElement);

            } else {

                if (operatorsStack.empty()) {

                    operatorsStack.push(currentElement);

                } else {

                    int lastStockOperatorWeight = OperatorHelper.getWeight(operatorsStack.peek());
                    int currentOperator = OperatorHelper.getWeight(currentElement);

                    if (lastStockOperatorWeight < currentOperator) {

                        operatorsStack.push(currentElement);

                    } else {

                        // >=
                        Enumeration enu = operatorsStack.elements();
                        while (enu.hasMoreElements()) {
                            output.add(operatorsStack.pop());
                        }

                        operatorsStack.push(currentElement);

                    }
                }
            }
        }

        Enumeration enu = operatorsStack.elements();
        while (enu.hasMoreElements()) {
            output.add(operatorsStack.pop());
        }

        return new Postfix(output);
    }




}

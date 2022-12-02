package org.konrad.domain;

import java.util.List;
import java.util.Stack;

import static org.konrad.domain.OperandHelper.isNumeric;
import static org.konrad.domain.OperandHelper.parseDouble;

public class Postfix {

    private final List<String> expression;

    Postfix(List<String> expression) {
        this.expression = expression;
    }

    public List<String> getExpression() {
        return expression;
    }

    /*
    [2, 3, *, 5, -]
    [6, 5, -]
    [1]

    [2, 3, 5, *, -]
    [2, 15, -]
    [-13]
     */

    Double calculate() {
        return countOnStack(this.expression);
    }

    private Double countOnStack(List<String> expression) {
        Stack<Double> stack = new Stack<>();

        for (String element : expression) {
            if (isNumeric(element)) {
                stack.push(parseDouble(element));
            } else {
                Double number2 = stack.pop();
                Double number1 = stack.pop();

                Double result = OperatorHelper.executeOperation(element, number1, number2);
//                Double result = Operator2Helper.executeOperation(element, number1, number2);

                stack.push(result);
            }
        }

        Double result = stack.pop();
        return result;
    }

}

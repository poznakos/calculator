package org.konrad.domain;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class InfixData {

    private final String[] infix;

    public InfixData(String infix) {
        this.infix = new MathematicalExpressionSplitter().split(infix);
    }

    public InfixData(String[] infix) {
        this.infix = infix;
    }

    public List<String> toPostfix() {
//        String[] output = new String[infix.length];
        List<String> output = new ArrayList<>();
        Stack<String> operatorsStack = new Stack<>();

        for (int i = 0; i < infix.length; i++) {
            String currentElement = infix[i];

            if (isNumeric(currentElement)) {

                output.add(currentElement);

            } else {

                if (operatorsStack.empty()) {

                    operatorsStack.push(currentElement);

                } else {

                    int lastStockOperatorWeight = Operator.getWeight(operatorsStack.peek());
                    int currentOperator = Operator.getWeight(currentElement);

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

        return output;
    }

    private boolean isNumeric(String infix) {
        try {
            double val = Double.parseDouble(infix);
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }


}

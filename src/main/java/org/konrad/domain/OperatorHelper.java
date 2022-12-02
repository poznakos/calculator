package org.konrad.domain;

import java.util.HashMap;

public class OperatorHelper {
    private static final HashMap<String, Integer> OPERATORS;

    static {
        HashMap<String, Integer> operatorWithWeight = new HashMap<>();
        operatorWithWeight.put("+", 2);
        operatorWithWeight.put("-", 2);
        operatorWithWeight.put("*", 3);
        operatorWithWeight.put("/", 3);
        OPERATORS = operatorWithWeight;

    }

    static Double executeOperation(String operator, Double number1, Double number2){
        switch(operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            default:
                return null;
        }
    }

    static Integer getWeight(String operator){
        return OPERATORS.get(operator);
    }

}

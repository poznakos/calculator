package org.konrad.domain;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Operator2Helper {
    private static final HashMap<String, Operator> OPERATORS;

    static {
        HashMap<String, Operator> operatorWithWeight = new HashMap<>();
        operatorWithWeight.put("+", new Operator(2, (a, b) -> a + b));
        operatorWithWeight.put("-", new Operator(2, (a, b) -> a - b));
        operatorWithWeight.put("*", new Operator(3, (a, b) -> a * b));
        operatorWithWeight.put("/", new Operator(2, (a, b) -> a / b));
        OPERATORS = operatorWithWeight;

    }

    static Integer getWeight(String operator) {
        return getOperator(operator).getWeight();
    }

    static Double executeOperation(String operator, Double number1, Double number2) {
        return getOperator(operator).function.apply(number1, number2);
    }

    private static Operator getOperator(String operator) {
        return OPERATORS.get(operator);
    }

    static class Operator {
        private Integer weight;
        private BiFunction<Double, Double, Double> function;

        public Operator(Integer weight, BiFunction<Double, Double, Double> function) {
            this.weight = weight;
            this.function = function;
        }

        public Integer getWeight() {
            return weight;
        }
    }

}

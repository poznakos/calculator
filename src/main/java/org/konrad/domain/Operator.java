package org.konrad.domain;

import java.util.HashMap;

public class Operator {
    private static final HashMap<String, Integer> OPERATORS;

    static {
        HashMap<String, Integer> operatorWithWeight = new HashMap<>();
        operatorWithWeight.put("+", 2);
        operatorWithWeight.put("-", 2);
        operatorWithWeight.put("*", 3);
        operatorWithWeight.put("/", 3);
        OPERATORS = operatorWithWeight;

    }

    static Integer getWeight(String operator){
        return OPERATORS.get(operator);
    }

}

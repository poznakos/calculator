package org.konrad.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StackToList {

    @Test
    public void StackToLost(){
        var someStack = new Stack<String>();
        var someList = new ArrayList<>();

        someStack.push("1");
        someStack.push("2");
        someStack.push("3");

        ArrayList<String> strings = new ArrayList<>(someStack);
        Collections.reverse(strings);

        someList.addAll(strings);

        someList.toString();
    }
}

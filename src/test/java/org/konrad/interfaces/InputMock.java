package org.konrad.interfaces;

import org.konrad.domain.Inputable;

public class InputMock implements Inputable {
    private final String testText;

    public InputMock(String testText){
        this.testText = testText;
    }

    @Override
    public String getInput() {
        return testText;
    }
}

package org.konrad;

import org.konrad.interfaces.Inputable;

public class InputMock implements Inputable {
    private final String testText;

    public InputMock(String testText){
        this.testText = testText;
    }

    @Override
    public double getInput() {

        return 0;
    }
}

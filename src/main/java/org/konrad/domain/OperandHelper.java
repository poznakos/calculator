package org.konrad.domain;

public class OperandHelper {

    static boolean isNumeric(String element) {
        return parseDouble(element) != null;
    }

    static Double parseDouble(String element){
        try {
            return Double.parseDouble(element);
        } catch (Exception e) {
//            System.out.println("Exception: " + e);
            return null;
        }
    }
}

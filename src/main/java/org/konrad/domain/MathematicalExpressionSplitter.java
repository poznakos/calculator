package org.konrad.domain;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MathematicalExpressionSplitter {

    private static final String REGEX_PATTERN = "\\d+|[\\+\\-\\*\\/]";

    String[] split(String mathExpression) {
        return Pattern.compile(REGEX_PATTERN)
                .matcher(mathExpression)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }
}

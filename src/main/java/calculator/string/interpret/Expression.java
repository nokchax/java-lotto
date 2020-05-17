package calculator.string.interpret;

import calculator.string.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String ZERO_EXPRESSION = "0";
    private static final int INDEX_OF_CUSTOM_SPLITTER_GROUP = 1;
    private static final int INDEX_OF_EXPRESSION = 2;

    private final String originalStr;
    private final Matcher matcher;

    private Expression(String expStr) {
        if (StringUtil.isEmpty(expStr)) {
            expStr = ZERO_EXPRESSION;
        }

        this.originalStr = expStr;
        this.matcher = PATTERN.matcher(originalStr);
        this.matcher.matches();
    }

    public static Expression match(final String expStr) {
        return new Expression(expStr);
    }

    public boolean isCustom() {
        return matcher.matches();
    }

    public String extractCustomSplitter() {
        return matcher.group(INDEX_OF_CUSTOM_SPLITTER_GROUP);
    }

    public String extractExpression() {
        return matcher.group(INDEX_OF_EXPRESSION);
    }

    public String origin() {
        return originalStr;
    }
}

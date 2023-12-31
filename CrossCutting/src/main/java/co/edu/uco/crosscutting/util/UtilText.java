package co.edu.uco.crosscutting.util;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class UtilText {
    private static final UtilText INSTANCE = new UtilText();
    public static final String EMPTY = "";
    public static final String LETTERS_AND_SPACES_ONLY = "^[a-zA-ZñÑ\\s]+$";
    public static final String SPACE = " ";
    private UtilText() {}

    public static UtilText getUtilText() {
        return INSTANCE;
    }

    public boolean isNull(String value) {
        return getUtilObject().isNull(value);
    }
    public String getDefault(String value, String defaultValue) {
        return getUtilObject().getDefaultIsNull(value, defaultValue);
    }
    public String getDefault(String value) {
        return getUtilObject().getDefaultIsNull(value, EMPTY);
    }

    public  String trim(String value) {return getDefault(value).trim();}

    public boolean isEmpty(String value) {
        return EMPTY.equals(trim(value));
    }

    public boolean isContainsOnlyLetterAndSpace(String value) {
        return validMatch(value, LETTERS_AND_SPACES_ONLY);
    }
    public boolean validMatch(String value, String expression) {
        return value.matches(expression);
    }
}

package com.goetschalckx.eric.uuid.parser.regex;

public class Regex {

    public static final String PATTERN =
            "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)";

    public static final String REPLACEMENT = "$1-$2-$3-$4-$5";

}

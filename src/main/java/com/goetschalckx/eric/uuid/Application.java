package com.goetschalckx.eric.uuid;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.BitShiftParser;
import com.goetschalckx.eric.uuid.parser.LongParser;
import com.goetschalckx.eric.uuid.parser.UuidParser;
import com.goetschalckx.eric.uuid.parser.bigint.BigIntegerParser1;
import com.goetschalckx.eric.uuid.parser.bigint.BigIntegerParser2;
import com.goetschalckx.eric.uuid.parser.fake.FullyRandomParser;
import com.goetschalckx.eric.uuid.parser.fake.FullyStaticParser;
import com.goetschalckx.eric.uuid.parser.regex.CompiledRegexParser;
import com.goetschalckx.eric.uuid.parser.regex.RegexParser;
import com.goetschalckx.eric.uuid.parser.slow.StringBuilderParser;
import com.goetschalckx.eric.uuid.parser.slow.StringConcatParser;
import com.goetschalckx.eric.uuid.parser.slow.StringMultiConcatParser;
import com.goetschalckx.eric.uuid.parser.slow.StringSplitterParser;

public class Application {

    private static final List<String> UUID_STRINGS_NO_HYPHENS = new LinkedList<>();
    private static final List<String> UUID_STRINGS = new LinkedList<>();

    private static final int NUM_UUIDS = 1000000;

    public static void main(String... args) {
        fillUuidStrings();

        stringSplitter();
        fullyRandom();
        regex();
        compiledregex();
        stringMultiConcat();
        stringBuilder();
        stringConcat();
        bigInt1();
        bigInt2();
        longParser();
        bitShift();
        fullyStatic();
        System.out.println();
        jdk();
    }

    private static void fillUuidStrings() {
        for (int i = 0; i < NUM_UUIDS; i++) {
            final String uuidStr = UUID.randomUUID().toString();
            UUID_STRINGS_NO_HYPHENS.add(uuidStr.replaceAll("-", ""));
            UUID_STRINGS.add(uuidStr);
        }
    }

    private static void fullyRandom() {
        testParse(new FullyRandomParser(), "Fully Random");
    }

    private static void fullyStatic() {
        testParse(new FullyStaticParser(), "Fully Static");
    }

    private static void stringConcat() {
        testParse(new StringConcatParser(), "String Concat");
    }

    private static void stringSplitter() {
        testParse(new StringSplitterParser(), "String Splitter");
    }

    private static void stringBuilder() {
        testParse(new StringBuilderParser(), "String Builder");
    }

    private static void stringMultiConcat() {
        testParse(new StringMultiConcatParser(), "String Multi Concat");
    }

    private static void regex() {
        testParse(new RegexParser(), "Regex");
    }

    private static void compiledregex() {
        testParse(new CompiledRegexParser(), "Compiled Regex");
    }

    private static void bigInt1() {
        testParse(new BigIntegerParser1(), "BigInteger 1");
    }

    private static void bigInt2() {
        testParse(new BigIntegerParser2(), "BigInteger 2");
    }

    private static void longParser() {
        testParse(new LongParser(), "Long");
    }

    private static void bitShift() {
        testParse(new BitShiftParser(), "Bit Shift");
    }

    private static void testParse(UuidParser uuidParser, String parserName) {
        final long start = System.currentTimeMillis();

        UUID_STRINGS_NO_HYPHENS.forEach(uuidParser::parse);

        final long stop = System.currentTimeMillis();

        System.out.println(String.format("%s\t%d ms", leftPad(parserName, 20), stop - start));
    }

    private static String leftPad(String str, int width) {
        return new String(new char[width - str.length()]).replace('\0', ' ') + str;
    }

    private static final void jdk() {
        final long start = System.currentTimeMillis();

        UUID_STRINGS.forEach(UUID::fromString);

        //System.out.println(UUID.fromString("a-2-3-4-f").toString());

        final long stop = System.currentTimeMillis();

        System.out.println(String.format("%s\t%d ms", leftPad("JDK", 20), stop - start));
    }

}

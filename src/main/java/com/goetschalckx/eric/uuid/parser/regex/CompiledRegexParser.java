package com.goetschalckx.eric.uuid.parser.regex;

import java.util.UUID;
import java.util.regex.Pattern;

import com.goetschalckx.eric.uuid.parser.UuidParser;

import static com.goetschalckx.eric.uuid.parser.regex.Regex.PATTERN;
import static com.goetschalckx.eric.uuid.parser.regex.Regex.REPLACEMENT;

public class CompiledRegexParser extends UuidParser {

    private static final Pattern COMPILED_PATTERN = Pattern.compile(PATTERN);

    @Override
    public UUID parseInternal(String uuidString) {
        String uuidWithHyphens = COMPILED_PATTERN.matcher(uuidString).replaceAll(REPLACEMENT);

        return UUID.fromString(uuidWithHyphens);
    }

}

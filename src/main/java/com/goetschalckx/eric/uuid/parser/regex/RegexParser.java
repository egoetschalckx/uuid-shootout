package com.goetschalckx.eric.uuid.parser.regex;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

import static com.goetschalckx.eric.uuid.parser.regex.Regex.PATTERN;
import static com.goetschalckx.eric.uuid.parser.regex.Regex.REPLACEMENT;

public class RegexParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        return UUID.fromString(uuidString.replaceFirst(PATTERN, REPLACEMENT));
    }

}

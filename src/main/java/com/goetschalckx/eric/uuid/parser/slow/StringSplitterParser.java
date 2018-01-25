package com.goetschalckx.eric.uuid.parser.slow;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class StringSplitterParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        return UUID.fromString(
                String.format(
                        "%s%s%s%s%s%s%s%s-%s%s%s%s-%s%s%s%s-%s%s%s%s-%s%s%s%s%s%s%s%s%s%s%s%s",
                        uuidString.split("")));
    }

}

package com.goetschalckx.eric.uuid.parser.slow;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class StringConcatParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        return UUID.fromString(
                uuidString.substring(0, 8)
                + "-"
                + uuidString.substring(8, 12)
                + "-"
                + uuidString.substring(12, 16)
                + "-"
                + uuidString.substring(16, 20)
                + "-"
                + uuidString.substring(20, 32));
    }

}

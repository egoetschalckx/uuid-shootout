package com.goetschalckx.eric.uuid.parser.slow;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class StringBuilderParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        final StringBuilder sb = new StringBuilder();
        sb.append(uuidString.substring(0, 8));
        sb.append("-");
        sb.append(uuidString.substring(8, 12));
        sb.append("-");
        sb.append(uuidString.substring(12, 16));
        sb.append("-");
        sb.append(uuidString.substring(16, 20));
        sb.append("-");
        sb.append(uuidString.substring(20, 32));

        return UUID.fromString(sb.toString());
    }

}

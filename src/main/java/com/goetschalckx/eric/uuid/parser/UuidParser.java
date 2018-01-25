package com.goetschalckx.eric.uuid.parser;

import java.util.UUID;

public abstract class UuidParser {

    public abstract UUID parseInternal(String uuidString);

    public UUID parse(String uuidString) {
        if (uuidString == null) {
            throw new NullPointerException("uuidString must not be null");
        }

        if (uuidString.length() != 32) {
            throw new NumberFormatException("uuidString must be 32 characters long with no hyphens");
        }

        return parseInternal(uuidString);
    }

}

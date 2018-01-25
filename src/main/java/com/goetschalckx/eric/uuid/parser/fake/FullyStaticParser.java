package com.goetschalckx.eric.uuid.parser.fake;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class FullyStaticParser extends UuidParser {

    private static final UUID uuid = UUID.randomUUID();

    @Override
    public UUID parseInternal(String uuidString) {
        return uuid;
    }

}

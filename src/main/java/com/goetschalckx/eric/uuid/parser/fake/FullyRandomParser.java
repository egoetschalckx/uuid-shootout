package com.goetschalckx.eric.uuid.parser.fake;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class FullyRandomParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        return UUID.randomUUID();
    }

}

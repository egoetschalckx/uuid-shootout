package com.goetschalckx.eric.uuid.parser;

import java.util.UUID;

public class LongParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        Long msb = Long.parseUnsignedLong(uuidString.substring(0, 16), 16);
        Long lsb = Long.parseUnsignedLong(uuidString.substring(16, 32), 16);

        return new UUID(msb, lsb);
    }

}

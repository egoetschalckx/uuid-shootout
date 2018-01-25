package com.goetschalckx.eric.uuid.parser.bigint;

import java.math.BigInteger;
import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class BigIntegerParser1 extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        final BigInteger mostSignificant = new BigInteger(uuidString.substring(0, 16), 16);
        final BigInteger leastSignificant = new BigInteger(uuidString.substring(16, 32), 16);

        return new UUID(
                mostSignificant.longValue(),
                leastSignificant.longValue());
    }

}

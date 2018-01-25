package com.goetschalckx.eric.uuid.parser.bigint;

import java.math.BigInteger;
import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class BigIntegerParser2 extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        final BigInteger bigInteger = new BigInteger(uuidString, 16);

        return new UUID(
                bigInteger.shiftRight(64).longValue(),
                bigInteger.longValue());
    }

}

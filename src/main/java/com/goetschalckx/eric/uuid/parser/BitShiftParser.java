package com.goetschalckx.eric.uuid.parser;

import java.util.UUID;

public class BitShiftParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        long lo = 0;
        long hi = 0;

        for (int i = 0, j = 0; i < 32; ++j) {
            int curr;
            char c = uuidString.charAt(i);

            if (c >= '0' && c <= '9') {
                curr = (c - '0');
            } else if (c >= 'a' && c <= 'f') {
                curr = (c - 'a' + 10);
            } else if (c >= 'A' && c <= 'F') {
                curr = (c - 'A' + 10);
            } else {
                throw new NumberFormatException(
                        "Non-hex character at #" + i + ": '" + c + "' (value 0x" + Integer.toHexString(c) + ")");
            }
            curr = (curr << 4);

            c = uuidString.charAt(++i);

            if (c >= '0' && c <= '9') {
                curr |= (c - '0');
            } else if (c >= 'a' && c <= 'f') {
                curr |= (c - 'a' + 10);
            } else if (c >= 'A' && c <= 'F') {
                curr |= (c - 'A' + 10);
            } else {
                throw new NumberFormatException(
                        "Non-hex character at #" + i + ": '" + c + "' (value 0x" + Integer.toHexString(c) + ")");
            }
            if (j < 8) {
                hi = (hi << 8) | curr;
            } else {
                lo = (lo << 8) | curr;
            }
            ++i;
        }
        return new UUID(hi, lo);
    }

}

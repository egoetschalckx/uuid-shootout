package com.goetschalckx.eric.uuid.parser.slow;

import java.util.UUID;

import com.goetschalckx.eric.uuid.parser.UuidParser;

public class StringMultiConcatParser extends UuidParser {

    @Override
    public UUID parseInternal(String uuidString) {
        final String str1 = uuidString.substring(0, 8) + "-";
        final String str2 = str1 + uuidString.substring(8, 12) + "-";
        final String str3 = str2 + uuidString.substring(12, 16) + "-";
        final String str4 = str3 + uuidString.substring(16, 20) + "-";
        final String finalStr = str4 + uuidString.substring(20, 32);


        return UUID.fromString(finalStr);
    }

}

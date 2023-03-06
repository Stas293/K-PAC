package org.spring.app.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Parser() {
    }

    public static String valueToTree(Object value) {
        return OBJECT_MAPPER.valueToTree(value).toString();
    }
}

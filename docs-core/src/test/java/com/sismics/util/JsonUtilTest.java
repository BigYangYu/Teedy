package com.sismics.util;

import junit.framework.TestCase;

import javax.json.JsonValue;

public class JsonUtilTest extends TestCase {

    public void testNullable() {
        String s = null;
        JsonValue x = JsonUtil.nullable(s);
        assertEquals(x, JsonValue.NULL);
    }
}
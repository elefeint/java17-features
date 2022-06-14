package com.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstanceofTest {

    String instanceOf11(Object something) {
        if (something instanceof String) {
            return "I'm a string of length " + ((String) something).length();
        } else if (something instanceof Integer) {
            Integer tempVariable = (Integer) something;
            return "I am a " + (tempVariable > 1000 ? "big" : "small") + " integer";
        } else {
            return "no idea";
        }
    }

    String instanceOf17(Object something) {
        // By the way, the variable scoping for pattern matching is... unique.
        // Try using `str` inside of the same if statement.
        if (something instanceof String str) {
            return "I'm a string of length " + str.length();
        } else if (something instanceof Integer num) {
            return "I am a " + (num > 1000 ? "big" : "small") + " integer";
        } else {
            return "no idea";
        }
    }

    @Test
    void theyDoTheSameThing() {
        assertEquals(instanceOf11("blah"), instanceOf17("blah"));
        assertEquals(instanceOf11(10), instanceOf17(10));
        assertEquals(instanceOf11(10_000), instanceOf17(10_000));
    }

}

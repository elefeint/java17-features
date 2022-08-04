package com.examples;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

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

    String instanceOf17_withGenerics_DoNotDoThis(Object something) {

        // this, for some bizarre reason, works (probably because ? equivalent to ungenericized)
        if (something instanceof Collection<?> str) {
            return "I'm a collection of size " + str.size();
        }

        /* here are all the ways that don't work:

        //Error:  'Object' cannot be safely cast to 'Collection<? extends CharSequence>'
        if (something instanceof Collection<? extends CharSequence> str) {
            return "nope";
        }

        // Error:  'Object' cannot be safely cast to 'Collection<? super Object>'
        if (something instanceof Collection<? super Object> str) {
            return "nope";
        }

        // Error: 'Object' cannot be safely cast to 'Collection<String>'
        if (something instanceof Collection<String> str) {
            return "nope";
        }
        */

        return "whatever";
    }

    @Test
    void theOnlyGenericWayThatWorks() {
        assertEquals("I'm a collection of size 2",
                instanceOf17_withGenerics_DoNotDoThis(List.of("blah", "blah")));
    }

    @Test
    void theyDoTheSameThing() {
        assertEquals(instanceOf11("blah"), instanceOf17("blah"));
        assertEquals(instanceOf11(10), instanceOf17(10));
        assertEquals(instanceOf11(10_000), instanceOf17(10_000));
    }

}

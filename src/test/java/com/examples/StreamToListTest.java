package com.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// small but pleasant improvement
public class StreamToListTest {

    @Test
    void stream() {
        List<String> expected = Arrays.asList("a", "b", "c");

        // Java 11 style
        assertEquals(expected, Stream.of("a", "b", "c").collect(Collectors.toList()));

        // Java 17 style
        assertEquals(expected, Stream.of("a", "b", "c").toList());
    }
}

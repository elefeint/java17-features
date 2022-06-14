package com.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumbersTest {

    @Test
    void compactNumbersAndWhereToFindThem() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

        assertEquals("3B", fmt.format(3_141_592_653L));
        assertEquals("3M", fmt.format(2_900_000));
        assertEquals("2K", fmt.format(2_500));
        assertEquals("3K", fmt.format(2_501));
    }
}

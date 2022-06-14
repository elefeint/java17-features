package com.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeOfDayTest {

    @Test
    public void soundHuman() {
        DateTimeFormatter timeOfDayFormatter = DateTimeFormatter.ofPattern("'We drink coffee' B");

        assertEquals("We drink coffee in the morning", timeOfDayFormatter.format(LocalTime.of(9, 30)));
        assertEquals("We drink coffee in the afternoon", timeOfDayFormatter.format(LocalTime.of(12, 30)));
        assertEquals("We drink coffee in the evening", timeOfDayFormatter.format(LocalTime.of(18, 30)));

    }

    @Test
    public void soundHumanInGerman() {
        DateTimeFormatter timeOfDayFormatter =
                DateTimeFormatter.ofPattern("'wir trinken' B 'kaffee'", Locale.GERMANY);

        assertEquals("wir trinken morgens kaffee", timeOfDayFormatter.format(LocalTime.of(9, 30)));
        assertEquals("wir trinken mittags kaffee", timeOfDayFormatter.format(LocalTime.of(12, 30)));
        assertEquals("wir trinken abends kaffee", timeOfDayFormatter.format(LocalTime.of(18, 30)));

    }

}

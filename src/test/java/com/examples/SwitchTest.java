package com.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SwitchTest {


    int switch11(String input) {
        String output;

        switch (input) {
            case "summer":
                output = "hot";
                break;
            case "spring":
                output = "warm";
                break;
            case "winter":
                output = "cold";
                break;
            case "fall":
            case "autumn":
                output = "depends on your luck";
                break;
            default:
                output = "dunno, check the weather app";
        }

        return output.length();
    }

    int switch17(String input) {
        String output = switch (input) {
            case "summer" -> "hot";
            case "spring" -> "warm";
            case "winter" -> "cold";
            case "fall", "autumn" -> "depends on your luck";
            default -> "dunno, check the weather app";  // default is required now!
        }; // notice the semicolon -- it's a statement, not a block now

        return output.length();
    }

    @Test
    void theyDoTheSameThing() {
        assertEquals(switch11("summer"), switch17("summer"));
        assertEquals(switch11("fall"), switch17("fall"));
        assertEquals(switch11("winter"), switch17("winter"));
        assertEquals(switch11("spring"), switch17("spring"));
        assertEquals(switch11("whatever"), switch17("whatever"));
    }

}

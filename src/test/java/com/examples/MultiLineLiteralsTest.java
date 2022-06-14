package com.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example from Spring Cloud GCP's DatastoreSampleApplicationIntegrationTests.
 */
public class MultiLineLiteralsTest {

    // With Java 11: tedious concatenation to achieve
    //   1) readability
    //   2) 80 or 120 character cutoff (so, also readability)
    String validation11 =
            "Using Pageable parameter\n"
                    + "Singer{singerId='singer1', firstName='John', lastName='Doe', "
                    + "albums=[], firstBand=null, bands=, personalInstruments=}\n"
                    + "Singer{singerId='singer2', firstName='Jane', lastName='Doe', "
                    + "albums=[Album{albumName='a', date=2012-01-20}";

    // With Java 17; looking better
    String validation17 = """
            Using Pageable parameter
            Singer{singerId='singer1', firstName='John', lastName='Doe', albums=[], firstBand=null, bands=, personalInstruments=}
            Singer{singerId='singer2', firstName='Jane', lastName='Doe', albums=[Album{albumName='a', date=2012-01-20}""";


    // But wait, now the lines are longer than 120 characters. Can this be fixed?
    // Yep; it's as easy as escaping the physical newline character
    String validation17_soft_breaks = """
                Using Pageable parameter
                Singer{singerId='singer1', firstName='John', lastName='Doe', \
                albums=[], firstBand=null, bands=, personalInstruments=}
                Singer{singerId='singer2', firstName='Jane', lastName='Doe', \
                albums=[Album{albumName='a', date=2012-01-20}""";

    @Test
    public void theyAreAllTheSameString() {
        assertEquals(validation11, validation17);
        assertEquals(validation11, validation17_soft_breaks);

    }

}

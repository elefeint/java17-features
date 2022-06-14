package com.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// As a bonus to records, static stuff is now allowed inside of inner classes.
public class RecordsTest {

    Cat11 cat11 = new Cat11("Olaf", null, 0, Arrays.asList("plastic spiral"));
    Cat17 cat17 = new Cat17("Olaf", null, 0, Arrays.asList("plastic spiral"));
    Cat17WithExtraStuff cat17extra = new Cat17WithExtraStuff("Olaf", null, 0, Arrays.asList("plastic spiral"));


    @Test
    void theyDoTheSameThing() {

        assertEquals("Olaf", cat11.getName());
        assertEquals("Olaf", cat17.name());
        assertEquals("Olaf", cat17extra.name());
    }


    @Test
    void doTheyThough() {
        // The manually implemented hashCode/equals only use one field -- "name".
        // Autogenerated records hashCodeEquals uses all the fields.
        assertNotEquals(cat11.hashCode(), cat17.hashCode());

        // But records are just classes with some autogeneration, so you can override anything.
        assertEquals(cat11.hashCode(), cat17extra.hashCode());
    }
}

// Literally, this is it. This is the whole record.
record Cat17 (String name, String whiskerColor, int appetite, Collection<String> favoriteToys) {
}


// but what if we want a bit more flexibility?
record Cat17WithExtraStuff(String name, String whiskerColor, int appetite, Collection<String> favoriteToys) {
    public Cat17WithExtraStuff(String name) {
        this(name, null, 0, new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat17WithExtraStuff)) return false;

        Cat17WithExtraStuff that = (Cat17WithExtraStuff) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

// The equivalent traditional class
class Cat11 {
    private String name;

    private String whiskerColor;
    private int appetite;
    private Collection<String> favoriteToys;

    public Cat11(String name) {
        this.name = name;
    }

    public Cat11(String name, String whiskerColor, int appetite, Collection<String> favoriteToys) {
        this.name = name;
        this.whiskerColor = whiskerColor;
        this.appetite = appetite;
        this.favoriteToys = favoriteToys;
    }

    public String getName() {
        return name;
    }

    public String getWhiskerColor() {
        return whiskerColor;
    }

    public int getAppetite() {
        return appetite;
    }

    public Collection<String> getFavoriteToys() {
        return favoriteToys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat11)) return false;

        Cat11 cat11 = (Cat11) o;

        return name.equals(cat11.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
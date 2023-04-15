package de.swen.pflege;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourplanTest extends TestCase {

    @Test(timeout = 1000)
    public void NameLenghtThree() {
        String name = new String();
        for (int i = 0; i <= 3; i++) {
            name += "A";
        }
        assertEquals(3, name.length());
        assertEquals("AAA", name);
    }
}
    @Test(timeout = 1000)
    public void NameIsNull() {

    }
}
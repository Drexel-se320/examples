package edu.drexel.se320;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestMin {

    @Test
    public void testmin1() {
        assertEquals(0, Min.min(0,1));
    }

    @Test
    public void testshouldfail() {
        assertEquals(34, Min.min(0,1));
    }

    @Test
    public void failAssertion() {
        assert false;
    }
}



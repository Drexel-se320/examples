package edu.drexel.se320;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class TestEditDistance {

    // How thoroughly have we really tested these after 100% coverage?

    // This test is only here so we can run the rest of this test class even with other tests commented out.
    @Test
    public void trivial() { assertTrue(true); }

    @Test
    public void nodiff() {
        assertEquals(0, EditDistance.naiveEditDistance("hi", "hi"));
    }

    @Test
    public void smalldiff() {
        assertEquals(1, EditDistance.naiveEditDistance("hi", "Hi"));
    }

    //@Property(tries = 100, shrinking = ShrinkingMode.BOUNDED)
    //public boolean capitalizationBound(@ForAll @StringLength(min=0, max=10) String s) {
    //    return EditDistance.naiveEditDistance(s, s.toUpperCase()) <= s.length();
    //}


}



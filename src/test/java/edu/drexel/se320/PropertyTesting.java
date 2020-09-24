package edu.drexel.se320;

import static edu.drexel.se320.Min.min;

// Jqwik
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
// No annotation is required for jqwik to find the tests
public class PropertyTesting {

    @Property(tries = 250, shrinking = ShrinkingMode.BOUNDED)
    public boolean checkMinRight(@ForAll int x, @ForAll int y) {
        Assume.that(x > y);
        return min(x,y) == y;
    }
    @Property(tries = 250, shrinking = ShrinkingMode.BOUNDED)
    public boolean checkMinLeft(@ForAll int x, @ForAll int y) {
        Assume.that(x < y);
        return min(x,y) == y;
    }
}

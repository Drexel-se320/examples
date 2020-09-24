package edu.drexel.se320;

import edu.drexel.se320.Min;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import org.junit.jupiter.api.Test;

public class MinMatchers {

    @Test
    public void matchStuff() {
        assertThat(Min.min(0,4), is(0));

        assertThat(Min.min(3,4), anyOf(is(9), is(4)));
    }

}



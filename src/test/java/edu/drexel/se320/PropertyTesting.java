package edu.drexel.se320;

import static edu.drexel.se320.Min.min;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

// Jqwik
import net.jqwik.api.*;
import net.jqwik.api.Tuple.Tuple2;
import net.jqwik.api.constraints.*;
import net.jqwik.api.statistics.Statistics;
// No annotation is required for jqwik to find the tests
public class PropertyTesting {

    @Property
    public boolean checkMin(@ForAll int x, @ForAll int y) {
        int m = min(x, y);
        return m <= x && m <= y;
    }

    @Property public boolean minCommutative(@ForAll int x, @ForAll int y) {
        return min(x,y) == min(y,x);
    }

    // Custom generator for HashMap<Integer,Integer>
    @Provide
    Arbitrary<HashMap<Integer,Integer>> hashMaps() {
        return Arbitraries.integers()   // start with integer generation
                .tuple2()               // generate pairs of them (tuples)
                .list()     // generate lists of those (pairs)
                .uniqueElements(p -> p.get1()) // unique first element of the pair
                .map(l -> {
                    HashMap<Integer,Integer> m = new HashMap<>();
                    for (Tuple2<Integer,Integer> p : l) {
                        m.put(p.get1(), p.get2());
                    }
                    return m;
                });
                // Finally, transform each list of pairs into a hashmap
    }


    @Property(tries = 250, shrinking = ShrinkingMode.BOUNDED)
    public boolean checkKeyValues(@ForAll("hashMaps") HashMap<Integer,Integer> m) {
        Set<Integer> keyset = m.keySet();
        Collection<Integer> vals = m.values();
        for (Integer k : keyset) {
            if (!vals.contains(m.get(k))) {
                return false;
            }
        }
        return true;
    }





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


    // This property will only succeed if the map [1->1] is generated 250 times...
    // Best to avoid doing this with "general-purpose" generators
    // Instead, use a specialized generator, e.g., one that only generates one-entry maps with keys and values from a narrow range
    @Property(tries = 250, shrinking = ShrinkingMode.BOUNDED)
    public boolean check11Map(@ForAll("hashMaps") HashMap<Integer,Integer> m) {
        Assume.that(m.size() == 1);
        Assume.that(m.containsKey(1));
        Assume.that(m.get(1) == 1);
        return true;
    }

    @Property
    public boolean checkMinWithStats(@ForAll int x, @ForAll int y) {
        int m = min(x, y);
        // Can only choose one kind of statistic to collect on each property
        Statistics.collect(x, y);
        //Statistics.collect(x < y);
        return m <= x && m <= y;
    }


    @Example
    public boolean checkMin34() {
        return min(3,4) == 3;
    }

}

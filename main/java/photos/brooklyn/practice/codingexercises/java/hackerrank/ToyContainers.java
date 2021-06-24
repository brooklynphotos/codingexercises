package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/priyanka-and-toys/problem
 */
public class ToyContainers {

    public static int toys(List<Integer> w) {
        Collections.sort(w);
        int count = 0;
        Integer base = null;
        final int extra = 4;
        for (int x : w) {
            if (base == null || x > base + extra) {
                base = x;
                count++;
            }
        }
        return count;
    }

}

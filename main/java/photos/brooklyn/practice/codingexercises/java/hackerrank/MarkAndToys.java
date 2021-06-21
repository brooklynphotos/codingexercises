package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Collections;
import java.util.List;

public class MarkAndToys {
    public static int maximumToys(List<Integer> prices, int k) {
        Collections.sort(prices);
        int count = 0;
        for (int p : prices) {
            if(p>k) return count;
            count++;
            k -= p;
        }
        return count;
    }
}

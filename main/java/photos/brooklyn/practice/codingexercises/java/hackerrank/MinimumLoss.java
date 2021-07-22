package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/minimum-loss/problem
 */
public class MinimumLoss {
    public static int minimumLoss(List<Long> price) {
        long diff = -(long)(10e16 + 1L);
        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            indexMap.put(price.get(i), i);
        }
        Collections.sort(price);
        for (int i = 1; i < price.size(); i++) {
            final Long curVal = price.get(i);
            final Long prevVal = price.get(i - 1);
            final long difference = (curVal - prevVal) * (indexMap.get(curVal) - indexMap.get(prevVal) < 0 ? -1 : 1);
            if (difference > 0) {
                continue;
            }
            diff = Math.max(diff, difference);
        }
        return -(int) diff;
    }
}

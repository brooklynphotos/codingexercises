package photos.brooklyn.practice.codingexercises.java.codility;

// you can also use imports, for example:
import java.util.*;

public class TargetInteger {

    public static void main(String [] args) {
        final int[] A = {-3,4,-1,5};
        final int target = 9;
        final int[] answer = findPair(A, target);
        if(answer==null){
            System.out.println("Can't find a pair that adds to "+target);
        }else{
            System.out.println(answer[0] + "," + answer[1]);
        }
    }

    /**
     *
     */
    static int[] findPair(int[] A, int target){
        // Need at least two numbers for this to make sense
        if (A.length < 2) {
            return null;
        }
        // keeps track of the unique numbers and their counts in the array
        final Map<Integer, Integer> numberCounts = new HashMap<>();
        for(int a : A) {
            numberCounts.compute(a, (n, count) -> count == null ? 1 : count + 1);
        }
        for(int a : A) {
            final long diffLong = target - a;
            // only integer-size values exist in our input A
            if(Math.abs(diffLong) > Integer.MAX_VALUE) continue;
            final int diff = (int)diffLong;
            // we have a winner if the candidate exists in the map AND that if that candidate is the same as `a`,
            // we must have at least two instances of `a`
            final Integer maybeCount = numberCounts.get(diff);
            if (maybeCount != null && (diff != a || maybeCount > 1)) {
                return new int[]{a, diff};
            }
        }
        return null;
    }
}

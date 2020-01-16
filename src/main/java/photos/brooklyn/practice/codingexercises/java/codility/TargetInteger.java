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
        final Set<Integer> set = new HashSet<>();
        for(int a : A) {
            set.add(a);
        }
        for(int a : A) {
            final long diff = target - a;
            if(Math.abs(diff) < Integer.MAX_VALUE && set.contains((int)diff)){
                // if diff is in the set, we know it's an int
                return new int[]{a, (int)diff};
            }
        }
        return null;
    }
}

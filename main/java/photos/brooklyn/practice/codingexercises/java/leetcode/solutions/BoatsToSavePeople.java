package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/discuss/156740/C++JavaPython-Two-Pointers
 */
public class BoatsToSavePeople {
    /**
     * the idea is that the heaviest person that hasn't gotten on the boat must go on the boat, and if the lightest person
     * still waiting is too heavy to go with the him, then he goes to the boat alone as everyone must go in the boat
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        // ascending
        Arrays.sort(people);
        // two pointers, one in the front, one starting from the back
        int i, j;
        for (i = 0, j = people.length - 1; i <= j; --j)
            // only advance the lighter pointer if a lighter person can sit with the heavier one, else heavier one is alone
            if (people[i] + people[j] <= limit) ++i;
        return people.length - 1 - j;
    }
}

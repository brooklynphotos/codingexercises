package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/contest/weekly-contest-96/problems/boats-to-save-people/
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        final Set<Integer> peopleWaiting = IntStream.range(0, people.length).boxed().collect(Collectors.toSet());
        final int halfLimit = limit / 2;
        final int[] weightList = Arrays.stream(people)
                .boxed()
                .sorted(Comparator.comparingInt(a -> Math.abs(a - halfLimit)))
                .mapToInt(Integer::intValue)
                .toArray();
        int boatCount = 0;
        for (int i=0;i<weightList.length;i++) {
            // no longer waiting
            if(!peopleWaiting.contains(i)) continue;
            boardBoat(i, peopleWaiting, weightList, limit);
            boatCount++;
        }
        return boatCount;
    }

    private void boardBoat(final Integer personIndex, final Set<Integer> peopleWaiting, final int[] weightList, final int limit) {
        peopleWaiting.remove(personIndex);
        // find a possible partner
        final int spaceLeft = limit - weightList[personIndex];
        for (int i = personIndex + 1; i < weightList.length && spaceLeft > 0; i++) {
            final int weight = weightList[i];
            // found his buddy
            if (weight <= spaceLeft) {
                peopleWaiting.remove(i);
                break;
            }
        }
    }
}

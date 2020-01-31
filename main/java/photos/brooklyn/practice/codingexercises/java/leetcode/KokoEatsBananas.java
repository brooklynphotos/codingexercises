package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;


/**
 * https://leetcode.com/contest/weekly-contest-94/problems/koko-eating-bananas/
 */
public class KokoEatsBananas {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        final int smallest = 1;
        final int largest = piles[piles.length - 1];
        // the largest will obviously work since H is not smaller than the length of piles
        // start with the smallest and go up half way to largest
        return getMinSpeedInRange(H, piles, smallest, largest);
    }

    /**
     *
     * @param maxHours
     * @param piles
     * @param smallest
     * @param largest guaranteed to perform better or same as H
     * @return
     */
    private static int getMinSpeedInRange(final int maxHours, final int[] piles, final int smallest, final int largest) {
        // if the smallest rate can get the hours, that's the answer
        final long hoursRequiredForSmallest = calculateHours(piles, smallest);
        if(hoursRequiredForSmallest<=maxHours) return smallest;
        if(largest==smallest+1) return largest;
        // then the answer must be greater than smallest. Try the midpoint
        final int midpoint = (largest+smallest)/2;
        final long hoursRequiredForMidpoint = calculateHours(piles, midpoint);
        if(hoursRequiredForMidpoint<=maxHours){
            // must be in the lower bound, not including the failed smallest
            return getMinSpeedInRange(maxHours, piles, smallest+1, midpoint);
        }else{
            // so it's in the upperbound, not including this midpoint
            return getMinSpeedInRange(maxHours, piles, midpoint+1, largest);
        }
    }

    private static long calculateHours(final int[] piles, final int rate) {
        long totalHours=0;
        for(final int pileSize : piles){
            totalHours += Math.ceil(pileSize/(double)rate);
        }
        return totalHours;
    }

}

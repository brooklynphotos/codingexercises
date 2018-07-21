package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/minimum-number-of-refueling-stops/
 */
public class MininumRefuelingStopsGreedy {
    public int minRefuelStops(final int target, final int startFuel, final int[][] stations) {
        // keep searching for the reachable station that has the largest amount of fuel
        return getRefueling(target, startFuel, stations, 0, 0);
    }

    private static int getRefueling(final int target, final int startFuel, final int[][] stations, final int startIndex, final int step){
        int stationIndex = startIndex;
        final int distanceFromStart = startIndex==0 ? 0 : stations[startIndex-1][0];
        final int mileage = startFuel + distanceFromStart;
        // if we can reach the target!
        if(mileage>=target) return step;
        int maxStationIndex = -1;
        int maxFinalFuel = 0;
        while(stationIndex<stations.length){
            final int[] station = stations[stationIndex++];
            final int stationFromStart = station[0];
            final int stationFuel = station[1];
            if(stationFromStart>mileage) break; // can't reach this or anything thereafter
            final int finalFuel = mileage - stationFromStart + stationFuel;
            if(maxStationIndex==-1 || finalFuel>maxFinalFuel){
                maxStationIndex = stationIndex-1; // account for already having incremented
                maxFinalFuel = finalFuel;
            }
        }
        // found no station we can reach, so we are done and dead
        if(maxStationIndex==-1) return -1;
        // so now we have the station with the highest fuel
        final int[] maxStation = stations[maxStationIndex];
        return getRefueling(target,maxFinalFuel,stations,maxStationIndex+1,step+1);
    }

    private static class State{
        private final int fuel;
        private final int lastStationIndex;
        private final int stationCount;
        private final String id;
        private State(final int fuel, final int lastStationIndex, final int stationCount){
            this.fuel = fuel;
            this.stationCount = stationCount;
            this.lastStationIndex = lastStationIndex;
            this.id = String.format("%d,%d,%d",fuel,lastStationIndex,stationCount);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(id, state.id);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return id;
        }
    }

}

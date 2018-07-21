package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/minimum-number-of-refueling-stops/
 * 1. given the initial state at point 0, can you reach the target? If so, return the count (initially 0), If not:
 * 2. Put all the stations you can reach in a stack, with the farthest one on top
 * 3. pop that one out, and repeat step 1 using an incremented count
 * 4. if there are no more stations and you can't reach the target, then try the next one on the stack with a decremented count
 * 5. if there's nothing more in the stack, return -1
 */
public class MininumRefuelingStopsDFS {
    public int minRefuelStops(final int target, final int startFuel, final int[][] stations) {
        // keep searching for the reachable station that has the largest amount of fuel
        return getRefueling(target, new State(startFuel, -1,0), stations, new LinkedList<>());
    }

    private static int getRefueling(final int target, final State state, final int[][] stations, final Deque<int[]> stationsStack){
        int stationIndex = state.lastStationIndex+1;
        final int distanceFromStart = state.getDistanceFromOrigin(stations);
        final int mileage = state.fuel + distanceFromStart;
        // if we can reach the target!
        if(mileage>=target)
            return state.stationCount;
        int newLevelsCount = 0;
        while(stationIndex<stations.length){
            final int[] station = stations[stationIndex++];
            final int stationFromStart = station[0];
            if(stationFromStart>mileage) break; // can't reach this or anything thereafter
            stationsStack.push(station);
            newLevelsCount++;
        }
        if(stationsStack.isEmpty()) return -1;
        final int[] farthestStation = stationsStack.pop();
        final State farthestStationState = State.goTo(state, farthestStation, stations, newLevelsCount+state.lastStationIndex);
        return getRefueling(target,farthestStationState,stations,stationsStack);
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

        public static State goTo(final State originState, final int[] destinationStation, final int[][] stations, final int stationIndex) {
            final int finalFuel = originState.fuel + originState.getDistanceFromOrigin(stations) - destinationStation[0] + destinationStation[1];
            return new State(finalFuel,stationIndex, originState.stationCount+1);
        }

        public int getDistanceFromOrigin(int[][] stations){
            return lastStationIndex==-1 ? 0 : stations[lastStationIndex][0];
        }
    }

}

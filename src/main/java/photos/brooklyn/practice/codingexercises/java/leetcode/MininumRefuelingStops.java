package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/minimum-number-of-refueling-stops/
 */
public class MininumRefuelingStops {
    public int minRefuelStops(final int target, final int startFuel, final int[][] stations) {
        int iterations = 0;
        // the queue contains all the starting points on each layer of the BFS
        // starting with the startFuel
        Queue<State> possibleStates = new LinkedList<>();
        possibleStates.offer(new State(0, startFuel, -1, 0)); // starting with the beginning state
        // making sure we only have unique stations in the new states
        final int[] stationMaxFuel = new int[stations.length];
        while(!possibleStates.isEmpty()){
            // among the new states, we only want to keep the states with the highest fuel for a the station
            final Map<Integer, State> maxStateResult = new HashMap<>(stations.length);
            final int queueSize = possibleStates.size();
            for(int q = 0; q<queueSize; q++) {
                State possibleState = possibleStates.poll();
                final int distanceFromTarget = target - possibleState.distanceFromStart;
                if(possibleState.fuel>=distanceFromTarget) {
                    System.out.println(iterations);
                    return possibleState.stationCount; // we have enough fuel to go from here to the target!
                }
                // we don't have enough, so let's see what fueling station can we get to from here
                int s=possibleState.lastStationIndex+1;
                while(s<stations.length){
                    iterations++;
                    final int[] station = stations[s++];
                    final int stationFromStart = station[0];
                    final int stationFuel = station[1];
                    final int distanceToStation = stationFromStart - possibleState.distanceFromStart;
                    if(distanceToStation>possibleState.fuel) break; // too far, can't reach the station or any beyond it
                    // we can get to that station during this step! Create new state
                    final State newState = new State(stationFromStart, possibleState.fuel-distanceToStation+stationFuel, s-1, possibleState.stationCount+1);
                    // do we already have a state that is in this station with more fuel? if so, don't bother
                    final int previousFuelAtStation = stationMaxFuel[newState.lastStationIndex];
                    if(previousFuelAtStation>newState.fuel) continue;

                    stationMaxFuel[newState.lastStationIndex] = newState.fuel;
                    // see if the new state has better fuel than the state already checked at this station
                    final State prevMax = maxStateResult.get(newState.lastStationIndex);
                    if(prevMax != null && prevMax.fuel>newState.fuel) continue;
                    maxStateResult.put(newState.lastStationIndex, newState);
                }
            }
            // lets now add the newly qualified states to the queue
            for(final State newState : maxStateResult.values()) {
                possibleStates.offer(newState);
            }
        }
        return -1;
    }

    private static class State{
        private final int fuel;
        private final int distanceFromStart;
        private final int lastStationIndex;
        private final int stationCount;
        private final String id;
        private State(final int distanceFromStart, final int fuel, final int lastStationIndex, final int stationCount){
            this.fuel = fuel;
            this.distanceFromStart = distanceFromStart;
            this.stationCount = stationCount;
            this.lastStationIndex = lastStationIndex;
            this.id = String.format("%d,%d,%d,%d",distanceFromStart,fuel,lastStationIndex,stationCount);
        }

        String stateWithoutCount() {
            return String.format("%d,%d", fuel,distanceFromStart);
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

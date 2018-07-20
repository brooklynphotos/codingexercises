package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/minimum-number-of-refueling-stops/
 */
public class MininumRefuelingStops {
    public int minRefuelStops(final int target, final int startFuel, final int[][] stations) {
        // the queue contains all the starting points on each layer of the BFS
        // starting with the startFuel
        Queue<State> possibleStates = new LinkedList<>();
        possibleStates.offer(new State(0, startFuel, (short)-1, (short)0)); // starting with the beginning state
        while(!possibleStates.isEmpty()){
            for(int q=0;q<possibleStates.size();q++) {
                State possibleState = possibleStates.poll();
                final int distanceFromTarget = target - possibleState.distanceFromStart;
                if(possibleState.fuel>=distanceFromTarget) return possibleState.stationCount; // we have enough fuel to go from here to the target!
                // we don't have enough, so let's see what fueling station can we get to from here
                short s=(short)(possibleState.lastStationIndex+1);
                while(s<stations.length){
                    final int[] station = stations[s];
                    final int stationFromStart = station[0];
                    final int stationFuel = station[1];
                    final int distanceToStation = stationFromStart - possibleState.distanceFromStart;
                    if(distanceToStation>possibleState.fuel) break; // too far, can't reach the station or any beyond it
                    // we can get to that station during this step! Create new state
                    possibleStates.offer(new State(stationFromStart, possibleState.fuel-distanceToStation+stationFuel, s, (short)(possibleState.stationCount+1)));
                    s++;
                }
                possibleState = null;
            }
        }
        return -1;
    }

    private static class State{
        private final int fuel;
        private final int distanceFromStart;
        private final short lastStationIndex;
        private final short stationCount;
        private State(final int distanceFromStart, final int fuel, final short lastStationIndex, final short stationCount){
            this.fuel = fuel;
            this.distanceFromStart = distanceFromStart;
            this.stationCount = stationCount;
            this.lastStationIndex = lastStationIndex;
        }
    }

}

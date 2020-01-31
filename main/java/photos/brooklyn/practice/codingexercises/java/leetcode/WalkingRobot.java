package photos.brooklyn.practice.codingexercises.java.leetcode;

import scala.Int;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/contest/weekly-contest-94/problems/walking-robot-simulation/
 */
public class WalkingRobot {
    private enum TurnCode {
        LEFT(-2), RIGHT(-1);

        private final int code;

        TurnCode(final int code) {
            this.code = code;
        }

        private static TurnCode convert(int i){
            for(TurnCode c : values()){
                if(i==c.code) return c;
            }
            throw new IllegalArgumentException("Bad code: "+i);
        }
    }
    private enum Direction {
        Y_POSITIVE(1) {
            @Override
            Direction changeDirection(final TurnCode code) {
                return code==TurnCode.LEFT ? X_NEGATIVE : X_POSITIVE;
            }
        },Y_NEGATIVE(-1) {
            @Override
            Direction changeDirection(final TurnCode code) {
                return code==TurnCode.LEFT ? X_POSITIVE : X_NEGATIVE;
            }
        },X_POSITIVE(1) {
            @Override
            Direction changeDirection(final TurnCode code) {
                return code==TurnCode.LEFT ? Y_POSITIVE : Y_NEGATIVE;
            }
        },X_NEGATIVE(-1) {
            @Override
            Direction changeDirection(final TurnCode code) {
                return code==TurnCode.LEFT ? Y_NEGATIVE : Y_POSITIVE;
            }
        };

        private final int increment;

        Direction(final int increment) {
            this.increment = increment;
        }

        abstract Direction changeDirection(TurnCode code);

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        final Map<Integer, TreeSet<Integer>> xMap = new HashMap<>();
        final Map<Integer, TreeSet<Integer>> yMap = new HashMap<>();
        populateObstacleMaps(obstacles, xMap, yMap);
        return walk(commands, xMap, yMap);
    }

    private static int walk(final int[] commands, final Map<Integer,TreeSet<Integer>> xMap, final Map<Integer,TreeSet<Integer>> yMap) {
        int[] state  = {0,0};
        int max = 0;
        Direction direction = Direction.Y_POSITIVE;
        for(int i=0;i<commands.length;i++){
            final int com = commands[i];
            if(com<0){
                direction = direction.changeDirection(TurnCode.convert(com));
                continue;
            }
            // we are moving, not turning
            switch (direction){
                case Y_POSITIVE:
                case Y_NEGATIVE:
                    state = new int[]{state[0],walk(state[1],com, direction.increment, xMap.get(state[0]))};
                    break;
                case X_NEGATIVE:
                case X_POSITIVE:
                    state = new int[]{walk(state[0],com, direction.increment, yMap.get(state[1])), state[1]};
                    break;
            }
            max = Math.max(max,state[0]* state[0] + state[1]* state[1]);
        }
        return max;
    }

    static int walk(final int start, final int steps, final int increment, final TreeSet<Integer> obstacles) {
        Integer obstacle = null;
        if(obstacles != null)
            obstacle = increment>0 ? obstacles.ceiling(start) : obstacles.floor(start);
        final int unobstructed = start + (increment * steps);
        if(obstacle != null){
            final int obstructed = obstacle - increment;
            return increment>0 ? Math.min(obstructed, unobstructed) : Math.max(obstructed, unobstructed);
        }else{
            return unobstructed;
        }
    }

    private static void populateObstacleMaps(final int[][] obstacles, final Map<Integer,TreeSet<Integer>> xMap, final Map<Integer,TreeSet<Integer>> yMap) {
        for(final int[] ob : obstacles){
            final int x = ob[0];
            final int y = ob[1];
            populate(xMap, x, y);
            populate(yMap, y, x);
        }
    }

    private static void populate(final Map<Integer,TreeSet<Integer>> map, final int k, final int v) {
        TreeSet<Integer> set = map.get(k);
        if(set==null){
            set = new TreeSet<>();
            map.put(k, set);
        }
        set.add(v);
    }
}

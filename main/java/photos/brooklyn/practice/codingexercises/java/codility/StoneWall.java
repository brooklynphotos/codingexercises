package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/start/
 */
public class StoneWall {
    public int solution(int[] H) {
        // this stack always only has rising heights
        final Stack<Integer> risers = new Stack<>();
        int res = 0;
        for (int h : H) {
            // keep popping and incrementing the result until the latest riser is smaller than the current one
            while (!risers.empty() && risers.peek() > h) {
                risers.pop();
                res++;
            }
            // if the new h is greater than the last riser, push it in
            if (risers.empty() || h > risers.peek()) {
                risers.push(h);
            }
        }
        return res + risers.size();
    }
}

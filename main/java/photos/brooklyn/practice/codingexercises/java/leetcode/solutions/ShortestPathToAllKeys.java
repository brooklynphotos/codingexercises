package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/discuss/147094/Concise-Java-Solution-68ms
 */
public class ShortestPathToAllKeys {
    public int shortestPathAllKeys(String[] g) {
        State start = null;
        // allKeys = integer encapsulating all the keys by OR operations with 'a' ==0
        // dir[] represents a way to obtain the four possible directions at any given point
        // steps is what keeps track of the steps taken
        int allKeys = 0, dir[] = {-1, 0, 1, 0, -1}, steps = 0, n = g.length, m = g[0].length();
        char[][] a = new char[n][m];
        // convert the array of strings to a matrix of chars
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                a[i][j] = g[i].charAt(j);
                // discovered the initial state
                if (a[i][j] == '@')
                    start = new State(i, j, 0);
                // finds a key so "pushing" it into the allKeys int
                else if (Character.isLowerCase(a[i][j]))
                    allKeys |= 1 << (a[i][j] - 'a');
            }
        final Queue<State> q = new LinkedList<>();
        final Set<String> seen = new HashSet<>();
        // adds the start to a queue
        q.offer(start);
        // indicate that we've seen the start
        seen.add(start.id);
        while (!q.isEmpty()) {
            steps++;
            // for every item in the CURRENT queue, which is FIFO
            // and add new unseen candidates into the queue
            for (int size = q.size(); size > 0; size--) {
                final State state = q.poll();
                // you get a loop of four by moving a window of 2 elements through this array of 5 elements starting with k=1
                for (int k = 1; k < dir.length; k++) {
                    int i = state.r + dir[k - 1], j = state.c + dir[k], keys = state.keys;
                    // if we encounter a wall or outside the boundary of the matrix, do nothing
                    if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] == '#') continue;
                    // if we hit a lock and we have no keys, we also do nothing
                    if (Character.isUpperCase(a[i][j]) && (keys & (1 << (a[i][j] - 'A'))) == 0) continue;
                    // if we see a key, we update our set of keys (which is an int)
                    if (Character.isLowerCase(a[i][j]))
                        keys |= 1 << (a[i][j] - 'a');
                    // if after possibly getting a key, we have all the keys, we are done and return the steps it took us
                    if (keys == allKeys)
                        return steps;
                    // if we didn't hit an impediment but we still don't have enough keys, we will create a new state
                    State nextState = new State(i, j, keys);
                    // we add this state into the queue if we have never seen this state before
                    // note that this addition doesn't affect the first for loop on line 39
                    if (seen.add(nextState.id))
                        q.offer(nextState);
                }
            }
        }
        return -1;
    }

    class State {
        final int r, c, keys;
        final String id;

        State(int r, int c, int keys) {
            this.r = r; this.c = c; this.keys = keys;
            id = r + "," + c + "," + keys;
        }
    }
}

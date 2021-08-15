package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueensAttack2 {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // find the closest obstacles on the eight directions
        int north = n - r_q;
        int east = n - c_q;
        int ne = Math.min(north, east);
        int south = r_q - 1;
        int se = Math.min(south, east);
        int west = c_q - 1;
        int sw = Math.min(south, west);
        int nw = Math.min(north, west);

        for (final List<Integer> ob : obstacles) {
            final int ob_r = ob.get(0);
            final int ob_c = ob.get(1);
            final int rDiff = ob_r - r_q;
            final int cDiff = ob_c - c_q;
            if (cDiff == 0) {
                if (ob_r > r_q) {
                    north = Math.min(north, ob_r - r_q - 1);
                } else {
                    south = Math.min(south, r_q - ob_r - 1);
                }
            }
            if (rDiff == 0) {
                if (ob_c > c_q) {
                    east = Math.min(east, ob_c - c_q - 1);
                }else{
                    west = Math.min(west, c_q - ob_c - 1);
                }
            }
            if (cDiff == rDiff) {
                if (cDiff > 0) {
                    ne = Math.min(ne, cDiff - 1);
                } else {
                    sw = Math.min(sw, -cDiff - 1);
                }
            }
            if (cDiff == -rDiff) {
                if (rDiff > 0) {
                    nw = Math.min(nw, rDiff - 1);
                } else {
                    se = Math.min(se, cDiff - 1);
                }
            }
        }
        return north + east + south + west + ne + nw + se + sw;
    }

}

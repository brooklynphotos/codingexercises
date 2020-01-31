package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-99/problems/surface-area-of-3d-shapes/
 */
public class SurfaceArea3DShapes {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                final int height = grid[row][col];
                if(height==0) continue;
                area += 2
                        + Math.max(0, height - (row > 0 ? grid[row - 1][col] : 0))
                        + Math.max(0, height - (row + 1 < grid.length ? grid[row + 1][col] : 0))
                        + Math.max(0, height - (col > 0 ? grid[row][col - 1] : 0))
                        + Math.max(0, height - (col + 1 < grid[row].length ? grid[row][col + 1] : 0));
            }
        }
        return area;
    }

}

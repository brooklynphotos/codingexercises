package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-96/problems/projection-area-of-3d-shapes/
 */
public class ProjectionArea3D {
    public int projectionArea(int[][] grid) {
        final int size = grid.length;
        int baseSize = 0;
        final int[] frontSizes = new int[size];
        final int[] sideSizes = new int[size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                final int cellHeight = grid[r][c];
                if(cellHeight>0) baseSize++;
                sideSizes[r] = Math.max(sideSizes[r], cellHeight);
                frontSizes[c] = Math.max(frontSizes[c], cellHeight);
            }
        }
        int totalSize = baseSize;
        for (int s : sideSizes) {
            totalSize += s;
        }
        for (int f : frontSizes) {
            totalSize += f;
        }
        return totalSize;
    }
}

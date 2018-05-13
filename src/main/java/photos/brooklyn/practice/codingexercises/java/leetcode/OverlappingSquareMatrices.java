package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-84/problems/image-overlap/
 */
public class OverlappingSquareMatrices {
    public int largestOverlap(int[][] A, int[][] B) {
        int maxOverLap = Math.max(0, countLargestOverlap(A, B));
        return Math.max(maxOverLap, countLargestOverlap(B, A));
    }

    public static int countLargestOverlap(int[][] base, int[][] overlapper) {
        int maxOverlap = 0;
        for(int i=0;i<base.length; i++){
            for(int j=0; j<base.length;j++){
                maxOverlap = Math.max(maxOverlap, countOverlap(base, overlapper, i, j));
            }
        }
        return maxOverlap;
    }

    /**
     * calculates the overlap between two square matrices, the second one being
     * @param base
     * @param overlapper
     * @param iOffset
     * @param jOffset
     * @return
     */
    private static int countOverlap(int[][] base, int[][] overlapper, int iOffset, int jOffset) {
        int count = 0;
        for(int i=iOffset;i<base.length;i++){
            for(int j=jOffset; j<base.length;j++){
                int baseVal = base[i][j];
                int overlapperVal = overlapper[i-iOffset][j-jOffset];
                if(baseVal==overlapperVal && baseVal==1)
                    count++;
            }
        }
        return count;
    }

}

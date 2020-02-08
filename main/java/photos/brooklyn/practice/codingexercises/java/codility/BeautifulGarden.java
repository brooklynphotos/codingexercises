package photos.brooklyn.practice.codingexercises.java.codility;

public class BeautifulGarden {

    /**
     *
     * @param A |A| range 1 to 100_000, a is between 2 and 1_000
     * @return
     */
    public int solution(int[] A) {
        return findMinCut(A, 0);
    }

    /**
     * Finds the minimum number of cuts
     * @param treeHeights
     * @param pivotIndex
     * @return
     */
    private int findMinCut(final int[] treeHeights, final int pivotIndex) {
        int min = Integer.MAX_VALUE;
        // decending all
        if (treeHeights[pivotIndex] > treeHeights[pivotIndex + 1] && treeHeights[pivotIndex + 1] > treeHeights[pivotIndex + 2]) {
            // cut first
            return Math.min(1 + findMinCut(treeHeights, pivotIndex + 1), 1 + findMinCut(treeHeights, pivotIndex + 2));
        }
        return findMinCut(treeHeights, pivotIndex + 1);

    }
}

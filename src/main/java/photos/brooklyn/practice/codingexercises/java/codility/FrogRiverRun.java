package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://www.martinkysel.com/codility-frogriverone-solution/
 */
public class FrogRiverRun {
    public int solution(int X, int[] A) {
        final LeafyPath lp = new LeafyPath(X);
        for (int k = 0; k < A.length; k++) {
            final int pos = A[k];
            lp.dropLeaf(pos);
            if (lp.leafCount == X) {
                return k;
            }
        }
        return -1;
    }

    private static class LeafyPath {
        private final boolean[] leaves; // all false, no leaves
        private int leafCount; // no leaves at the start

        LeafyPath(int size) {
            // note that we aren't using position 0
            this.leaves = new boolean[size + 1];
        }

        void dropLeaf(int position) {
            // not thread safe
            // if there's no leaf
            if (leaves[position] == false) {
                leafCount++;
                leaves[position] = true;
            }
        }
    }

}
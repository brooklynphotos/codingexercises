package photos.brooklyn.practice.codingexercises.java.codility;

public class MaxNonoverlappingSegments {
    /**
     * A and B have the same length set to be <=30,000, each element is between 1 and 1,000,000,000 incl
     * @param A start of a segment
     * @param B end of a segment, >= A, always sorted
     * @return max number of non-overlapping segments
     */
    public int solution(int[] A, int[] B) {
        /*
         * strategy
         * 1. Start with first one, if it's fewer than two, return N
         * 2. Find the next non-overlapping segment, if found, increment result, and search again using the found segment
         * 3. When no more segments are found, return the length of the result list
         */
        if (A.length < 2) {
            return A.length;
        }
        int candidateIndex = 0;
        int res = 0;
        while (candidateIndex < A.length) {
            int nextCandidateIndex = findNonoverlapping(candidateIndex, A, B);
            if (nextCandidateIndex == -1) {
                break;
            }
            res += candidateIndex == 0 ? 2 : 1; // the first candidate index wasn't counted until it found a matching one
            candidateIndex = nextCandidateIndex;
        }
        return res;
    }

    /**
     * finds first segment following the candidate that does not overlap
     * @param candidateIndex
     * @param A
     * @param B
     * @return
     */
    static int findNonoverlapping(final int candidateIndex, final int[] A, final int[] B) {
        for (int i = candidateIndex + 1; i < A.length; i++) {
            if (A[i] > B[candidateIndex]) {
                return i;
            }
        }
        return -1; // failed to find one
    }
}

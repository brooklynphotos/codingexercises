package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/start/
 */
public class MaxCounters {

    /**
     *
     * @param N between 1 and 100_000 incl, number of counters, all starting at 0
     * @param A size is also between 1 and 100_000 incl, each value is between 1 and N+1, incl; sequential instructions
     * @return
     */
    public int[] solution(int N, int[] A) {
        int currentMax = 0;
        int baseline = 0;
        int[] counter = new int[N];
        for (int a : A) {
            if (a > N) {
                baseline += currentMax;
                currentMax = 0; // now we have no current max on the counter array
                counter = new int[N]; // we reset the baseline to zero
            } else {
                int index = a - 1;
                int newVal = counter[index] + 1;
                counter[index] = newVal;
                if (newVal > currentMax) {
                    currentMax = newVal;
                }
            }
        }
        // the result is always the baseline plus whatever the counter says
        for (int i = 0; i < counter.length; i++) {
            counter[i] += baseline;
        }
        return counter;
    }
}

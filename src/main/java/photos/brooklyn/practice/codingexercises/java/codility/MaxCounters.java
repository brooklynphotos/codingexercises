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
        final int[] counter = new int[N];
        for (int a : A) {
            if (a > N) {
                updateCounter(counter, currentMax);
            } else {
                int index = a - 1;
                int newVal = counter[index] + 1;
                counter[index] = newVal;
                if (newVal > currentMax) {
                    currentMax = newVal;
                }
            }
        }
        return counter;
    }

    static void updateCounter(int[] counter, int newVal) {
        for (int i = 0; i < counter.length; i++) {
            counter[i] = newVal;
        }
    }
}

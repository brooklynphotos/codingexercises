package photos.brooklyn.practice.codingexercises.java.codility;

public class ChangeMaker {
    private static int[] DENOMINATIONS = {1, 5, 10, 25, 50, 100};

    /**
     * all ints represent cents
     * @param M
     * @param P
     * @return
     */
    public int[] getChange(double M, double P) {
        int change = (int) (M * 100 - P * 100); // never negative
        return getMinChange(change);
    }

    private int[] getMinChange(final int change) {
        int currentChange = change;
        int[] res = new int[DENOMINATIONS.length];
        for (int i = res.length - 1; i >= 0; i--) {
            int den = DENOMINATIONS[i];
            int count = currentChange / den;
            res[i] = count;
            currentChange = currentChange % den;
        }
        return res;
    }
}

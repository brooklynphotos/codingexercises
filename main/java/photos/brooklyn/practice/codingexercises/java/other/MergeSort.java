package photos.brooklyn.practice.codingexercises.java.other;

public class MergeSort {

    public static void sort(int[] ints) {
        if (ints.length < 2) {
            return;
        }
        final int[] left = new int[ints.length / 2];
        System.arraycopy(ints, 0, left, 0, left.length);
        final int[] right = new int[ints.length - left.length];
        System.arraycopy(ints, left.length, right, 0, right.length);
        sort(left);
        sort(right);
        merge(ints, left, right);
    }

    private static void merge(int[] original, int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                original[i] = left[l++];
            }else{
                original[i] = right[r++];
            }
            i++;
        }
        for (; l < left.length; l++) {
            original[i++] = left[l];
        }
        for (; r < right.length; r++) {
            original[i++] = right[r];
        }
    }
}

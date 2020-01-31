package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Arrays;

public class SmallestPositive {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int res = 1;
        for (int a : A) {
            if (a == res) {
                res++;
            } else if (a > res) {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.printf("%d%n",new SmallestPositive().solution(new int[]{1,2,3}));
    }
}

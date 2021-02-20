package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 */
public class MinPerimeterRectangle {
    public int solution(int N) {
        for (int i = (int) Math.sqrt(N); i >= 1; i--) {
            if (N % i == 0) {
                return 2 * (i + (N / i));
            }
        }
        throw new IllegalStateException("Can't be possible since N can at least be divided by 1");
    }
}

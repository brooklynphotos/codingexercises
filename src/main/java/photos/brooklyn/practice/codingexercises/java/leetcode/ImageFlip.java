package photos.brooklyn.practice.codingexercises.java.leetcode;

public class ImageFlip {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] row : A){
            for(int i=0;i<row.length/2; i++){
                final int tmp = row[i];
                row[i] = invert(row[row.length-1-i]);
                row[row.length-1-i] = invert(tmp);
            }
            // if odd, invert the middle
            if(row.length % 2 ==1){
                row[row.length/2] = invert(row[row.length/2]);
            }
        }
        return A;
    }

    private static int invert(int i) {
        return i==0 ? 1 : 0;
    }
}

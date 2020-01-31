package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/binary-gap/
 */
public class BinaryGap {
    public int binaryGap(int N) {
        final String bin = Integer.toBinaryString(N);
        int maxDistance = 0;
        int currentOne = -1;
        for(int i=0;i<bin.length();i++){
            final char c = bin.charAt(i);
            if(c=='1'){
                if(currentOne==-1){
                    currentOne = i;
                    continue;
                }
                maxDistance = Math.max(i - currentOne, maxDistance);
                currentOne = i;
            }
        }
        return maxDistance;
    }
}

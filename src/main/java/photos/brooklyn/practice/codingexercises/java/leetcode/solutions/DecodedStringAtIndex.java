package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/decoded-string-at-index/discuss/156773/Java-recursion
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long curlen = 0;
        for(int i=0;i<S.length();i++){
            char curchar = S.charAt(i);
            if(Character.isLetter(curchar)){
                curlen+=1;
                if(curlen>K-1){
                    // we found the char when in the middle of a string we have reached K
                    return ""+curchar;
                }
            }
            if(Character.isDigit(curchar)){
                int times = curchar-'0';
                // preserve the length before multiplication
                long prelen = curlen;
                curlen*=times;
                // recursion only happens if the new length covers the K target
                if(curlen>K-1){
                    // (K-1)%prelen => index where K would stick out in the prelen string
                    // + 1 to make it back to 1-based like K is
                    // the problem is repeated with a reduced K
                    return decodeAtIndex(S,(K-1)%(int)prelen+1);
                }
            }
        }
        return "";
    }
}

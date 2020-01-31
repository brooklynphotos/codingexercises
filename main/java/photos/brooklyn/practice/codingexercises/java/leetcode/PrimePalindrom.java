package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-92/problems/prime-palindrome/
 */
public class PrimePalindrom {
    public int primePalindrome(int N) {
        if(N<=11) return nextPrime(N);
        return (int)findPrime(closestPalindrom(N));
    }

    private static int nextPrime(int n) {
        return isPrime(n) ? n : nextPrime(n+1);
    }

    public static long closestPalindrom(int n) {
        return isPalindrom(n) ? n : nextPalindrom(n);
    }

    public static boolean isPalindrom(int n) {
        final String str = Integer.toString(n);
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
        }
        return true;
    }

    public long findPrime(long testPalindrom) {
        if(isPrime(testPalindrom)) return testPalindrom;
        return findPrime(nextPalindrom(testPalindrom));
    }

    public static long nextPalindrom(long palindrom) {
        final String str = Long.toString(palindrom);
        if(str.length()%2==0){
            final String half = str.substring(0,(str.length()/2));
            final long fromHalf = makePalindrom(half,str.length());
            if(fromHalf>palindrom) return fromHalf;
            final String newHalf = Long.toString(Long.parseLong(half)+1);
            if(half.length()==newHalf.length()){
                return Long.parseLong(newHalf+reverse(newHalf));
            }else{
                return Long.parseLong(newHalf+reverse(newHalf).substring(1));
            }
        }else{
            final String half = str.substring(0,(str.length()/2)+1);
            final long fromHalf = makePalindrom(half,str.length());
            if(fromHalf>palindrom) return fromHalf;
            final String newHalf = Long.toString(Long.parseLong(half)+1);
            if(half.length()==newHalf.length()){
                return Long.parseLong(newHalf+reverse(newHalf).substring(1));
            }else{
                return Long.parseLong(newHalf+reverse(newHalf).substring(1));
            }
        }
    }

    public static long makePalindrom(String half, int length) {
        if(length%2==0){
            return Long.parseLong(half+reverse(half));
        }else{
            return Long.parseLong(half+reverse(half).substring(1));
        }
    }

    public static String reverse(String str) {
        final char[] r = new char[str.length()];
        for(int i=0;i<str.length();i++){
            r[i] = str.charAt(str.length()-i-1);
        }
        return new String(r);
    }

    private static boolean isPrime(long x) {
        if(x<=1) return false;
        if(x<=3) return true;
        if(x%2==0 || x%3==0) return false;
        for(long i=5;(i*i)<=x;i+=6){
            if(x % i ==0 || x % (i+2)==0) return false;
        }
        return true;
    }
}

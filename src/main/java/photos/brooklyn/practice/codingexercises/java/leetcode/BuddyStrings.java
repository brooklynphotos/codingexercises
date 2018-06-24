package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/contest/weekly-contest-90/problems/buddy-strings/
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.length()<2) return false;
        for(int i=0;i<A.length();i++){
            char a = A.charAt(i);
            char b = B.charAt(i);
            if(a==b) continue;
            // now that found something different, the answer can only be true if the remaining string matches except
            // where b can be found in A at some j where B[j] is a
            return findSwapped(a, b, A, B, i+1);
        }
        // if the two strings are identical then it is true if there are duplicates
        Set<Character> chars = A.chars().mapToObj(i->(char)i).collect(Collectors.toSet());
        return chars.size()<A.length();
    }

    private boolean findSwapped(char shouldBeInB, char shouldBeInA, String A, String B, int start) {
        for(int i=start; i<A.length();i++){
            char a = A.charAt(i);
            char b = B.charAt(i);
            if(shouldBeInA==a && shouldBeInB==b){
                // the rest need to equal
                return A.substring(i+1).equals(B.substring(i+1));
            }
        }
        return false; // didn't find it
    }
}

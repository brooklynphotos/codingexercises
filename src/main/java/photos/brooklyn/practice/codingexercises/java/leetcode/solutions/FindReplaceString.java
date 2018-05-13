package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/contest/weekly-contest-84/problems/find-and-replace-in-string/
 */
public class FindReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] s, String[] t) {
        Map<Integer, String[]> map = new TreeMap<>();
        for(int i=0; i<indexes.length; i++) map.put(indexes[i], new String[]{s[i], t[i]});

        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(Map.Entry e : map.entrySet()) {
            int idx = (int)e.getKey();
            String ss = ((String[])e.getValue())[0];
            String tt = ((String[])e.getValue())[1];
            if(S.indexOf(ss,idx) == idx) {
                sb.append(S.substring(start, idx)).append(tt);
                start = idx+ss.length();
            }
        }
        if(start != S.length()) sb.append(S.substring(start));
        return sb.toString();
    }
}

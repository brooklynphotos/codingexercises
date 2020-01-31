package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-84/problems/find-and-replace-in-string/
 */
public class FindReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        final StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            final int possibleReplace = findPossibleReplace(i, indexes);
            if(possibleReplace == -1){
                sb.append(S.charAt(i));
                continue;
            }
            final String source = sources[possibleReplace];
            if(!S.substring(i,i+source.length()).equals(source)){
                sb.append(S.charAt(i));
                continue;
            }
            // we have a match
            sb.append(targets[possibleReplace]);
            // advance the i for as much as the string is greater than 1
            i += source.length()-1;
        }
        return sb.toString();
    }

    private static int findPossibleReplace(int i, int[] indexes) {
        for(int j=0;j<indexes.length;j++){
            if(indexes[j]==i) return j;
        }
        return -1;
    }
}

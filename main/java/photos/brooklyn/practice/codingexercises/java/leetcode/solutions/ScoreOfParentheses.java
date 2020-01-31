package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/score-of-parentheses/discuss/141777/C++JavaPython-Concise-O(1)-Space
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        // each i represents a layer, where i=0 is the bottom-most layer that contains the score of the entire string
        // for example, layer i=1 means any layer above the bottom-most layer
        int res[] = new int[30], i = 0;
        for (char c : S.toCharArray())
            // if it's the start of a group on a layer, initialize it to zero. Note that it's ++i and not i++
            // this means we are preparing for the next layer, i+1, if there is a layer (next char might be ), which
            // is the closing of this layer i)
            if (c == '(') res[++i] = 0;
            // this means closing of a group, which means the layer corresponding to this closing parenthesis gets its
            // score upgraded. Note the effective use of i-1 and i--. res[i--] * 2 means 2* the score of the layer above
            else res[i - 1] += Math.max(res[i--] * 2, 1);
        return res[0];
    }
}

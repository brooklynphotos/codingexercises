package example.codingproblems.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.com/contest/weekly-contest-82/problems/most-profit-assigning-work/
 */
public class WorkProfit {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int totalProfit = 0;
        final Map<Integer, Integer> difficultyProfit = buildDifficultyProfit(difficulty, profit);
        for(int i=0;i<workers.length;i++){
            final int maxDifficulty = workers[i];
            totalProfit += findMaxProfit(maxDifficulty, difficultyProfit);
        }
        return totalProfit;
    }

    private static Map<Integer,Integer> buildDifficultyProfit(int[] difficulty, int[] profit) {
        final Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<difficulty.length; i++){
            m.put(difficulty[i], profit[i]);
        }
        return m;
    }

    private static int findMaxProfit(final int maxDifficulty, final Map<Integer,Integer> difficultyProfit) {
        Integer maxProfit = 0;
        for(Integer difficulty : difficultyProfit.keySet()){
            if(difficulty<=maxDifficulty){
                final Integer profit = difficultyProfit.get(difficulty);
                if(profit>maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }

}

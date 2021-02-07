package learn.alg.dynamicrecur;

import java.util.HashMap;

/**
 * 换钱的方法数
 */
public class Coins {

    private int changeMoneyWays(int[] coins, int target) {
        if (coins == null || coins.length == 0 || target <= 0) {
            return 0;
        }
        return violenceRecursion(coins, 0, target);
    }

    /**
     * 暴力递归法
     */
    private int violenceRecursion(int[] coins, int idx, int target) {
        int res = 0;
        if (coins.length == idx) {
             if (target == 0) {
                 res = 1;
             }
        } else {
            for (int i = 0; i * coins[idx] <= target; i++) {
                res += violenceRecursion(coins, idx + 1, target - i * coins[idx]);
            }
        }
        return res;
    }

    private HashMap<Integer, Integer> memoryMap = new HashMap<Integer, Integer>();

    /**
     * 记忆搜索法
     */
    private int memorySearch(int[] coins, int idx, int target, int[][] memoryArray) {
        int res = 0;
        if (coins.length == idx) {
            if (target == 0) {
                res = 1;
            }
        } else {
            for (int i = 0; i * coins[idx] <= target; i++) {
                if (memoryArray[idx + 1][target - i * coins[idx]] != 0) {
                    res += memoryArray[idx][target];
                } else {
                    memorySearch(coins, idx + 1, target - i * coins[idx], memoryArray);
                }
            }
        }
        memoryArray[idx][target] = res;
        return res;
    }

    /**
     * 动态规划
     */
    private int dynamicProgramming(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target <= 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= target; i++) {
            dp[0][i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] += dp[i-1][j] + (j - arr[i] > 0 ? dp[i][j-arr[i]] : 0);
            }
        }
        return dp[arr.length-1][target];
    }

    /**
     * 空间压缩
     */
    private int dynamicProgramming2(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        for (int i = 0; i * arr[0] <= target; i++) {
            dp[i * arr[0]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                // dp[i-1] + dp
                dp[j] += (j - arr[i] >= target ? dp[j-arr[i]] : 0);
            }
        }
        return dp[target];
    }
}

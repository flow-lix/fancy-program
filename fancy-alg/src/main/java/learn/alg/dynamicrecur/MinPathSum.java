package learn.alg.dynamicrecur;

public class MinPathSum {

    /**
     * time: O(m*n) ; space: O(m*n)
     */
    public int getMinPathSum(int[][] m) {
        if (m == null || m.length == 0) {
            return 0;
        }
        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = m[0][0];
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = dp[i][i-1] + m[i][0];
        }
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }
        return dp[m.length-1][m[0].length-1];
    }

    /**
     * time: O(m*n); space O(Min{m, n})
     */
    private int getMinPathSum2(int[][] m) {
        if (m == null || m.length == 0) {
            return 0;
        }
        boolean rowMore = m.length > m[0].length ;
        int lessLen = Math.min(m.length, m[0].length);
        int[] dp = new int[lessLen];
        for (int i = 0; i < lessLen; i++) {
            dp[i] = rowMore ? m[0][i] : m[i][0];
        }
        for (int i = 1; i < (rowMore ? m.length : lessLen); i++) {
            dp[0] = dp[0] + (rowMore ? m[i][0] : m[0][i]);
            for (int j = 1; j < (rowMore ? lessLen : m.length); j++) {
                dp[i] = Math.min(dp[i-1], dp[i]) + m[i][j];
            }
        }
        return dp[dp.length-1];
    }
}

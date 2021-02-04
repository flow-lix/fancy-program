package learn.alg.string;

/**
 * 最小切割回文字串
 */
public class MinCut {

    public static void main(String[] args) {
        String s = "ACDCDCDAD";
        System.out.println(new MinCut().getMinCut(s));
    }

    private int getMinCut(String str) {
        int[] dp = new int[str.length() + 1];
        char[] strArray = str.toCharArray();
        boolean[][] isPalindrome = new boolean[dp.length][dp.length];
        dp[strArray.length] = -1;
        for (int i = strArray.length - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < strArray.length; j++) {
                if (strArray[i] == strArray[j] && (j - i < 2 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }
            }
        }
        return dp[0];
    }

}

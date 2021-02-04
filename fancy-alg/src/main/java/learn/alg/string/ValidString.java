package learn.alg.string;

/**
 * 括号字符串
 */
public class ValidString {

    public static void main(String[] args) {
        System.out.println(new ValidString().getMaxLength("()(()())"));
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c != ')' || --count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    /**
     * 查找最长的有效括号字符串的长度
     * （）（（）()）
     */
    private int getMaxLength(String str) {
        int[] dp = new int[str.length()];
        char[] strArray = str.toCharArray();
        int ret = 0;
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[i] == ')') {
                int pre = i - dp[i-1] -1;
                if (strArray[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}

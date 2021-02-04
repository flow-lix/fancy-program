package learn.alg.string;

/**
 * 查找特殊字符
 */
public class PontNewChar {

    private String getPointNewChar(String str, int k) {
        if (str == null || str.isEmpty() || k < 0 || k > str.length()) {
            return "";
        }
        // 1 aaA
        char[] array = str.toCharArray();

        int num = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (isSmall(array[i])) {
                break;
            }
            num++;
        }
        if ((num & 1) == 1) {
            return str.substring(k-1, k + 1);
        } else if (isSmall(array[k])){
            return String.valueOf(array[k]);
        } else {
            return str.substring(k, k + 2);
        }
    }

    private boolean isSmall(char c) {
        int idx = c - 'a';
        return  0 <= idx && idx <= 26;
    }
}

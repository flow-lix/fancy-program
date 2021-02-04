package learn.alg.string;

/**
 * 最大不重复子串
 */
public class MaxUnique {

    public static void main(String[] args) {
        System.out.println(new MaxUnique().getMaxUnique("abccnmd"));
    }

    private int getMaxUnique(String str) {
        int[] chars = new int[256];
        for (int i = 0; i < 256; i++) {
            chars[i] = -1;
        }
        char[] strArray = str.toCharArray();
        int pre = -1;
        int len = 0;
        for (int i = 0; i < strArray.length; i++) {
            pre = Math.max(pre, chars[strArray[i]]);
            len = Math.max(len, i - pre);
            chars[strArray[i]] = i;
        }
        return len;
    }
}

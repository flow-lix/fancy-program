package learn.alg.string;

import cn.hutool.core.lang.Assert;

/**
 * 判断2个字符串是否互为变形词
 * 1. 数量相等；
 * 2. 种类相等。
 */
public class isDeformation {

    public static void main(String[] args) {
        Assert.isTrue(isDeformation("123", "213"));
        Assert.isFalse(isDeformation("adsaf1", "safd"));
    }

    private static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        int[] charArrays = new int[256];
        for (char c : str1.toCharArray()) {
            charArrays[c]++;
        }
        for (char c : str2.toCharArray()) {
            if (charArrays[c]-- == 0) {
                return false;
            }
        }
        return true;
    }

}

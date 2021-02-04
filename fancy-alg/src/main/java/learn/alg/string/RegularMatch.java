/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.string;

/**
 * . * 匹配
 */
public class RegularMatch {

    /**
     * 校验输入参数是否有效
     */
    private boolean isValid(String input, String regex) {
        // input 不能含有* 和 .
        for (char c :  input.toCharArray()) {
            if (c == '*' || c == '.') {
                return false;
            }
        }
        // regex的*不能相连，不能是首字符
        char[] charArray = regex.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == '*' && charArray[i-1] == '*') {
                return false;
            }
        }
        return charArray[0] == '*';
    }

}

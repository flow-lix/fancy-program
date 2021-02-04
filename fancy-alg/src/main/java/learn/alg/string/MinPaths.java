package learn.alg.string;

import java.util.*;

/**
 * 字符串的转换路径问题
 */
public class MinPaths {

    private Map<String, List<String>> nexts = new HashMap<>();

    private Map<String, Integer> distance = new HashMap<>();

    private void getNexts(List<String> strs, String start) {
        strs.add(start);
        Set<String> set = new HashSet<>(strs);
        for (String s : strs) {
            List<String> nextList = nexts.computeIfAbsent(s, k -> new LinkedList<>());
            for (char c = 'a'; c <= 'z'; c++) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != c) {
                        char tmp = chars[i];
                        chars[i] = c;
                        if (set.contains(String.valueOf(chars))) {
                            nextList.add(String.valueOf(chars));
                        }
                        chars[i] = tmp;
                    }
                }
            }
        }
    }

    private void getDistance(String start) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> set = new HashSet<>();
        set.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String str : nexts.get(cur)) {
                if (!set.contains(str)) {
                    distance.put(str, distance.get(cur) + 1);
                    queue.add(str);
                    set.add(str);
                }
            }
        }
    }
}

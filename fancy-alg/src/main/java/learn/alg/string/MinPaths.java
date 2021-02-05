package learn.alg.string;

import java.util.*;

/**
 * 字符串的转换路径问题
 */
public class MinPaths {

    private Map<String, List<String>> nexts = new HashMap<>();

    private Map<String, Integer> distance = new HashMap<>();

    private List<List<String>> retList = new LinkedList<>();

    public List<List<String>> findMinPaths(List<String> strList,  String start, String to) {
        getNexts(strList, start);
        getDistance(start);
        recur(start, to, new LinkedList<>());
        return retList;
    }

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

    /**
     * 每个节点到start的距离
     * @param start 第一个字符串
     */
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

    /**
     * 返回所有最短的路径
     */
    private void recur(String start, String to, LinkedList<String> addedStr) {
        if (start.equals(to)) {
            retList.add(new LinkedList<>(addedStr));
        } else {
            addedStr.add(start);
            for (String cur : nexts.get(start)) {
                if (distance.get(cur) + 1 == distance.get(start)) {
                    // 当前节点的下一个节点距离start+1
                    recur(start, to, addedStr);
                }
            }
            addedStr.pollLast();
        }
    }
}

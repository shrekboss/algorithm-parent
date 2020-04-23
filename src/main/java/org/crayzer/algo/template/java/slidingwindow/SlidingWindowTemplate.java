package org.crayzer.algo.template.java.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowTemplate {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for (char c : t1) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while (right < s1.length) {
            char c = s1[right];
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            System.out.println("window: [" + left + ", " + right + "]");

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s1[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /* 滑动窗口算法框架 */
    public void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (char c : t1) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        while (right < s1.length) {
            char c = s1[right];
            right++;
            // 进行窗口内数据的一系列更新
            // ...

            /*** debug 输出位置 ***/
            System.out.println("window: [" + left + ", " + right + "]");
            /***********************/

            // 判断左侧窗口是否要收缩
            //while (window need shrink) {
                // d 是将移出窗口的字符
                char d = s1[left];
                // 左移窗口
                left++;
                // 进行窗口内部数据的一系列更新
                // ...
           // }
        }
    }
}

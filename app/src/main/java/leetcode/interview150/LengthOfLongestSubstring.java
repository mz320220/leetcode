package leetcode.interview150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring2(s);
        System.out.println("result:" + result);
    }

    /**
     * 典型双指针滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (n == 0) return 0;
        int left = 0;
        int right = 0;
        int lens = Integer.MIN_VALUE;
        Set<Character> strSet = new HashSet<>();
        while (right < n) {
            char current = chars[right];
            while (strSet.contains(current)) {
                strSet.remove(chars[left]);
                left++;
            }
            strSet.add(chars[right]);
            lens = Math.max(lens, right - left + 1);
            right++;
        }
        return lens;
    }

    /**
     * 可以优化下用 hashMap 处理，保存 char 所在位置直接跳转 left
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (n == 0) return 0;
        int left = 0;
        int lens = Integer.MIN_VALUE;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char current = chars[right];
            /*while (hashMap.containsKey(current)) {
                left = Math.max(left, hashMap.get(current) + 1);
                hashMap.remove(current);
            }*/
            //这里可以优化下，通过 if 判断
            if (hashMap.containsKey(current)) {
                left = Math.max(left, hashMap.get(current) + 1);
            }
            hashMap.put(current, right);
            lens = Math.max(lens, right - left + 1);
        }
        return lens;
    }
}

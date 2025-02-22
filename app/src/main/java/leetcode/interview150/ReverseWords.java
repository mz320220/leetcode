package leetcode.interview150;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "example   good a";
        String result = reverseWords2(s);
        System.out.println("result:" + result);
    }

    public static String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        if (str.length == 1) return str[0];
        StringBuffer out = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) continue;
            out.append(str[i]).append(" ");
        }
        return out.toString().substring(0, out.length() - 1);
    }

    public static String reverseWords2(String s) {
        s = s.trim();
        int n = s.length();
        StringBuilder sub = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                sub.append(s.charAt(i));
            } else if (sub.toString().length() > 0) {
                //在输出的 StringBuilder 前面插入，达到 reverse
                ans.insert(0, sub);
                ans.insert(0, ' ');
                sub.setLength(0);
            }
        }
        ans.insert(0, sub.toString());
        return ans.toString();
    }
}

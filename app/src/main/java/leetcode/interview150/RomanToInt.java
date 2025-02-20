package leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 */
public class RomanToInt {

    public static void main(String[] args) {
        String s = "LVIII";
        int result = romanToInt(s);
        System.out.println("result:" + result);
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> transMap = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int total = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = transMap.get(s.charAt(i));
            if (i < n - 1 && value < transMap.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }
        return total;
    }
}

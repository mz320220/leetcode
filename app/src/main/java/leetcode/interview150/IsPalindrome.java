package leetcode.interview150;

import java.util.Locale;

/**
 * 125. 验证回文串
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "str";
        boolean result = isPalindrome(s);
        System.out.println("result:" + result);
    }

    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int n = str.length();
        if (n <= 1) return true;
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            //内部循环跳过非字母、数字可能会导致 left、right 交汇，所以需要额外判断left<right
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }


}

package leetcode.temp;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("123abba367"));
        //System.out.println(longestPalindrome("123abcdcba567"));
    }

    private static String longestPalindrome(String s){
        if (s == null || s.length() < 1) return "";
        int start=0, end = 0;
        for (int i = 0; i<s.length(); i++){
            int len1 = findStartEnd(s,i,i); //寻找奇数位的回文串
            int len2 = findStartEnd(s,i,i+1); //寻找偶数位的回文串
            int len = Math.max(len1,len2);
            if (len > end - start ){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end +1); //左闭右开
    }

    private static int findStartEnd(String s, int start, int end){
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        /**
         * 减1：最后一次是不满足条件的。end - start + 1 - 2
         */
        return end - start -1;
    }
}

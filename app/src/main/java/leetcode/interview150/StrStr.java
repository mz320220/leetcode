package leetcode.interview150;

/**
 * 28. 找出字符串中第一个匹配项的下标
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        int result = strStr2(haystack, needle);
        System.out.println("result:" + result);
    }

    /**
     * String的字符串匹配使用的是暴力对比
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * KMP 算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        int m = haystack.length(); //主串长度
        int n = needle.length();
        if (m < n) return -1;
        int[] next = buildNext(needle);
        int i = 0, j = 0; //i遍历主串，j 遍历模式串
        while (i < m) {
            //匹配则分别往后移动
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) return i - n; //说明匹配完成，从当前位置减去模式串长度 --> 最初匹配到的 index
            //tips：这里需要再次判断 i < m,否则如果最后一位 n-1匹配上了，i++会导致取主串[n],数组越界
            if (i < m && haystack.charAt(i) != needle.charAt(j)) {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; //匹配失败
    }

    //KMP算法重点在于构建 NEXT 数组，避免指针无用回归从头比较
    public static int[] buildNext(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];
        int j = 0; //表示当前字符的最大前/后缀匹配
        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

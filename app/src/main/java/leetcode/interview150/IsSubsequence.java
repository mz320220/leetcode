package leetcode.interview150;

/**
 * 392. 判断子序列
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String s = "aza";
        String t = "abzba";
        boolean result = isSubsequence2(s, t);
        System.out.println("result:" + result);
    }

    public static boolean isSubsequence(String s, String t) {
        int m = s.length(); //子串长度
        int n = t.length(); //主串长度
        if (m == 0) return true; //注意处理空串
        for (int i = 0; i < m; i++) {
            int index = t.indexOf(s.charAt(i));
            if (index < 0) {
                return false;
            }
            if (i == m - 1) return true;
            if (index < n) { //当前索引没有到末尾
                t = t.substring(index + 1, n);
                n -= index + 1;
            }
        }
        return false;
    }

    /**
     * 双指针处理
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

}

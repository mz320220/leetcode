package leetcode.interview150;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String result = longestCommonPrefix2(strs);
        System.out.println("result:" + result);
    }

    /**
     * 横向扫描，一个个对比
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (strs == null || n == 0) {
            return null;
        }
        String preStr = strs[0];
        for (int i = 1; i < n; i++) {
            preStr = findCommonPrefix(preStr, strs[i]);
            if (preStr.length() == 0) return "";
        }
        return preStr;
    }

    private static String findCommonPrefix(String str1, String str2) {
        int compareSize = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < compareSize && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);

        /*for (int i = 0; i < compareSize; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, compareSize);*/
    }

    /**
     * 纵向查找，一列列比较
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        String preStr = strs[0]; //默认以第一个为基准
        int n = strs.length;
        //遍历 preStr 的每个字母，每个字母与剩余所有字段比较，找出最大的索引结束位置
        for (int i = 0; i < preStr.length(); i++) {
            char s = preStr.charAt(i);
            for (int j = 1; j < n; j++) {
                //字母不匹配，或者已经匹配到当前字段最大长度，跳出循环
                /*if (strs[j].charAt(i) != s || strs[j].length() == i){*/
                //注意，需要先判断长度，否则可能会导致outofIndex！
                if (strs[j].length() == i || strs[j].charAt(i) != s) {
                    return preStr.substring(0, i);
                }
            }
        }
        return preStr;
    }
}

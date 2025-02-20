package leetcode.interview150;

/**
 * 12. 整数转罗马数字
 */
public class IntToRoman {

    public static void main(String[] args) {
        int num = 3749;
        String result = intToRoman(num);
        System.out.println("result:" + result);
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                str.append(symbols[i]);
                num -= values[i];
            }
            if (num == 0) break;
        }
        return str.toString();
    }
}

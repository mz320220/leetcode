package leetcode.interview150;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int result = lengthOfLastWord(s);
        System.out.println("result:" + result);
    }

    public static int lengthOfLastWord(String s) {
        String str = s.trim();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                return str.length() - i - 1;
            }
        }
        return str.length();
    }
}

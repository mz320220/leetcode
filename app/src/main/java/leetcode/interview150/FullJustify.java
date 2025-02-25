package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * todo
 */
public class FullJustify {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> resultList = fullJustify(words, maxWidth);
        System.out.println("result:");
        resultList.stream().forEach(System.out::println);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resultlist = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].length() + 1 >= maxWidth) {

            }
        }
        return null;
    }
}

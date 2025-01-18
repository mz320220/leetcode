package greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        //partitionLabels(s).stream().forEach(System.out::println);
        partitionLabels2(s).stream().forEach(System.out::println);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int last = s.lastIndexOf(s.charAt(i));
            if (last > end) {
                end = last;
            }
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int length = s.length();
        /**
         * 重点：题干限制在26个字母，避免循环中计算字母的lastIndex，提前初始化，速度快很多
         */
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


}

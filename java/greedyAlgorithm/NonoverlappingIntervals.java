package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 */
public class NonoverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        //只需要根据末尾字符升序排序即可
        /*Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1])); 耗时更多*/
        Arrays.sort(intervals, (p1,p2)->{
            return p1[1] -p2[1];
        });
        int num = 0;
        int start = intervals[0][1]; //从排序后第一个区间的末尾作为初始点，和后一个区间起点作比较
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < start) {
                num++;
            } else {
                start = intervals[i][1];
            }
        }
        return num;
    }
}

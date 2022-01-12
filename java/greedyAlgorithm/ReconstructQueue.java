package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            } else {
                return p2[0] - p1[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            /**
             * 按照p[1]顺序进行插入
             */
            res.add(p[1], p);
        }
        return res.toArray(people);
    }
}

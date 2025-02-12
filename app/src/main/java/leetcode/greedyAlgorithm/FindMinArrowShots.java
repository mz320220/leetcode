package leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        //int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        /**
         * 注意边界的测试用例，不可以直接相减，排序会出问题
         */
        /*Arrays.sort(points, (p1, p2) -> {
            return p1[1] - p2[1];
        });*/
        //Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1],p2[1]));
        int num = 1;
        int arrow = points[0][1]; //箭矢位置：初始为第一个气球末端
        for (int i = 1; i < points.length; i++) {
            //下一个气球无法被当前箭矢射中
            if (points[i][0] > arrow) {
                num++;
                arrow = points[i][1];
            }
        }
        return num;
    }
}

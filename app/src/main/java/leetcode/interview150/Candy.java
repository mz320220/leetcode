package leetcode.interview150;

import java.util.Arrays;

/**
 * 135.分发糖果
 */
public class Candy {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        int result = candy2(nums);
        System.out.println("result:" + result);
    }

    /**
     * 两次遍历两个方向满足条件再取较大值
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int total = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1; //同时初始化了0
            }
        }

        /*int[] right = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
            total += Math.max(right[i], left[i]);
        }*/
        //可以不保存 right 数组，直接进行计算total
        int right = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            total += Math.max(right, left[i]);
        }
        return total;
    }

    /**
     * 常数空间判断
     *
     * @param ratings
     * @return
     */
    public static int candy2(int[] ratings) {
        int length = ratings.length;
        int total = 1; //从第二个开始判断，第一位同学默认为1
        int dec = 0; //递减序列长度
        int inc = 1; //递增序列长度
        int pre = 1; //前一个同学的糖果数量
        for (int i = 1; i < length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                total = total + pre;
                inc = pre; //增长序列的长度,仅用于后续与递减比较
            } else {
                //递减的序列
                dec = dec +1;
                if (dec == inc){
                    dec = dec +1; //相同长度，需要将递增最后一个归入递减
                }
                total = total + dec;
                pre = 1;

            }
        }
        return total;
    }
}

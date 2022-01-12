package greedyAlgorithm;

import java.util.Arrays;

/**
 * 135. 分发糖果
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int size = ratings.length;
        if (size < 2) {
            return size;
        }
        int[] nums = new int[size];
        for (int i = 0; i < size - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                /*if (nums[i-1] <= nums[i]){
                    nums[i-1] = nums[i] +1;
                }*/
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        //return Arrays.stream(nums).sum() + size;
        int sum = size;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

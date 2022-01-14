package dualPointer;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 滑动窗口解决
     */
    public static int minSubArrayLen(int target, int[] nums) {
        //剪枝
        if (nums[0] >= target) {
            return 1;
        }
        int right = 0;
        int left = 0;
        int size = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                int wide = right - left;
                size = size == 0 ? wide : Math.min(size, wide);
                sum -= nums[left];
                left++;
            }

        }
        return size;
    }
}

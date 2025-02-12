package leetcode.dualPointer;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
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
        while (right < nums.length) { //left <= right条件可以省略：题目中nums[i]>=1,所以循环中不会出现此种场景
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

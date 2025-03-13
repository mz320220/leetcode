package leetcode.interview150;

/**
 * 209. 长度最小的子数组
 * tips：子数组为连续的
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 213;
        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        int result = minSubArrayLen(target, nums);
        System.out.println("result:" + result);
    }

    /**
     * 注意题目要求是子数组，是不能排序的
     * 考虑使用滑动窗口的思想处理
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int lens = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            //先移动右侧边界找到大于 target 的位置，再尝试移动左侧来找到可能存在的更小的窗口范围
            while (sum >= target) {
                lens = Math.min(lens, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return lens == Integer.MAX_VALUE ? 0 : lens;

    }
}

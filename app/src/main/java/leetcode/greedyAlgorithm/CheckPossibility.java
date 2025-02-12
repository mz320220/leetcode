package leetcode.greedyAlgorithm;

/**
 * 665. 非递减数列
 */
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int size = nums.length;
        /**
         * 剪枝
         */
        if (size < 3) {
            return true;
        }
        int n = 0;
        //针对3.4.2.3这种还是需要修改后比较才满足
        /**
         * 1、如果只是小于i，大于i-1，那么修改i即可【改为i-1或改为i+1都行】，且不会影响整体的递增性 --> 次数+1即可
         * 2、如果小于i，又小于i-1，则必须修改i+1位的数据，需要进一步判断后续是否递增。
         */
        for (int i = 0; i < size - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if (y < x) {
                n++;
                if (n > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}

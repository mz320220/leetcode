package leetcode.interview150;

/**
 * 55.跳跃游戏
 */
public class CanJump {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean result = canJump(nums);
        System.out.println("result:" + result);
    }

    public static boolean canJump(int[] nums) {
        int size = nums.length;
        int maxLength = 0;
        for (int i = 0; i < size; i++) {
            if (i > maxLength) return false;
            maxLength = Math.max(maxLength, i + nums[i]);
            if (maxLength >= size -1) return true;
        }
        return false;
    }
}
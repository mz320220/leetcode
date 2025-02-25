package leetcode.interview150;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = -2;
        int[] result = twoSum(nums, target);
        System.out.println("result:" + Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            //注意是有序数组
            while (left < right && numbers[left] + numbers[right] > target) {
                right--;
            }
            while (left < right && numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找处理--理解思想，并不快
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) { //tips:需要包含等于，避免left-right 为一个值时提前终止！
                int mid = (right - left) / 2 + left;
                if (numbers[i] + numbers[mid] == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] + numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

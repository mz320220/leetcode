package dualPointer;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (end > start) {
            int temp = numbers[start] + numbers[end];
            if (temp == target) {
                result[0] = ++start;
                result[1] = ++end;
                return result;
            } else {
                if (temp > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}

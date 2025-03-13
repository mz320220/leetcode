package leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("result:" + result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums); //排序
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //跳过重复元素
            int left = i + 1;
            int right = n - 1;
            //找到 num[i] + num[left] + num[right] = 0;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //找到其中一个解后，移动左右指针，同时跳过相同的 value
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resultList;
    }
}

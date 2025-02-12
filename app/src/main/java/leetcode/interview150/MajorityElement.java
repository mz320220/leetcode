package leetcode.interview150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169.多数元素
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement3(nums);
        System.out.println("result:" + result);
    }

    //方法 1：使用 HashMap 保存每个元素的数量
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        Map.Entry<Integer, Integer> max = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (max == null) max = entry;
            if (entry.getValue() > max.getValue()) {
                max = entry;
            }
        }
        return max.getKey();
    }

    //方法 2：直接排序，取数组中间值，一定为过半的重数
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //方法 3：Boyer-moore 投票算法
    public static int majorityElement3(int[] nums) {
        int tempMax = nums[0];
        int count = 0;
        /*for (int i = 0; i < nums.length; i++) {
            if (tempMax == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    tempMax = nums[i];
                    count++;
                }
            }
        }*/
        //优化一下：
        for (int num : nums) {
            if (count == 0) {
                tempMax = num;
            }
            count += (tempMax == num) ? 1 : -1;
        }
        return tempMax;
    }

}

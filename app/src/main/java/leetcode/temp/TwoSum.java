package leetcode.temp;

import java.util.HashMap;

/**
 * 1、两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] index = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i< nums.length ; i ++){
            if (hashMap.containsKey(nums[i])){
                index[0] = i;
                index[1] = hashMap.get(nums[i]);
                return;
            }
            hashMap.put(target - nums[i],i);
        }
        return;
    }
}

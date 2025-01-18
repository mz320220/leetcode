package interview150;

import java.util.Arrays;

/**
 * 80.删除有序数组的重复项 II
 */
public class RemoveDuplicatesII {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int result = removeDuplicates(nums);
        System.out.println("result:" + result);
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int count = 1; //计数器，同一元素最多出现 2 次
        if (nums.length ==1){
            return 1;
        }
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
                count = 1;
            }else if(count <2){
                left++;
                nums[left] = nums[right];
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left+1;
    }
}

package leetcode.interview150;

/**
 * 26.删除有序数组中的重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println("result:" + result);
    }

    //双指针：从头遍历，快指针与慢指针比较，不相同则赋值，最终慢指针记录所有不重复数据
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
        }
        return left+1;
    }
}

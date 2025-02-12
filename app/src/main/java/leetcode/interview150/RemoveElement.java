package leetcode.interview150;

/**
 * 27.移除元素
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int result = removeElement2(nums, 3);
        System.out.println("result:"+result);
    }

    //前后索引向中间处理：重点是找到循环前提begin < end
    public static int removeElement(int[] nums, int val) {
        int begin = 0;
        int end = nums.length;
        //注意 end 的取值，长度则小于，索引（length-1）则为小于等于
        while (begin < end){
            if (nums[begin] == val){
                nums[begin] = nums[end-1];
                end--;
            }else{
                begin++;
            }
        }
        return begin;
    }

    //双指针同时从头出发，右指针循环，如果满足则复制给左指针记录
    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}

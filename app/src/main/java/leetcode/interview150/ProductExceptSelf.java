package leetcode.interview150;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf2(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 左右乘积
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) { //从第二位开始循环
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) { //倒数第二位开始
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    /**
     * 减少构造一个数组，节省空间复杂度
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        Arrays.fill(answer,1); //各位先初始化为 1
        int L = 1;
        for(int i =0 ; i<length; i++){
            answer[i] *= L;
            L *= nums[i];
        }

        int R = 1;
        for (int i = length-1; i >=0; i--){
            answer[i] *= R;
            R *= nums[i];
        }
        return answer;
    }
}

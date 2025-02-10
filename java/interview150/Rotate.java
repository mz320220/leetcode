package interview150;

import java.util.Arrays;

/**
 * 189.轮转数组
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    //方法 1：使用额外数组
    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] newNums = new int[size];
        for (int i = 0; i < size; i++) {
            newNums[(i + k) % size] = nums[i];
        }
        //复制到原数组
        System.arraycopy(newNums, 0, nums, 0, size);
    }

    //方法 2：环状替换-最大公约数法
    public static void rotate2(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        for (int i = 0; i < gcd(k, size); i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % size;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (i != current);
        }
    }

    //求最大公约数
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    //环状替换：数据遍历
    public static void rotate2_2(int[] nums, int k) {
        int size = nums.length;
        int count = 0;
        k = k % size;
        //循环次数一定小于 k
        for (int i = 0; i < k; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % size;
                int temp = nums[next];
                nums[next] = prev;
                count++;
                if (count >= size) return; //通过对替换数量来终止程序
                prev = temp;
                current = next;
            } while (i != current);
        }
    }

    //方法 3：数组翻转
    public static void rotate3(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        reverse(nums, 0, size - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}

package leetcode.dualPointer;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
        int n = 3;
        merge(num1, m, num2, n);
    }

    /**
     * 关于为什么可以直接从后插入不会覆盖nums1原有的值：
     * nums1任意时刻有m-p1-1个值放入nums1后半部；-->p1：操作nums1的指针
     * nums2任意时刻有m-p2-1个值放入nums1后半部；
     * nums1后半部一共有 m+n-1-p1个位置：
     * m+n-1-p1 >= (m-p1-1) + (m-p2-1) --> p2 >= -1
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int position = m-- + n-- - 1; //指向合并后数组的末尾,同时是m、n分别减一指向两个数组的末尾
        while (m >= 0 && n >= 0) {
            nums1[position--] = nums2[n] > nums1[m] ? nums2[n--] : nums1[m--];
        }
        while (n >= 0) {
            nums1[position--] = nums2[n--];
        }
        System.out.println(Arrays.toString(nums1));
    }
}

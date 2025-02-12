package leetcode.interview150;

import java.util.Arrays;

/**
 * 88.合并有序数组
 */
public class MergeOrderArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,10,0,0,0};
        int[] nums2 = {2,11,18};
        merge(nums1,(nums1.length - nums2.length),nums2,nums2.length);
    }

    //双指针同时处理：重点在于由于 nums1后侧为空，需要从后向前处理
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int reverseIndex = m+n -1;
        while(m >0 && n >0){
            nums1[reverseIndex--] = nums1[m-1] > nums2[n-1] ? nums1[--m] : nums2[--n];
        }
        while (n >0){
            nums1[reverseIndex--]= nums2[--n];
        }
        System.out.println(Arrays.toString(nums1));
    }

}

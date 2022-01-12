package temp;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int left = (a + b + 1) / 2;
        int right = (a + b + 2) / 2;
        return (findk(nums1,0,nums2,0,left) + findk(nums1,0,nums2,0,right))/2.0;
    }

    public static int findk(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        /**
         * k为1说明匹配到左侧最后一次，left取小
         */
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int v1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int v2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (v1 < v2) {
            return findk(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findk(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}

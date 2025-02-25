package leetcode.interview150;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1, 2, 4, 3};
        int result = maxArea2(height);
        System.out.println("result:" + result);
    }

    /**
     * 暴力循环会超时
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < i) {
                max = Math.max(max, Math.min(height[i], height[j]) * (i - j));
                j++;
            }
        }
        return max;
    }

    //理解：移动两条边中较小的，才有可能到达更大的容量
    public static int maxArea2(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return max;
    }

    // 思路：每次比较两边指针的大小，小的向相反的方向移动，直到两个指针相遇
    public static int maxArea3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0; // 初始化水的重量
        while (left < right) {
            // 最小边界
            int min = Math.min(height[left], height[right]);
            // 判断最大容量
            maxArea = Math.max(maxArea, (min * (right - left)));
            // 寻找下一个边界要大于最短边界
            while (left < right && height[left] <= min) {
                left++;
            }
            while (left < right && height[right] <= min) {
                right--;
            }
        }
        return maxArea;
    }
}

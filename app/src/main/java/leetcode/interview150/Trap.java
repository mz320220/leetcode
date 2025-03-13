package leetcode.interview150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42.接雨水
 */
public class Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap3(height);
        System.out.println("result:" + result);
    }

    /**
     * 分别计算左侧 max、右侧 max 取重叠，再减去原有 height 得到结果
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;
    }

    /**
     * 使用单调栈
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int waterBottom = stack.pop(); //当前计算的水域面积底部高度
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[waterBottom];
                total += width * h;
            }
            stack.push(i);
        }
        return total;
    }

    /**
     * 双指针往中间逼近
     * 假设中间没有柱子，分别逼近，注意左右指针的移动条件
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] < height[right]) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}

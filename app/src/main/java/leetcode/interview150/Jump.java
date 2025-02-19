package leetcode.interview150;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        int result = jump(nums);
        System.out.println("result:" + result);
    }

    public static int jump(int[] nums) {
        int size = nums.length;
        if (size <= 1) return 0; //长度为 1 不需要跳跃
        int steps = 0; //跳跃次数
        int stepEnd = 0; //当前跳跃范围内最远距离
        int maxDest = 0; //进行下次跳跃可以到达的最远距离
        for (int i = 0; i < size - 1; i++) { //最后终点可以不遍历
            maxDest = Math.max(maxDest, i + nums[i]);
            if (i == stepEnd) {
                steps++;
                stepEnd = maxDest;
                if (stepEnd >= size - 1) {
                    return steps;
                }
            }
        }
        return steps;
    }
}

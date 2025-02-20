package leetcode.interview150;

/**
 * 134. 加油站
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println("result:" + result);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int i = 0;
        while (i < size) {
            int totalGas = 0;
            int totalCost = 0;
            int step = 0;
            while (step < size) {
                int current = (i + step) % size;
                totalGas += gas[current];
                totalCost += cost[current];
                if (totalCost > totalGas) {
                    break;
                }
                step++;
            }
            //循环了一周后退出
            if (step == size) {
                return i;
            } else {
                i = i + step + 1; //如果无法到达，则说明中间步数均不可达，从下一步开始循环
            }
        }
        return -1;
    }
}
